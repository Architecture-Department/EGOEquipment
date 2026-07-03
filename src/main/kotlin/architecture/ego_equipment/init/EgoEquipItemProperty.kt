package architecture.ego_equipment.init

import architecture.ego_equipment.util.EgoEquipUtil.modRl
import architecture.resonator_combat_framework.combat.AttackActionPhase
import architecture.resonator_combat_framework.combat.AttackAnimationAction
import architecture.resonator_combat_framework.combat.JointColliderPair
import architecture.resonator_combat_framework.common.item_property.WeaponProperty
import architecture.resonator_combat_framework.event.ItemPropertyRegistryEvent
import architecture.resonator_combat_framework.events.registry.AnimationControllers
import architecture.resonator_combat_framework.module.combat.ActionSequence
import org.joml.Vector3f
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
						1, 4, 2, 0, 10,
						phases = arrayOf(
							AttackActionPhase.of(
								5, 7,
								JointColliderPair.of(
									"right_item",
									Vector3f(0f, 1.1f, 0f),
									Vector3f(0.1f, 0.55f, 0.1f)
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
							AttackActionPhase.of(
								9, 11,
								JointColliderPair.of(
									"right_item",
									Vector3f(0f, 1.1f, 0f),
									Vector3f(0.1f, 0.55f, 0.1f)
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
							AttackActionPhase.of(
								9, 22,
								JointColliderPair.of(
									"right_item",
									Vector3f(0f, 1.1f, 0f),
									Vector3f(0.1f, 0.55f, 0.1f)
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
							AttackActionPhase.of(
								13, 16,
								JointColliderPair.of(
									"right_item",
									Vector3f(0f, 1.1f, 0f),
									Vector3f(0.1f, 0.55f, 0.1f)
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
							AttackActionPhase.of(
								10, 13,
								JointColliderPair.of(
									"right_item",
									Vector3f(0f, 1.1f, 0f),
									Vector3f(0.1f, 0.55f, 0.1f)
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
					3, 22, 32, 0, 5,
					phases = arrayOf(
						AttackActionPhase.of(
							25, 57,
							JointColliderPair.of(
								"right_item",
								Vector3f(0f, 1.1f, 0f),
								Vector3f(0.1f, 0.55f, 0.1f)
							)
						)
					)
				)
			})
		}
	}
}