package architecture.ego_equipment.init

import architecture.ego_equipment.core.EGOEquipment
import net.minecraft.Util
import net.minecraft.core.Holder
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.resources.ResourceLocation
import net.minecraft.sounds.SoundEvent
import net.minecraft.world.item.ArmorItem
import net.minecraft.world.item.ArmorMaterial
import net.minecraft.world.item.Items
import net.minecraft.world.item.crafting.Ingredient
import net.neoforged.neoforge.registries.DeferredRegister
import java.util.*
import architecture.ego_equipment.core.EGOEquipmentConstants

object EGOEquipmentArmorMaterials {
	val REGISTRY: DeferredRegister<ArmorMaterial> = EGOEquipmentConstants.modRegister(BuiltInRegistries.ARMOR_MATERIAL)

	val ZAYIN: Holder<ArmorMaterial> = register(
		"zayin", 1, 2, 3, 1, 3, 9,
		EGOEquipmentSoundEvents.ARMOR_EQUIP_ZAYIN, 0.5F, 0.0F
	)
	val TETH: Holder<ArmorMaterial> = register(
		"teth", 2, 5, 6, 2, 5, 9,
		EGOEquipmentSoundEvents.ARMOR_EQUIP_TETH, 1.0F, 0.0F
	)
	val HE: Holder<ArmorMaterial> = register(
		"he", 3, 6, 8, 3, 11, 9,
		EGOEquipmentSoundEvents.ARMOR_EQUIP_HE, 2.0F, 0.025F
	)
	val WAW: Holder<ArmorMaterial> = register(
		"waw", 4, 7, 9, 4, 12, 9,
		EGOEquipmentSoundEvents.ARMOR_EQUIP_WAW, 3.0F, 0.05F
	)
	val ALEPH: Holder<ArmorMaterial> = register(
		"aleph", 4, 8, 10, 5, 13, 9,
		EGOEquipmentSoundEvents.ARMOR_EQUIP_ALEPH, 4.0F, 0.1F
	)

	val SUIT: Holder<ArmorMaterial> = register(
		"suit", 1, 2, 3, 1, 3, 9,
		EGOEquipmentSoundEvents.ARMOR_EQUIP_ZAYIN, 0.0F, 0.0F
	)

	private fun register(
		id: String, boots: Int, leggings: Int, chestplate: Int, helmet: Int, body: Int,
		enchantmentValue: Int, equipSound: Holder<SoundEvent>, toughness: Float,
		knockbackResistance: Float
	): Holder<ArmorMaterial> = register(
		id, boots, leggings, chestplate, helmet, body, enchantmentValue, equipSound,
		toughness, knockbackResistance
	) { Ingredient.of(Items.AIR) }

	private fun register(
		id: String, boots: Int, leggings: Int, chestplate: Int, helmet: Int, body: Int,
		enchantmentValue: Int, equipSound: Holder<SoundEvent>, toughness: Float,
		knockbackResistance: Float, repairIngredient: () -> Ingredient
	): Holder<ArmorMaterial> = register(id, Util.make(EnumMap(ArmorItem.Type::class.java)) { map ->
		map[ArmorItem.Type.BOOTS] = boots
		map[ArmorItem.Type.LEGGINGS] = leggings
		map[ArmorItem.Type.CHESTPLATE] = chestplate
		map[ArmorItem.Type.HELMET] = helmet
		map[ArmorItem.Type.BODY] = body
	}, enchantmentValue, equipSound, toughness, knockbackResistance, repairIngredient)

	private fun register(
		id: String, defense: EnumMap<ArmorItem.Type, Int>, enchantmentValue: Int,
		equipSound: Holder<SoundEvent>, toughness: Float, knockbackResistance: Float,
		repairIngredient: () -> Ingredient
	): Holder<ArmorMaterial> {
		val list = listOf(ArmorMaterial.Layer(ResourceLocation.withDefaultNamespace(id)))
		return register(id, defense, enchantmentValue, equipSound, toughness, knockbackResistance, repairIngredient, list)
	}

	private fun register(
		id: String, defense: EnumMap<ArmorItem.Type, Int>, enchantmentValue: Int,
		equipSound: Holder<SoundEvent>, toughness: Float, knockbackResistance: Float,
		repairIngridient: () -> Ingredient, layers: List<ArmorMaterial.Layer>
	): Holder<ArmorMaterial> {
		val enummap = EnumMap<ArmorItem.Type, Int>(ArmorItem.Type::class.java)
		for (armoritemType in ArmorItem.Type.entries) {
			enummap[armoritemType] = defense[armoritemType]
		}
		return REGISTRY.register(id) { ->
			ArmorMaterial(enummap, enchantmentValue, equipSound, repairIngridient, layers, toughness, knockbackResistance)
		}
	}
}
