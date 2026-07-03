package architecture.ego_equipment.init

import architecture.ego_equipment.init.animation.EgoEquipStaticAnimations
import architecture.ego_equipment.util.EgoEquipUtil.modRl
import architecture.resonator_combat_framework.combat.AttackAnimationAction
import architecture.resonator_combat_framework.common.item_property.WeaponProperty
import architecture.resonator_combat_framework.event.ItemPropertyRegistryEvent
import architecture.resonator_combat_framework.events.registry.AnimationControllers
import architecture.resonator_combat_framework.module.combat.ActionSequence
import java.util.function.Supplier

object EgoEquipItemProperty {
	lateinit var LIFE_FOR_A_DAREDEVIL: Supplier<WeaponProperty?>

	@JvmStatic
	internal fun register(event: ItemPropertyRegistryEvent) {
		LIFE_FOR_A_DAREDEVIL = event.register(modRl("life_for_a_daredevil")) {
			WeaponProperty(it, {
				ActionSequence.of(
					modRl("life_for_a_daredevil"),
					AttackAnimationAction(
						modRl("attack"),
						EgoEquipStaticAnimations.LIFE_FOR_A_DAREDEVIL_ATTACK,
						AnimationControllers.ACTION,
						1, 4, 2, 0, 10
					),
					AttackAnimationAction(
						modRl("attack1"),
						EgoEquipStaticAnimations.LIFE_FOR_A_DAREDEVIL_ATTACK1,
						AnimationControllers.ACTION,
						3, 6, 2, 0, 10
					),
					AttackAnimationAction(
						modRl("attack2"),
						EgoEquipStaticAnimations.LIFE_FOR_A_DAREDEVIL_ATTACK2,
						AnimationControllers.ACTION,
						3, 6, 12, 0, 10
					),
					AttackAnimationAction(
						modRl("attack3"),
						EgoEquipStaticAnimations.LIFE_FOR_A_DAREDEVIL_ATTACK3,
						AnimationControllers.ACTION,
						3, 10, 3, 0, 20
					),
					AttackAnimationAction(
						modRl("attack4"),
						EgoEquipStaticAnimations.LIFE_FOR_A_DAREDEVIL_ATTACK4,
						AnimationControllers.ACTION,
						3, 7, 3, 0, 10
					)
				)
			}, {
				AttackAnimationAction(
					modRl("special_attack"),
					EgoEquipStaticAnimations.LIFE_FOR_A_DAREDEVIL_SPECIAL_ATTACK,
					AnimationControllers.ACTION,
					3, 22, 22, 0, 10
				)
			})
		}
	}
}