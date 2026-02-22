# common_di

Hierarchical dependency injection system with Jetpack Compose integration.

## DI Structure

The DI graph has 3 levels in a fixed hierarchy:

```
Global -> Window -> Screen
```

| Level    | Purpose                              | Count        | ViewModelFactoryProvider |
|----------|--------------------------------------|--------------|--------------------------|
| `Global` | App-wide singletons                  | Exactly 1    | No                       |
| `Window` | Window-related objects                | 1 or more    | Yes                      |
| `Screen` | Business logic & screen-specific objects | 1 or more | Yes                      |

Each level consists of:
- A DI Component
- A Compose scope
- A `With*` composable function that creates and provides the component

Rules:
- A lower-level component can access all bindings from its ancestors.
- Two components at the same level are isolated from each other (each has its own dependencies).
- Two components at the same level may share a common parent (e.g. two `Screen` components under one `Window`).


## How Components Are Created and Distributed

Components are created and `remember{}`-ed inside `With*` composable functions, then provided to children via scope objects and `CompositionLocal` providers:

| Composable                             | Available in         | Provides                                                                        |
|----------------------------------------|----------------------|---------------------------------------------------------------------------------|
| `ApplicationScope.WithGlobalComponent` | Application root     | `GlobalScope`, `LocalGlobalComponentProvider`                                   |
| `GlobalScope.WithWindowComponent`      | Inside `GlobalScope` | `WindowScope`, `LocalWindowComponentProvider`                                   |
| `WindowScope.WithScreenComponent`      | Inside `WindowScope` | `ScreenScope`, `LocalScreenComponentProvider`, `LocalViewModelFactoryProvider`  |

Each `With*` composable:
- Creates and `remember{}`-s its DI component
- Provides the component to children via a `CompositionLocal`
- Exposes a scope interface so child content can access the component directly

### CompositionLocal Providers

- `LocalGlobalComponentProvider` - provides `GlobalComponent`
- `LocalWindowComponentProvider` - provides `WindowComponent`
- `LocalScreenComponentProvider` - provides `ScreenComponent`


## Usage

```kotlin
fun main() {
    application {
        WithGlobalComponent(
            globalComponentFactory = { AppGlobalComponent::class.create() }
        ) {
            WithWindowComponent {
                WithScreenComponent {
                    // Access components via scope receivers:
                    //   globalComponent, windowComponent, screenComponent
                    //
                    // Or via CompositionLocal:
                    //   LocalGlobalComponentProvider.current
                    //   LocalWindowComponentProvider.current
                    //   LocalScreenComponentProvider.current
                }
            }
        }
    }
}
```


## Starting Point (KSP Constraint)

`@MergeComponent` can only merge `@ContributesTo` interfaces visible during its own module's compilation. Since app-specific contributions live in the app module, `@MergeComponent` must also live there.

For this reason, `GlobalComponent` in this library is a plain interface, not a `@MergeComponent`. The app module must declare a merged component that extends it:

```kotlin
@MergeComponent(GlobalComponent.Scope::class)
@SingleIn(GlobalComponent.Scope::class)
interface AppGlobalComponent : GlobalComponent
```

Then in the main function:

```kotlin
fun main() {
    application {
        WithGlobalComponent(
            globalComponentFactory = {
                AppGlobalComponent::class.create()
            }
        ) {
            val binding = (globalComponent as MyContribution).getBindingInApp()
            // ...
        }
    }
}
```


## Contributing Bindings

Similar to `@Module` + `@InstallIn()` on Android, use `@ContributesTo(scope::class)` to contribute bindings to a component scope:

- `@ContributesTo(GlobalComponent.Scope::class)` -> adds bindings to `Global`
- `@ContributesTo(WindowComponent.Scope::class)` -> adds bindings to `Window`
- `@ContributesTo(ScreenComponent.Scope::class)` -> adds bindings to `Screen`


## Obtaining ViewModels with `getVM()`

- `getVM<T>()` creates an injectable ViewModel of type `T` by querying the closest `ViewModelFactoryProvider`.
- `Screen` and `Window` components each provide a `ViewModelFactoryProvider`. `Global` does not.


## Creating ViewModels

All ViewModels require a Factory class, regardless of being `@Inject` or `@AssistedInject`. Each Factory must be contributed to the appropriate scope using `@ContributesBinding(Scope::class, multibinding = true)` so that `getVM()` can discover it.

**`@Inject` ViewModel** -- Factory implements `ViewModelFactory`:

```kotlin
class MainScreenViewModel @Inject constructor(
    // dependencies
) {
    @SingleIn(MainScreenComponent.Scope::class)
    @ContributesBinding(MainScreenComponent.Scope::class, multibinding = true)
    class Factory @Inject constructor(
        val create: () -> MainScreenViewModel
    ) : ViewModelFactory {
        override val classKey: KClass<MainScreenViewModel> = MainScreenViewModel::class
        override fun createVM(): MainScreenViewModel = create()
    }
}
```

**Assisted `@Inject` ViewModel** -- Factory implements `AssistedInjectViewModelFactory`:

```kotlin
class SubViewModel @Inject constructor(
    @Assisted val initNumber: Int,
) {
    @ContributesBinding(TestScreenCompScope::class, multibinding = true)
    class Factory @Inject constructor(
        private val _create: (initColor: Int) -> SubViewModel
    ) : AssistedInjectViewModelFactory {
        fun create(initColor: Int): SubViewModel = _create(initColor)
    }
}
```

ViewModels do not need to subclass Android's `ViewModel`.


## Specialized Screen Components

For screens that need isolated dependencies not accessible by other screens:

- The component should depend on `ScreenComponent`.
- It should provide its own `ViewModelFactoryProvider`, which may include the parent `Screen`'s provider (opt-in based on business logic).
- See `MainScreenComponent` as an example.
