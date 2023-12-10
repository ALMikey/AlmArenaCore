package org.almrealm.almarenacore.manager;

import org.almrealm.almarenacore.AlmArenaCore;
import org.bukkit.configuration.file.FileConfiguration;

public class GetConfigManager {
    // 单例实例
    private static GetConfigManager instance;
    // 插件实例
    private final AlmArenaCore plugin;
    // 配置文件
    private FileConfiguration config;

    // 私有构造函数，确保只能通过getInstance方法获取实例
    public GetConfigManager(AlmArenaCore plugin) {
        this.plugin = plugin;
        // 初始化配置文件
        plugin.reloadConfig();
        // 获取插件config.yml
        this.config = plugin.getConfig();
    }

    // 获取config.yml中的字符串值
    public String getString(String key) {
        return config.getString(key);
    }

    // 获取config.yml中的整数值
    public int getInt(String key) {
        return config.getInt(key);
    }

    // 获取config.yml中的布尔值
    public boolean getBoolean(String key) {
        return config.getBoolean(key);
    }

    // 获取配置文件内容
    public String getConfigVersion() { return getString("Version"); }
    public String getConfigLanguage() {
        return getString("Language");
    }
    public String getConfigArenaWorld() {
        return getString("ArenaWorld");
    }


}
