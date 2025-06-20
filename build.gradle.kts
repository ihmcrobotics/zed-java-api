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
    api("us.ihmc:javacpp:1.5.11-ihmc-2") {
        isTransitive = true
    }
    api("us.ihmc:cuda:12.6-9.5-1.5.11-ihmc-2") {
        isTransitive = true
    }
    api("us.ihmc:ihmc-native-library-loader:2.0.4") {
        isTransitive = true
    }
}

testDependencies {
   // OpenCV for demos
   val openblasVersion = "0.3.28-1.5.11-ihmc-2"
   implementation("us.ihmc:openblas:$openblasVersion")
   implementation("us.ihmc:openblas:$openblasVersion:linux-x86_64")
   implementation("us.ihmc:openblas:$openblasVersion:linux-arm64")
   implementation("us.ihmc:openblas:$openblasVersion:windows-x86_64")
   val opencvVersion = "4.10.0-1.5.11-ihmc-2"
   implementation("us.ihmc:opencv:$opencvVersion")
   implementation("us.ihmc:opencv:$opencvVersion:linux-arm64")
   implementation("us.ihmc:opencv:$opencvVersion:linux-x86_64")
   implementation("us.ihmc:opencv:$opencvVersion:windows-x86_64")
}
