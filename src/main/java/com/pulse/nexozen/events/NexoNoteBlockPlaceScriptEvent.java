package com.pulse.nexozen.events;

import com.denizenscript.denizen.events.BukkitScriptEvent;
import com.denizenscript.denizen.objects.ItemTag;
import com.denizenscript.denizen.objects.LocationTag;
import com.denizenscript.denizen.objects.MaterialTag;
import com.denizenscript.denizen.utilities.implementation.BukkitScriptEntryData;
import com.denizenscript.denizencore.objects.ObjectTag;
import com.denizenscript.denizencore.objects.core.ElementTag;
import com.denizenscript.denizencore.scripts.ScriptEntryData;
import com.nexomc.nexo.api.events.custom_block.noteblock.NexoNoteBlockPlaceEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class NexoNoteBlockPlaceScriptEvent extends BukkitScriptEvent implements Listener {
    public NexoNoteBlockPlaceScriptEvent() {
        registerCouldMatcher("player nexoplaces block");
    }

    NexoNoteBlockPlaceEvent event;
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
    public ObjectTag getContext(String name) {
        return switch (name) {
            case "location" -> location;
            case "block_id" -> new ElementTag(event.getMechanic().getItemID());
            case "item" -> item;
            case "block" -> new MaterialTag(event.getBlock());
            default -> super.getContext(name);
        };
    }

    @Override
    public ScriptEntryData getScriptEntryData() {
        return new BukkitScriptEntryData(event.getPlayer());
    }

    @EventHandler
    public void onNoteBlockPlaceEvent(NexoNoteBlockPlaceEvent event) {
        this.event = event;
        location = new LocationTag(event.getBlock().getLocation());
        item = new ItemTag(event.getItemInHand());
        fire(event);
    }
} 