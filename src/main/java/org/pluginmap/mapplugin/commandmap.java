package org.pluginmap.mapplugin; // Définition du package dans lequel se trouve la classe

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;


public class commandmap implements CommandExecutor {
    final private MapPlugin main; // Définition de la variable main qui est de type MapPlugin

    public commandmap(MapPlugin mapPlugin) { // Constructeur de la classe commandmap
        this.main = mapPlugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {// Vérifie si la commande entrée correspond à celle définie dans la configuration du plugin
        if (!(sender instanceof Player)) { // Vérifie si l'émetteur de la commande est un joueur
            sender.sendMessage(Objects.requireNonNull(main.getConfig().getString("messages.denymessage"))); // Envoie un message de refus si l'émetteur n'est pas un joueur
            return false; // Retourne false pour indiquer que la commande n'a pas été exécutée avec succès
        }
        Player player = (Player) sender; // Conversion de l'émetteur en joueur

        // Création d'un composant de texte contenant le message de la commande
        TextComponent message = new TextComponent(Objects.requireNonNull(main.getConfig().getString("messages.map")).replace("&" , "§"));
        message.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, Objects.requireNonNull(main.getConfig().getString("messages.url")).replace("&", "§"))); // Ajout d'un événement de clic pour ouvrir l'URL définie dans la configuration du plugin
        player.spigot().sendMessage(message); // Envoi du message contenant l'URL


            return true; // Retourne true pour indiquer que la commande a été exécutée avec succès
        }
    }

