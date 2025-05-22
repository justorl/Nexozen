package com.pulse.nexozen.commands;

import com.denizenscript.denizencore.objects.core.ElementTag;
import com.denizenscript.denizen.objects.LocationTag;
import com.denizenscript.denizencore.scripts.ScriptEntry;
import com.denizenscript.denizencore.scripts.commands.generator.ArgName;
import com.denizenscript.denizencore.scripts.commands.generator.ArgPrefixed;
import com.pulse.nexozen.commands.abstracts.AbstractNexoBlockCommand;

public class NexoPlaceCommand extends AbstractNexoBlockCommand {

    public NexoPlaceCommand() {
        setName("nexoplace");
        setSyntax("nexoplace type:<type> id:<id> location:<location>");
        autoCompile();
    }

    public static void autoExecute(
            ScriptEntry scriptEntry,
            @ArgName("type") @ArgPrefixed ElementTag type,
            @ArgName("id") @ArgPrefixed ElementTag id,
            @ArgName("location") @ArgPrefixed LocationTag location
    ) {
        boolean isFurniture = type != null && type.asString().equalsIgnoreCase("furniture");
        ((NexoPlaceCommand) scriptEntry.getCommand()).validateAndExecute(scriptEntry, isFurniture ? id : null, !isFurniture ? id : null, location, true);
    }
}