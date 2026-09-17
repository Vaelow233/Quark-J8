package org.vaelow233.quark.example.gradle;

import org.bukkit.plugin.java.JavaPlugin;
import org.vaelow233.quark.bukkit.BukkitLibraryManager;

public class QuarkGradleExamplePlugin extends JavaPlugin {
    private BukkitLibraryManager libraryManager;

    @Override
    public void onLoad() {
        libraryManager = new BukkitLibraryManager(this);
        libraryManager.loadFromGradle();
    }
}
