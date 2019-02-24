## How to build the application?

`./gradlew build`

## How to run the game?

`./gradlew desktop:run`

## How to build the APK for Android?

Create a `keystore.properties` file in this directory:
```
storePassword=storePassword
keyPassword=keyPassword
keyAlias=keyAlias
storeFile=storeFile.jks
```

Create a `local.properties` file in this directory if you didn't have set `ANDROID_HOME`:
```
sdk.dir=<path to the android sdk>
```


`./gradlew android:assembleRelease -PANDROID=true`

Because the android plugin is a bit buggy with IntelliJ, Android project is enable only on demand, thanks
to the parameter `ANDROID`