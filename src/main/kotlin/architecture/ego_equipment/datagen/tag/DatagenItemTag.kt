package architecture.ego_equipment.datagen.tag

import architecture.ego_equipment.init.tag.EgoEquipItemTags
import architecture.ego_equipment.util.EgoEquipUtil
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
) : ItemTagsProvider(output, lookupProvider, blockTags, EgoEquipUtil.ID, existingFileHelper) {

	override fun addTags(provider: HolderLookup.Provider) {
		addSet(EgoEquipItemTags.EGO_ARMOUR, EgoEquipUtil.EGO_ARMOUR)
		addSet(EgoEquipItemTags.EGO_TOOL, EgoEquipUtil.EGO_TOOL)
		addSet(EgoEquipItemTags.EGO_WEAPON, EgoEquipUtil.EGO_WEAPON)
			.add(LibItems.CHAOS_SWORD.get())
		tag(LibItemTags.EGO)
			.addTags(
				EgoEquipItemTags.EGO_ARMOUR,
				EgoEquipItemTags.EGO_WEAPON,
				EgoEquipItemTags.EGO_TOOL
			)

		addSet(ItemTags.HEAD_ARMOR, EgoEquipUtil.HEAD_ARMOR)
		addSet(ItemTags.CHEST_ARMOR, EgoEquipUtil.CHEST_ARMOR)
		addSet(ItemTags.LEG_ARMOR, EgoEquipUtil.LEG_ARMOR)
		addSet(ItemTags.FOOT_ARMOR, EgoEquipUtil.FOOT_ARMOR)
		tag(Tags.Items.ARMORS)
			.addTag(EgoEquipItemTags.EGO_ARMOUR)

		EgoEquipUtil.MELEE.addAll(EgoEquipUtil.KNIFE)
		EgoEquipUtil.MELEE.addAll(EgoEquipUtil.HAMMER)
		EgoEquipUtil.MELEE.addAll(EgoEquipUtil.FIST)
		EgoEquipUtil.MELEE.addAll(EgoEquipUtil.SPEAR)
		EgoEquipUtil.MELEE.addAll(EgoEquipUtil.MACE)
		addSet(EgoEquipItemTags.MELEE, EgoEquipUtil.MELEE)
			.addTag(ItemTags.SWORDS)

		EgoEquipUtil.GUN.addAll(EgoEquipUtil.CANNON)
		EgoEquipUtil.GUN.addAll(EgoEquipUtil.PISTOL)
		EgoEquipUtil.GUN.addAll(EgoEquipUtil.RIFLE)
		addSet(EgoEquipItemTags.GUN, EgoEquipUtil.GUN)

		addSet(EgoEquipItemTags.REMOTE, EgoEquipUtil.REMOTE).addTags(
			Tags.Items.TOOLS_CROSSBOW,
			Tags.Items.TOOLS_BOW,
			EgoEquipItemTags.GUN
		)

		addSet(ItemTags.BOW_ENCHANTABLE, EgoEquipUtil.BOW)
		addSet(ItemTags.CROSSBOW_ENCHANTABLE, EgoEquipUtil.CROSSBOW)

		addSet(Tags.Items.TOOLS_CROSSBOW, EgoEquipUtil.CROSSBOW)
		addSet(Tags.Items.TOOLS_BOW, EgoEquipUtil.BOW)
		addSet(ItemTags.AXES, EgoEquipUtil.AXE)

		EgoEquipUtil.SWORDS.addAll(EgoEquipUtil.KNIFE)
		addSet(ItemTags.SWORDS, EgoEquipUtil.SWORDS)
			.add(LibItems.CHAOS_SWORD.get())
		tag(ItemTags.SWORD_ENCHANTABLE).addTag(EgoEquipItemTags.MELEE)
		tag(ItemTags.BREAKS_DECORATED_POTS).addTag(EgoEquipItemTags.MELEE)
		addSet(EgoEquipItemTags.SPECIAL, EgoEquipUtil.SPECIAL)
		tag(Tags.Items.TOOLS)
			.add(LibItems.CREATIVE_RATIONALITY_TOOL.get())
			.addTags(
				EgoEquipItemTags.EGO_WEAPON,
				EgoEquipItemTags.EGO_TOOL,
				EgoEquipItemTags.SPECIAL,
				EgoEquipItemTags.REMOTE,
				EgoEquipItemTags.MELEE
			)
	}

	private fun addSet(tag: TagKey<Item>, set: MutableSet<DeferredItem<out Item>>) =
		tag(tag).add(*set.map { it.get() }.toTypedArray())
}
