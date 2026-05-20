package architecture.ego_equipment.core.registry.client

import architecture.ego_equipment.core.EGOEquipment
import net.minecraft.client.Minecraft
import net.neoforged.api.distmarker.Dist
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.ModContainer
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.fml.common.Mod
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent
import net.neoforged.neoforge.client.gui.ConfigurationScreen
import net.neoforged.neoforge.client.gui.IConfigScreenFactory

@Mod(value = [EGOEquipment.ID], dist = [Dist.CLIENT])
@EventBusSubscriber(modid = EGOEquipment.ID, value = [Dist.CLIENT])
class EGOEquipmentClient(container: ModContainer) {
	init {
		container.registerExtensionPoint(IConfigScreenFactory::class.java, ConfigurationScreen::new)
	}

	companion object {
		@SubscribeEvent
		@JvmStatic
		fun onClientSetup(event: FMLClientSetupEvent) {
			EGOEquipment.LOGGER.info("HELLO FROM CLIENT SETUP")
			EGOEquipment.LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().user.name)
		}

		@SubscribeEvent
		@JvmStatic
		fun registerEntityRenderers(event: net.neoforged.neoforge.client.event.EntityRenderersEvent.RegisterRenderers) {
		}
	}
}
