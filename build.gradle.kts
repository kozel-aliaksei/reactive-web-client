plugins {
    java
    `maven-publish`
}

group = "by.akozel"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages1"
            url = uri("https://maven.pkg.github.com/kozel-aliaksei/reactive-web-client/")
            credentials {
                username = System.getenv("GITHUB_ACTOR")
                password = System.getenv("GITHUB_TOKEN")
            }
        }
    }
    publications {
        create<MavenPublication>("reactive-web-client") {
            groupId = "by.akozel"
            artifactId = "reactive-web-client"
            version = "0.0.1"

            from(components["java"])
        }
    }
}

tasks.test {
    useJUnitPlatform()
}