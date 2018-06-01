# RadioGroupErrorSupport
This library provides a RadioGroup widget with setError functionality similar to Material Design input widget. It supports mult-line error.

<img src='https://drive.google.com/uc?export=view&id=1fBVRJ2eo0xuaoAgAjbGf-4jt2M-OM2Hq'/>

## Usage

```groovy
repositories { 
    jcenter()
    maven { url “https://jitpack.io” }
}
dependencies {
    impementation 'com.github.abhishekab:RadioGroupErrorSupport:v1.1'
}

```
```java
radioGroupErrorSupport.setErrorTextColor(Color.RED);
radioGroupErrorSupport.setErrorTextSize(12);
radioGroupErrorSupport.setError("This is error test");

// To remove the error
radioGroupErrorSupport.setError(null);
```
