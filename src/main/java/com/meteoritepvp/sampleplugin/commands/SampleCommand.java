package com.meteoritepvp.sampleplugin.commands;

import com.meteoritepvp.api.MeteoritePlugin;
import com.meteoritepvp.api.command.Command;
import com.meteoritepvp.api.command.CommandClass;
import com.meteoritepvp.api.command.DefaultCommand;
import com.meteoritepvp.api.inventory.MeteoriteInventory;
import com.meteoritepvp.api.inventory.presets.BackableInventory;
import com.meteoritepvp.api.inventory.presets.BasicInventory;
import com.meteoritepvp.api.utils.CC;
import com.meteoritepvp.api.utils.ItemBuilder;
import com.meteoritepvp.api.utils.Message;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

@Command(name = "test", description = "Just a test command")
public class SampleCommand implements CommandClass {

    MeteoriteInventory inventory;

    public SampleCommand(MeteoritePlugin plugin) {
        inventory = new MeteoriteInventory(plugin, CC.RED + CC.BOLD + "AWASOME INVENTORY", 9, 6, false);

        BasicInventory page = new BasicInventory();

        page.setItem(0, new ItemStack(Material.DIAMOND_BLOCK));
        page.setItem(1, new ItemStack(Material.EMERALD_BLOCK));
        page.setItem(2, new ItemStack(Material.GOLD_BLOCK));
        page.setItem(3, new ItemStack(Material.REDSTONE_BLOCK));
        page.setItem(4, new ItemStack(Material.IRON_BLOCK));
        page.update();

        page.setOnSlotClickListener(e -> {
            e.getEvent().getWhoClicked().sendMessage("x: " + e.getSlotX() + " y: " + e.getSlotY());
        });

        inventory.applyPage(page);
    }


    @Command(description = "Show gui command",
            name = "gui")
    public void showGUICommand(CommandSender sender, MeteoritePlugin plugin, Player player) {
        sender.sendMessage(Message.fromString(player, "&6This is a test command."));

        if (player != null)
            inventory.show(player);
    }
}
