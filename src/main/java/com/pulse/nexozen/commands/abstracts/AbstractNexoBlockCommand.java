package com.pulse.nexozen.commands.abstracts;

import com.denizenscript.denizencore.objects.core.ElementTag;
import com.denizenscript.denizen.objects.LocationTag;
import com.denizenscript.denizencore.scripts.ScriptEntry;
import com.denizenscript.denizencore.scripts.commands.AbstractCommand;
import com.denizenscript.denizencore.utilities.debugging.Debug;
import com.nexomc.nexo.api.NexoBlocks;
import com.nexomc.nexo.api.NexoFurniture;
import org.bukkit.Location;
import org.bukkit.block.BlockFace;

public abstract class AbstractNexoBlockCommand extends AbstractCommand {

    protected void validateAndExecute(
            ScriptEntry scriptEntry,
            ElementTag furniture,
            ElementTag block,
            LocationTag location,
            boolean isPlace
    ) {
        if (location == null) {
            Debug.echoError(scriptEntry, "Specify a location");
            return;
        }

        Location loc = location.getBlockLocation();
        try {
            if (furniture != null) {
                BlockFace face = loc.getBlock().getFace(loc.getBlock());
                assert face != null;
                if (isPlace) {
                    NexoFurniture.place(furniture.asString(), loc.getBlock().getLocation(), loc.getYaw(), face);
                } else {
                    NexoFurniture.remove(loc);
                }
            } else if (block != null) {
                if (isPlace) {
                    NexoBlocks.place(block.asString(), loc);
                } else {
                    NexoBlocks.remove(loc);
                }
            } else if (!isPlace) {
                try {
                    NexoFurniture.remove(loc);
                } catch (Exception ignored) {}
                try {
                    NexoBlocks.remove(loc);
                } catch (Exception ignored) {}
            } else {
                Debug.echoError(scriptEntry, "Error in Nexozen (мне лень)");
            }
        } catch (Exception ex) {
            Debug.echoError(scriptEntry, "Error in " + (isPlace ? "placing" : "removing") + "nexo block: " + ex.getMessage());
        }
    }
} 