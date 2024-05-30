# zed-java-api
zed-java-api provides Java JNI bindings for ZED SDK. The bindings are based on [zed-c-api](https://github.com/stereolabs/zed-c-api).

Allows you to use Stereolabs sensors such as ZED 2, ZED 2i, ZED X, ZED Mini, ZED X Mini from Java.
## Usage
zed-java-api requires ZED SDK to be installed on the system. Download ZED SDK for your system from [here](https://www.stereolabs.com/developers/release).

Supported platforms:
- Linux (Ubuntu 20.04+ or similar x86_64)
- SOON: Linux, NVIDIA Jetson (arm64)
- Windows (Windows 10+ x86_64)

Requires Java 17
### Gradle
```
dependencies {
  implementation("us.ihmc:zed-java-api:1.0.0")
}
```
### Maven
```
<dependencies>
  <dependency>
    <groupId>us.ihmc</groupId>
    <artifactId>zed-java-api</artifactId>
    <version>1.0.0</version>
  </dependency>
</dependencies>
```
### Setup
You must manually load the library first before using it.
```
ZEDJavaAPINativeLibrary.load();
```
Ensure [this test](https://github.com/ihmcrobotics/zed-java-api/blob/main/src/test/java/us/ihmc/zed/test/TestNativeLibraryLoads.java) runs on your machine before proceeding.