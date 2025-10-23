package com.pulse.nexozen.tags;

import com.denizenscript.denizen.objects.LocationTag;
import com.denizenscript.denizencore.objects.core.ElementTag;
import com.nexomc.nexo.api.NexoBlocks;
import com.nexomc.nexo.api.NexoFurniture;
import org.bukkit.block.Block;

import java.util.Objects;

public class LocationTagExtension {

    public static void register() {
        LocationTag.tagProcessor.registerTag(ElementTag.class, "is_nblock", (attribute, location) ->
                new ElementTag(NexoBlocks.isNexoNoteBlock(location.getBlock())));

        LocationTag.tagProcessor.registerTag(ElementTag.class, "is_nfurniture", (attribute, location) ->
                new ElementTag(NexoFurniture.isFurniture(location)));

        LocationTag.tagProcessor.registerTag(ElementTag.class, "get_nvariation", (attribute, location) -> {
            Block block = location.getBlock();

            if (NexoBlocks.isNexoNoteBlock(block)) {
                return new ElementTag(Objects.requireNonNull(NexoBlocks.customBlockMechanic(location)).getCustomVariation());
            }

            return new ElementTag("");
        });

        LocationTag.tagProcessor.registerTag(ElementTag.class, "get_ntype", (attribute, location) -> {
            Block block = location.getBlock();

            if (NexoBlocks.isNexoNoteBlock(block)) return new ElementTag("noteblock");
            else if (NexoBlocks.isNexoChorusBlock(block)) return new ElementTag("chorus");
            else if (NexoBlocks.isNexoStringBlock(block)) return new ElementTag("string");
            else if (NexoFurniture.isFurniture(location)) return new ElementTag("furniture");

            return new ElementTag("");
        });

        LocationTag.tagProcessor.registerTag(ElementTag.class, "get_nid", (attribute, location) -> {
            Block block = location.getBlock();

            if (NexoBlocks.isNexoNoteBlock(block)) return new ElementTag(
                            Objects.requireNonNull(
                                    NexoBlocks.customBlockMechanic(location)
                            ).getItemID()
            ); else if (NexoFurniture.isFurniture(location)) return new ElementTag(
                    Objects.requireNonNull(
                            NexoFurniture.furnitureMechanic(location)
                    ).getItemID()
            );

            return new ElementTag("");
        });
    }
} 