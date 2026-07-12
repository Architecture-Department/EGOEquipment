package architecture.ego_equipment.init.itemproperty

import architecture.resonator_combat_framework.combat.ActionSequence
import architecture.resonator_combat_framework.common.item_property.ItemProperty
import architecture.resonator_combat_framework.common.item_property.WeaponProperty
import architecture.resonator_combat_framework.init.RcfRegistries
import architecture.resonator_combat_framework.util.RcfUtil
import net.minecraft.resources.ResourceLocation
import net.neoforged.neoforge.registries.DeferredHolder
import java.util.function.Function

object EgoEquipItemPropertys {
	val REGISTRY = RcfUtil.modRegister(RcfRegistries.ITEM_PROPERTY)
	val LIFE_FOR_A_DAREDEVIL = register("life_for_a_daredevil") {
		WeaponProperty(
			it,
			ActionSequence.of(
				EgoEquipActions.LIFE_FOR_A_DAREDEVIL_ATTACK,
				EgoEquipActions.LIFE_FOR_A_DAREDEVIL_ATTACK,
				EgoEquipActions.LIFE_FOR_A_DAREDEVIL_ATTACK1,
				EgoEquipActions.LIFE_FOR_A_DAREDEVIL_ATTACK2,
				EgoEquipActions.LIFE_FOR_A_DAREDEVIL_ATTACK3,
				EgoEquipActions.LIFE_FOR_A_DAREDEVIL_ATTACK4,
			),
			EgoEquipActions.LIFE_FOR_A_DAREDEVIL_SPECIAL_ATTACK,
		)
	}

	private fun <T : ItemProperty> register(
		id: String,
		function: Function<ResourceLocation, T>
	): DeferredHolder<ItemProperty, T> {
		return REGISTRY.register(id, function)
	}
}