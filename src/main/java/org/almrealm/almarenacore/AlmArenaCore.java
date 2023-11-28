package org.almrealm.almarenacore;

import org.almrealm.almarenacore.command.AdminCommand;
import org.almrealm.almarenacore.listener.PlayerKillListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class AlmArenaCore extends JavaPlugin {

    public void onLoad() {
        getLogger().info("Loading...");
    }

    @Override
    public void onEnable() {
        getLogger().info("Welcome to use！！");
        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new PlayerKillListener(),this);

        getServer().getPluginCommand("almarenacore").setExecutor(new AdminCommand());

    }

    @Override
    public void onDisable() {
        getLogger().info("Hey Goodbye/~");

    }
}
