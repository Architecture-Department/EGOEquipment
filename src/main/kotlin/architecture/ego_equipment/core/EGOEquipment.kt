package architecture.ego_equipment.core

import architecture.ego_equipment.init.*
import architecture.goldenboughs_lib.core.Lib
import architecture.goldenboughs_lib.eventexecute.client.EntityRenderEventExecute
import net.minecraft.core.Registry
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.fml.common.Mod
import net.neoforged.neoforge.event.server.ServerStartingEvent
import net.neoforged.neoforge.registries.DeferredRegister
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.jetbrains.annotations.Contract
import thedarkcolour.kotlinforforge.neoforge.forge.LOADING_CONTEXT
import thedarkcolour.kotlinforforge.neoforge.forge.MOD_BUS

@Mod(EGOEquipment.ID)
@EventBusSubscriber
object EGOEquipment {
	const val ID: String = "ego_equipment"
	const val NAME: String = "E.G.O.Equipment"

	@JvmField
	val LOGGER: Logger = LogManager.getLogger(ID)

	init {
		val modContainer = LOADING_CONTEXT.activeContainer
		val modBus = MOD_BUS

		EGOArmorItems.REGISTRY.register(modBus)
		EGOEquipmentArmorMaterials.REGISTRY.register(modBus)
		EGOEquipmentMobEffects.REGISTRY.register(modBus)
		EGOEquipmentSoundEvents.REGISTRY.register(modBus)
		EGOWeaponItems.REGISTRY.register(modBus)
		EGOEquipmentParticleTypes.REGISTRY.register(modBus)
		EGOEquipmentCreativeModeTabs.REGISTRY.register(modBus)
		EGOEquipmentProjectileEntityTypes.REGISTRY.register(modBus)
		EntityRenderEventExecute.INSTANCE.add(EGOArmorItems.IN_THE_NAME_OF_LOVE_AND_HATE)
		EntityRenderEventExecute.INSTANCE.add(EGOArmorItems.MAGIC_BULLET)
	}

	@SubscribeEvent
	fun onServerStarting(event: ServerStartingEvent) {
		Lib.LOGGER.info("HELLO from server starting")
	}

	@JvmStatic
	@Contract("_ -> new")
	fun modRl(name: String): ResourceLocation {
		return ResourceLocation.fromNamespaceAndPath(ID, name)
	}

	@JvmStatic
	@Contract(pure = true)
	fun modRlText(name: String): String {
		return "$ID:$name"
	}

	@JvmStatic
	fun <T> modRegister(registry: Registry<T>): DeferredRegister<T> {
		return DeferredRegister.create<T>(registry, ID)
	}

	@JvmStatic
	fun <T> modRegister(registry: ResourceKey<Registry<T>>): DeferredRegister<T> {
		return DeferredRegister.create<T>(registry, ID)
	}
}
