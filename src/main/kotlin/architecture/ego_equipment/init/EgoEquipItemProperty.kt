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
						windupTime = 4f / 20f,
						activeTime = 2f / 20f,
						recoveryTime = 0f,
						fadeOutTime = 10f / 20f,
						phases = arrayOf(
							AttackActionPhase(
								6f / 20f, 13f / 20f,
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
						3f / 20f, 6f / 20f, 2f / 20f, 0f, 10f / 20f,
						phases = arrayOf(
							AttackActionPhase(
								9f / 20f, 13f / 20f,
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
						3f / 20f, 6f / 20f, 12f / 20f, 0f, 10f / 20f,
						phases = arrayOf(
							AttackActionPhase(
								5f / 20f, 11f / 20f,
								maxStrikes = 5,
								colliderCount = 5,
								colliders = arrayOf(
									JointColliderPair("right_item", EgoEquipColliderData.LIFE_FOR_A_DAREDEVIL)
								)
							),
							AttackActionPhase(
								14f / 20f, 21f / 20f,
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
						3f / 20f, 10f / 20f, 3f / 20f, 0f, 20f / 20f,
						phases = arrayOf(
							AttackActionPhase(
								8f / 20f, 14f / 20f,
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
						3f / 20f, 7f / 20f, 3f / 20f, 0f, 10f / 20f,
						phases = arrayOf(
							AttackActionPhase(
								7f / 20f, 13f / 20f,
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
					3f / 20f, 12f / 20f, 22f / 20f, 0f, 5f / 20f,
					phases = arrayOf(
						AttackActionPhase(
							14f / 20f, 23f / 20f,
							maxStrikes = 10,
							colliderCount = 10,
							colliders = arrayOf(
								JointColliderPair("right_item", EgoEquipColliderData.LIFE_FOR_A_DAREDEVIL)
							)
						),
						AttackActionPhase(
							26f / 20f, 37f / 20f,
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
