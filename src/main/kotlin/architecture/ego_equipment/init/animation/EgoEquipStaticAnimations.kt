package architecture.ego_equipment.init.animation

import architecture.ego_equipment.util.EgoEquipUtil.modRl
import architecture.resonator_combat_framework.animation.AttackAnimationDef
import architecture.resonator_combat_framework.module.entity_animation.event.AnimationDefRegistryEvent
import java.util.function.Supplier

object EgoEquipStaticAnimations {
	lateinit var LIFE_FOR_A_DAREDEVIL_ATTACK: Supplier<AttackAnimationDef?>
	lateinit var LIFE_FOR_A_DAREDEVIL_ATTACK1: Supplier<AttackAnimationDef?>
	lateinit var LIFE_FOR_A_DAREDEVIL_ATTACK2: Supplier<AttackAnimationDef?>
	lateinit var LIFE_FOR_A_DAREDEVIL_ATTACK3: Supplier<AttackAnimationDef?>
	lateinit var LIFE_FOR_A_DAREDEVIL_ATTACK4: Supplier<AttackAnimationDef?>
	lateinit var LIFE_FOR_A_DAREDEVIL_SPECIAL_ATTACK: Supplier<AttackAnimationDef?>

	@JvmStatic
	internal fun register(event: AnimationDefRegistryEvent) {
		LIFE_FOR_A_DAREDEVIL_ATTACK = event.register(modRl("life_for_a_daredevil_attack"))
		{ AttackAnimationDef(it, modRl("player/weapon/life_for_a_daredevil/attack")) }
		LIFE_FOR_A_DAREDEVIL_ATTACK1 = event.register(modRl("life_for_a_daredevil_attack1"))
		{ AttackAnimationDef(it, modRl("player/weapon/life_for_a_daredevil/attack1")) }
		LIFE_FOR_A_DAREDEVIL_ATTACK2 = event.register(modRl("life_for_a_daredevil_attack2"))
		{ AttackAnimationDef(it, modRl("player/weapon/life_for_a_daredevil/attack2")) }
		LIFE_FOR_A_DAREDEVIL_ATTACK3 = event.register(modRl("life_for_a_daredevil_attack3"))
		{ AttackAnimationDef(it, modRl("player/weapon/life_for_a_daredevil/attack3")) }
		LIFE_FOR_A_DAREDEVIL_ATTACK4 = event.register(modRl("life_for_a_daredevil_attack4"))
		{ AttackAnimationDef(it, modRl("player/weapon/life_for_a_daredevil/attack4")) }
		LIFE_FOR_A_DAREDEVIL_SPECIAL_ATTACK = event.register(modRl("life_for_a_daredevil_special_attack"))
		{ AttackAnimationDef(it, modRl("player/weapon/life_for_a_daredevil/special_attack")) }
	}
}
