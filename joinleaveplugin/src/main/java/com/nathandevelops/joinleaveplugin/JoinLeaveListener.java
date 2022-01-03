package com.nathandevelops.joinleaveplugin;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinLeaveListener implements Listener {

    JoinLeavePLugin plugin;

    public JoinLeaveListener(JoinLeavePLugin pLugin) {
        this.plugin = pLugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){

        Player player = e.getPlayer();


        String JoinMessage = plugin.getConfig().getString("Join-Message");
        String newJoinMessage = plugin.getConfig().getString("New-Join-Message");

        JoinMessage = JoinMessage.replace("%player%", player.getDisplayName());
        newJoinMessage = newJoinMessage.replace("%player%", player.getDisplayName());

        if (player.hasPlayedBefore()){
            e.setJoinMessage(ChatColor.translateAlternateColorCodes('&', JoinMessage));
        } else {
            e.setJoinMessage(ChatColor.translateAlternateColorCodes('&', newJoinMessage));
        }

    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e){
        Player player = e.getPlayer();

        String leaveMessage = plugin.getConfig().getString("Leave-Message");
        leaveMessage = leaveMessage.replace("%player%", player.getDisplayName());

        e.setQuitMessage(ChatColor.translateAlternateColorCodes('&', leaveMessage));

    }

}
