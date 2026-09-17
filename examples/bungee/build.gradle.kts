plugins {
    id("java")
    id("com.gradleup.shadow") version "8.3.11"
}

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/groups/public/")
}

dependencies {
    compileOnly("net.md-5:bungeecord-api:1.19-R0.1-SNAPSHOT")

    // implementation("org.vaelow233.quark:bungee:1.x.x") // <-- uncomment in your project and set the version
    implementation(project(":quark-bungee")) // don't use this line in your build file
}

val pluginName = "BungeeExamplePlugin"

tasks {
    build {
        dependsOn(shadowJar)
    }

    java {
        toolchain.languageVersion.set(JavaLanguageVersion.of(8))
    }

    jar {
        enabled = false
    }

    shadowJar {
        archiveBaseName.set(pluginName)
        archiveClassifier.set("")
        minimize()
    }
}
