package architecture.ego_equipment.init.item

import net.neoforged.bus.api.IEventBus

object EgoEquipItems {
	@JvmStatic
	fun register(bus: IEventBus) {
		EgoWeaponItems.REGISTRY.register(bus)
		EgoArmorItems.REGISTRY.register(bus)
	}
}