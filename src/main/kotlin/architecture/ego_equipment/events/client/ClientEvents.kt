package architecture.ego_equipment.events.client

import architecture.ego_equipment.client.gui.hudlayers.RedEyesTachiChopFlavor
import architecture.ego_equipment.core.EGOEquipment
import architecture.ego_equipment.init.item.EGOWeaponItems
import architecture.goldenboughs_lib.event.ChopFlavorLayerEvent
import net.neoforged.api.distmarker.Dist
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import architecture.ego_equipment.core.EGOEquipmentConstants

@EventBusSubscriber(modid = EGOEquipmentConstants.ID, value = [Dist.CLIENT])
object ClientEvents {

	@SubscribeEvent
	fun addChopFlavorLayer(event: ChopFlavorLayerEvent) {
		event.add(
			EGOEquipmentConstants.modRl("red_eyes_tachi"),
			{ itemStack -> itemStack.`is`(EGOWeaponItems.RED_EYES_TACHI) },
			RedEyesTachiChopFlavor()
		)
	}
}