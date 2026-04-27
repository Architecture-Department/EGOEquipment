package architecture.ego_equipment.init.tag;

import architecture.ego_equipment.core.EGOEquipment;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public final class EquipmentItemTags {
	//region E.G.O
	/**
	 * E.G.O盔甲
	 */
	public static final TagKey<Item> EGO_ARMOUR = createTag("ego/armour");
	/**
	 * E.G.O武器
	 */
	public static final TagKey<Item> EGO_WEAPON = createTag("ego/weapon");
	/**
	 * E.G.O工具
	 */
	public static final TagKey<Item> EGO_TOOL = createTag("ego/tool");

	//region 武器类型
	/**
	 * 特殊武器
	 */
	public static final TagKey<Item> SPECIAL = createTag("weapon_type/special");

	/**
	 * 远程武器
	 */
	public static final TagKey<Item> REMOTE = createTag("weapon_type/remote");
	/**
	 * 近战武器
	 */
	public static final TagKey<Item> MELEE = createTag("weapon_type/melee");

	/**
	 * 枪
	 */
	public static final TagKey<Item> GUN = createTag("weapon_type/gun");
	//endregion
	//endregion

	private static TagKey<Item> createTag(String name) {
		return createTag(EGOEquipment.modRl(name));
	}

	private static TagKey<Item> createTag(ResourceLocation location) {
		return ItemTags.create(location);
	}

	private static TagKey<Item> createCTag(String name) {
		return createTag(ResourceLocation.fromNamespaceAndPath("c", name));
	}

	private static TagKey<Item> createMcTag(String name) {
		return createTag(ResourceLocation.withDefaultNamespace(name));
	}
}
