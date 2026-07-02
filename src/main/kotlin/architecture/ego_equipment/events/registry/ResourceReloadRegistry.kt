package architecture.ego_equipment.events.registry

import architecture.ego_equipment.init.EgoEquipItemProperty
import architecture.ego_equipment.init.animation.EgoEquipActionSequences
import architecture.ego_equipment.init.animation.EgoEquipActions
import architecture.ego_equipment.init.animation.EgoEquipStaticAnimations
import architecture.ego_equipment.util.EgoEquipUtil
import architecture.resonator_combat_framework.event.ItemPropertyRegistryEvent
import architecture.resonator_combat_framework.module.entity_animation.event.AnimationDefRegistryEvent
import architecture.resonator_combat_framework.module.entity_state_machine.event.ActionRegistryEvent
import architecture.resonator_combat_framework.module.entity_state_machine.event.ActionSequenceRegistryEvent
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber

@EventBusSubscriber(modid = EgoEquipUtil.ID)
object ResourceReloadRegistry {
	@SubscribeEvent
	fun registry(event: AnimationDefRegistryEvent) {
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

	@SubscribeEvent
	fun registry(event: ItemPropertyRegistryEvent) {
		EgoEquipItemProperty.register(event)
	}
}