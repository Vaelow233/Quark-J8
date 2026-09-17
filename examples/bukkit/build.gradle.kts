plugins {
    id("java")
    id("com.gradleup.shadow") version "8.3.11"
    id("xyz.jpenilla.run-paper") version "2.3.1"
}

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/groups/public/")
}

dependencies {
    compileOnly("org.spigotmc:spigot-api:1.19.4-R0.1-SNAPSHOT")

    // implementation("org.bxteam.quark:bukkit:1.x.x") // <-- uncomment in your project and set the version
    implementation(project(":quark-bukkit")) // don't use this line in your build file
}

val pluginName = "BukkitExamplePlugin"

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

    runServer {
        minecraftVersion("1.19.4")
        allJvmArgs = listOf("-DPaper.IgnoreJavaVersion=true")
    }
}
