package architecture.ego_equipment.datagen.tag

import architecture.ego_equipment.init.tag.EquipmentItemTags
import architecture.ego_equipment.util.EGOEquipmentUtil
import architecture.goldenboughs_lib.init.LibItems
import architecture.goldenboughs_lib.init.tag.LibItemTags
import net.minecraft.core.HolderLookup
import net.minecraft.data.PackOutput
import net.minecraft.data.tags.ItemTagsProvider
import net.minecraft.tags.ItemTags
import net.minecraft.tags.TagKey
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import net.neoforged.neoforge.common.Tags
import net.neoforged.neoforge.common.data.ExistingFileHelper
import net.neoforged.neoforge.registries.DeferredItem
import java.util.concurrent.CompletableFuture

class DatagenItemTag(
	output: PackOutput,
	lookupProvider: CompletableFuture<HolderLookup.Provider>,
	blockTags: CompletableFuture<TagLookup<Block>>,
	existingFileHelper: ExistingFileHelper
) : ItemTagsProvider(output, lookupProvider, blockTags, EGOEquipmentUtil.ID, existingFileHelper) {

	override fun addTags(provider: HolderLookup.Provider) {
		addSet(EquipmentItemTags.EGO_ARMOUR, EGOEquipmentUtil.EGO_ARMOUR)
		addSet(EquipmentItemTags.EGO_TOOL, EGOEquipmentUtil.EGO_TOOL)
		addSet(EquipmentItemTags.EGO_WEAPON, EGOEquipmentUtil.EGO_WEAPON)
			.add(LibItems.CHAOS_SWORD.get())
		tag(LibItemTags.EGO)
			.addTags(
				EquipmentItemTags.EGO_ARMOUR,
				EquipmentItemTags.EGO_WEAPON,
				EquipmentItemTags.EGO_TOOL
			)

		addSet(ItemTags.HEAD_ARMOR, EGOEquipmentUtil.HEAD_ARMOR)
		addSet(ItemTags.CHEST_ARMOR, EGOEquipmentUtil.CHEST_ARMOR)
		addSet(ItemTags.LEG_ARMOR, EGOEquipmentUtil.LEG_ARMOR)
		addSet(ItemTags.FOOT_ARMOR, EGOEquipmentUtil.FOOT_ARMOR)
		tag(Tags.Items.ARMORS)
			.addTag(EquipmentItemTags.EGO_ARMOUR)

		EGOEquipmentUtil.MELEE.addAll(EGOEquipmentUtil.KNIFE)
		EGOEquipmentUtil.MELEE.addAll(EGOEquipmentUtil.HAMMER)
		EGOEquipmentUtil.MELEE.addAll(EGOEquipmentUtil.FIST)
		EGOEquipmentUtil.MELEE.addAll(EGOEquipmentUtil.SPEAR)
		EGOEquipmentUtil.MELEE.addAll(EGOEquipmentUtil.MACE)
		addSet(EquipmentItemTags.MELEE, EGOEquipmentUtil.MELEE)
			.addTag(ItemTags.SWORDS)

		EGOEquipmentUtil.GUN.addAll(EGOEquipmentUtil.CANNON)
		EGOEquipmentUtil.GUN.addAll(EGOEquipmentUtil.PISTOL)
		EGOEquipmentUtil.GUN.addAll(EGOEquipmentUtil.RIFLE)
		addSet(EquipmentItemTags.GUN, EGOEquipmentUtil.GUN)

		addSet(EquipmentItemTags.REMOTE, EGOEquipmentUtil.REMOTE).addTags(
			Tags.Items.TOOLS_CROSSBOW,
			Tags.Items.TOOLS_BOW,
			EquipmentItemTags.GUN
		)

		addSet(ItemTags.BOW_ENCHANTABLE, EGOEquipmentUtil.BOW)
		addSet(ItemTags.CROSSBOW_ENCHANTABLE, EGOEquipmentUtil.CROSSBOW)

		addSet(Tags.Items.TOOLS_CROSSBOW, EGOEquipmentUtil.CROSSBOW)
		addSet(Tags.Items.TOOLS_BOW, EGOEquipmentUtil.BOW)
		addSet(ItemTags.AXES, EGOEquipmentUtil.AXE)

		EGOEquipmentUtil.SWORDS.addAll(EGOEquipmentUtil.KNIFE)
		addSet(ItemTags.SWORDS, EGOEquipmentUtil.SWORDS)
			.add(LibItems.CHAOS_SWORD.get())
		tag(ItemTags.SWORD_ENCHANTABLE).addTag(EquipmentItemTags.MELEE)
		tag(ItemTags.BREAKS_DECORATED_POTS).addTag(EquipmentItemTags.MELEE)
		addSet(EquipmentItemTags.SPECIAL, EGOEquipmentUtil.SPECIAL)
		tag(Tags.Items.TOOLS)
			.add(LibItems.CREATIVE_RATIONALITY_TOOL.get())
			.addTags(
				EquipmentItemTags.EGO_WEAPON,
				EquipmentItemTags.EGO_TOOL,
				EquipmentItemTags.SPECIAL,
				EquipmentItemTags.REMOTE,
				EquipmentItemTags.MELEE
			)
	}

	private fun addSet(tag: TagKey<Item>, set: MutableSet<DeferredItem<out Item>>) =
		tag(tag).add(*set.map { it.get() }.toTypedArray())
}
