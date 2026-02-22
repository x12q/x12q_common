# common_di_compose

Jetpack Compose integration for the `common_di` hierarchical dependency injection system.

This module bridges the three-level DI component hierarchy (`Global -> Window -> Screen`) with Compose's composition tree using scoped composable functions and `CompositionLocal` providers.

## Overview

| Composable                             | Available in         | Provides                                                                        |
|----------------------------------------|----------------------|---------------------------------------------------------------------------------|
| `ApplicationScope.WithGlobalComponent` | Application root     | `GlobalScope`, `LocalGlobalComponentProvider`                                   |
| `GlobalScope.WithWindowComponent`      | Inside `GlobalScope` | `WindowScope`, `LocalWindowComponentProvider`                                   |
| `WindowScope.WithScreenComponent`      | Inside `WindowScope` | `ScreenScope`, `LocalScreenComponentProvider`, `LocalViewModelFactoryProvider`  |

Each `With*` composable:
- Creates and `remember{}`-s its DI component
- Provides the component to children via a `CompositionLocal`
- Exposes a scope interface so child content can access the component directly

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

## CompositionLocal Providers

- `LocalGlobalComponentProvider` - provides `GlobalComponent`
- `LocalWindowComponentProvider` - provides `WindowComponent`
- `LocalScreenComponentProvider` - provides `ScreenComponent`

## Dependencies

- `common_di` - core DI components and interfaces
- Jetpack Compose (Desktop)
- Compose ViewModel integration

See [DI_DOCUMENTATION.md](../common_di/DI_DOCUMENTATION.md) for the full DI architecture documentation.