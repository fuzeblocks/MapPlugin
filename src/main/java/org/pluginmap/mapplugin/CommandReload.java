package org.pluginmap.mapplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class CommandReload implements CommandExecutor {
    private final JavaPlugin plugin;

    public CommandReload(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("reload")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (!player.hasPermission(Objects.requireNonNull(plugin.getConfig().getString("messages.reloadperm")))) {
                    player.sendMessage(plugin.getConfig().getString("messages.reloadperm"));
                    return true;
                }
            }
            plugin.reloadConfig();
            sender.sendMessage(plugin.getConfig().getString("messages.reload"));
            return true;

        }
        return false;
    }
}