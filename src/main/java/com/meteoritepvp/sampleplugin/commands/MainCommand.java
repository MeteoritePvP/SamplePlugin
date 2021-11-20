package com.meteoritepvp.sampleplugin.commands;

import com.meteoritepvp.api.MeteoritePlugin;
import com.meteoritepvp.api.command.Command;
import com.meteoritepvp.api.command.CommandClass;
import com.meteoritepvp.api.command.DefaultCommand;
import com.meteoritepvp.api.utils.CC;
import com.meteoritepvp.api.utils.Message;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@DefaultCommand
public class MainCommand implements CommandClass {


    @Command(name = "", description = "Say hello.")
    public void onMainCommand(CommandSender sender) {
        sender.sendMessage("Hello");
    }


    @Command(description = "First command",
            name = "first",
            args = {"remove"},
            permission = "sampleplugin.permission",
            canHaveMoreParams = true)
    public void firstCommand(CommandSender sender, MeteoritePlugin plugin, Player player, String[] params) {
        String paramsString = String.join(" ", params);
        sender.sendMessage(Message.fromString(player, "&6This is the first command. Params: " + paramsString));
    }


    @Command(description = "Load text from config command",
            name = "config")
    public void loadConfigTextCommand(CommandSender sender, MeteoritePlugin plugin) {
        sender.sendMessage(Message.fromMainConfig(plugin, "message.error"));
    }


    @Command(description = "Second command",
            args = {"second"},
            params = "@myParam")
    public void secondCommand(CommandSender sender, String[] params) {
        sender.sendMessage(CC.format("&4This is a second command. " + params[0]));
    }
}
