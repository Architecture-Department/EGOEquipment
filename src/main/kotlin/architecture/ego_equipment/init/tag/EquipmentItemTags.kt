package architecture.ego_equipment.init.tag

import architecture.ego_equipment.core.EGOEquipmentConstants
import architecture.goldenboughs_lib.util.LibUtil.rlOf
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.ItemTags
import net.minecraft.tags.TagKey
import net.minecraft.world.item.Item

object EquipmentItemTags {
	val EGO_ARMOUR: TagKey<Item> = createTag("ego/armour")
	val EGO_WEAPON: TagKey<Item> = createTag("ego/weapon")
	val EGO_TOOL: TagKey<Item> = createTag("ego/tool")

	val SPECIAL: TagKey<Item> = createTag("weapon_type/special")
	val REMOTE: TagKey<Item> = createTag("weapon_type/remote")
	val MELEE: TagKey<Item> = createTag("weapon_type/melee")
	val GUN: TagKey<Item> = createTag("weapon_type/gun")

	private fun createTag(name: String): TagKey<Item> = createTag(EGOEquipmentConstants.modRl(name))

	private fun createTag(location: ResourceLocation): TagKey<Item> = ItemTags.create(location)

	@Suppress("unused")
	private fun createCTag(name: String): TagKey<Item> = createTag(rlOf("c", name))

	@Suppress("unused")
	private fun createMcTag(name: String): TagKey<Item> = createTag(ResourceLocation.withDefaultNamespace(name))
}
