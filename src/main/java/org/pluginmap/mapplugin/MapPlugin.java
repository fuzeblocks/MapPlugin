package org.pluginmap.mapplugin;

import org.bukkit.plugin.java.JavaPlugin;

public final class MapPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
         System.out.println("Map activé");
         getCommand("map").setExecutor(new commandmap(this));
         getCommand("reload").setExecutor(new CommandReload(this));

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
