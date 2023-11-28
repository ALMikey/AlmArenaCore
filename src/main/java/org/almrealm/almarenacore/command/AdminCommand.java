package org.almrealm.almarenacore.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class AdminCommand implements CommandExecutor, TabExecutor {
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length < 1 ) return false;
        if (args[0].equalsIgnoreCase("reload")){
            sender.sendMessage("插件重载完成!");
            return true;
        }
        if (args[0].equalsIgnoreCase("help")){
            sender.sendMessage("输出 help.");
            return true;
        }
        return false;
    }
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        List<String> tabCompletions = new ArrayList<>();

        if (args.length == 1) {
            tabCompletions.add("reload");
            tabCompletions.add("help");
        }

        return tabCompletions;
    }
}
