package architecture.ego_equipment.init

import architecture.ego_equipment.core.EGOEquipment
import architecture.ego_equipment.datagen.i18n.ZhCn
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.sounds.SoundEvent
import net.neoforged.neoforge.registries.DeferredHolder
import net.neoforged.neoforge.registries.DeferredRegister

object EGOEquipmentSoundEvents {
	val REGISTRY: DeferredRegister<SoundEvent> = EGOEquipment.modRegister(BuiltInRegistries.SOUND_EVENT)

	val ARMOR_EQUIP_ZAYIN: DeferredHolder<SoundEvent, SoundEvent> = registerForHolder(
		"armor_equip_zayin", "", "item.armor.equip_zayin"
	)
	val ARMOR_EQUIP_TETH: DeferredHolder<SoundEvent, SoundEvent> = registerForHolder(
		"armor_equip_teth", "", "item.armor.equip_teth"
	)
	val ARMOR_EQUIP_HE: DeferredHolder<SoundEvent, SoundEvent> = registerForHolder(
		"armor_equip_he", "", "item.armor.equip_he"
	)
	val ARMOR_EQUIP_WAW: DeferredHolder<SoundEvent, SoundEvent> = registerForHolder(
		"armor_equip_waw", "", "item.armor.equip_waw"
	)
	val ARMOR_EQUIP_ALEPH: DeferredHolder<SoundEvent, SoundEvent> = registerForHolder(
		"armor_equip_aleph", "", "item.armor.equip_aleph"
	)

	val SOLEMN_LAMENT_WEAPON_ATTACK_BLACK: DeferredHolder<SoundEvent, SoundEvent> = registerForHolder(
		"solemn_lament_weapon_attack_black", "圣宣-黑：射击", "item.solemn_lament_weapon.attack.black"
	)
	val SOLEMN_LAMENT_WEAPON_ATTACK_WHITE: DeferredHolder<SoundEvent, SoundEvent> = registerForHolder(
		"solemn_lament_weapon_attack_white", "圣宣-白：射击", "item.solemn_lament_weapon.attack.white"
	)
	val SOLEMN_LAMENT_WEAPON_STONGATTACK_BLACK: DeferredHolder<SoundEvent, SoundEvent> = registerForHolder(
		"solemn_lament_weapon_stongattack_black", "圣宣-黑：特殊射击", "item.solemn_lament_weapon.stongattack.black"
	)
	val SOLEMN_LAMENT_WEAPON_STONGATTACK_WHITE: DeferredHolder<SoundEvent, SoundEvent> = registerForHolder(
		"solemn_lament_weapon_stongattack_white", "圣宣-白：特殊射击", "item.solemn_lament_weapon.stongattack.white"
	)

	private fun registerForHolder(id: String, zhName: String, location: String): DeferredHolder<SoundEvent, SoundEvent> {
		val register = REGISTRY.register(id) { SoundEvent.createVariableRangeEvent(EGOEquipment.modRl(location)) }
		ZhCn.addI18nSoundEventText(zhName, register)
		return register
	}
}
