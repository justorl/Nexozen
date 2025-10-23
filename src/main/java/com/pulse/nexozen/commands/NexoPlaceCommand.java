package com.pulse.nexozen.commands;

import com.denizenscript.denizencore.objects.core.ElementTag;
import com.denizenscript.denizen.objects.LocationTag;
import com.denizenscript.denizencore.scripts.ScriptEntry;
import com.denizenscript.denizencore.scripts.commands.AbstractCommand;
import com.denizenscript.denizencore.scripts.commands.generator.ArgName;
import com.denizenscript.denizencore.scripts.commands.generator.ArgPrefixed;
import com.denizenscript.denizencore.utilities.debugging.Debug;
import com.nexomc.nexo.api.NexoBlocks;
import com.nexomc.nexo.api.NexoFurniture;
import org.bukkit.block.BlockFace;

public class NexoPlaceCommand extends AbstractCommand {

    public NexoPlaceCommand() {
        setName("nplace");
        setSyntax("nplace type:<type> id:<id> location:<location>");
        autoCompile();
    }

    public static void autoExecute(ScriptEntry scriptEntry,
            @ArgName("type") @ArgPrefixed ElementTag type,
            @ArgName("id") @ArgPrefixed ElementTag id,
            @ArgName("location") @ArgPrefixed LocationTag location
    ) {
        BlockFace face = location.getBlock().getFace(location.getBlock());
        if (face == null) {
            Debug.echoError(scriptEntry, "Can't find block face");
            return;
        }

        if (type.advancedMatches("block")) NexoBlocks.place(id.asString(), location);
        else if (type.advancedMatches("furniture")) NexoFurniture.place(id.asString(), location, location.getYaw(), face);
    }
}