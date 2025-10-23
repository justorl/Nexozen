package com.pulse.nexozen.tags;

import com.denizenscript.denizen.objects.EntityTag;
import com.denizenscript.denizen.objects.ItemTag;
import com.denizenscript.denizencore.objects.core.ElementTag;
import com.nexomc.nexo.api.NexoFurniture;
import com.nexomc.nexo.api.NexoItems;
import org.bukkit.entity.Entity;

import java.util.Objects;

public class EntityTagExtension {

    public static void register() {
        EntityTag.tagProcessor.registerTag(ElementTag.class, "is_nfurniture", (attribute, entity) ->
                new ElementTag(NexoFurniture.isFurniture(entity.entity)));

        EntityTag.tagProcessor.registerTag(ElementTag.class, "get_nid", (attribute, entity) -> {
            if (NexoFurniture.isFurniture(entity.entity)) return new ElementTag(
                    Objects.requireNonNull(
                            NexoFurniture.furnitureMechanic(entity.entity)
                    ).getItemID()
            );
            return new ElementTag("");
        });
    }
} 