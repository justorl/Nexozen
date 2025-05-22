**Какие функции сейчас есть в плагине?**
- <util.get_nexo_item[айдишник]> - itemtag
- <EntityTag.is_nexofurniture> - true/false
- <LocationTag.is_nexoblock> - true/false
- <LocationTag.is_nexofurniture> - true/false
- <LocationTag.get_nexoblock_variation> - ElementTag (возвращает custom_variation у блоков)
- <LocationTag.get_nexoblock_id> - ElementTag (возвращает айдишник в конфиге у блока)
- \- nexoremove type:furniture\/block location:\<LocationTag\>
- \- nexoplace type:furniture\/block id:\<ElementTag\> location:\<LocationTag\>

**Какие ивенты сейчас есть в плагине? (справа контексты)**
- (on/after) player nexodamages furniture - location, furniture_id (имеет игрока, отменяемый)
- (on/after) player nexobreaks furniture - location, furniture_id (имеет игрока, отменяемый)
- (on/after) player nexoplaces furniture - location, furniture_id (имеет игрока, отменяемый)
- (on/after) player nexointeracts furniture - location, furniture_id, item (имеет игрока, отменяемый)
- (on/after) player nexodamages block - block, block_id, location (имеет игрока, отменяемый)
- (on/after) player nexobreaks block - block, block_id, location (имеет игрока, отменяемый)
- (on/after) player nexointeracts block - block, block_id, location (имеет игрока, отменяемый)
- (on/after) player nexoplace block - block, block_id, location (имеет игрока, отменяемый)
