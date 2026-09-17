plugins {
    id("java-library")
    id("io.github.gradle-nexus.publish-plugin") version "2.0.0"
}

allprojects {
    group = project.group
    version = project.version

    repositories {
        mavenCentral()
    }
}

nexusPublishing {
    repositories {
        sonatype {
            nexusUrl.set(
                uri("https://ossrh-staging-api.central.sonatype.com/service/local/")
            )
            snapshotRepositoryUrl.set(
                uri("https://central.sonatype.com/repository/maven-snapshots/")
            )

            username.set(
                providers.environmentVariable("CENTRAL_USERNAME")
            )
            password.set(
                providers.environmentVariable("CENTRAL_PASSWORD")
            )
        }
    }
}
