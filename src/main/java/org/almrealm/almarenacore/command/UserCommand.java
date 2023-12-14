package org.almrealm.almarenacore.command;

import org.almrealm.almarenacore.AlmArenaCore;
import org.almrealm.almarenacore.manager.GetConfigManager;
import org.almrealm.almarenacore.manager.GetMessagesManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class UserCommand implements CommandExecutor, TabExecutor {
    private final AlmArenaCore plugin;
    public UserCommand(AlmArenaCore plugin) { this.plugin = plugin; }

    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        GetConfigManager gcm = new GetConfigManager(plugin);
        GetMessagesManager gmm = new GetMessagesManager(plugin);

        if (args.length < 1 ) return false;
        if (args[0].equalsIgnoreCase("version")){
            sender.sendMessage("插件版本为: "+gcm.getConfigVersion());
            return true;
        }
        if (args[0].equalsIgnoreCase("reload")){
            plugin.reloadConfig();
            sender.sendMessage(gmm.getMsg("reload"));
            return true;
        }
        if (args[0].equalsIgnoreCase("help")){
            sender.sendMessage(gmm.getMsg("help"));
            return true;
        }
        return false;
    }
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        List<String> tabCompletions = new ArrayList<>();

        if (args.length == 1) {
            tabCompletions.add("version");
            tabCompletions.add("reload");
            tabCompletions.add("help");
        }

        return tabCompletions;
    }
}
