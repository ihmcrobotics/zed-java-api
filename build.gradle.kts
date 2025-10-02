plugins {
   id("java")
   id("us.ihmc.ihmc-build")
}

ihmc {
   group = "us.ihmc"
   version = "5.0.0"
   vcsUrl = "https://github.com/ihmcrobotics/zed-java-api"
   openSource = true
   description = "Use Stereolabs sensors such as ZED 2, ZED 2i, ZED X, ZED Mini, ZED X Mini from Java."

   configureDependencyResolution()
   configurePublications()
}

tasks.javadoc {
   // The javadoc compiler has a lot of errors with the javacpp generated comments, but we need a javadoc.jar for publishing
   exclude("us/ihmc/zed/**")
}

mainDependencies {
   // Transitive dependencies
   api("org.bytedeco:javacpp:1.5.11") {
      isTransitive = true
   }
   api("org.bytedeco:cuda:12.6-9.5-1.5.11") {
      isTransitive = true
   }
   api("us.ihmc:ihmc-native-library-loader:2.0.4") {
      isTransitive = true
   }
}

testDependencies {
   val openblasVersion = "0.3.28-1.5.11"
   api("org.bytedeco:openblas:$openblasVersion")
   api("org.bytedeco:openblas:$openblasVersion:linux-x86_64")
   api("org.bytedeco:openblas:$openblasVersion:linux-arm64")
   api("org.bytedeco:openblas:$openblasVersion:windows-x86_64")
   val opencvVersion = "4.10.0-1.5.11-20251001-ihmc" // Hosted on https://robotlabfiles.ihmc.us/repository
   api("us.ihmc:opencv:$opencvVersion")
   api("us.ihmc:opencv:$opencvVersion:linux-arm64")
   api("us.ihmc:opencv:$opencvVersion:linux-arm64-gpu")
   api("us.ihmc:opencv:$opencvVersion:linux-x86_64")
   api("us.ihmc:opencv:$opencvVersion:linux-x86_64-gpu")
   api("us.ihmc:opencv:$opencvVersion:windows-x86_64")
   api("us.ihmc:opencv:$opencvVersion:windows-x86_64-gpu")
}
