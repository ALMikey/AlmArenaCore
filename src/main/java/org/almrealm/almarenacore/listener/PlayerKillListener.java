package org.almrealm.almarenacore.listener;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.almrealm.almarenacore.AlmArenaCore;
import org.almrealm.almarenacore.manager.GetConfigManager;
import org.almrealm.almarenacore.manager.GetMessagesManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerKillListener implements Listener {
    private final AlmArenaCore plugin;
    public PlayerKillListener(AlmArenaCore plugin) { this.plugin = plugin; }
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {

        GetConfigManager gcm = new GetConfigManager(plugin);
        String ArenaWorld = gcm.getString("ArenaWorld");

        Player victim = event.getEntity();
        Player killer = event.getEntity().getKiller();

        if (killer.getWorld().getName().equalsIgnoreCase(ArenaWorld)){
                sendKillMessage(killer, victim);
        }
    }

    private void sendKillMessage(Player killer, Player victim) {
        GetMessagesManager gmm = new GetMessagesManager(plugin);
        GetConfigManager gcm = new GetConfigManager(plugin);
        // 在这里编写发送提示信息的逻辑

        // tell messages
        if (gcm.getBoolean("pvp-message.msg")){
            killer.sendMessage(gmm.getMsgPlayer(victim, "kill-player"));
            victim.sendMessage(gmm.getMsgPlayer(killer, "killed-by-player"));
        }

        // title messages
        if(gcm.getBoolean("pvp-message.title")){
            killer.sendTitle(gmm.getMsgPlayer(victim, "title.kill-player"),"", 20, 50, 20);
            victim.sendTitle(gmm.getMsgPlayer(killer, "title.killed-by-player"),"", 20, 50, 20);
        }

        // actionbar messages
        if (gcm.getBoolean("pvp-message.actionbar")){
            String killerMsg = gmm.getMsgPlayer(victim, "actionbar.kill-player");
            String victimMsg= gmm.getMsgPlayer(killer, "actionbar.killed-by-player");
            killer.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(killerMsg));
            victim.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(victimMsg));
        }
    }
}
