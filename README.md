# SecurePreferencesX

> **Archived / discontinued**
>
> SecurePreferencesX is a historical Android library that provided a small wrapper around Jetpack Security's encrypted `SharedPreferences` APIs.
>
> **Do not use this library in new applications.**

This repository is preserved for historical and reference purposes and is no longer maintained.

## Background

SecurePreferencesX was created to simplify the use of the then-new Android Jetpack Security APIs for storing encrypted key-value data.

Instead of configuring the underlying encrypted preferences implementation directly, applications could initialize SecurePreferencesX once and then use a small API for storing and retrieving values.

The library was built on top of AndroidX Security Crypto and delegated encryption, decryption, and key management to Jetpack Security.

## Why is this project archived?

The Android security APIs this project was built around have since changed substantially.

In particular, AndroidX now marks APIs including:

* `EncryptedSharedPreferences`
* `MasterKey`
* `MasterKeys`

as deprecated.

Because SecurePreferencesX is fundamentally a wrapper around those APIs, updating the library would require redesigning its underlying security model rather than simply updating its dependencies.

For new Android applications, use the current Android security guidance and platform APIs instead.

Relevant documentation:

* [Android cryptography documentation](https://developer.android.com/privacy-and-security/cryptography)
* [Android Keystore system](https://developer.android.com/privacy-and-security/keystore)
* [AndroidX Security Crypto API reference](https://developer.android.com/reference/androidx/security/crypto/package-summary)

## Historical API

The following examples document how SecurePreferencesX was originally used.

### Initialize

```kotlin
SecurePreferences.initSecurePreferences(
    packageName,
    "SecurePreferencesFileName"
)
```

### Store a value

```kotlin
SecurePreferences.storeValue(
    context,
    "key",
    "value"
)
```

### Retrieve a value

```kotlin
val value = SecurePreferences.getValue(
    context,
    "key",
    "defaultValue"
)
```

## Original behavior

SecurePreferencesX:

* provided a minimal wrapper around Jetpack Security encrypted preferences;
* handled creation and access to encrypted `SharedPreferences`;
* delegated encryption and key management to AndroidX Security;
* supported Android API 23 and above;
* provided a simpler application-facing API for storing and retrieving encrypted values.

## Security notice

This repository contains an old implementation built against early versions of AndroidX Security.

It should **not** be treated as a current security recommendation or used as a dependency in new production applications.

Security-sensitive storage should be implemented according to current Android platform guidance, taking into account requirements such as:

* Android Keystore usage;
* key generation and lifecycle;
* authentication requirements;
* backup and restore behavior;
* key invalidation;
* migration between storage formats;
* supported Android API levels.

## Project status

**Status:** Archived
**Maintenance:** Discontinued
**Recommended for new projects:** No

The source remains available because it represents the original implementation and may still be useful for historical reference.

## License

Licensed under the [Apache License 2.0](LICENSE).
