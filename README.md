**Nexozen - is an addon for Denizen that provides the API of the Nexo plugin.**


### What is Nexo?
Nexo is a plugin for Minecraft that allows you to create customizable items, blocks, armor, and furniture.
In addition, it handles the creation of resource packs, their loading, and distribution to players.

[You can buy it here](https://polymart.org/product/6901/nexo)

### What is Denizen?
Denizen is a powerful scripting language that allows you to customize your server without programming skills.

[You can download it here](https://ci.citizensnpcs.co/job/Denizen_Developmental/lastSuccessfulBuild/)

----

Give me a star on github, if you appreciate my work

----

**-- PLUGIN META --**

<util.get_nexo_item[айдишник]> - itemtag
<EntityTag.is_nexofurniture> - true/false
<LocationTag.is_nexoblock> - true/false
<LocationTag.is_nexofurniture> - true/false
<LocationTag.get_nexoblock_variation> - ElementTag
<LocationTag.get_nexoblock_id> - ElementTag


\- nexoremove type:furniture/block location:\<LocationTag\>  
\- nexoplace type:furniture/block id:\<ElementTag> location:\<LocationTag\>

(on/after) player nexodamages furniture - location, furniture_id (has player, cancellable)  
(on/after) player nexobreaks furniture - location, furniture_id (has player, cancellable)   
(on/after) player nexoplaces furniture - location, furniture_id (has player, cancellable)   
(on/after) player nexointeracts furniture - location, furniture_id, item (has player, cancellable)     
(on/after) player nexodamages block - block, block_id, location (has player, cancellable)      
(on/after) player nexobreaks block - block, block_id, location (has player, cancellable)      
(on/after) player nexointeracts block - block, block_id, location (has player, cancellable)     
(on/after) player nexoplace block - block, block_id, location (has player, cancellable)   
