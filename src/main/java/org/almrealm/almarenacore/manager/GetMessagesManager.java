package org.almrealm.almarenacore.manager;

import org.almrealm.almarenacore.AlmArenaCore;
import org.bukkit.configuration.file.YamlConfiguration;

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
        GetConfigManager gcm = new GetConfigManager(plugin);
        String Language = gcm.getConfigLanguage();
        File messageFile = new File(plugin.getDataFolder(), "messages/"+Language+".yml");
        messagesConfig = YamlConfiguration.loadConfiguration(messageFile);
    }
    public String getMsg(String key) {
        return messagesConfig.getString("messages." + key);
    }

}
