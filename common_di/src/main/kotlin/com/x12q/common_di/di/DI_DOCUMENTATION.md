# DI structure

The app DI graph is split into 3 major levels (fixed and strongly tied to each other):
- `Global`: contains mostly singleton services relevant to everything in the app
- `Window`: contains window-related objects
- `Screen`: contains objects related to the app-business logic and screen-related objects.

The hierarchy is : `Global` -> `Window` -> `Screen`.
- `Window` is below `Global` 
- `Screen` is below `Window`


Each level consist of:
- a DI Component.
- a Compose scope
- a Composable function to provide DI Component
- a `ViewModelFactoryProvider` (`view model factory provider`). `Global` does not have this. 

These composable functions and composable scopes are structured in a way to enforce a fixed hierarchy as follows:

- `Global` can only be used at application level. That means there is exactly one Global component,
- `Window` can only be used within `Global` component.
- `Screen` can only be used within `Window` component.
- Component of a lower level can access all the bindings in the upper level (direct parent + all indirect parent at higher level).
- There can only be 1 `Global`.
- There can be as many `Window` component and `Screen` component as desired. Each support a `Window` or a `Screen`.
- Two component of the same type (two `Screen` for example), cannot access each other and has their own set of dependencies
- Two component of the same type may have a common parent component (such as two `Screen` components can have one common `Window` parent component)


# Provide bindings to each component level from the consumer of the DI structure (such as an app)

Similar to using `@Module` + `@InstallIn()` on android, use `@ContributesTo(scope::class)` to contribute to a scope.

For example:
`@ContributesTo(GlobalComponent.Scope::class)` -> will add bindings to `Global` component
`@ContributesTo(ScreenComponent.Scope::class)` -> will add bindings to `Screen` component


# Starting point:
`@MergeComponent` can only merge `@ContributesTo` interfaces that are visible during its own module's compilation (a KSP limitation). Since app-specific contributions (e.g. `GlobalComponentContribution`) live in the app module, `@MergeComponent` must also live there.

For this reason, `GlobalComponent` in this library is a plain interface, not a `@MergeComponent`.

The app module must declare a merged component that extends `GlobalComponent`:

```kotlin
@MergeComponent(GlobalComponent.Scope::class)
@SingleIn(GlobalComponent.Scope::class)
interface AppGlobalComponent : GlobalComponent
```

Then in the main function of the app:

```kotlin
fun main(){
    application {
        WithGlobalComponent(
            globalComponentFactory = {
                AppGlobalComponent::class.create()
            }
        ){
            val binding = (globalComponent as MyContribution).getBindingInApp()
            // ...
        }
    }
}
```




# How are DI components created and distributed?
- DI components are created and `remember{}` inside `With*` composable functions, and then provided to children Composable via `Scope` object.
- Each `With*` function is tied to a Scope object to ensure the binding between major DI level.
  - `ApplicationScope`.`WithGlobalComponent`: 
    - provides `GlobalScope` -> `GlobalComponent`
    - provide all children with direct access to `GlobalComponent` via `LocalGlobalComponentProvider`
  - `GlobalScope`.`WithWindowComponent`: 
    - provides `WindowScope` -> `WindowComponent`
    - provide all children with direct access to `WindowComponent` via `LocalWindowComponentProvider`
  - `WindowScope`.`WithScreenComponent`:
    - provides `ScreenScope` -> `ScreenComponent`
    - provide all children with direct access to `ScreenComponent` via `LocalScreenComponentProvider`
    - provide all children with direct access to `ViewModelFactoryProvider` via `LocalViewModeFactoryProvider`

# Obtain view model from DI component with `getVM()`
- Composable function `getVM<T>()` can be use to create an injectable view model of type `T`.
- `getVM()` works by querying from the closest `view model factory provider` (`ViewModelFactoryProvider`)
- `ScreenComponent` and `WindowCompnent` each provide a `view model factory provider`.
- `GlobalComponent` does not provide a `view model factory provider`.

# Create viewmodel 

All ViewModel needs to be created with a Factory class regardless of the view model being `@Inject` or `@AssistedInject`.

For `@Inject` view model -> Factory must implement `ViewmodelFactory`

```kotlin
class MainScreenViewModel @Inject constructor(
    // add dependency here
) {
    // 
    @SingleIn(MainScreenComponent.Scope::class)
    @ContributesBinding(MainScreenComponent.Scope::class, multibinding = true)
    class Factory @Inject constructor(
        val create:()-> MainScreenViewModel
    ): ViewmodelFactory{
        override val classKey: KClass<MainScreenViewModel> = MainScreenViewModel::class
        override fun createVM(): MainScreenViewModel {
            return create()
        }
    }   
}
```

For `@AssistedInject` view model -> Factory must implement `AssistedInjectViewModelFactory`

```kotlin

class SubViewModel @Inject constructor(
    @Assisted val initNumber: Int,
) {
    // 
    @ContributesBinding(TestScreenCompScope::class, multibinding = true)
    class Factory @Inject constructor(
        private val _create: (initColor: Int) -> SubViewModel
    ) : AssistedInjectViewModelFactory {
        fun create(initColor: Int): SubViewModel {
            return _create(initColor)
        }
    }
}
```
# Subclassing ViewModel class ? 

No, the view model in the app does not need to subclass android `ViewModel`.

# How to make a specialized Screen component:
- This is a rare case because it's just easier to duplicate `Screen` component for everything.
- Often, this is for specialized screens that contain objects must not be accessible by other screens.
- Component of this screen should depend on `Screen` component, (or maybe window, if it really need to manipulate window, but this probably never exists)
- The component should provide its own `view model factory provider`, and that provider should include the `view model factory provider`of its upper level `Screen`™. This inclusion maybe opt out depend on business logic.
- See `MainScreenComponent` as an example.

