package PluginReference;

/**
 * Entity Type
 */
public enum MC_EntityType {
    UNSPECIFIED,
	PLAYER,

	// Normal Mobs
	BAT,
	CHICKEN,
	COW,
	HORSE,
	MUSHROOM_COW,
	OCELOT,
	PIG,
	RABBIT,
	SHEEP,
	SNOWMAN,
	SQUID,
	VILLAGER_GOLEM,
	WOLF,
	VILLAGER,
	ENDERDRAGON,
	WITHERBOSS,
	BLAZE,
	CAVE_SPIDER,
	CREEPER,
	ENDERMAN,
	ENDERMITE,
	GHAST,
	GIANT,
	GUARDIAN,
	LAVA_SLIME,
	PIG_ZOMBIE,
	SILVERFISH,
	SKELETON,
	SLIME,
	SPIDER,
	WITCH,
	ZOMBIE,
	
	// Special Mobs...
	FISHING_HOOK,
	ARROW,
	SMALL_FIREBALL,
	FIREBALL,
	SNOWBALL,
	THROWN_ENDERPEARL,
	EYE_OF_ENDER_SIGNAL,
	THROWN_EGG,
	THROWN_POTION,
	THROWN_EXP_BOTTLE,
	FIREWORK,
	ITEM,
	MINECART,
	BOAT,
	PRIMED_TNT,
	FALLING_SAND,
	@Deprecated
	HANGING, // i.e. painting, item_frame
	ARMOR_STAND,
	XP_ORB,
	ENDER_CRYSTAL,
	WITHER_SKULL,
	
	// Added during 1.9
	LEASH_KNOT, 
	PAINTING,
	ITEM_FRAME, 
	LIGHTNING_BOLT, // note: the above (Leash, Painting, Frames, ...) obvious before 1.9 but added as specific entities rather than just 'hanging' ones
	SHULKER,
	SHULKER_BULLET,
	AREA_EFFECT_CLOUD,
    SPECTRAL_ARROW,
    DRAGON_FIREBALL,

    // Added in 1.10
    POLAR_BEAR,

	// Added in 1.11
    // Subtypes of previous entities that are now full entities
    ZOMBIE_HORSE,
    SKELETON_HORSE,
    DONKEY,
    MULE,
    HUSK,
    ZOMBIE_VILLAGER,
    STRAY,
    WHITHER_SKELETON,
    ELDER_GUARDIAN,
	MINECART_CHEST,
	MINECART_FURNACE,
	MINECART_TNT,
	MINECART_HOPPER,
	MINECART_SPAWNER,

    // new entities
    EVOCATION_FANGS,
    EVOKER,
    VEX,
    LLAMA,
    VINDICATOR,

	// Added in 1.12
	ILLUSIONER,
	PARROT
}
