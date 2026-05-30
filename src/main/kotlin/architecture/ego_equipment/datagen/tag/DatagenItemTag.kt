package architecture.ego_equipment.datagen.tag

import architecture.ego_equipment.core.EGOEquipmentConstants
import architecture.ego_equipment.init.tag.EquipmentItemTags
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
) : ItemTagsProvider(output, lookupProvider, blockTags, EGOEquipmentConstants.ID, existingFileHelper) {

	override fun addTags(provider: HolderLookup.Provider) {
		addSet(EquipmentItemTags.EGO_ARMOUR, EGOEquipmentConstants.EGO_ARMOUR)
		addSet(EquipmentItemTags.EGO_TOOL, EGOEquipmentConstants.EGO_TOOL)
		addSet(EquipmentItemTags.EGO_WEAPON, EGOEquipmentConstants.EGO_WEAPON)
			.add(LibItems.CHAOS_SWORD.get())
		tag(LibItemTags.EGO)
			.addTags(
				EquipmentItemTags.EGO_ARMOUR,
				EquipmentItemTags.EGO_WEAPON,
				EquipmentItemTags.EGO_TOOL
			)

		addSet(ItemTags.HEAD_ARMOR, EGOEquipmentConstants.HEAD_ARMOR)
		addSet(ItemTags.CHEST_ARMOR, EGOEquipmentConstants.CHEST_ARMOR)
		addSet(ItemTags.LEG_ARMOR, EGOEquipmentConstants.LEG_ARMOR)
		addSet(ItemTags.FOOT_ARMOR, EGOEquipmentConstants.FOOT_ARMOR)
		tag(Tags.Items.ARMORS)
			.addTag(EquipmentItemTags.EGO_ARMOUR)

		EGOEquipmentConstants.MELEE.addAll(EGOEquipmentConstants.KNIFE)
		EGOEquipmentConstants.MELEE.addAll(EGOEquipmentConstants.HAMMER)
		EGOEquipmentConstants.MELEE.addAll(EGOEquipmentConstants.FIST)
		EGOEquipmentConstants.MELEE.addAll(EGOEquipmentConstants.SPEAR)
		EGOEquipmentConstants.MELEE.addAll(EGOEquipmentConstants.MACE)
		addSet(EquipmentItemTags.MELEE, EGOEquipmentConstants.MELEE)
			.addTag(ItemTags.SWORDS)

		EGOEquipmentConstants.GUN.addAll(EGOEquipmentConstants.CANNON)
		EGOEquipmentConstants.GUN.addAll(EGOEquipmentConstants.PISTOL)
		EGOEquipmentConstants.GUN.addAll(EGOEquipmentConstants.RIFLE)
		addSet(EquipmentItemTags.GUN, EGOEquipmentConstants.GUN)

		addSet(EquipmentItemTags.REMOTE, EGOEquipmentConstants.REMOTE).addTags(
			Tags.Items.TOOLS_CROSSBOW,
			Tags.Items.TOOLS_BOW,
			EquipmentItemTags.GUN
		)

		addSet(ItemTags.BOW_ENCHANTABLE, EGOEquipmentConstants.BOW)
		addSet(ItemTags.CROSSBOW_ENCHANTABLE, EGOEquipmentConstants.CROSSBOW)

		addSet(Tags.Items.TOOLS_CROSSBOW, EGOEquipmentConstants.CROSSBOW)
		addSet(Tags.Items.TOOLS_BOW, EGOEquipmentConstants.BOW)
		addSet(ItemTags.AXES, EGOEquipmentConstants.AXE)

		EGOEquipmentConstants.SWORDS.addAll(EGOEquipmentConstants.KNIFE)
		addSet(ItemTags.SWORDS, EGOEquipmentConstants.SWORDS)
			.add(LibItems.CHAOS_SWORD.get())
		tag(ItemTags.SWORD_ENCHANTABLE).addTag(EquipmentItemTags.MELEE)
		tag(ItemTags.BREAKS_DECORATED_POTS).addTag(EquipmentItemTags.MELEE)
		addSet(EquipmentItemTags.SPECIAL, EGOEquipmentConstants.SPECIAL)
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
