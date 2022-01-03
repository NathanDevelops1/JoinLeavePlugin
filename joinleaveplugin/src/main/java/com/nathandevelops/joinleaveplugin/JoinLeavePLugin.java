package com.nathandevelops.joinleaveplugin;

import org.bukkit.plugin.java.JavaPlugin;

public final class JoinLeavePLugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        System.out.println("The Leave Join Plugin Has Started");

        getServer().getPluginManager().registerEvents(new JoinLeaveListener(this), this);

        getConfig().options().copyDefaults();
        saveDefaultConfig();

    }


}
