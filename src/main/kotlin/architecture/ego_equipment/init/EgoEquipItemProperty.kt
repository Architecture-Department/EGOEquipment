package architecture.ego_equipment.init

import architecture.ego_equipment.util.EgoEquipUtil.modRl
import architecture.resonator_combat_framework.combat.AttackActionPhase
import architecture.resonator_combat_framework.combat.AttackAnimationAction
import architecture.resonator_combat_framework.combat.JointColliderPair
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
						modRl("player/weapon/life_for_a_daredevil/attack"),
						AnimationControllers.ACTION,
						windupTick = 4, activeTick = 2, recoveryTick = 0, fadeOutTick = 10, phases = arrayOf(
							AttackActionPhase(
								6, 13,
								maxStrikes = 5,
								colliderCount = 5,
								colliders = arrayOf(
									JointColliderPair("right_item", EgoEquipColliderData.LIFE_FOR_A_DAREDEVIL)
								)
							)
						)
					),
					AttackAnimationAction(
						modRl("attack1"),
						modRl("player/weapon/life_for_a_daredevil/attack1"),
						AnimationControllers.ACTION,
						3, 6, 2, 0, 10,
						phases = arrayOf(
							AttackActionPhase(
								9, 13,
								maxStrikes = 5,
								colliderCount = 10,
								colliders = arrayOf(
									JointColliderPair("right_item", EgoEquipColliderData.LIFE_FOR_A_DAREDEVIL)
								)
							)
						)
					),
					AttackAnimationAction(
						modRl("attack2"),
						modRl("player/weapon/life_for_a_daredevil/attack2"),
						AnimationControllers.ACTION,
						3, 6, 12, 0, 10,
						phases = arrayOf(
							AttackActionPhase(
								5, 11,
								maxStrikes = 5,
								colliderCount = 5,
								colliders = arrayOf(
									JointColliderPair("right_item", EgoEquipColliderData.LIFE_FOR_A_DAREDEVIL)
								)
							),
							AttackActionPhase(
								14, 21,
								maxStrikes = 5,
								colliderCount = 5,
								colliders = arrayOf(
									JointColliderPair("right_item", EgoEquipColliderData.LIFE_FOR_A_DAREDEVIL)
								)
							)
						)
					),
					AttackAnimationAction(
						modRl("attack3"),
						modRl("player/weapon/life_for_a_daredevil/attack3"),
						AnimationControllers.ACTION,
						3, 10, 3, 0, 20,
						phases = arrayOf(
							AttackActionPhase(
								8, 14,
								maxStrikes = 5,
								colliderCount = 5,
								colliders = arrayOf(
									JointColliderPair("right_item", EgoEquipColliderData.LIFE_FOR_A_DAREDEVIL)
								)
							)
						)
					),
					AttackAnimationAction(
						modRl("attack4"),
						modRl("player/weapon/life_for_a_daredevil/attack4"),
						AnimationControllers.ACTION,
						3, 7, 3, 0, 10,
						phases = arrayOf(
							AttackActionPhase(
								7, 13,
								maxStrikes = 5,
								colliderCount = 5,
								colliders = arrayOf(
									JointColliderPair("right_item", EgoEquipColliderData.LIFE_FOR_A_DAREDEVIL)
								)
							)
						)
					)
				)
			}, {
				AttackAnimationAction(
					modRl("special_attack"),
					modRl("player/weapon/life_for_a_daredevil/special_attack"),
					AnimationControllers.ACTION,
					3, 12, 22, 0, 5,
					phases = arrayOf(
						AttackActionPhase(
							14, 23,
							maxStrikes = 10,
							colliderCount = 10,
							colliders = arrayOf(
								JointColliderPair("right_item", EgoEquipColliderData.LIFE_FOR_A_DAREDEVIL)
							)
						),
						AttackActionPhase(
							26, 37,
							maxStrikes = 3,
							colliderCount = 5,
							colliders = arrayOf(
								JointColliderPair("right_item", EgoEquipColliderData.LIFE_FOR_A_DAREDEVIL)
							)
						)
					)
				)
			})
		}
	}
}
