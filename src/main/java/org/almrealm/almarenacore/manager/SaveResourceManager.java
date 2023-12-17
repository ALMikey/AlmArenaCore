package org.almrealm.almarenacore.manager;

import org.almrealm.almarenacore.AlmArenaCore;

import java.io.File;

public class SaveResourceManager {

    private final AlmArenaCore plugin;
    private File chineseFile;
    private File englishFile;
    public SaveResourceManager(AlmArenaCore plugin) { this.plugin = plugin; }
    public void saveFile() {
        // 获取插件数据文件夹
        // File dataFolder = plugin.getDataFolder();
        chineseFile = new File(plugin.getDataFolder(),"messages/chinese.yml");
        englishFile = new File(plugin.getDataFolder(),"messages/english.yml");

        // 如果文件不存在...
        if (!chineseFile.exists()){
            plugin.saveResource("messages/chinese.yml", false);
        }
        if (!englishFile.exists()){
            plugin.saveResource("messages/english.yml", false);
        }
    }
}
