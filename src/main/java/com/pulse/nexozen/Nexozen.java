package com.pulse.nexozen;

import com.denizenscript.denizencore.DenizenCore;
import com.denizenscript.denizencore.events.ScriptEvent;
import com.pulse.nexozen.commands.NexoPlaceCommand;
import com.pulse.nexozen.commands.NexoRemoveCommand;
import com.pulse.nexozen.events.*;
import com.pulse.nexozen.tags.LocationTagExtension;
import com.pulse.nexozen.tags.EntityTagExtension;
import com.pulse.nexozen.tags.NexoItemTagExtension;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Nexozen extends JavaPlugin {
    private static Nexozen instance;

    private boolean isPluginAvailable(String pluginName) {
        return !Bukkit.getPluginManager().isPluginEnabled(pluginName);
    }

    @Override
    public void onEnable() {
        instance = this;

        if (isPluginAvailable("Denizen")) {
            getLogger().severe("Denizen is not enabled. Disabling..");
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }

        if (isPluginAvailable("Nexo")) {
            getLogger().severe("Nexo is not enabled. Disabling..");
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }

        DenizenCore.commandRegistry.registerCommand(NexoPlaceCommand.class);
        DenizenCore.commandRegistry.registerCommand(NexoRemoveCommand.class);
        ScriptEvent.registerScriptEvent(NexoFurnitureInteractScriptEvent.class);
        ScriptEvent.registerScriptEvent(NexoFurniturePlaceScriptEvent.class);
        ScriptEvent.registerScriptEvent(NexoFurnitureBreakScriptEvent.class);
        ScriptEvent.registerScriptEvent(NexoFurnitureDamageScriptEvent.class);
        ScriptEvent.registerScriptEvent(NexoNoteBlockInteractScriptEvent.class);
        ScriptEvent.registerScriptEvent(NexoNoteBlockPlaceScriptEvent.class);
        ScriptEvent.registerScriptEvent(NexoNoteBlockBreakScriptEvent.class);
        ScriptEvent.registerScriptEvent(NexoNoteBlockDamageScriptEvent.class);
        LocationTagExtension.register();
        EntityTagExtension.register();
        new NexoItemTagExtension();

        getLogger().info("Nexozen successfully loaded");
    }

    @Override
    public void onDisable() {
        getLogger().info("Nexozen successfully disabled");
    }

    public static Nexozen getInstance() {
        return instance;
    }
} 