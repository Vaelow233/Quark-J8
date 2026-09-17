plugins {
    id("java-library")
    id("maven-publish")
    id("signing")
}

group = project.group
version = project.version

tasks.withType<Javadoc> {
    (options as StandardJavadocDocletOptions).apply {
        encoding = Charsets.UTF_8.name()
        use()
        tags("apiNote:a:API Note:")
    }
}

publishing {
    java {
        withSourcesJar()
        withJavadocJar()
    }

    publications {
        create<MavenPublication>("maven") {
            groupId = project.group.toString()
            artifactId = project.name.removePrefix("quark-")
            version = project.version.toString()
            from(components["java"])
        }
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
