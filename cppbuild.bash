#!/bin/bash
# This build script is designed to work on Linux and Windows. For Windows, run from a bash shell launched with launchBashWindows.bat
pushd .
mkdir cppbuild
cd cppbuild

ZED_C_API_VERSION=4.1.0
if [ ! -f "zed-c-api.tar.gz" ]; then
  curl -o zed-c-api.tar.gz https://codeload.github.com/stereolabs/zed-c-api/tar.gz/refs/tags/v$ZED_C_API_VERSION
fi

tar -xvf zed-c-api.tar.gz

cp ../patches/CMakeLists.txt.zed_c_api.patch zed-c-api-$ZED_C_API_VERSION/CMakeLists.txt.zed_c_api.patch

cd zed-c-api-$ZED_C_API_VERSION

patch CMakeLists.txt CMakeLists.txt.zed_c_api.patch

mkdir build
cd build

cmake ..
cmake --build . --config Release --target install

popd
### Java generation ####
cd cppbuild
cp -r ../src/main/java/* .

JAVACPP_VERSION=1.5.10
JAVACPP_CUDA_VERSION=12.3-8.9-1.5.10
if [ ! -f javacpp.jar ]; then
  curl -L https://github.com/bytedeco/javacpp/releases/download/$JAVACPP_VERSION/javacpp-platform-$JAVACPP_VERSION-bin.zip -o javacpp-platform-$JAVACPP_VERSION-bin.zip
  unzip -j javacpp-platform-$JAVACPP_VERSION-bin.zip
fi
if [ ! -f cuda-$JAVACPP_CUDA_VERSION.jar ]; then
    curl -O https://repo.maven.apache.org/maven2/org/bytedeco/cuda/$JAVACPP_CUDA_VERSION/cuda-$JAVACPP_CUDA_VERSION.jar
fi

java -cp "javacpp.jar:cuda-$JAVACPP_CUDA_VERSION.jar" org.bytedeco.javacpp.tools.Builder us/ihmc/zed/ZEDJavaAPIConfig.java
cp us/ihmc/zed/*.java ../src/main/java/us/ihmc/zed
cp us/ihmc/zed/global/*.java ../src/main/java/us/ihmc/zed/global/

#### JNI compilation ####
java -cp "javacpp.jar:cuda-$JAVACPP_CUDA_VERSION.jar" org.bytedeco.javacpp.tools.Builder us/ihmc/zed/*.java us/ihmc/zed/global/*.java -d javainstall

##### Copy shared libs to resources ####
# Linux
mkdir -p ../src/main/resources/zed-java-api/native/linux-x86_64
if [ -f "javainstall/libjnized.so" ]; then
  cp javainstall/libjnized.so ../src/main/resources/zed-java-api/native/linux-x86_64
fi
if [ -f "lib/libsl_zed_c.so" ]; then
  cp lib/libsl_zed_c.so ../src/main/resources/zed-java-api/native/linux-x86_64
fi
# Windows
mkdir -p ../src/main/resources/zed-java-api/native/windows-x86_64
if [ -f "javainstall/jnized.dll" ]; then
  cp javainstall/jnized.dll ../src/main/resources/zed-java-api/native/windows-x86_64
fi
if [ -f "bin/sl_zed_c.dll" ]; then
  cp bin/sl_zed_c.dll ../src/main/resources/zed-java-api/native/windows-x86_64
fi