package architecture.ego_equipment.init.item

import net.neoforged.bus.api.IEventBus

object EGOEquipmentItems {
	@JvmStatic
	fun register(bus: IEventBus) {
		EGOWeaponItems.REGISTRY.register(bus)
		EGOArmorItems.REGISTRY.register(bus)
	}
}