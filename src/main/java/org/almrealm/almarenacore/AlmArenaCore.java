package org.almrealm.almarenacore;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class AlmArenaCore extends JavaPlugin implements Listener {



    @Override
    public void onLoad() {
        getLogger().info("Loading...");
    }

    @Override
    public void onEnable() {
        getLogger().info("Welcome to use!!");
        saveResource("config.yml", false);
        saveDefaultConfig();

//        Bukkit.getCommandMap().register(this.getName(),);
    }

    @Override
    public void onDisable() {
        getLogger().info("Hey Goodbye/~");
    }
}
