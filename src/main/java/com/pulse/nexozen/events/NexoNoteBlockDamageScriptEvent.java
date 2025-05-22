package com.pulse.nexozen.events;

import com.denizenscript.denizen.events.BukkitScriptEvent;
import com.denizenscript.denizen.objects.LocationTag;
import com.denizenscript.denizen.objects.MaterialTag;
import com.denizenscript.denizen.utilities.implementation.BukkitScriptEntryData;
import com.denizenscript.denizencore.objects.ObjectTag;
import com.denizenscript.denizencore.objects.core.ElementTag;
import com.denizenscript.denizencore.scripts.ScriptEntryData;
import com.nexomc.nexo.api.events.custom_block.noteblock.NexoNoteBlockDamageEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class NexoNoteBlockDamageScriptEvent extends BukkitScriptEvent implements Listener {
    public NexoNoteBlockDamageScriptEvent() {
        registerCouldMatcher("player nexodamages block");
    }

    NexoNoteBlockDamageEvent event;
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
            case "block_id" -> new ElementTag(event.getMechanic().getItemID());
            case "block" -> new MaterialTag(event.getBlock());
            default -> super.getContext(name);
        };
    }

    @EventHandler
    public void onNoteBlockDamageEvent(NexoNoteBlockDamageEvent event) {
        this.event = event;
        location = new LocationTag(event.getBlock().getLocation());
        fire(event);
    }
} 