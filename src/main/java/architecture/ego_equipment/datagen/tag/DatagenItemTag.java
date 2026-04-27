package architecture.ego_equipment.datagen.tag;

import architecture.ego_equipment.core.EGOEquipment;
import architecture.ego_equipment.core.EGOEquipmentConstants;
import architecture.ego_equipment.init.tag.EquipmentItemTags;
import architecture.goldenboughs_lib.init.LibItems;
import architecture.goldenboughs_lib.init.tag.LibItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import org.jetbrains.annotations.NotNull;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

@SuppressWarnings("unchecked")
public final class DatagenItemTag extends ItemTagsProvider {
	public DatagenItemTag(final PackOutput output, final CompletableFuture<HolderLookup.Provider> lookupProvider, final CompletableFuture<TagLookup<Block>> blockTags, final ExistingFileHelper existingFileHelper) {
		super(output, lookupProvider, blockTags, EGOEquipment.ID, existingFileHelper);
	}

	@Override
	protected void addTags(final HolderLookup.Provider provider) {
		//region E.G.O
		addSet(EquipmentItemTags.EGO_ARMOUR, EGOEquipmentConstants.EGO_ARMOUR);
		addSet(EquipmentItemTags.EGO_TOOL, EGOEquipmentConstants.EGO_TOOL);
		addSet(EquipmentItemTags.EGO_WEAPON, EGOEquipmentConstants.EGO_WEAPON)
			.add(LibItems.CHAOS_SWORD.get());
		tag(LibItemTags.EGO)
			.addTags(EquipmentItemTags.EGO_ARMOUR,
				EquipmentItemTags.EGO_WEAPON,
				EquipmentItemTags.EGO_TOOL);

		addSet(ItemTags.HEAD_ARMOR, EGOEquipmentConstants.HEAD_ARMOR);
		addSet(ItemTags.CHEST_ARMOR, EGOEquipmentConstants.CHEST_ARMOR);
		addSet(ItemTags.LEG_ARMOR, EGOEquipmentConstants.LEG_ARMOR);
		addSet(ItemTags.FOOT_ARMOR, EGOEquipmentConstants.FOOT_ARMOR);
		tag(Tags.Items.ARMORS)
			.addTag(EquipmentItemTags.EGO_ARMOUR);
		//endregion

		//region 近战武器
		EGOEquipmentConstants.MELEE.addAll(EGOEquipmentConstants.KNIFE);
		EGOEquipmentConstants.MELEE.addAll(EGOEquipmentConstants.HAMMER);
		EGOEquipmentConstants.MELEE.addAll(EGOEquipmentConstants.FIST);
		EGOEquipmentConstants.MELEE.addAll(EGOEquipmentConstants.SPEAR);
		EGOEquipmentConstants.MELEE.addAll(EGOEquipmentConstants.MACE);
		addSet(EquipmentItemTags.MELEE, EGOEquipmentConstants.MELEE)
			.addTag(ItemTags.SWORDS);
		//endregion

		//region 远程武器
		EGOEquipmentConstants.GUN.addAll(EGOEquipmentConstants.CANNON);
		EGOEquipmentConstants.GUN.addAll(EGOEquipmentConstants.PISTOL);
		EGOEquipmentConstants.GUN.addAll(EGOEquipmentConstants.RIFLE);
		addSet(EquipmentItemTags.GUN, EGOEquipmentConstants.GUN);

		addSet(EquipmentItemTags.REMOTE, EGOEquipmentConstants.REMOTE).addTags(
			Tags.Items.TOOLS_CROSSBOW,
			Tags.Items.TOOLS_BOW,
			EquipmentItemTags.GUN);
		//endregion

		addSet(ItemTags.BOW_ENCHANTABLE, EGOEquipmentConstants.BOW);
		addSet(ItemTags.CROSSBOW_ENCHANTABLE, EGOEquipmentConstants.CROSSBOW);

		addSet(Tags.Items.TOOLS_CROSSBOW, EGOEquipmentConstants.CROSSBOW);
		addSet(Tags.Items.TOOLS_BOW, EGOEquipmentConstants.BOW);
		addSet(ItemTags.AXES, EGOEquipmentConstants.AXE);

		EGOEquipmentConstants.SWORDS.addAll(EGOEquipmentConstants.KNIFE);
		addSet(ItemTags.SWORDS, EGOEquipmentConstants.SWORDS)
			.add(LibItems.CHAOS_SWORD.get());
		tag(ItemTags.SWORD_ENCHANTABLE).addTag(EquipmentItemTags.MELEE);
		tag(ItemTags.BREAKS_DECORATED_POTS).addTag(EquipmentItemTags.MELEE);
		addSet(EquipmentItemTags.SPECIAL, EGOEquipmentConstants.SPECIAL);
		tag(Tags.Items.TOOLS)
			.add(LibItems.CREATIVE_RATIONALITY_TOOL.get())
			.addTags(
				EquipmentItemTags.EGO_WEAPON,
				EquipmentItemTags.EGO_TOOL,
				EquipmentItemTags.SPECIAL,
				EquipmentItemTags.REMOTE,
				EquipmentItemTags.MELEE);
	}

	private @NotNull IntrinsicTagAppender<Item> addSet(TagKey<Item> tag, @NotNull Set<DeferredItem<? extends Item>> set) {
		return tag(tag).add(set.stream().map(DeferredHolder::get).toArray(Item[]::new));
	}
}
