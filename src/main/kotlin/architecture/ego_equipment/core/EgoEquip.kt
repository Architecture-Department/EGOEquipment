package architecture.ego_equipment.core

import architecture.ego_equipment.init.*
import architecture.ego_equipment.init.item.EgoArmorItems
import architecture.ego_equipment.init.item.EgoEquipItems
import architecture.ego_equipment.util.EgoEquipUtil
import architecture.goldenboughs_lib.eventexecute.client.EntityRenderEventExecute
import architecture.goldenboughs_lib.util.LibUtil
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.fml.common.Mod
import net.neoforged.neoforge.event.server.ServerStartingEvent
import thedarkcolour.kotlinforforge.neoforge.forge.LOADING_CONTEXT
import thedarkcolour.kotlinforforge.neoforge.forge.MOD_BUS

@Mod(EgoEquipUtil.ID)
@EventBusSubscriber
object EgoEquip {
	@SubscribeEvent
	fun onServerStarting(event: ServerStartingEvent) {
		LibUtil.LOGGER.info("HELLO from server starting")
	}

	init {
		val modContainer = LOADING_CONTEXT.activeContainer
		val modBus = MOD_BUS

		EgoEquipArmorMaterials.REGISTRY.register(modBus)
		EgoEquipMobEffects.REGISTRY.register(modBus)
		EgoEquipSoundEvents.REGISTRY.register(modBus)
		EgoEquipParticleTypes.REGISTRY.register(modBus)
		EgoEquipCreativeModeTabs.REGISTRY.register(modBus)
		EgoEquipProjectileEntityTypes.REGISTRY.register(modBus)
		EgoEquipItems.register(modBus)
		EntityRenderEventExecute.add(EgoArmorItems.IN_THE_NAME_OF_LOVE_AND_HATE)
		EntityRenderEventExecute.add(EgoArmorItems.MAGIC_BULLET)
	}
}
