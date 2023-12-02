package org.almrealm.almarenacore.listener;

import org.almrealm.almarenacore.AlmArenaCore;
import org.almrealm.almarenacore.manager.GetConfigManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerKillListener implements Listener {

    private final AlmArenaCore plugin;

    public PlayerKillListener(AlmArenaCore plugin) { this.plugin = plugin; }
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        String Pvpworldname = plugin.getConfig().getString("pvpworldname");

        Player victim = event.getEntity();
        Player killer = event.getEntity().getKiller();

        if (killer.getWorld().getName().equalsIgnoreCase(Pvpworldname)){
                sendKillMessage(killer, victim);
        }
    }

    private void sendKillMessage(Player killer, Player victim) {
        GetConfigManager gcm = new GetConfigManager(plugin);
        // 在这里编写发送提示信息的逻辑
        killer.sendMessage(gcm.getkillplayer()+victim.getName());
        victim.sendMessage(gcm.getvictimlplayer()+killer.getName());
    }
}
