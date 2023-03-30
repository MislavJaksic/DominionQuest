string = '''package cards.base_set

import cards.ActionCard
import game.Player

data class $1(override var owner: Player) : ActionCard {
    override val cost: Int
        get() = -1

    override fun execute() {
    }
}'''

names = [
"Harbinger",
"Poacher",
"Bandit",
"Sentry",
"Artisan",
"Vassal",
"Merchant",
"Adventurer",
"Woodcutter",
"Chancellor",
"Feast",
"Spy",
"Thief",
"Witch",
"Mine",
"Market",
"Library",
"Laboratory",
"Festival",
"Remodel",
"Moneylender",
"Militia",
"Gardens",
"Bureaucrat",
"Smithy",
"Throne Room",
"Council Room",
"Curse",
"Cellar",
"Chapel",
"Moat",
"Village",
"Workshop"
]

for name in names:
    with open("{}.kt".format(name), "w") as file:
        file.write(string.replace("$1", name))

'''
 Name 
Blockade 
Sea Chart 
Astrolabe 
Monkey 
Corsair 
Tide Pools 
Sailor 
Sea Witch 
Pirate 
Navigator 
Sea Hag 
Explorer 
Pearl Diver 
Embargo 
Ambassador 
Pirate Ship 
Ghost Ship 
Island 
Salvager 
Treasure Map 
Bazaar 
Haven 
Lighthouse 
Native Village 
Fishing Village 
Lookout 
Smugglers 
Warehouse 
Caravan 
Cutpurse 
Outpost 
Merchant Ship 
Wharf 
Treasury 
Tactician 
Hideout 
Flag Bearer 
Improve 
Experiment 
Cargo Ship 
Acting Troupe 
Inventor 
Mountain Village 
Patron 
Priest 
Research 
Silk Merchant 
Old Witch 
Recruiter 
Scepter 
Scholar 
Sculptor 
Seer 
Spices 
Swashbuckler 
Treasurer 
Villain 
Flag 
Horn 
Key 
Lantern 
Treasure Chest 
Cathedral 
City Gate 
Pageant 
Sewers 
Star Chart 
Exploration 
Fair 
Silos 
Sinister Plot 
Academy 
Capitalism 
Fleet 
Guildhall 
Piazza 
Border Guard 
Canal 
Innovation 
Ducat 
Lackeys 
Road Network 
Barracks 
Crop Rotation 
Citadel 
Collection 
War Chest 
Anvil 
Clerk 
Investment 
Tiara 
Magnate 
Charlatan 
Crystal Ball 
Goons 
Counting House 
Contraband
Mountebank 
Royal Seal 
Talisman 
Trade Route 
Loan 
Venture 
City 
Mint 
Rabble 
Vault 
Grand Market 
Platinum 
Colony 
Worker's Village 
Quarry 
Monument 
Bishop 
Watchtower 
Peddler 
King's Court 
Forge 
Expand 
Bank 
Hoard 
Prince 
Captain 
Summon 
Stash 
Governor 
Avanto 
Walled Village 
Sauna 
Envoy 
Dismantle 
Church 
Black Market 
Grotto 
Jewelled Egg 
Search 
Shaman 
Cage 
Siren 
Stowaway 
Taskmaster 
Abundance 
Secluded Shrine 
Crucible 
Flagship 
Cabin Boy 
Fortune Hunter 
Gondola 
Tormentor 
Tragic Hero 
Vampire 
Werewolf 
Raider 
Will-o'-Wisp 
Wish 
Bat 
Imp 
Ghost 
Zombie Apprentice 
Zombie Mason 
Zombie Spy 
Haunted Mirror 
Magic Lamp 
Goat 
Pasture 
Pouch 
Cursed Gold 
Lucky Coin 
The Earth's Gift 
The Field's Gift 
The Flame's Gift 
The Forest's Gift 
The Moon's Gift 
The Mountain's Gift 
The River's Gift 
The Sea's Gift 
The Sky's Gift 
The Sun's Gift 
The Swamp's Gift 
The Wind's Gift 
Bad Omens 
Delusion 
Envy 
Famine 
Fear 
Greed 
Haunting 
Locusts 
Misery 
Plague 
Poverty 
War 
Deluded 
Envious 
Lost in the Woods 
Miserable 
Twice Miserable 
Secret Cave 
Night Watchman 
Leprechaun 
Ghost Town 
Fool 
Changeling 
Bard 
Blessed Village 
Cemetery 
Conclave 
Devil's Workshop 
Exorcist 
Necromancer 
Shepherd 
Skulk 
Cobbler 
Crypt 
Cursed Village 
Den of Sin 
Idol 
Pooka 
Sacred Grove 
Druid 
Tracker 
Pixie 
Monastery 
Guardian 
Faithful Hound 
Camel Train 
Goatherd 
Scrap 
Sheepdog 
Snowy Village 
Stockpile 
Bounty Hunter 
Enhance 
Toil 
Ride 
Pursue 
Gamble 
Desperation 
Delay 
Animal Fair 
Wayfarer 
Destrier 
Horse 
Supplies 
Sleigh 
Black Cat 
Alliance 
Gatekeeper 
Falconer 
Displace 
Coven 
Barge 
Hunting Lodge 
Kiln 
Livery 
Mastermind 
Paddock 
Sanctuary 
Cavalry 
Groom 
Hostelry 
Village Green 
Fisherman 
Cardinal 
Way of the Turtle 
Way of the Squirrel 
Way of the Sheep 
Way of the Seal 
Way of the Rat 
Way of the Pig 
Way of the Owl 
Way of the Ox 
Way of the Otter 
Way of the Mule 
Way of the Worm 
March 
Transport 
Banish 
Bargain 
Invest 
Seize the Day 
Commerce 
Demand 
Stampede 
Reap 
Enclave 
Way of the Mouse 
Way of the Monkey 
Way of the Mole 
Way of the Horse 
Way of the Goat 
Way of the Frog 
Way of the Chameleon 
Way of the Camel 
Way of the Butterfly 
Populate 
Lurker 
Diplomat 
Secret Passage 
Mill 
Courtier 
Patrol 
Replace 
Tribute 
Secret Chamber 
Saboteur 
Scout 
Great Hall 
Coppersmith 
Courtyard 
Pawn 
Steward 
Masquerade 
Shanty Town 
Conspirator 
Swindler 
Wishing Well 
Baron 
Bridge 
Nobles 
Ironworks 
Mining Village 
Duke 
Minion 
Torturer 
Trading Post 
Upgrade 
Harem 
Weaver 
Cauldron 
Souk 
Wheelwright 
Witch's Hut 
Guard Dog 
Trail 
Nomads 
Berserker 
Oracle 
Noble Brigand 
Nomad Camp 
Ill-Gotten Gains 
Mandarin 
Duchess 
Embassy 
Silk Road 
Cache 
Tunnel 
Scheme 
Oasis 
Develop 
Fool's Gold 
Border Village 
Stables 
Margrave 
Inn 
Highway 
Haggler 
Farmland 
Jack of All Trades 
Spice Merchant 
Trader 
Cartographer 
Crossroads 
Stonemason 
Doctor 
Masterpiece 
Advisor 
Candlestick Maker 
Plaza 
Taxman 
Herald 
Butcher 
Baker 
Merchant Guild 
Journeyman 
Soothsayer 
Haunted Castle 
Small Castle 
Crumbling Castle 
Humble Castle 
Fortune 
Wild Hunt 
Plunder 
Legionary 
Opulent Castle 
Sprawling Castle 
Grand Castle 
Crown 
Charm 
Emporium 
Forum 
Groundskeeper 
Archive 
Bustling Village 
Capital 
Chariot Race 
Catapult 
Settlers 
Patrician 
Encampment 
Overlord 
Royal Blacksmith 
City Quarter 
Engineer 
Wolf Den 
Wall 
Triumphal Arch 
Tower 
Tomb 
Palace 
Orchard 
Obelisk 
Museum 
Mountain Pass 
Labyrinth 
Keep 
Fountain 
Defiled Shrine 
Colonnade 
Baths 
King's Castle 
Triumph 
Annex 
Donate 
Advance 
Delve 
Tax 
Banquet 
Ritual 
Salt the Earth 
Wedding 
Windfall 
Conquest 
Dominate 
Aqueduct 
Arena 
Bandit Fort 
Basilica 
Battlefield 
Villa 
Temple 
Sacrifice 
Rocks 
Gladiator 
Farmers' Market 
Enchantress 
Market Square 
Sage 
Storeroom 
Urchin 
Armory 
Death Cart 
Feodum 
Fortress 
Ironmonger 
Marauder 
Procession 
Hermit 
Forager 
Vagrant 
Squire 
Beggar 
Poor House 
Overgrown Estate 
Counterfeit 
Cultist 
Graverobber 
Junk Dealer 
Mystic 
Pillage 
Rebuild 
Rogue 
Altar 
Hunting Grounds 
Abandoned Mine 
Ruined Library 
Ruined Market 
Ruined Village 
Survivors 
Count 
Catacombs 
Bandit Camp 
Band of Misfits 
Wandering Minstrel 
Scavenger 
Rats 
Sir Martin 
Sir Michael 
Sir Vander 
Madman 
Sir Destry 
Sir Bailey 
Dame Sylvia 
Dame Natalie 
Dame Molly 
Dame Josephine 
Dame Anna 
Necropolis 
Hovel 
Mercenary 
Spoils 
Trusty Steed 
Princess 
Diadem 
Followers 
Hamlet 
Fortune Teller 
Menagerie 
Farming Village 
Horse Traders 
Remake 
Tournament 
Young Witch 
Harvest 
Horn of Plenty 
Hunting Party 
Jester 
Fairgrounds 
Bag of Gold 
Emissary 
Contract 
Capital City 
Barbarian 
Town 
Royal Galley 
Innkeeper 
Courier 
Carpenter 
Broker 
Underling 
Sentinel 
Importer 
Merchant Camp 
Sycophant 
Bauble 
Territory 
Architects' Guild 
Band of Nomads 
Cave Dwellers 
Circle of Witches 
City-state 
Coastal Haven 
Crafters' Guild 
Desert Guides 
Family of Inventors 
Fellowship of Scribes 
Forest Dwellers 
Stronghold 
Lich 
Distant Shore 
Sibyl 
Warlord 
Hill Fort 
Sorcerer 
Elder 
Sunken Treasure 
Sorceress 
Archer 
Garrison 
Conjurer 
Miller 
Voyage 
Acolyte 
Battle Plan 
Tent 
Student 
Blacksmith 
Old Map 
Herb Gatherer 
Town Crier 
Marquis 
Swap 
Specialist 
Skirmisher 
Modify 
Hunter 
Highwayman 
Guildmaster 
Galleria 
Woodworkers' Guild 
Gang of Pickpockets 
Island Folk 
League of Bankers 
League of Shopkeepers 
Market Towns 
Mountain Folk 
Order of Astrologers 
Order of Masons 
Peaceful Cult 
Plateau Shepherds 
Trappers' Lodge 
Vineyard 
Herbalist 
Apothecary 
Scrying Pool 
University 
Transmute 
Potion 
Possession 
Apprentice 
Golem 
Philosopher's Stone 
Familiar 
Alchemist 
Soldier 
Fugitive 
Disciple 
Teacher 
Pathfinding 
Inheritance 
Training 
Lost Arts 
Trade 
Seaway 
Raid 
Champion 
Hero 
Treasure Hunter 
Warrior 
Coin of the Realm 
Page 
Peasant 
Ratcatcher 
Raze 
Amulet 
Caravan Guard 
Dungeon 
Gear 
Guide 
Duplicate 
Magpie 
Messenger 
Miser 
Port 
Ranger 
Transmogrify 
Artificer 
Bridge Troll 
Distant Lands 
Giant 
Haunted Woods 
Lost City 
Relic 
Royal Carriage 
Storyteller 
Swamp Hag 
Treasure Trove 
Wine Merchant 
Ball 
Pilgrimage 
Mission 
Plan 
Ferry 
Expedition 
Bonfire 
Travelling Fair 
Scouting Party 
Save 
Quest 
Borrow 
Alms 
Hireling '''