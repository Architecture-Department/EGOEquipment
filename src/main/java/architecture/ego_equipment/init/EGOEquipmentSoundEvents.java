package architecture.ego_equipment.init;

import architecture.ego_equipment.core.EGOEquipment;
import architecture.ego_equipment.datagen.i18n.ZhCn;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class EGOEquipmentSoundEvents {
	public static final DeferredRegister<SoundEvent> REGISTRY = EGOEquipment.modRegister(BuiltInRegistries.SOUND_EVENT);

	public static final DeferredHolder<SoundEvent, SoundEvent> ARMOR_EQUIP_ZAYIN = registerForHolder(
		"armor_equip_zayin", "", "item.armor.equip_zayin");
	public static final DeferredHolder<SoundEvent, SoundEvent> ARMOR_EQUIP_TETH = registerForHolder(
		"armor_equip_teth", "", "item.armor.equip_teth");
	public static final DeferredHolder<SoundEvent, SoundEvent> ARMOR_EQUIP_HE = registerForHolder(
		"armor_equip_he", "", "item.armor.equip_he");
	public static final DeferredHolder<SoundEvent, SoundEvent> ARMOR_EQUIP_WAW = registerForHolder(
		"armor_equip_waw", "", "item.armor.equip_waw");
	public static final DeferredHolder<SoundEvent, SoundEvent> ARMOR_EQUIP_ALEPH = registerForHolder(
		"armor_equip_aleph", "", "item.armor.equip_aleph");

	public static final DeferredHolder<SoundEvent, SoundEvent> SOLEMN_LAMENT_WEAPON_ATTACK_BLACK = registerForHolder(
		"solemn_lament_weapon_attack_black", "圣宣-黑：射击", "item.solemn_lament_weapon.attack.black");
	public static final DeferredHolder<SoundEvent, SoundEvent> SOLEMN_LAMENT_WEAPON_ATTACK_WHITE = registerForHolder(
		"solemn_lament_weapon_attack_white", "圣宣-白：射击", "item.solemn_lament_weapon.attack.white");
	public static final DeferredHolder<SoundEvent, SoundEvent> SOLEMN_LAMENT_WEAPON_STONGATTACK_BLACK = registerForHolder(
		"solemn_lament_weapon_stongattack_black", "圣宣-黑：特殊射击", "item.solemn_lament_weapon.stongattack.black");
	public static final DeferredHolder<SoundEvent, SoundEvent> SOLEMN_LAMENT_WEAPON_STONGATTACK_WHITE = registerForHolder(
		"solemn_lament_weapon_stongattack_white", "圣宣-白：特殊射击", "item.solemn_lament_weapon.stongattack.white");

	private static DeferredHolder<SoundEvent, SoundEvent> registerForHolder(String id, String zhName, String location) {
		DeferredHolder<SoundEvent, SoundEvent> register = EGOEquipmentSoundEvents.REGISTRY.register(id, () -> SoundEvent.createVariableRangeEvent(EGOEquipment.modRl(location)));
		ZhCn.addI18nSoundEventText(zhName, register);
		return register;
	}
}
