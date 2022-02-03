package locb.odi.viangel.tools;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Craft {

    public static ItemStack craftViDispenser(){
        ItemStack item = new ItemStack( Material.DISPENSER);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA + "Раздатчик Витражей");

        List<String> lore = new ArrayList<String>();
        lore.add(ChatColor.LIGHT_PURPLE + "Поставь этот раздатчик");
        lore.add(ChatColor.LIGHT_PURPLE + "перед блоком с рамкой :p");
        meta.setLore(lore);

        meta.addEnchant(Enchantment.OXYGEN, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        return item;
    }
}
