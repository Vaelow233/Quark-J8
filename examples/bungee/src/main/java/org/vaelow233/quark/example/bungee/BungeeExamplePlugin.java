package org.vaelow233.quark.example.bungee;

import net.md_5.bungee.api.plugin.Plugin;
import org.vaelow233.quark.bungee.BungeeLibraryManager;
import org.vaelow233.quark.dependency.Dependency;
import org.vaelow233.quark.relocation.Relocation;

import java.util.Collections;

public class BungeeExamplePlugin extends Plugin {
    private BungeeLibraryManager libraryManager;

    @Override
    public void onLoad() {
        libraryManager = new BungeeLibraryManager(this);
        libraryManager.addGoogleMavenCentralMirror();

        libraryManager.loadDependencies(
            Collections.singletonList(
                Dependency.of("com.google.code.gson", "gson", "2.10.1")),
            Collections.singletonList(
                Relocation.of("com.google.gson",
                    "org.bxteam.quarkj8test.gson"))
        );

        try {
            Class<?> type = Class.forName(
                "org.bxteam.quarkj8test.gson.Gson",
                true,
                getClass().getClassLoader()
            );

            Object gson = type.getDeclaredConstructor().newInstance();
            String json = (String) type.getMethod("toJson", Object.class)
                .invoke(gson, Collections.singletonMap("answer", 42));

            if (!"{\"answer\":42}".equals(json)) {
                throw new IllegalStateException("Unexpected JSON: " + json);
            }

            getLogger().info("Java " + System.getProperty("java.version"));
            getLogger().info("Gson loaded from: "
                + type.getProtectionDomain().getCodeSource().getLocation());
            getLogger().info("QUARK_J8_TEST_PASS");
        } catch (ReflectiveOperationException e) {
            throw new IllegalStateException("Quark Java 8 test failed", e);
        }
    }
}
