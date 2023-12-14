package org.almrealm.almarenacore.manager;

import org.almrealm.almarenacore.AlmArenaCore;

public class SaveResourceManager {

    private final AlmArenaCore plugin;
    public SaveResourceManager(AlmArenaCore plugin) { this.plugin = plugin; }
    public void myResource(){
        plugin.saveDefaultConfig();
        plugin.saveResource("messages/chinese.yml",false);
        plugin.saveResource("messages/english.yml",false);
    }
}
