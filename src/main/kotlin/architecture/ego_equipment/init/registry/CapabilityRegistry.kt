package architecture.ego_equipment.init.registry

import architecture.ego_equipment.init.EgoEquipItemProperty
import architecture.ego_equipment.init.item.EgoWeaponItems
import architecture.ego_equipment.util.EgoEquipUtil
import architecture.resonator_combat_framework.common.registry.ItemPropertyRegistry
import architecture.resonator_combat_framework.init.RcfCapabilitys
import architecture.resonator_combat_framework.init.RcfCapabilitys.registerItemAbility
import net.neoforged.bus.api.EventPriority
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent

/**
 * 注册 NeoForge Capability 系统。
 * 将 [RcfCapabilitys.ITEM_ABILITY] 能力附加到所有物品上，
 * 由 [ItemPropertyRegistry] 按物品类型提供实际的 [ItemCapability] 实例。
 */
@EventBusSubscriber(modid = EgoEquipUtil.ID)
object CapabilityRegistry {
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	fun registry(event: RegisterCapabilitiesEvent) {

		event.registerItemAbility(
			{ EgoEquipItemProperty.LIFE_FOR_A_DAREDEVIL.get() },
			EgoWeaponItems.LIFE_FOR_A_DAREDEVIL
		)
	}
}