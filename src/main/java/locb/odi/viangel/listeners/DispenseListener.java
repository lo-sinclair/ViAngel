package locb.odi.viangel.listeners;

import locb.odi.viangel.ViAngel;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.Container;
import org.bukkit.block.Dropper;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Directional;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemFrame;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Dispenser;

import java.util.Collection;

public class DispenseListener implements Listener {
    private final ViAngel pl;


    public DispenseListener(ViAngel pl) {
        this.pl = pl;
    }



    @EventHandler(priority = EventPriority.LOWEST)
    public void onDispanseItem(BlockDispenseEvent e) {


        if(e.getBlock().getType() == Material.DISPENSER  ) {
            String dispName = ((Nameable)e.getBlock().getState()).getCustomName();
            if(dispName != null && dispName.equals(ChatColor.AQUA + "Раздатчик Витражей")) {
                e.setCancelled(true);
                if (e.getBlock().getBlockData() instanceof Directional) {

                    Directional directional = (Directional) e.getBlock().getBlockData();


                    Location loc = e.getBlock().getLocation();

                    switch (directional.getFacing()) {
                        case EAST:
                            loc.setX(loc.getBlockX() + 1);
                            break;
                        case WEST:
                            loc.setX(loc.getBlockX() - 1);
                            break;
                        case SOUTH:
                            loc.setZ(loc.getBlockZ() + 1);
                            break;
                        case NORTH:
                            loc.setZ(loc.getBlockZ() - 1);
                            break;
                        case DOWN:
                            loc.setY(loc.getBlockY() - 1);
                            break;
                        case UP:
                            loc.setY(loc.getBlockY() + 1);
                            break;

                    }
                    Block b = loc.getBlock();

                    for (Entity entity : b.getWorld().getNearbyEntities(b.getLocation(), 2, 2, 2)) {


                        if (entity instanceof ItemFrame && entity.getLocation().getBlock().getRelative(((ItemFrame) entity).getAttachedFace()).equals(b)) {
                            ItemFrame itemFrame = (ItemFrame) entity;
                            Inventory inventory = ((Container) e.getBlock().getState()).getInventory();
                            Bukkit.getScheduler().runTaskLater(ViAngel.getInstance(), new Runnable() {

                                @Override
                                public void run() {
                                    ItemStack dispenserItem = e.getItem();
                                    ItemStack frameItem = itemFrame.getItem();

                                    itemFrame.setItem(dispenserItem);
                                    if (frameItem.getType().equals(Material.AIR)) {

                                        ((Container) e.getBlock().getState()).getInventory().clear(0);
                                    } else {
                                        ((Container) e.getBlock().getState()).getInventory().setItem(0, frameItem);
                                    }
                                }
                            }, 1);

                        }
                    }
                }
            }
        }

    }
}
