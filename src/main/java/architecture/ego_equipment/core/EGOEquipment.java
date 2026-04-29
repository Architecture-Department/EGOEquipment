package architecture.ego_equipment.core;

import architecture.ego_equipment.init.*;
import architecture.goldenboughs_lib.eventexecute.client.EntityRenderEventExecute;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

@Mod(EGOEquipment.ID)
public class EGOEquipment {

	public static final String ID = "ego_equipment";
	public static final String NAME = "E.G.O.Equipment";
	public static final Logger LOGGER = LogManager.getLogger(ID);

	public EGOEquipment(IEventBus modEventBus, ModContainer modContainer) {
		NeoForge.EVENT_BUS.register(this);
		EGOArmorItems.REGISTRY.register(modEventBus);
		EGOEquipmentArmorMaterials.REGISTRY.register(modEventBus);
		EGOEquipmentMobEffects.REGISTRY.register(modEventBus);
		EGOEquipmentSoundEvents.REGISTRY.register(modEventBus);
		EGOWeaponItems.REGISTRY.register(modEventBus);
		EGOEquipmentParticleTypes.REGISTRY.register(modEventBus);
		EGOEquipmentCreativeModeTabs.REGISTRY.register(modEventBus);
		EGOEquipmentProjectileEntityTypes.REGISTRY.register(modEventBus);
		EntityRenderEventExecute.INSTANCE.add(EGOArmorItems.IN_THE_NAME_OF_LOVE_AND_HATE);
		EntityRenderEventExecute.INSTANCE.add(EGOArmorItems.MAGIC_BULLET);
	}

	@Contract("_ -> new")
	public static @NotNull ResourceLocation modRl(final String name) {
		return ResourceLocation.fromNamespaceAndPath(ID, name);
	}

	@Contract(pure = true)
	public static @NotNull String modRlText(final String name) {
		return ID + ":" + name;
	}

	public static <T> @NotNull DeferredRegister<T> modRegister(Registry<T> registry) {
		return DeferredRegister.create(registry, ID);
	}

	public static <T> @NotNull DeferredRegister<T> modRegister(ResourceKey<Registry<T>> registry) {
		return DeferredRegister.create(registry, ID);
	}

	@SubscribeEvent
	public void onServerStarting(ServerStartingEvent event) {
		LOGGER.info("HELLO from server starting");
	}
}
