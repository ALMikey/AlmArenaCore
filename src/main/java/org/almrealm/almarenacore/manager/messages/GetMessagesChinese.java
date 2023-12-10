package org.almrealm.almarenacore.manager.messages;

import org.almrealm.almarenacore.AlmArenaCore;
import org.almrealm.almarenacore.manager.GetConfigManager;
import org.bukkit.configuration.file.FileConfiguration;

public class GetMessagesChinese {
    private static GetConfigManager instance;
    // 插件实例
    private final AlmArenaCore plugin;
    // 配置文件
    private FileConfiguration Chinese;

    // 私有构造函数，确保只能通过getInstance方法获取实例
    public GetMessagesChinese(AlmArenaCore plugin) {
        this.plugin = plugin;
    }
}
