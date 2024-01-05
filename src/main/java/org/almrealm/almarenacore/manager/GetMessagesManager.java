package org.almrealm.almarenacore.manager;

import me.clip.placeholderapi.PlaceholderAPI;
import org.almrealm.almarenacore.AlmArenaCore;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class GetMessagesManager {
    private final AlmArenaCore plugin;
    private YamlConfiguration messagesConfig;
    public GetMessagesManager(AlmArenaCore plugin) {
        this.plugin = plugin;
        getMessage();
    }
//    public FileConfiguration getMessagesConfig() {
//        File messageFile = new File(plugin.getDataFolder(), "messages/chinese.yml");
//
//        if (!messageFile.exists()) {
//            // 如果文件不存在，从JAR文件中复制默认文件到插件文件夹
//            plugin.saveResource("messages/chinese.yml", false);
//        }
//        return YamlConfiguration.loadConfiguration(messageFile);
//    }
    public void getMessage(){
        // 声明 GetConfigManager 类 用于获取 gcm.getConfigLanguage();
        GetConfigManager gcm = new GetConfigManager(plugin);
        String Language = gcm.getString("Language");
        // 语言切换模块
        File messageFile = new File(plugin.getDataFolder(), "messages/"+Language+".yml");
        messagesConfig = YamlConfiguration.loadConfiguration(messageFile);
    }
    // 默认使用获取消息
    public String getMsg(String key) {
        String msg = messagesConfig.getString("messages." + key);
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
    // 替换玩家占位符方法
    public String getMsgPlayer(Player player, String key) {
        String msg = messagesConfig.getString("messages." + key);
        msg = ChatColor.translateAlternateColorCodes('&', msg);
        return PlaceholderAPI.setPlaceholders(player, msg);
    }

}
