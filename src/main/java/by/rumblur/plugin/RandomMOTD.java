package by.rumblur.plugin;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;
import java.util.logging.Level;

public class RandomMOTD extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getLogger().log(Level.INFO, "Enabled, ready.");
        Objects.requireNonNull(this.getCommand("randommotd")).setExecutor(new Commands(this));
        Objects.requireNonNull(this.getCommand("randommotd")).setTabCompleter(new TabCompleter());
        getServer().getPluginManager().registerEvents(new ServerMOTD(this), this);
    }

    @Override
    public void onDisable() {
        getLogger().log(Level.INFO, "Goodbye!");
    }

}
