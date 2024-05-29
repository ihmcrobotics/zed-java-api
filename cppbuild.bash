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

find ./zed-c-api-$ZED_C_API_VERSION -type f -print0 | xargs -0 dos2unix
cd zed-c-api-$ZED_C_API_VERSION

patch CMakeLists.txt CMakeLists.txt.zed_c_api.patch

mkdir build
cd build

if [ "$MAC_CROSS_COMPILE_ARM" == "1" ]; then
  cmake -DCMAKE_OSX_ARCHITECTURES="arm64" ..
elif [ "$LINUX_CROSS_COMPILE_ARM" == "1" ]; then
  cmake -DCMAKE_C_COMPILER=aarch64-linux-gnu-gcc \
        -DCMAKE_CXX_COMPILER=aarch64-linux-gnu-g++ \
        -DCMAKE_FIND_ROOT_PATH=/usr/aarch64-linux-gnu \
        -DCMAKE_PROGRAM_PATH=/usr/aarch64-linux-gnu/bin \
        ..
else
  cmake ..
fi
cmake --build . --config Release
cmake --build . --target install

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
# TODO: Fix CUDA
#if [ ! -f cuda-$JAVACPP_CUDA_VERSION.jar ]; then
#    curl -O https://repo.maven.apache.org/maven2/org/bytedeco/cuda/$JAVACPP_CUDA_VERSION/cuda-$JAVACPP_CUDA_VERSION.jar
#    unzip cuda-$JAVACPP_CUDA_VERSION.jar
#fi

java -jar javacpp.jar us/ihmc/zed/ZEDJavaAPIConfig.java
cp us/ihmc/zed/*.java ../src/main/java/us/ihmc/zed
cp us/ihmc/zed/global/*.java ../src/main/java/us/ihmc/zed/global/

#### JNI compilation ####
if [ "$MAC_CROSS_COMPILE_ARM" == "1" ]; then
  java -jar javacpp.jar -properties macosx-arm64 us/ihmc/zed/*.java us/ihmc/zed/global/*.java -d javainstall
elif [ "$LINUX_CROSS_COMPILE_ARM" == "1" ]; then
  java -jar javacpp.jar -properties linux-arm64 -Dplatform.compiler=aarch64-linux-gnu-g++ us/ihmc/zed/*.java us/ihmc/zed/global/*.java -d javainstall
else
  java -jar javacpp.jar us/ihmc/zed/*.java us/ihmc/zed/global/*.java -d javainstall
fi

##### Copy shared libs to resources ####
# Linux
mkdir -p ../src/main/resources/zed-java-api/native/linux-x86_64
mkdir -p ../src/main/resources/zed-java-api/native/linux-arm64
if [ -f "javainstall/libjnized.so" ]; then
  if [ "$LINUX_CROSS_COMPILE_ARM" == "1" ]; then
    cp javainstall/libjnized.so ../src/main/resources/zed-java-api/native/linux-arm64
  else
    cp javainstall/libjnized.so ../src/main/resources/zed-java-api/native/linux-x86_64
  fi
fi
if [ -f "lib/libsl_zed_c.so" ]; then
  if [ "$LINUX_CROSS_COMPILE_ARM" == "1" ]; then
    cp lib/libsl_zed_c.so ../src/main/resources/zed-java-api/native/linux-arm64
  else
    cp lib/libsl_zed_c.so ../src/main/resources/zed-java-api/native/linux-x86_64
  fi
fi