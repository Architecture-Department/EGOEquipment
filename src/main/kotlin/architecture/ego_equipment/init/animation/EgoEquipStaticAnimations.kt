package architecture.ego_equipment.init.animation

import architecture.resonator_combat_framework.module.entity_animation.animation.StaticAnimation
import architecture.resonator_combat_framework.module.entity_animation.event.StaticAnimationRegistryEvent
import architecture.resonator_combat_framework.util.RcfUtil
import java.util.function.Supplier

object EgoEquipStaticAnimations {
	lateinit var IDLE: Supplier<StaticAnimation?>

	@JvmStatic
	internal fun register(event: StaticAnimationRegistryEvent) {
		IDLE = event.register(RcfUtil.modRl("idle"), ::StaticAnimation)
	}
}
