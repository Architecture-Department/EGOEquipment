package architecture.ego_equipment.core

import architecture.ego_equipment.init.*
import architecture.ego_equipment.init.item.EGOArmorItems
import architecture.ego_equipment.init.item.EGOEquipmentItems
import architecture.ego_equipment.util.EGOEquipmentUtil
import architecture.goldenboughs_lib.eventexecute.client.EntityRenderEventExecute
import architecture.goldenboughs_lib.util.LibUtil
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.fml.common.Mod
import net.neoforged.neoforge.event.server.ServerStartingEvent
import thedarkcolour.kotlinforforge.neoforge.forge.LOADING_CONTEXT
import thedarkcolour.kotlinforforge.neoforge.forge.MOD_BUS

@Mod(EGOEquipmentUtil.ID)
@EventBusSubscriber
object EGOEquipment {
	@SubscribeEvent
	fun onServerStarting(event: ServerStartingEvent) {
		LibUtil.LOGGER.info("HELLO from server starting")
	}

	init {
		val modContainer = LOADING_CONTEXT.activeContainer
		val modBus = MOD_BUS

		EGOEquipmentArmorMaterials.REGISTRY.register(modBus)
		EGOEquipmentMobEffects.REGISTRY.register(modBus)
		EGOEquipmentSoundEvents.REGISTRY.register(modBus)
		EGOEquipmentParticleTypes.REGISTRY.register(modBus)
		EGOEquipmentCreativeModeTabs.REGISTRY.register(modBus)
		EGOEquipmentProjectileEntityTypes.REGISTRY.register(modBus)
		EGOEquipmentItems.register(modBus)
		EntityRenderEventExecute.add(EGOArmorItems.IN_THE_NAME_OF_LOVE_AND_HATE)
		EntityRenderEventExecute.add(EGOArmorItems.MAGIC_BULLET)
	}
}
