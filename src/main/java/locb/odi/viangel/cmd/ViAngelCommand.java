package locb.odi.viangel.cmd;
import locb.odi.viangel.ViAngel;
import locb.odi.viangel.tools.Craft;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ViAngelCommand implements TabExecutor {

    private ViAngel pl;

    public ViAngelCommand(ViAngel pl) {
        this.pl = pl;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if(!(commandSender instanceof Player)) {
            commandSender.sendMessage(ChatColor.RED + "Only for players!");
            return true;
        }

        if(args.length > 0 ) {
            Player p = (Player)commandSender;

            if(args[0].equals("dispenser")) {
                ItemStack item = Craft.craftViDispenser();
                p.getInventory().addItem(item);
            }
        }

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String label, String[] args) {
        return Arrays.asList("dispenser");
    }
}
