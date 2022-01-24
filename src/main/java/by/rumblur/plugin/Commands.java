package by.rumblur.plugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import javax.annotation.Nonnull;
import java.util.List;

public class Commands implements CommandExecutor {

    private final RandomMOTD plugin;

    public Commands(RandomMOTD plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@Nonnull CommandSender sender, Command cmd, @Nonnull String label, @Nonnull String[] args) {
        if (cmd.getName().equalsIgnoreCase("randommotd")) {
            if(args.length == 0) {
                if(!sender.hasPermission("RumblurMOTD.main")) {return true;}
                sender.sendMessage(ChatColor.GREEN + "RumblurMOTD from Xtimms");
                sender.sendMessage("Version: " + ChatColor.YELLOW + plugin.getDescription().getVersion());
                return true;
            }
            if ("reload".equals(args[0])) {
                if (!sender.hasPermission("RumblurMOTD.reload")) {
                    return true;
                }
                plugin.saveDefaultConfig();
                plugin.reloadConfig();
                sender.sendMessage("[RumblurMOTD] Config reloaded!");
                return true;
            } else if ("motd".equals(args[0])) {
                if (!sender.hasPermission("RumblurMOTD.motd")) {
                    return true;
                }
                sender.sendMessage(ChatColor.AQUA + "System MOTDs: " + ChatColor.WHITE + plugin.getConfig().getBoolean("system.enabled"));
                sender.sendMessage(ChatColor.YELLOW + "Normal: ");
                List<String> systemmotdlistnormal = plugin.getConfig().getStringList("system.motd.normal");
                for (String loopsystemnormal : systemmotdlistnormal) {
                    sender.sendMessage("- " + loopsystemnormal);
                }
                sender.sendMessage(ChatColor.YELLOW + "Whitelist: ");
                List<String> systemmotdlistwhitelist = plugin.getConfig().getStringList("system.motd.whitelist");
                for (String loopsystemwhitelist : systemmotdlistwhitelist) {
                    sender.sendMessage("- " + loopsystemwhitelist);
                }
                return true;
            } else if ("help".equals(args[0])) {
                if (!sender.hasPermission("RumblurMOTD.help")) {
                    return true;
                }
                sender.sendMessage(ChatColor.GREEN + "/rmotd" + ChatColor.WHITE + " --> Shows the description of RandomMOTD.");
                sender.sendMessage(ChatColor.GREEN + "/rmotd reload" + ChatColor.WHITE + " --> Reloads RandomMOTD configurations.");
                sender.sendMessage(ChatColor.GREEN + "/rmotd motd" + ChatColor.WHITE + " --> Shows the MOTDs being used in the server.");
                sender.sendMessage(ChatColor.GREEN + "/rmotd author" + ChatColor.WHITE + " --> Shows the author description.");
                return true;
            } else if ("author".equals(args[0])) {
                if(!sender.hasPermission("RumblurMOTD.author")) return true;
                sender.sendMessage("Developed by" + ChatColor.YELLOW + " Xtimms for Rumblur");
                return true;
            } else {
                sender.sendMessage(ChatColor.RED + "[ERROR] Unknown command!");
                sender.sendMessage("To see the list of commands and their description, use the " + ChatColor.YELLOW + "/motd help" + ChatColor.WHITE + " command!");
                return true;
            }
        }
        return true;
    }
}
