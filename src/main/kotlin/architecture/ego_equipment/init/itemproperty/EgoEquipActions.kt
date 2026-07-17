package architecture.ego_equipment.init.itemproperty

import architecture.ego_equipment.util.EgoEquipUtil
import architecture.resonator_combat_framework.combat.*
import architecture.resonator_combat_framework.init.RcfAnimationControllers
import architecture.resonator_combat_framework.init.RcfRegistries
import architecture.resonator_combat_framework.util.RcfUtil
import net.minecraft.resources.ResourceLocation
import net.neoforged.neoforge.registries.DeferredHolder
import java.util.function.Function

object EgoEquipActions {
	val REGISTRY = RcfUtil.modRegister(RcfRegistries.ACTION)

	@JvmField
	val LIFE_FOR_A_DAREDEVIL_ATTACK = registerAttackAnimation(
		"life_for_a_daredevil/attack",
		EgoEquipUtil.modRl("player/weapon/life_for_a_daredevil/attack"),
		RcfAnimationControllers.ACTION,
		1f / 20f,
		4f / 20f,
		2f / 20f,
		0f,
		10f / 20f,
		InterruptData(),
		2500,
		AttackActionPhase(
			6f / 20f,
			13f / 20f,
			maxStrikes = 5,
			colliderCount = 5,
			colliders = arrayOf(
				JointColliderPair("right_item", EgoEquipColliderDatas.LIFE_FOR_A_DAREDEVIL)
			)
		)
	)

	@JvmField
	val LIFE_FOR_A_DAREDEVIL_ATTACK1 = registerAttackAnimation(
		"life_for_a_daredevil/attack1",
		EgoEquipUtil.modRl("player/weapon/life_for_a_daredevil/attack1"),
		RcfAnimationControllers.ACTION,
		3f / 20f,
		6f / 20f,
		2f / 20f,
		0f,
		10f / 20f,
		phases = arrayOf(
			AttackActionPhase(
				9f / 20f,
				13f / 20f,
				maxStrikes = 5,
				colliderCount = 10,
				colliders = arrayOf(
					JointColliderPair("right_item", EgoEquipColliderDatas.LIFE_FOR_A_DAREDEVIL)
				)
			)
		)
	)

	@JvmField
	val LIFE_FOR_A_DAREDEVIL_ATTACK2 = registerAttackAnimation(
		"life_for_a_daredevil/attack2",
		EgoEquipUtil.modRl("player/weapon/life_for_a_daredevil/attack2"),
		RcfAnimationControllers.ACTION,
		3f / 20f,
		6f / 20f,
		12f / 20f,
		0f,
		10f / 20f,
		phases = arrayOf(
			AttackActionPhase(
				5f / 20f,
				11f / 20f,
				maxStrikes = 5,
				colliderCount = 5,
				colliders = arrayOf(
					JointColliderPair("right_item", EgoEquipColliderDatas.LIFE_FOR_A_DAREDEVIL)
				)
			),
			AttackActionPhase(
				14f / 20f,
				21f / 20f,
				maxStrikes = 5,
				colliderCount = 5,
				colliders = arrayOf(
					JointColliderPair("right_item", EgoEquipColliderDatas.LIFE_FOR_A_DAREDEVIL)
				)
			)
		)
	)

	@JvmField
	val LIFE_FOR_A_DAREDEVIL_ATTACK3 = registerAttackAnimation(
		"life_for_a_daredevil/attack3",
		EgoEquipUtil.modRl("player/weapon/life_for_a_daredevil/attack3"),
		RcfAnimationControllers.ACTION,
		3f / 20f,
		10f / 20f,
		3f / 20f,
		0f,
		20f / 20f,
		phases = arrayOf(
			AttackActionPhase(
				8f / 20f,
				14f / 20f,
				maxStrikes = 5,
				colliderCount = 5,
				colliders = arrayOf(
					JointColliderPair("right_item", EgoEquipColliderDatas.LIFE_FOR_A_DAREDEVIL)
				)
			)
		)
	)

	@JvmField
	val LIFE_FOR_A_DAREDEVIL_ATTACK4 = registerAttackAnimation(
		"life_for_a_daredevil/attack4",
		EgoEquipUtil.modRl("player/weapon/life_for_a_daredevil/attack4"),
		RcfAnimationControllers.ACTION,
		3f / 20f,
		7f / 20f,
		3f / 20f,
		0f,
		10f / 20f,
		phases = arrayOf(
			AttackActionPhase(
				7f / 20f,
				13f / 20f,
				maxStrikes = 5,
				colliderCount = 5,
				colliders = arrayOf(
					JointColliderPair("right_item", EgoEquipColliderDatas.LIFE_FOR_A_DAREDEVIL)
				)
			)
		)
	)

	@JvmField
	val LIFE_FOR_A_DAREDEVIL_SPECIAL_ATTACK = registerAttackAnimation(
		"life_for_a_daredevil/special_attack",
		EgoEquipUtil.modRl("player/weapon/life_for_a_daredevil/special_attack"),
		RcfAnimationControllers.ACTION,
		3f / 20f,
		12f / 20f,
		22f / 20f,
		0f,
		5f / 20f,
		phases = arrayOf(
			AttackActionPhase(
				14f / 20f,
				23f / 20f,
				maxStrikes = 10,
				colliderCount = 10,
				colliders = arrayOf(
					JointColliderPair("right_item", EgoEquipColliderDatas.LIFE_FOR_A_DAREDEVIL)
				)
			),
			AttackActionPhase(
				26f / 20f,
				37f / 20f,
				maxStrikes = 3,
				colliderCount = 5,
				colliders = arrayOf(
					JointColliderPair("right_item", EgoEquipColliderDatas.LIFE_FOR_A_DAREDEVIL)
				)
			)
		)
	)

	private fun <T : Action> register(id: String, function: Function<ResourceLocation, T>): DeferredHolder<Action, T> {
		return REGISTRY.register(id, function)
	}

	private fun registerAttackAnimation(
		id: String,
		animationId: ResourceLocation,
		controllerId: ResourceLocation?,
		fadeInTimeLength: Float = 1f / 20f,
		windupTimeLength: Float = 0f,
		activeTimeLength: Float = 4f / 20f,
		recoveryTimeLength: Float = 2f / 20f,
		fadeOutTimeLength: Float = 1f / 20f,
		interruptData: InterruptData = InterruptData(),
		weight: Int = 2500,
		vararg phases: AttackActionPhase,
	): DeferredHolder<Action, AttackAnimationAction> {
		return register(id) {
			AttackAnimationAction(
				it,
				animationId,
				controllerId,
				fadeInTimeLength,
				windupTimeLength,
				activeTimeLength,
				recoveryTimeLength,
				fadeOutTimeLength,
				interruptData,
				weight,
				*phases
			)
		}
	}
}