package architecture.ego_equipment.common.item.armor

import architecture.goldenboughs_lib.api.capability.item.IItemUsageReq
import architecture.goldenboughs_lib.api.world.item.IEgoItem
import architecture.goldenboughs_lib.init.LibAttributes
import architecture.goldenboughs_lib.init.LibDataComponentTypes
import architecture.goldenboughs_lib.module.virtue.data_component.ItemVirtueUsageReq
import architecture.goldenboughs_lib.util.world.item.ItemBuilderUtil
import net.minecraft.core.Holder
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.entity.EquipmentSlotGroup
import net.minecraft.world.entity.ai.attributes.AttributeModifier
import net.minecraft.world.entity.ai.attributes.Attributes
import net.minecraft.world.item.ArmorItem
import net.minecraft.world.item.ArmorMaterial
import net.minecraft.world.item.component.ItemAttributeModifiers
import software.bernie.geckolib.animatable.GeoItem
import software.bernie.geckolib.animatable.client.GeoRenderProvider
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache
import software.bernie.geckolib.animation.AnimatableManager
import software.bernie.geckolib.util.GeckoLibUtil
import java.util.function.Consumer

class EgoArmorItem(
	armorMaterial: Holder<ArmorMaterial>,
	armorType: Type,
	itemProperties: Properties,
	egoArmorBuilder: Builder,
	private val renderProvider: GeoRenderProvider
) : ArmorItem(
	armorMaterial, armorType, itemProperties
		.stacksTo(1)
		.attributes(egoArmorBuilder.getItemAttributeModifiers(armorType, armorMaterial))
		.component(LibDataComponentTypes.IS_RESTRAIN, false)
		.component(LibDataComponentTypes.ITEM_VIRTUE_USAGE_REQ, egoArmorBuilder.virtueUsageReqBuilder!!.build())
), GeoItem, IItemUsageReq, IEgoItem {

	private val cache: AnimatableInstanceCache = GeckoLibUtil.createInstanceCache(this)

	override fun registerControllers(controllerRegistrar: AnimatableManager.ControllerRegistrar) {}

	override fun createGeoRenderer(consumer: Consumer<GeoRenderProvider>) {
		consumer.accept(renderProvider)
	}

	override fun getAnimatableInstanceCache(): AnimatableInstanceCache = cache

	class Builder {
		var virtueUsageReqBuilder: ItemVirtueUsageReq.Builder? = null
		private var physicsVulnerable: Double = 0.0
		private var spiritVulnerable: Double = 0.0
		private var erosionVulnerable: Double = 0.0
		private var theSoulVulnerable: Double = 0.0

		fun getItemAttributeModifiers(armorType: Type, material: Holder<ArmorMaterial>): ItemAttributeModifiers {
			val attributeBuilder = ItemAttributeModifiers.builder()
			val armorMaterial = material.value()
			val equipmentSlotGroup = EquipmentSlotGroup.bySlot(armorType.slot)
			val id = getArmorModifierId(armorType)
			ItemBuilderUtil.addAttributeModifier(
				attributeBuilder,
				LibAttributes.PHYSICS_VULNERABLE,
				id,
				physicsVulnerable,
				AttributeModifier.Operation.ADD_VALUE,
				equipmentSlotGroup
			)
			ItemBuilderUtil.addAttributeModifier(
				attributeBuilder,
				LibAttributes.SPIRIT_VULNERABLE,
				id,
				spiritVulnerable,
				AttributeModifier.Operation.ADD_VALUE,
				equipmentSlotGroup
			)
			ItemBuilderUtil.addAttributeModifier(
				attributeBuilder,
				LibAttributes.EROSION_VULNERABLE,
				id,
				erosionVulnerable,
				AttributeModifier.Operation.ADD_VALUE,
				equipmentSlotGroup
			)
			ItemBuilderUtil.addAttributeModifier(
				attributeBuilder,
				LibAttributes.THE_SOUL_VULNERABLE,
				id,
				theSoulVulnerable,
				AttributeModifier.Operation.ADD_VALUE,
				equipmentSlotGroup
			)

			ItemBuilderUtil.addAttributeModifier(
				attributeBuilder,
				Attributes.ARMOR,
				id,
				armorMaterial.getDefense(armorType).toDouble(),
				AttributeModifier.Operation.ADD_VALUE,
				equipmentSlotGroup
			)
			ItemBuilderUtil.addAttributeModifier(
				attributeBuilder,
				Attributes.ARMOR_TOUGHNESS,
				id,
				armorMaterial.toughness().toDouble(),
				AttributeModifier.Operation.ADD_VALUE,
				equipmentSlotGroup
			)
			ItemBuilderUtil.addAttributeModifier(
				attributeBuilder,
				Attributes.KNOCKBACK_RESISTANCE,
				id,
				armorMaterial.knockbackResistance().toDouble(),
				AttributeModifier.Operation.ADD_VALUE,
				equipmentSlotGroup
			)
			return attributeBuilder.build()
		}

		fun virtueUsageReqBuilder(virtueRequirementBuilder: ItemVirtueUsageReq.Builder): Builder {
			this.virtueUsageReqBuilder = virtueRequirementBuilder
			return this
		}

		fun vulnerable(
			physicsVulnerability: Double,
			spiritVulnerability: Double,
			erosionVulnerability: Double,
			soulVulnerability: Double
		): Builder {
			this.physicsVulnerable = physicsVulnerability
			this.spiritVulnerable = spiritVulnerability
			this.erosionVulnerable = erosionVulnerability
			this.theSoulVulnerable = soulVulnerability
			return this
		}

		companion object {
			private fun getArmorModifierId(armorType: Type): ResourceLocation =
				ResourceLocation.withDefaultNamespace("armor.${armorType.getName()}")
		}
	}
}
