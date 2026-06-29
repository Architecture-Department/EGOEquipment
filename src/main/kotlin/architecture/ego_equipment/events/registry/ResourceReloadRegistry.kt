package architecture.ego_equipment.events.registry

import architecture.ego_equipment.init.animation.EgoEquipActionSequences
import architecture.ego_equipment.init.animation.EgoEquipActions
import architecture.ego_equipment.init.animation.EgoEquipStaticAnimations
import architecture.resonator_combat_framework.module.entity_animation.event.StaticAnimationRegistryEvent
import architecture.resonator_combat_framework.module.entity_state_machine.event.ActionRegistryEvent
import architecture.resonator_combat_framework.module.entity_state_machine.event.ActionSequenceRegistryEvent
import architecture.resonator_combat_framework.util.RcfUtil
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber

@EventBusSubscriber(modid = RcfUtil.ID)
object ResourceReloadRegistry {
	@SubscribeEvent
	fun registry(event: StaticAnimationRegistryEvent) {
		EgoEquipStaticAnimations.register(event)
	}

	@SubscribeEvent
	fun registry(event: ActionRegistryEvent) {
		EgoEquipActions.register(event)
	}

	@SubscribeEvent
	fun registry(event: ActionSequenceRegistryEvent) {
		EgoEquipActionSequences.register(event)
	}
}