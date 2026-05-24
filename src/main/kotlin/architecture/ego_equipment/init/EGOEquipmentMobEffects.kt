package architecture.ego_equipment.init

import architecture.ego_equipment.core.EGOEquipment
import architecture.ego_equipment.init.item.EGOWeaponItems
import architecture.goldenboughs_lib.common.mobeffect.MobEffectExpand
import architecture.goldenboughs_lib.datagen.i18n.LibZhCn
import net.minecraft.core.Holder
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.effect.MobEffect
import net.minecraft.world.effect.MobEffectCategory
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.ai.attributes.AttributeModifier
import net.minecraft.world.entity.ai.attributes.Attributes
import net.neoforged.neoforge.registries.DeferredHolder
import net.neoforged.neoforge.registries.DeferredRegister

object EGOEquipmentMobEffects {
	val REGISTRY: DeferredRegister<MobEffect> = EGOEquipment.modRegister(BuiltInRegistries.MOB_EFFECT)

	val RED_EYES_HUNTING: Holder<MobEffect> = register("red_eyes_hunting", "赤瞳-狩猎", { category, color ->
		object : MobEffectExpand(category, color) {
			override fun applyEffectTick(livingEntity: LivingEntity, amplifier: Int): Boolean {
				if (livingEntity.mainHandItem.`is`(EGOWeaponItems.RED_EYES_TACHI) ||
					livingEntity.offhandItem.`is`(EGOWeaponItems.RED_EYES_TACHI)
				) {
					return super.applyEffectTick(livingEntity, amplifier)
				}
				return false
			}

			override fun shouldApplyEffectTickThisTick(duration: Int, amplifier: Int): Boolean = true
		}
	}, MobEffectCategory.BENEFICIAL, 0xac2323) { e, id ->
		e
			.addAttributeModifier(Attributes.ATTACK_SPEED, id, 0.30, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
			.addAttributeModifier(Attributes.ATTACK_DAMAGE, id, 0.25, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
	}

	private fun <T : MobEffect> register(
		name: String, zhCnText: String, biFunction: (MobEffectCategory, Int) -> T, category: MobEffectCategory, color: Int
	): DeferredHolder<MobEffect, T> = register(name, zhCnText) { biFunction(category, color) }

	private fun <T : MobEffect> register(
		name: String, zhCnText: String, supplier: () -> T
	): DeferredHolder<MobEffect, T> {
		val holder = REGISTRY.register(name, supplier)
		LibZhCn.addI18nMobEffectText(zhCnText, holder)
		return holder
	}

	private fun <T : MobEffect> register(
		name: String, zhCnText: String, supplier: () -> T, function: (T) -> MobEffect
	): DeferredHolder<MobEffect, T> = register(name, zhCnText) {
		val apply = supplier()
		function(apply)
		apply
	}

	private fun <T : MobEffect> register(
		name: String, zhCnText: String, supplier: () -> T, function: (T, ResourceLocation) -> MobEffect
	): DeferredHolder<MobEffect, T> = register(name, zhCnText) {
		val apply = supplier()
		function(apply, EGOEquipment.modRl(name))
		apply
	}

	private fun <T : MobEffect> register(
		name: String, zhCnText: String, biFunction: (MobEffectCategory, Int) -> T, category: MobEffectCategory, color: Int,
		function: (T) -> MobEffect
	): DeferredHolder<MobEffect, T> = register(name, zhCnText) {
		val apply = biFunction(category, color)
		function(apply)
		apply
	}

	private fun <T : MobEffect> register(
		name: String, zhCnText: String, biFunction: (MobEffectCategory, Int) -> T, category: MobEffectCategory, color: Int,
		function: (T, ResourceLocation) -> MobEffect
	): DeferredHolder<MobEffect, T> = register(name, zhCnText) {
		val apply = biFunction(category, color)
		function(apply, EGOEquipment.modRl(name))
		apply
	}
}
