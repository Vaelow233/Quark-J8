plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
    `maven-publish`
    signing
    id("io.github.gradle-nexus.publish-plugin") version "2.0.0"
}

group = "org.vaelow233.quark"
version = "1.3.0"

repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    compileOnly("com.gradleup.shadow:com.gradleup.shadow.gradle.plugin:8.3.11")
}

sourceSets {
    main {
        java.setSrcDirs(listOf("src"))
        resources.setSrcDirs(emptyList<String>())
    }
    test {
        java.setSrcDirs(emptyList<String>())
        resources.setSrcDirs(emptyList<String>())
    }
}

gradlePlugin {
    plugins {
        create("quark") {
            id = "org.vaelow233.quark"
            displayName = "Quark Plugin"
            description = "A lightweight, runtime dependency management system for Java 8 plugins running on Minecraft server platforms"
            implementationClass = "org.vaelow233.quark.gradle.QuarkPlugin"
            vcsUrl = "https://github.com/Vaelow233/Quark-J8"
            tags = listOf("maven", "downloader", "runtime dependency", "minecraft", "bukkit", "spigot", "paper", "bungee")
        }
    }
}

publishing {
    java {
        withSourcesJar()
        withJavadocJar()
    }
}

publishing.publications.withType<MavenPublication>().configureEach {
    pom {
        name.set("Quark-J8 ${project.name}")
        description.set("Java 8 compatible runtime dependency management for Minecraft plugins")
        url.set("https://github.com/Vaelow233/Quark-J8")

        licenses {
            license {
                name.set("GNU General Public License, version 3")
                url.set("https://www.gnu.org/licenses/gpl-3.0.html")
                distribution.set("repo")
            }
        }

        developers {
            developer {
                id.set("Vaelow233")
                name.set("Vaelow233")
                url.set("https://github.com/Vaelow233")
            }
        }

        scm {
            url.set("https://github.com/Vaelow233/Quark-J8")
            connection.set("scm:git:https://github.com/Vaelow233/Quark-J8.git")
            developerConnection.set("scm:git:ssh://git@github.com/Vaelow233/Quark-J8.git")
        }
    }
}

signing {
    useInMemoryPgpKeys(
        providers.environmentVariable("SIGNING_KEY").orNull,
        providers.environmentVariable("SIGNING_PASSWORD").orNull
    )
    sign(publishing.publications)
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
