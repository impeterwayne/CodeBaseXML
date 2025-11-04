# Application Architecture Guidelines

## Overview
The Android application in this repository is organized using a layered Model–View–ViewModel (MVVM) architecture. Code is grouped into the following top-level packages:

- `data/` – platform and network access, persistence, and DTO transformations.
- `domain/` – business entities (`model/`) and use-case level contracts (`repository/`).
- `presenter/` – UI layer composed of view components, adapters, and Jetpack ViewModels.
- `di/`, `utils/`, and `binding/` – shared helpers such as dependency injection setup, utility extensions, and binding adapters.

Changes should keep responsibilities within their respective layers and add new packages that mirror this structure when introducing features.

## MVVM expectations

1. **Views** (Activities, Fragments, Composables, adapters) belong in the `presenter/` layer. They should only interact with the exposed state from a ViewModel and send user actions as events.
2. **ViewModels** must extend `BaseViewModel` from `presenter/base/common`. This base class provides:
   - Coroutine scope management with a standardized `launchBlock` helper.
   - Connectivity and purchase-state flows shared across the UI.
   - An `onEvent` contract that enforces event-driven state handling.
3. **Domain layer** should remain UI-agnostic. Use data classes in `domain/model` for state exposed to the UI, and define repositories or use-case interfaces inside `domain/repository`.
4. **Data layer** implementations must satisfy the contracts defined in the domain layer and should not depend on view classes. Use DTO-to-domain mappings inside the data layer.

## Working with `BaseViewModel`

- Implement feature-specific ViewModels by extending `BaseViewModel<MyEvent>` and overriding `onEvent` to handle all user interactions.
- Expose UI state via `StateFlow` or `SharedFlow`. When adding new state holders, keep them `private` and expose read-only flows using `.asStateFlow()`.
- Use `launchBlock` for asynchronous work so that coroutines benefit from the shared `CoroutineExceptionHandler`.
- Update the provided `purchaseState` and `networkState` flows only when necessary. If additional shared states are required, add them in the base class with careful consideration to avoid feature coupling.

## Feature implementation checklist

- [ ] Define or update domain models and repository contracts to represent new business logic.
- [ ] Add data-layer implementations that fulfill domain contracts and handle platform or API integration.
- [ ] Create/extend a `BaseViewModel` subclass in the presenter layer, managing UI state through immutable flows and the `onEvent` contract.
- [ ] Wire the ViewModel to UI components so that views observe state and forward user intents as events.
- [ ] Provide dependency injection bindings so that ViewModels and data sources can be constructed consistently across the app.

Following these guidelines keeps the codebase aligned with the existing MVVM architecture and ensures that new contributions integrate seamlessly.
