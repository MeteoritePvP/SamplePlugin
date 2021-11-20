package com.meteoritepvp.sampleplugin;

import com.meteoritepvp.api.MeteoritePlugin;
import com.meteoritepvp.sampleplugin.commands.GenericCommands;
import com.meteoritepvp.sampleplugin.commands.MainCommand;
import com.meteoritepvp.sampleplugin.commands.SampleCommand;

import java.util.ArrayList;
import java.util.List;

public class Main extends MeteoritePlugin {

    // This removes the main command, so we can add our own.
    @Override
    protected void onRegisterMainCommand(String description) { }


    // This can be used to define aliases on the main command.
    @Override
    protected void onRegisterCommands(String... aliases) {
        super.onRegisterCommands("sample");
    }

    @Override
    protected void onInit() {
        super.onInit();

        SampleCommand commands = new SampleCommand(this);

        // Commands must be declared only on onInit().
        registerCommandObject(commands);
        registerCommandClass(MainCommand.class);
        registerCommandClass(GenericCommands.class);
    }


    @Override
    public void onEnable() {
        super.onEnable();

        saveDefaultConfig();
        reloadConfig();

        registerPlaceholderParameter("myParam", (sender -> getNames()));
    }

    public List<String> getNames() {
        List<String> names = new ArrayList<>();

        names.add("Hello");
        names.add("Second");
        names.add("123");

        return names;
    }
}
