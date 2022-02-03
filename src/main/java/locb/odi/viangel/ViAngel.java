package locb.odi.viangel;

import locb.odi.viangel.cmd.ViAngelCommand;
import locb.odi.viangel.listeners.DispenseListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class ViAngel extends JavaPlugin {

    private static ViAngel instance;

    @Override
    public void onEnable() {
        instance = this;
        ConsoleCommandSender console = getServer().getConsoleSender();
        console.sendMessage(ChatColor.GOLD + "[ViAngel] " + ChatColor.GRAY + "Hi!");

        Bukkit.getPluginManager().registerEvents(new DispenseListener(this), this);

        getCommand("viangel").setExecutor(new ViAngelCommand(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static ViAngel getInstance(){
        return instance;
    }
}
