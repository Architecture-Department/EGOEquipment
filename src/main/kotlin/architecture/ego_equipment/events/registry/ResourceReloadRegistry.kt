package architecture.ego_equipment.events.registry

import architecture.ego_equipment.init.animation.EgoEquipStaticAnimations
import architecture.ego_equipment.util.EgoEquipUtil
import architecture.resonator_combat_framework.event.AnimationDefRegisterEvent
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber

@EventBusSubscriber(modid = EgoEquipUtil.ID)
object ResourceReloadRegistry {
	@SubscribeEvent
	fun registry(event: AnimationDefRegisterEvent) {
		EgoEquipStaticAnimations.register(event)
	}
}