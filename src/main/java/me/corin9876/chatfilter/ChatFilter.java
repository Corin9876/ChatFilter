package me.corin9876.chatfilter;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class ChatFilter extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        String message = event.getMessage().toLowerCase();

        for (String swears : this.getConfig().getStringList("filter")) {
            if(message.contains(swears)) {
                player.sendMessage(ChatColor.RED + "Please avoid saying swear words in chat.");
                event.setCancelled(true);
            }
        }
    }
}
