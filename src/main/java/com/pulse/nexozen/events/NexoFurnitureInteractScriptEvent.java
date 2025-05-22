package com.pulse.nexozen.events;

import com.denizenscript.denizen.events.BukkitScriptEvent;
import com.denizenscript.denizen.objects.ItemTag;
import com.denizenscript.denizen.objects.LocationTag;
import com.denizenscript.denizen.utilities.implementation.BukkitScriptEntryData;
import com.denizenscript.denizencore.objects.ObjectTag;
import com.denizenscript.denizencore.objects.core.ElementTag;
import com.denizenscript.denizencore.scripts.ScriptEntryData;
import com.nexomc.nexo.api.events.furniture.NexoFurnitureInteractEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class NexoFurnitureInteractScriptEvent extends BukkitScriptEvent implements Listener {
    public NexoFurnitureInteractScriptEvent() {
        registerCouldMatcher("player nexointeracts furniture");
    }

    NexoFurnitureInteractEvent event;
    LocationTag location;
    ItemTag item;

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
            case "item" -> item;
            default -> super.getContext(name);
        };
    }

    @EventHandler
    public void onFurnitureInteractEvent(NexoFurnitureInteractEvent event) {
        this.event = event;
        location = new LocationTag(event.getBaseEntity().getLocation());
        item = new ItemTag(event.getItemInHand());
        fire(event);
    }
} 