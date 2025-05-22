package com.pulse.nexozen.tags;

import com.denizenscript.denizen.objects.EntityTag;
import com.denizenscript.denizencore.objects.core.ElementTag;
import com.nexomc.nexo.api.NexoFurniture;
import org.bukkit.entity.Entity;

public class EntityTagExtension {

    public static void register() {
        EntityTag.tagProcessor.registerTag(ElementTag.class, "is_nexofurniture", (attribute, entity) -> {
            Entity bukkitEntity = entity.getBukkitEntity();
            return new ElementTag(NexoFurniture.isFurniture(bukkitEntity));
        });
    }
} 