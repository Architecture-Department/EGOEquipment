package architecture.ego_equipment.init

import architecture.ego_equipment.core.EGOEquipment
import architecture.ego_equipment.datagen.i18n.ZhCn
import architecture.ego_equipment.init.item.EGOArmorItems
import architecture.ego_equipment.init.item.EGOWeaponItems
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.network.chat.Component
import net.minecraft.resources.ResourceKey
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.ItemStack
import net.neoforged.neoforge.registries.DeferredHolder
import net.neoforged.neoforge.registries.DeferredRegister
import architecture.ego_equipment.core.EGOEquipmentConstants

object EGOEquipmentCreativeModeTabs {
	val REGISTRY: DeferredRegister<CreativeModeTab> =
		EGOEquipmentConstants.modRegister(BuiltInRegistries.CREATIVE_MODE_TAB)

	val EGO_WEAPON: DeferredHolder<CreativeModeTab, CreativeModeTab> = register(
		"ego_weapon", "E.G.O武器"
	) { name, zhCn ->
		createCreativeModeTab(name, zhCn, { _, output -> addRegistryItem(EGOWeaponItems.REGISTRY, output) }) {
			EGOWeaponItems.IN_THE_NAME_OF_LOVE_AND_HATE.get().defaultInstance
		}
	}

	val EGO_ARMOR: DeferredHolder<CreativeModeTab, CreativeModeTab> = register(
		"ego_armor", "E.G.O护甲"
	) { name, zhCn ->
		createCreativeModeTab(name, zhCn, { _, output -> addRegistryItem(EGOArmorItems.REGISTRY, output) }) {
			EGOArmorItems.IN_THE_NAME_OF_LOVE_AND_HATE.chestplate!!.get().defaultInstance
		}
	}

	private fun register(
		name: String,
		zhCn: String,
		builder: (String, String) -> CreativeModeTab.Builder
	): DeferredHolder<CreativeModeTab, CreativeModeTab> =
		REGISTRY.register(name) { -> builder(name, zhCn).build() }

	@Suppress("unused")
	private fun createCreativeModeTab(
		name: String,
		zhCn: String,
		displayItemsGenerator: CreativeModeTab.DisplayItemsGenerator,
		icon: () -> ItemStack,
		withTabsBefore: ResourceKey<CreativeModeTab>
	): CreativeModeTab.Builder = createCreativeModeTab(name, zhCn, displayItemsGenerator, icon)
		.withTabsBefore(withTabsBefore)

	private fun createCreativeModeTab(
		name: String,
		zhCn: String,
		displayItemsGenerator: CreativeModeTab.DisplayItemsGenerator,
		icon: () -> ItemStack
	): CreativeModeTab.Builder = createCreativeModeTab(name, zhCn, displayItemsGenerator)
		.icon(icon)

	private fun createCreativeModeTab(
		name: String,
		zhCn: String,
		displayItemsGenerator: CreativeModeTab.DisplayItemsGenerator
	): CreativeModeTab.Builder {
		val key = "itemGroup.${EGOEquipmentConstants.ID}.$name"
		ZhCn.addI18nText(zhCn, key)
		return CreativeModeTab.builder()
			.title(Component.translatable(key))
			.displayItems(displayItemsGenerator)
	}

	private fun addRegistryItem(registry: DeferredRegister.Items, output: CreativeModeTab.Output) {
		registry.entries.forEach { entry -> output.accept(entry.get()) }
	}
}
