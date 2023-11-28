package org.almrealm.almarenacore.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerKillListener implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {

        Player victim = event.getEntity();
        Player killer = event.getEntity().getKiller();

        if (killer != null) {
            // 玩家被击杀
            sendKillMessage(killer, victim);
        }
    }

    private void sendKillMessage(Player killer, Player victim) {
        // 在这里编写发送提示信息的逻辑
        killer.sendMessage("You Kill:"+victim.getName());
    }
}
