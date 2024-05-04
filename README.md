# README

## OTP Edit Text

<img src="https://i.ibb.co/10RPM7v/edittext.jpg" alt="OTP Edit Text" width="200" height="450">

### How to Integrate

To integrate the OTP Edit Text into your project, follow these steps:

1. Add the following code in your `settings.gradle` file:

```groovy
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven { url 'https://jitpack.io' }
        jcenter()
    }
}
```
2. Add the dependency in your `build.gradel` file:
```groovy
implementation 'com.github.samarth2varshney:OTP-Edit-Text:1.0'
```

### How to use
1. Add this in your xml
```xml
<com.example.otp_edit_text.OtpEditText
        android:id="@+id/otp"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"/>
```
2. In your activity
```kotlin
val optEditText = findViewById<OtpEditText>(R.id.otp).getText()
```
3. To get the Otp use this
```kotlin
optEditText.getText()
```
4. To clear the Otp use this
```kotlin
optEditText.Clear()
``` 

