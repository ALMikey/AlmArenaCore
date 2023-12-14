package org.almrealm.almarenacore.listener;

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
        GetMessagesManager gmm = new GetMessagesManager(plugin);
        String ArenaWorld = gcm.getConfigArenaWorld();

        Player victim = event.getEntity();
        Player killer = event.getEntity().getKiller();

        if (killer.getWorld().getName().equalsIgnoreCase(ArenaWorld)){
                sendKillMessage(killer, victim);
        }
    }

    private void sendKillMessage(Player killer, Player victim) {
        // 在这里编写发送提示信息的逻辑
        killer.sendMessage("Yes");
    }
}
