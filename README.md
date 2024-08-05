# zed-java-api
zed-java-api provides Java JNI bindings for ZED SDK. The bindings are based on [zed-c-api](https://github.com/stereolabs/zed-c-api).

Currently compatible with ZED SDK **4.1.3**.

Allows you to use Stereolabs sensors such as ZED 2, ZED 2i, ZED X, ZED Mini, ZED X Mini from Java.
## Usage
zed-java-api requires ZED SDK to be installed on the system. Download ZED SDK for your system from [here](https://www.stereolabs.com/developers/release). You do not need to install zed-c-api, just ZED SDK.

Supported platforms:
- Linux (Ubuntu 20.04+ or similar x86_64)
- SOON: Linux, NVIDIA Jetson (arm64)
- Windows (Windows 10+ x86_64)

Requires Java 17.
### Gradle
```
dependencies {
  implementation("us.ihmc:zed-java-api:4.1.3-1")
}
```
### Maven
```
<dependencies>
  <dependency>
    <groupId>us.ihmc</groupId>
    <artifactId>zed-java-api</artifactId>
    <version>4.1.3-1</version>
  </dependency>
</dependencies>
```
### Setup
You must manually load the library first before using it.
```
ZEDJavaAPINativeLibrary.load();
```
Ensure [this test](https://github.com/ihmcrobotics/zed-java-api/blob/main/src/test/java/us/ihmc/zed/test/TestNativeLibraryLoads.java) runs on your machine before proceeding.

### OpenCV Demo
A basic demo to display the images read from the camera is located in [DemoImageCaptureOpenCV.java](https://github.com/ihmcrobotics/zed-java-api/blob/main/src/test/java/us/ihmc/zed/test/DemoImageCaptureOpenCV.java).
<p align="center">
  <img src="https://github.com/ihmcrobotics/zed-java-api/assets/30220598/a040c614-f7ed-4475-bd86-5b1feee497f0" width="600px">
</p>
