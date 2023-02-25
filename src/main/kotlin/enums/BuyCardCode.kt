package enums

enum class BuyCardCode {
    CURSE, COPPER, SILVER, GOLD, PLATINUM, POTION, ESTATE, DUCHY, PROVINCE, COLONY,
    FIRST, SECOND, THIRD, FOURTH, FIFTH, SIXTH, SEVENTH, EIGHTH, NINTH, TENTH
    /*ABANDONED_MINE, ACADEMY, ACTING_TROUPE, ADVANCE, ADVENTURER, ADVISOR, ALCHEMIST, ALLIANCE, ALMS, ALTAR, AMBASSADOR, AMULET, ANIMAL_FAIR, ANNEX, ANVIL, APOTHECARY, APPRENTICE, AQUEDUCT, ARCHIVE, ARENA, ARMORY, ARTIFICER, ARTISAN, ASTROLABE, AVANTO, BAD_OMENS, BAG_OF_GOLD, BAKER, BALL, BAND_OF_MISFITS, BANDIT, BANDIT_CAMP, BANDIT_FORT, BANISH, BANK, BANQUET, BARBARIAN, BARD, BARGAIN, BARGE, BARON, BARRACKS, BASILICA, BAT, BATHS, BATTLEFIELD, BAUBLE, BAZAAR, BEGGAR, BISHOP, BLACK_CAT, BLACK_MARKET, BLESSED_VILLAGE, BONFIRE, BORDER_GUARD, BORDER_VILLAGE, BORROW, BOUNTY_HUNTER, BRIDGE, BRIDGE_TROLL, BUREAUCRAT, BUSTLING_VILLAGE, BUTCHER, CACHE, CAMEL_TRAIN, CANAL, CANDLESTICK_MAKER, CAPITAL, CAPITALISM, CAPTAIN, CARAVAN, CARAVAN_GUARD, CARDINAL, CARGO_SHIP, CARPENTER, CARTOGRAPHER, CATACOMBS, CATAPULT, CATHEDRAL, CASTLES, CAVALRY, CELLAR, CEMETERY, CHAMPION, CHANCELLOR, CHANGELING, CHAPEL, CHARIOT_RACE, CHARLATAN, CHARM, CHURCH, CITADEL, CITY, CITY_GATE, CITY_QUARTER, COBBLER, COIN_OF_THE_REALM, COLLECTION, COLONNADE, COMMERCE, CONCLAVE, CONQUEST, CONSPIRATOR, CONTRABAND, COPPERSMITH, CORSAIR, COUNCIL_ROOM, COUNT, COUNTERFEIT, COUNTING_HOUSE, COURIER, COURTIER, COURTYARD, COVEN, CROP_ROTATION, CROSSROADS, CROWN, CRUMBLING_CASTLE, CRYPT, CULTIST, CURSED_GOLD, CURSED_VILLAGE, CUTPURSE, DAME_ANNA, DAME_JOSEPHINE, DAME_MOLLY, DAME_NATALIE, DAME_SYLVIA, DEATH_CART, DEFILED_SHRINE, DELUSION, DELVE, DEMAND, DEN_OF_SIN, DESTRIER, DEVELOP, DEVILS_WORKSHOP, DIADEM, DIPLOMAT, DISCIPLE, DISMANTLE, DISPLACE, DISTANT_LANDS, DOCTOR, DOMINATE, DONATE, DRUID, DUCAT, DUCHESS, DUKE, DUNGEON, DUPLICATE, EMBARGO, EMBASSY, EMPORIUM, ENCAMPMENT, ENCHANTRESS, ENCLAVE, ENGINEER, ENVY, ENVOY, EXORCIST, EXPAND, EXPEDITION, EXPERIMENT, EXPLORATION, EXPLORER, FAIR, FAIRGROUNDS, FAITHFUL_HOUND, FALCONER, FAMILIAR, FAMINE, FARMERS_MARKET, FARMING_VILLAGE, FARMLAND, FEAR, FEAST, FEODUM, FERRY, FESTIVAL, FISHERMAN, FISHING_VILLAGE, FLAG_BEARER, FLEET, FOLLOWERS, FOOL, FOOLS_GOLD, FORAGER, FORGE, FORTRESS, FORTUNE, FORTUNE_TELLER, FORUM, FOUNTAIN, FUGITIVE, GANG_OF_PICKPOCKETS, GARDENS, GATEKEEPER, GEAR, GHOST, GHOST_SHIP, GHOST_TOWN, GIANT, GLADIATOR, GOAT, GOATHERD, GOLEM, GOONS, GOVERNOR, GRAND_CASTLE, GRAND_MARKET, GRAVEROBBER, GREAT_HALL, GREED, GROOM, GROUNDSKEEPER, GUARDIAN, GUIDE, GUILDHALL, HAGGLER, HAMLET, HARBINGER, HAREM, HARVEST, HAUNTED_CASTLE, HAUNTED_MIRROR, HAUNTED_WOODS, HAUNTING, HAVEN, HERALD, HERBALIST, HERMIT, HERO, HIDEOUT, HIGHWAY, HIRELING, HOARD, HORN_OF_PLENTY, HORSE, HORSE_TRADERS, HOSTELRY, HOVEL, HUMBLE_CASTLE, HUNTER, HUNTING_GROUNDS, HUNTING_LODGE, HUNTING_PARTY, IDOL, ILL_GOTTEN_GAINS, IMP, IMPORTER, IMPROVE, INHERITANCE, INN, INNKEEPER, INNOVATION, INVENTOR, INVEST, IRONMONGER, IRONWORKS, ISLAND, JACK_OF_ALL_TRADES, JESTER, JOURNEYMAN, JUNK_DEALER, KEEP, KILN, KINGS_CASTLE, KINGS_COURT, KNIGHTS, LABORATORY, LABYRINTH, LACKEYS, LEAGUE_OF_BANKERS, LEGIONARY, LEPRECHAUN, LIBRARY, LIGHTHOUSE, LIVERY, LOAN, LOCUSTS, LOOKOUT, LOST_ARTS, LOST_CITY, LOST_IN_THE_WOODS, LUCKY_COIN, LURKER, MADMAN, MAGIC_LAMP, MAGNATE, MAGPIE, MANDARIN, MARAUDER, MARGRAVE, MARKET, MARKET_SQUARE, MASQUERADE, MASTERMIND, MASTERPIECE, MENAGERIE, MERCENARY, MERCHANT, MERCHANT_GUILD, MERCHANT_SHIP, MESSENGER, MILITIA, MILL, MINE, MINION, MINING_VILLAGE, MINT, MISER, MISERY, MISSION, MOAT, MONASTERY, MONEYLENDER, MONKEY, MONUMENT, MOUNTAIN_PASS, MOUNTAIN_VILLAGE, MOUNTEBANK, MUSEUM, MYSTIC, NATIVE_VILLAGE, NAVIGATOR, NECROMANCER, NECROPOLIS, NIGHT_WATCHMAN, NOBLE_BRIGAND, NOMAD_CAMP, NOBLES, OASIS, OBELISK, OLD_WITCH, OPULENT_CASTLE, ORACLE, ORCHARD, OVERLORD, OUTPOST, OVERGROWN_ESTATE, PADDOCK, PAGE, PAGEANT, PALACE, PASTURE, PATHFINDING, PATRICIAN, PATROL, PATRON, PAWN, PEARL_DIVER, PEASANT, PEDDLER, PHILOSOPHERS_STONE, PIAZZA, PILGRIMAGE, PILLAGE, PIRATE, PIRATE_SHIP, PIXIE, PLAGUE, PLAN, PLATEAU_SHEPHERDS, PLAZA, PLUNDER, POACHER, POOKA, POOR_HOUSE, PORT, POSSESSION, POUCH, POVERTY, PRIEST, PRINCE, PRINCESS, PROCESSION, QUARRY, QUEST, RABBLE, RAID, RAIDER, RANGER, RATCATCHER, RATS, RAZE, REAP, REBUILD, RECRUITER, RELIC, REMAKE, REMODEL, REPLACE, RESEARCH, RITUAL, ROAD_NETWORK, ROCKS, ROGUE, ROYAL_BLACKSMITH, ROYAL_CARRIAGE, ROYAL_GALLEY, ROYAL_SEAL, RUINED_LIBRARY, RUINED_MARKET, RUINED_VILLAGE, RUINS, SABOTEUR, SACRED_GROVE, SACRIFICE, SAGE, SALT_THE_EARTH, SALVAGER, SANCTUARY, SAUNA, SAVE, SCAVENGER, SCEPTER, SCHEME, SCHOLAR, SCOUT, SCOUTING_PARTY, SCRAP, SCRYING_POOL, SCULPTOR, SEA_CHART, SEA_HAG, SEA_WITCH, SEAWAY, SENTINEL, SECRET_CAVE, SECRET_CHAMBER, SECRET_PASSAGE, SEER, SENTRY, SETTLERS, SEWERS, SHANTY_TOWN, SHEEPDOG, SHEPHERD, SILK_MERCHANT, SILK_ROAD, SILOS, SINISTER_PLOT, SIR_BAILEY, SIR_DESTRY, SIR_MARTIN, SIR_MICHAEL, SIR_VANDER, SKULK, SLEIGH, SMALL_CASTLE, SMITHY, SMUGGLERS, SNOWY_VILLAGE, SOLDIER, SOOTHSAYER, SPICE_MERCHANT, SPICES, SPOILS, SPRAWLING_CASTLE, SPY, SQUIRE, STABLES, STAMPEDE, STAR_CHART, STASH, STEWARD, STOCKPILE, STONEMASON, STOREROOM, STORYTELLER, SUMMON, SUPPLIES, SURVIVORS, SWAMP_HAG, SWASHBUCKLER, SWINDLER, TACTICIAN, TALISMAN, TAX, TAXMAN, TEACHER, TEMPLE, TENT, TERRITORY, THE_EARTHS_GIFT, THE_FIELDS_GIFT, THE_FLAMES_GIFT, THE_FORESTS_GIFT, THE_MOONS_GIFT, THE_MOUNTAINS_GIFT, THE_RIVERS_GIFT, THE_SEAS_GIFT, THE_SKYS_GIFT, THE_SUNS_GIFT, THE_SWAMPS_GIFT, THE_WINDS_GIFT, THIEF, THRONE_ROOM, TOMB, TORMENTOR, TORTURER, TOURNAMENT, TOWER, TRACKER, TRADE, TRADER, TRADE_ROUTE, TRADING_POST, TRAGIC_HERO, TRAIL, TRAINING, TRANSMOGRIFY, TRANSMUTE, TRAVELLING_FAIR, TREASURE_HUNTER, TREASURE_MAP, TREASURE_TROVE, TREASURER, TREASURY, TRIBUTE, TRIUMPH, TRIUMPHAL_ARCH, TRUSTY_STEED, TUNNEL, UNDERLING, UNIVERSITY, UPGRADE, URCHIN, VAGRANT, VAMPIRE, VASSAL, VAULT, VENTURE, VILLA, VILLAGE, VILLAGE_GREEN, VILLAIN, VINEYARD, WALL, WALLED_VILLAGE, WANDERING_MINSTREL, WAR, WAREHOUSE, WARRIOR, WATCHTOWER, WAY_OF_THE_OX, WAYFARER, WEAVER, WEDDING, WEREWOLF, WHARF, WILD_HUNT, WILL_O_WISP, WINDFALL, WINE_MERCHANT, WISH, WISHING_WELL, WITCH, WITCHS_HUT, WOLF_DEN, WOODCUTTER, WORKERS_VILLAGE, WORKSHOP, YOUNG_WITCH, ZOMBIE_APPRENTICE, ZOMBIE_MASON, ZOMBIE_SPY*/
}