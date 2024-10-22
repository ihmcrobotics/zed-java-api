#!/bin/bash
# This build script is designed to work on Linux and Windows. For Windows, run from a bash shell launched with launchBashWindows.bat
pushd .
mkdir cppbuild
cd cppbuild

ZED_C_API_VERSION=4.2.0
if [ ! -f "zed-c-api.tar.gz" ]; then
  curl -o zed-c-api.tar.gz https://codeload.github.com/stereolabs/zed-c-api/tar.gz/refs/tags/v$ZED_C_API_VERSION
fi

tar -xvf zed-c-api.tar.gz

cp ../patches/CMakeLists.txt.zed_c_api.patch zed-c-api-$ZED_C_API_VERSION/CMakeLists.txt.zed_c_api.patch

cd zed-c-api-$ZED_C_API_VERSION

patch CMakeLists.txt CMakeLists.txt.zed_c_api.patch

mkdir build
cd build

if [ "$(uname)" == "Linux" ]; then
  if [ "$LINUX_CROSS_COMPILE_ARM" == "1" ]; then
    # For some reason, it's stubs_ on older versions of L4T
    cmake -DCMAKE_LIBRARY_PATH=/usr/local/cuda/lib64/stubs_ ..
  else
    cmake -DCMAKE_LIBRARY_PATH=/usr/local/cuda/lib64/stubs ..
  fi
else # Windows
  cmake ..
fi
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

CP_SEPARATOR=":"
UNAME=$( command -v uname)
case $( "${UNAME}" | tr '[:upper:]' '[:lower:]') in
  msys*|cygwin*|mingw*|nt|win*)
    CP_SEPARATOR=";"
    ;;
  *)
    CP_SEPARATOR=":"
    ;;
esac

java -cp "javacpp.jar"$CP_SEPARATOR"cuda-$JAVACPP_CUDA_VERSION.jar" org.bytedeco.javacpp.tools.Builder us/ihmc/zed/ZEDJavaAPIConfig.java
cp us/ihmc/zed/*.java ../src/main/java/us/ihmc/zed
cp us/ihmc/zed/global/*.java ../src/main/java/us/ihmc/zed/global/

#### JNI compilation ####
java -cp "javacpp.jar"$CP_SEPARATOR"cuda-$JAVACPP_CUDA_VERSION.jar" org.bytedeco.javacpp.tools.Builder us/ihmc/zed/*.java us/ihmc/zed/global/*.java -d javainstall

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
# Windows
mkdir -p ../src/main/resources/zed-java-api/native/windows-x86_64
if [ -f "javainstall/jnized.dll" ]; then
  cp javainstall/jnized.dll ../src/main/resources/zed-java-api/native/windows-x86_64
fi
if [ -f "bin/sl_zed_c.dll" ]; then
  cp bin/sl_zed_c.dll ../src/main/resources/zed-java-api/native/windows-x86_64
fi