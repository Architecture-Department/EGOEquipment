package architecture.ego_equipment.datagen

import architecture.ego_equipment.init.EgoEquipSoundEvents
import architecture.ego_equipment.util.EgoEquipUtil
import architecture.goldenboughs_lib.datagen.BasicSoundDefinitionsProvider
import net.minecraft.data.PackOutput
import net.minecraft.resources.ResourceLocation
import net.minecraft.sounds.SoundEvent
import net.neoforged.neoforge.common.data.ExistingFileHelper

class DatagenSoundDefinitionsProvider(output: PackOutput, existingFileHelper: ExistingFileHelper) :
	BasicSoundDefinitionsProvider(output, EgoEquipUtil.ID, existingFileHelper) {

	companion object {
		@JvmStatic
		fun getSubtitle(soundEvent: SoundEvent): String = getSubtitle(soundEvent.location)

		@JvmStatic
		fun getSubtitle(location: ResourceLocation): String = "sound.${location.toLanguageKey()}"
	}

	override fun registerSounds() {
		add(EgoEquipSoundEvents.SOLEMN_LAMENT_WEAPON_ATTACK_BLACK.value(), 0.5f, 0.5f, 1, 8)
		add(EgoEquipSoundEvents.SOLEMN_LAMENT_WEAPON_ATTACK_WHITE.value(), 0.5f, 0.5f, 1, 8)
		add(EgoEquipSoundEvents.SOLEMN_LAMENT_WEAPON_STONGATTACK_BLACK.value(), 0.5f, 0.5f, 1, 8)
		add(EgoEquipSoundEvents.SOLEMN_LAMENT_WEAPON_STONGATTACK_WHITE.value(), 0.5f, 0.5f, 1, 8)
	}
}
