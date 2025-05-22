package com.pulse.nexozen.tags;

import com.denizenscript.denizen.objects.ItemTag;
import com.denizenscript.denizen.utilities.BukkitImplDeprecations;
import com.denizenscript.denizencore.objects.core.*;
import com.denizenscript.denizencore.scripts.commands.core.AdjustCommand;
import com.denizenscript.denizencore.tags.TagManager;
import com.denizenscript.denizencore.tags.core.UtilTagBase;
import com.nexomc.nexo.api.NexoItems;

import java.util.Objects;

public class NexoItemTagExtension extends UtilTagBase {
    public static NexoItemTagExtension instance;

    public NexoItemTagExtension() {
        instance = this;
        TagManager.registerStaticTagBaseHandler(UtilTagBase.class, "util", (t) -> instance);
        TagManager.registerStaticTagBaseHandler(ElementTag.class, "global", (attribute) -> {
            BukkitImplDeprecations.globalTagName.warn(attribute.context);
            return null;
        });
        AdjustCommand.specialAdjustables.put("util", mechanism -> tagProcessor.processMechanism(instance, mechanism));
    }

    @Override
    public void register() {
        tagProcessor.registerTag(ItemTag.class, ElementTag.class, "get_nexo_item", (attribute, object, id) -> new ItemTag(Objects.requireNonNull(NexoItems.itemFromId(id.asString())).build()));
    }
}