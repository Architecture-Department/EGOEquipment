package architecture.ego_equipment.common.item.weapon.melee.special

import architecture.ego_equipment.client.renderer.item.RedEyesTachiItemWeaponRenderer
import architecture.ego_equipment.common.item.weapon.melee.MeleeEgoWeaponGeoItem
import architecture.ego_equipment.init.EGOEquipmentMobEffects
import architecture.ego_equipment.mixin.MobEffectInstanceAccessorMixin
import architecture.goldenboughs_lib.api.world.item.IMeleeEgoWeaponItem
import architecture.goldenboughs_lib.client.renderer.GeoItemRenderProvider
import architecture.goldenboughs_lib.mixin.world.entity.LivingEntityAccessorMixin
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.item.ItemStack
import software.bernie.geckolib.animatable.client.GeoRenderProvider
import software.bernie.geckolib.animation.AnimatableManager
import software.bernie.geckolib.animation.AnimationController
import software.bernie.geckolib.animation.PlayState
import software.bernie.geckolib.model.GeoModel
import java.util.function.Consumer

class RedEyesTachiItem : MeleeEgoWeaponGeoItem {
	constructor(
		itemProperties: Properties,
		egoWeaponBuilder: IMeleeEgoWeaponItem.Builder,
		geoModel: GeoModel<MeleeEgoWeaponGeoItem>,
		guiModel: GeoModel<MeleeEgoWeaponGeoItem>?
	) : super(itemProperties, egoWeaponBuilder, geoModel, guiModel)

	constructor(
		itemProperties: Properties,
		egoWeaponBuilder: IMeleeEgoWeaponItem.Builder,
		modPath: ResourceLocation
	) : super(itemProperties, egoWeaponBuilder, modPath)

	companion object {
		@JvmStatic
		fun phaseSwitch() {
		}
	}

	override fun registerControllers(controllerRegistrar: AnimatableManager.ControllerRegistrar) {
		controllerRegistrar.add(AnimationController(this) { PlayState.STOP })
	}

	@Suppress("UNCHECKED_CAST")
	override fun createGeoRenderer(consumer: Consumer<GeoRenderProvider>) {
		consumer.accept(
			GeoItemRenderProvider(
				model as GeoModel<RedEyesTachiItem>,
				guiModel as GeoModel<RedEyesTachiItem>?,
				::RedEyesTachiItemWeaponRenderer
			)
		)
	}

	override fun hurtEnemy(stack: ItemStack, target: LivingEntity, attacker: LivingEntity): Boolean {
		val effect = attacker.getEffect(EGOEquipmentMobEffects.RED_EYES_HUNTING)
		if (effect != null) {
			return true
		}
		return super.hurtEnemy(stack, target, attacker)
	}

	override fun postHurtEnemy(stack: ItemStack, target: LivingEntity, attacker: LivingEntity) {
		val effect = attacker.getEffect(EGOEquipmentMobEffects.RED_EYES_HUNTING)
		if (effect != null) {
			val effectDuration = effect.duration
			val increase = 10
			val max = 100
			(effect as MobEffectInstanceAccessorMixin).`ego_equipment$setDuration`(
				(effectDuration + increase).coerceIn(0, Math.max(effectDuration, max))
			)
			(attacker as LivingEntityAccessorMixin).`goldenboughs_lib$onEffectUpdated`(effect, true, attacker)
		}
	}
}
