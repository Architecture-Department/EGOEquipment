package architecture.ego_equipment.init

import architecture.ego_equipment.init.animation.EgoEquipStaticAnimations
import architecture.ego_equipment.util.EgoEquipUtil.modRl
import architecture.resonator_combat_framework.combat.AttackAnimationAction
import architecture.resonator_combat_framework.common.item_property.WeaponProperty
import architecture.resonator_combat_framework.event.ItemPropertyRegistryEvent
import architecture.resonator_combat_framework.events.registry.AnimationControllers
import architecture.resonator_combat_framework.module.entity_state_machine.combat.ActionSequence
import architecture.resonator_combat_framework.module.entity_state_machine.combat.StageTiming
import java.util.function.Supplier

object EgoEquipItemProperty {
	lateinit var LIFE_FOR_A_DAREDEVIL: Supplier<WeaponProperty?>

	@JvmStatic
	internal fun register(event: ItemPropertyRegistryEvent) {
		LIFE_FOR_A_DAREDEVIL = event.register(modRl("life_for_a_daredevil")) {
			WeaponProperty(it) {
				ActionSequence.of(
					modRl("life_for_a_daredevil"),
					AttackAnimationAction(
						modRl("attack"),
						EgoEquipStaticAnimations.LIFE_FOR_A_DAREDEVIL_ATTACK,
						AnimationControllers.ACTION,
						StageTiming.of(5, 4, 5,)
					),
					AttackAnimationAction(
						modRl("attack1"),
						EgoEquipStaticAnimations.LIFE_FOR_A_DAREDEVIL_ATTACK1,
						AnimationControllers.ACTION,
						StageTiming.of(8, 3, 5,)
					),
					AttackAnimationAction(
						modRl("attack2"),
						EgoEquipStaticAnimations.LIFE_FOR_A_DAREDEVIL_ATTACK2,
						AnimationControllers.ACTION,
						StageTiming.of(8, 3, 5,)
					),
					AttackAnimationAction(
						modRl("attack3"),
						EgoEquipStaticAnimations.LIFE_FOR_A_DAREDEVIL_ATTACK3,
						AnimationControllers.ACTION,
						StageTiming.of(8, 3, 5,)
					),
					AttackAnimationAction(
						modRl("attack4"),
						EgoEquipStaticAnimations.LIFE_FOR_A_DAREDEVIL_ATTACK4,
						AnimationControllers.ACTION,
						StageTiming.of(8, 3, 5,)
					)
				)
			}
		}
	}
}