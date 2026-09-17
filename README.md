<div align="center">

# Quark-J8
Java 8 compatible runtime dependency management for Minecraft plugins.

![bukkit](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy/supported/bukkit_vector.svg)
![bungeecord](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy/supported/bungeecord_vector.svg)
<br>
![fabric](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy/supported/fabric_vector.svg)
![sponge](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy/supported/sponge_vector.svg)

</div>

> [!IMPORTANT]
> This project is a Java 8 compatible fork of [Quark](https://github.com/BX-Team/Quark), which is used with plugins that designed to compatible with Java 8.
> If your plugin is developing under Java 11 or later, consider using the upstream repository!

## ⚙️ Features

- **🚀 Runtime Dependency Loading** - Download and load Maven dependencies at runtime without build-time configuration
- **🔄 Transitive Dependency Resolution** - Automatically resolves and loads all required dependencies
- **📦 Package Relocation** - Relocate packages to avoid conflicts with other plugins or server dependencies
- **🔒 Isolated Class Loading** - Load dependencies into isolated class loaders to prevent conflicts
- **🐘 Gradle Plugin** - Seamless integration with Gradle and ShadowJar
- **🎯 Platform Specific** - Dedicated implementations for **Bukkit**, **BungeeCord**, **Fabric**, and **Sponge**

## 📥 Getting Started

> [!NOTE]
> The documentation is under development, stay tuned!

## 📦 Examples
- [Bukkit Example](https://github.com/Vaelow233/Quark-J8/tree/master/examples/bukkit)
- [Bungee Example](https://github.com/Vaelow233/Quark-J8/tree/master/examples/bungee)
- [Gradle Example](https://github.com/Vaelow233/Quark-J8/tree/master/examples/gradle)

## ⚖️ License ![Static Badge](https://img.shields.io/badge/license-GPL_3.0-lightgreen)

Quark-J8 is licensed under the GNU General Public License v3.0. You can find the license [here](LICENSE).
