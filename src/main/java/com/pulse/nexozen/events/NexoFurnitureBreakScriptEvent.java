package com.pulse.nexozen.events;

import com.denizenscript.denizen.events.BukkitScriptEvent;
import com.denizenscript.denizen.objects.LocationTag;
import com.denizenscript.denizen.utilities.implementation.BukkitScriptEntryData;
import com.denizenscript.denizencore.objects.ObjectTag;
import com.denizenscript.denizencore.objects.core.ElementTag;
import com.denizenscript.denizencore.scripts.ScriptEntryData;
import com.nexomc.nexo.api.events.furniture.NexoFurnitureBreakEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class NexoFurnitureBreakScriptEvent extends BukkitScriptEvent implements Listener {
    public NexoFurnitureBreakScriptEvent() {
        registerCouldMatcher("player nexobreaks furniture");
    }

    NexoFurnitureBreakEvent event;
    LocationTag location;

    @Override
    public boolean matches(ScriptPath path) {
        if (!runInCheck(path, event.getPlayer().getLocation())) {
            return false;
        }
        return super.matches(path);
    }

    @Override
    public ScriptEntryData getScriptEntryData() {
        return new BukkitScriptEntryData(event.getPlayer());
    }

    @Override
    public ObjectTag getContext(String name) {
        return switch (name) {
            case "location" -> location;
            case "furniture_id" -> new ElementTag(event.getMechanic().getItemID());
            default -> super.getContext(name);
        };
    }

    @EventHandler
    public void onFurnitureBreakEvent(NexoFurnitureBreakEvent event) {
        this.event = event;
        location = new LocationTag(event.getBaseEntity().getLocation());
        fire(event);
    }
} 