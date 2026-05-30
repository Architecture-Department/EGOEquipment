package architecture.ego_equipment.datagen

import architecture.ego_equipment.core.EGOEquipmentConstants
import architecture.ego_equipment.init.EGOEquipmentSoundEvents
import net.minecraft.data.PackOutput
import net.minecraft.resources.ResourceLocation
import net.minecraft.sounds.SoundEvent
import net.neoforged.neoforge.common.data.ExistingFileHelper
import net.neoforged.neoforge.common.data.SoundDefinition
import net.neoforged.neoforge.common.data.SoundDefinitionsProvider

class DatagenSoundDefinitionsProvider(output: PackOutput, existingFileHelper: ExistingFileHelper) :
	SoundDefinitionsProvider(output, EGOEquipmentConstants.ID, existingFileHelper) {

	companion object {
		@JvmStatic
		fun getSubtitle(soundEvent: SoundEvent): String = getSubtitle(soundEvent.location)

		@JvmStatic
		fun getSubtitle(location: ResourceLocation): String = "sound.${location.toLanguageKey()}"
	}

	override fun registerSounds() {
		add(EGOEquipmentSoundEvents.SOLEMN_LAMENT_WEAPON_ATTACK_BLACK.value(), 0.5f, 0.5f, 1, 8)
		add(EGOEquipmentSoundEvents.SOLEMN_LAMENT_WEAPON_ATTACK_WHITE.value(), 0.5f, 0.5f, 1, 8)
		add(EGOEquipmentSoundEvents.SOLEMN_LAMENT_WEAPON_STONGATTACK_BLACK.value(), 0.5f, 0.5f, 1, 8)
		add(EGOEquipmentSoundEvents.SOLEMN_LAMENT_WEAPON_STONGATTACK_WHITE.value(), 0.5f, 0.5f, 1, 8)
	}

	private fun add(soundEvent: SoundEvent, volume: Float, pitch: Float, weight: Int, attenuationDistance: Int) {
		add(soundEvent, 1, volume, pitch, weight, attenuationDistance)
	}

	private fun add(
		soundEvent: SoundEvent,
		amount: Int,
		volume: Float,
		pitch: Float,
		weight: Int,
		attenuationDistance: Int
	) {
		val location = soundEvent.location
		assert(amount > 0) { "sund : $location amount must be greater than 0" }
		val definition = SoundDefinition.definition()
		for (i in 0 until amount) {
			definition.with(
				SoundDefinition.Sound.sound(
					location.withSuffix(if (i > 0) i.toString() else ""),
					SoundDefinition.SoundType.SOUND
				)
					.volume(volume)
					.pitch(pitch)
					.weight(weight)
					.attenuationDistance(attenuationDistance)
			)
		}
		add(
			soundEvent, definition
				.subtitle(getSubtitle(location))
				.replace(true)
		)
	}
}
