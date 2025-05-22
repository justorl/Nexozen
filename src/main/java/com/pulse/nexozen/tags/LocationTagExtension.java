package com.pulse.nexozen.tags;

import com.denizenscript.denizen.objects.LocationTag;
import com.denizenscript.denizencore.objects.core.ElementTag;
import com.nexomc.nexo.api.NexoBlocks;
import com.nexomc.nexo.api.NexoFurniture;
import org.bukkit.block.Block;

import java.util.Objects;

public class LocationTagExtension {

    public static void register() {
        LocationTag.tagProcessor.registerTag(ElementTag.class, "is_nexoblock", (attribute, location) -> {
            Block block = location.getBlock();
            return new ElementTag(NexoBlocks.isNexoNoteBlock(block));
        });

        LocationTag.tagProcessor.registerTag(ElementTag.class, "is_nexofurniture", (attribute, location) -> {
            return new ElementTag(NexoFurniture.isFurniture(location));
        });

        LocationTag.tagProcessor.registerTag(ElementTag.class, "get_nexoblock_variation", (attribute, location) -> {
            Block block = location.getBlock();
            if (NexoBlocks.isNexoNoteBlock(block)) {
                return new ElementTag(Objects.requireNonNull(NexoBlocks.customBlockMechanic(location)).getCustomVariation());
            }
            return new ElementTag("");
        });

        LocationTag.tagProcessor.registerTag(ElementTag.class, "get_nexoblock_id", (attribute, location) -> {
            Block block = location.getBlock();
            if (NexoBlocks.isNexoNoteBlock(block)) {
                return new ElementTag(Objects.requireNonNull(Objects.requireNonNull(NexoBlocks.customBlockMechanic(location)).getItemID()));
            }
            return new ElementTag("");
        });
    }
} 