plugins {
    id("java-library")
    id("maven-publish")
}

group = "us.ihmc"
version = "4.1.2-SNAPSHOT"

repositories {
    mavenCentral()
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
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    api("org.bytedeco:javacpp:1.5.10") {
        isTransitive = true
    }
    api("org.bytedeco:cuda:12.3-8.9-1.5.10") {
        isTransitive = true
    }
    api("us.ihmc:ihmc-native-library-loader:2.0.2") {
        isTransitive = true
    }
}

tasks.test {
    useJUnitPlatform()
}
