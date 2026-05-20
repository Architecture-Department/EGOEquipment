package architecture.ego_equipment.datagen.i18n

import architecture.ego_equipment.core.EGOEquipment
import architecture.goldenboughs_lib.datagen.i18n.DatagenI18n
import net.minecraft.data.PackOutput
import net.minecraft.sounds.SoundEvent
import net.minecraft.world.entity.EntityType
import net.minecraft.world.item.Item
import net.neoforged.fml.loading.FMLEnvironment
import org.jetbrains.annotations.ApiStatus

@ApiStatus.Internal
class ZhCn(output: PackOutput) : DatagenI18n(output, EGOEquipment.ID, "zh_cn") {

	companion object {
		private val ITEMS: MutableMap<() -> Item, String> = HashMap()
		private val SOUND_EVENT: MutableMap<() -> SoundEvent, String> = HashMap()
		private val MAP: MutableMap<String, String> = HashMap()
		private val ENTITY: MutableMap<() -> EntityType<*>, String> = HashMap()

		@JvmStatic
		fun addI18nText(zhCn: String, key: String) {
			if (!FMLEnvironment.production) {
				MAP[key] = zhCn
			}
		}

		@JvmStatic
		fun addI18nItemText(zhName: String, deferredItem: () -> Item) {
			if (!FMLEnvironment.production) {
				ITEMS[deferredItem] = zhName
			}
		}

		@JvmStatic
		fun addI18nSoundEventText(zhName: String, supplier: () -> SoundEvent) {
			if (!FMLEnvironment.production) {
				SOUND_EVENT[supplier] = zhName
			}
		}

		@JvmStatic
		fun addI18nEntityTypeText(zhName: String, supplier: () -> EntityType<*>) {
			if (!FMLEnvironment.production) {
				ENTITY[supplier] = zhName
			}
		}
	}

	override fun addTranslations() {
		addPackDescription(EGOEquipment.ID, "E.G.O.装备")
		addItemList(ITEMS)
		addEntityList(ENTITY)
		addSoundEventList(SOUND_EVENT)
		MAP.forEach { (key, value) -> add(key, value) }
	}
}
