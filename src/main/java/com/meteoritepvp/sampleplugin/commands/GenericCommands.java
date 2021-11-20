package com.meteoritepvp.sampleplugin.commands;

import com.meteoritepvp.api.command.Command;
import com.meteoritepvp.api.command.CommandClass;
import com.meteoritepvp.api.utils.CC;
import org.bukkit.command.CommandSender;

public class GenericCommands implements CommandClass {

    @Command(name = "test1", description = "Just a test command")
    public void test1Command(CommandSender sender) {
        sender.sendMessage(CC.AQUA + "Test1 command.");
    }

    @Command(name = "test2", description = "Just a test command")
    public void test2Command(CommandSender sender) {
        sender.sendMessage(CC.GREEN + "Test2 command.");
    }

    @Command(name = "test3", description = "Just a test command")
    public void test3Command(CommandSender sender) {
        sender.sendMessage(CC.YELLOW + "Test3 command.");
    }
}
