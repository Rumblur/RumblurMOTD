package by.rumblur.plugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class TabCompleter implements org.bukkit.command.TabCompleter {
    public List<String> onTabComplete(@Nonnull CommandSender sender, @Nonnull Command cmd, @Nonnull String label, String[] args) {
        if (args.length == 1) {
            List<String> tabCompleteList = new ArrayList<String>();
            tabCompleteList.add("author");
            tabCompleteList.add("motd");
            tabCompleteList.add("reload");
            tabCompleteList.add("help");
            return tabCompleteList;
        }
        return null;
    }
}
