package de.morgon.LegendsOfArrol.commands;

import de.morgon.LegendsOfArrol.configs.PlayerProgressConfig;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

public class TrackPlayerProgress implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;
            if (args[0].equals("get")) {
                if (args.length == 1) {
                    p.sendMessage("Your Quest Pprogress: " + PlayerProgressConfig.get().getDouble(p.getName()));
                } else if (args.length == 2) {
                    String target = args[1];
                    p.sendMessage(target + "'s Quest Progress: " + PlayerProgressConfig.get().getDouble(target));
                }
            } else if (args[0].equals("set")) {
                if (args.length == 3) {
                    String target = args[1];
                    Double QuestProgress = Double.valueOf(args[2]);
                    p.sendMessage("Set " + target + "'s Quest Progress to: " + QuestProgress);
                    PlayerProgressConfig.get().set(target, QuestProgress);
                }
            }
        }
        return false;
    }
}
