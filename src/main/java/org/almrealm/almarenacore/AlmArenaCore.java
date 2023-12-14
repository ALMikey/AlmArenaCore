package org.almrealm.almarenacore;

import org.almrealm.almarenacore.command.UserCommand;
import org.almrealm.almarenacore.listener.PlayerKillListener;
import org.almrealm.almarenacore.manager.GetConfigManager;
import org.almrealm.almarenacore.manager.GetMessagesManager;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class AlmArenaCore extends JavaPlugin {

    private GetConfigManager gcm;
    private GetMessagesManager gmm;
    public void onLoad() {
        getLogger().info("Loading...");

    }
    @Override
    public void onEnable() {
        getLogger().info("Welcome to use！！");
        saveDefaultConfig();
        saveResource("messages/chinese.yml",false);
        saveResource("messages/english.yml",false);

        // 初始化 GetConfigManager.java 实例
        gcm = new GetConfigManager(this);
        gmm = new GetMessagesManager(this);

        getServer().getPluginManager().registerEvents(new PlayerKillListener(this),this);
        getServer().getPluginCommand("almarenacore").setExecutor(new UserCommand(this));


    }

    @Override
    public void onDisable() {
        getLogger().info("Hey Goodbye/~");

    }
}
