plugins {
    id("java-library")
    id("maven-publish")
}

group = "us.ihmc"
version = "4.2.0_2"

repositories {
    mavenCentral()
}

java {
    withSourcesJar()
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])

            groupId = project.group.toString()
            artifactId = "zed-java-api"
            version = project.version.toString()
        }
    }

    repositories {
        maven {
            val releasesRepo = uri("https://s01.oss.sonatype.org/content/repositories/releases")
            val snapshotsRepo = uri("https://s01.oss.sonatype.org/content/repositories/snapshots")
            url = if (version.toString().endsWith("SNAPSHOT")) snapshotsRepo else releasesRepo

            credentials {
                username = project.findProperty("publishUsername").toString()
                password = project.findProperty("publishPassword").toString()
            }
        }
    }
}

dependencies {
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

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    // OpenCV for demos
    val openblasVersion = "0.3.28-1.5.11-ihmc-2"
    testImplementation("us.ihmc:openblas:$openblasVersion")
    testImplementation("us.ihmc:openblas:$openblasVersion:linux-x86_64")
    testImplementation("us.ihmc:openblas:$openblasVersion:linux-arm64")
    testImplementation("us.ihmc:openblas:$openblasVersion:windows-x86_64")
    val opencvVersion = "4.10.0-1.5.11-ihmc-2"
    testImplementation("us.ihmc:opencv:$opencvVersion")
    testImplementation("us.ihmc:opencv:$opencvVersion:linux-arm64")
    testImplementation("us.ihmc:opencv:$opencvVersion:linux-x86_64")
    testImplementation("us.ihmc:opencv:$opencvVersion:linux-x86_64-gpu")
    testImplementation("us.ihmc:opencv:$opencvVersion:windows-x86_64")
    testImplementation("us.ihmc:opencv:$opencvVersion:windows-x86_64-gpu")
}

tasks.test {
    useJUnitPlatform()
}
