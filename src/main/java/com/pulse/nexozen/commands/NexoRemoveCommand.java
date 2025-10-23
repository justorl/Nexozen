package com.pulse.nexozen.commands;

import com.denizenscript.denizencore.objects.core.ElementTag;
import com.denizenscript.denizen.objects.LocationTag;
import com.denizenscript.denizencore.scripts.ScriptEntry;
import com.denizenscript.denizencore.scripts.commands.AbstractCommand;
import com.denizenscript.denizencore.scripts.commands.generator.ArgName;
import com.denizenscript.denizencore.scripts.commands.generator.ArgPrefixed;
import com.nexomc.nexo.api.NexoBlocks;
import com.nexomc.nexo.api.NexoFurniture;

public class NexoRemoveCommand extends AbstractCommand {

    public NexoRemoveCommand() {
        setName("nremove");
        setSyntax("nremove type:<type> location:<location>");
        autoCompile();
    }

    public static void autoExecute(ScriptEntry scriptEntry,
            @ArgName("type") @ArgPrefixed ElementTag type,
            @ArgName("location") @ArgPrefixed LocationTag location
    ) {
        if (type.advancedMatches("block")) NexoBlocks.remove(location);
        else if (type.advancedMatches("furniture")) NexoFurniture.remove(location);
    }
}