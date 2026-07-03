package architecture.ego_equipment.events.registry

import architecture.ego_equipment.init.EgoEquipItemProperty
import architecture.ego_equipment.init.animation.EgoEquipActionSequences
import architecture.ego_equipment.init.animation.EgoEquipActions
import architecture.ego_equipment.init.animation.EgoEquipStaticAnimations
import architecture.ego_equipment.util.EgoEquipUtil
import architecture.resonator_combat_framework.event.ItemPropertyRegistryEvent
import architecture.resonator_combat_framework.module.animation.event.AnimationDefRegisterEvent
import architecture.resonator_combat_framework.module.state_machine.event.ActionRegisterEvent
import architecture.resonator_combat_framework.module.state_machine.event.ActionSequenceRegisterEvent
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber

@EventBusSubscriber(modid = EgoEquipUtil.ID)
object ResourceReloadRegistry {
	@SubscribeEvent
	fun registry(event: AnimationDefRegisterEvent) {
		EgoEquipStaticAnimations.register(event)
	}

	@SubscribeEvent
	fun registry(event: ActionRegisterEvent) {
		EgoEquipActions.register(event)
	}

	@SubscribeEvent
	fun registry(event: ActionSequenceRegisterEvent) {
		EgoEquipActionSequences.register(event)
	}

	@SubscribeEvent
	fun registry(event: ItemPropertyRegistryEvent) {
		EgoEquipItemProperty.register(event)
	}
}