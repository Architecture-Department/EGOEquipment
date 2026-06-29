package architecture.ego_equipment.events.client

import architecture.ego_equipment.client.gui.hudlayers.RedEyesTachiChopFlavor
import architecture.ego_equipment.init.item.EgoWeaponItems
import architecture.ego_equipment.util.EgoEquipUtil
import architecture.goldenboughs_lib.event.ChopFlavorLayerEvent
import net.neoforged.api.distmarker.Dist
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber

@EventBusSubscriber(modid = EgoEquipUtil.ID, value = [Dist.CLIENT])
object ClientEvents {
	@SubscribeEvent
	fun onAddChopFlavorLayer(event: ChopFlavorLayerEvent) {
		event.add(
			EgoEquipUtil.modRl("red_eyes_tachi"),
			{ itemStack -> itemStack.`is`(EgoWeaponItems.RED_EYES_TACHI) },
			RedEyesTachiChopFlavor()
		)
	}
}