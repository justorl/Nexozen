package com.pulse.nexozen.commands;

import com.denizenscript.denizencore.objects.core.ElementTag;
import com.denizenscript.denizen.objects.LocationTag;
import com.denizenscript.denizencore.scripts.ScriptEntry;
import com.denizenscript.denizencore.scripts.commands.generator.ArgName;
import com.denizenscript.denizencore.scripts.commands.generator.ArgPrefixed;
import com.pulse.nexozen.commands.abstracts.AbstractNexoBlockCommand;

public class NexoRemoveCommand extends AbstractNexoBlockCommand {

    public NexoRemoveCommand() {
        setName("nexoremove");
        setSyntax("nexoremove type:<type> location:<location>");
        autoCompile();
    }

    public static void autoExecute(
            ScriptEntry scriptEntry,
            @ArgName("type") @ArgPrefixed ElementTag type,
            @ArgName("location") @ArgPrefixed LocationTag location
    ) {
        boolean isFurniture = type != null && type.asString().equalsIgnoreCase("furniture");
        ((NexoRemoveCommand) scriptEntry.getCommand()).validateAndExecute(scriptEntry, isFurniture ? new ElementTag("") : null, !isFurniture ? new ElementTag("") : null, location, false);
    }
}