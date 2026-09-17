pluginManagement {
    includeBuild("gradle-plugin")
}

rootProject.name = "Quark-J8"

setOf(
    "bukkit",
    "bungee",
    "core",
    "fabric",
    "sponge",
).forEach {
    subProject(it)
}

fun subProject(name: String) {
    include(":quark-$name")
    project(":quark-$name").projectDir = file(name)
}

setOf(
    "bukkit",
    "bungee",
    "gradle",
).forEach {
    exampleProject(it)
}

fun exampleProject(name: String) {
    include(":examples:$name")
    project(":examples:$name").projectDir = file("examples/$name")
}
