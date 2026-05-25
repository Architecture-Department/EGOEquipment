package architecture.ego_equipment.common.item.weapon.melee.swords

import architecture.ego_equipment.common.item.weapon.melee.MeleeEgoWeaponGeoItem
import architecture.goldenboughs_lib.api.world.item.IMeleeEgoWeaponItem
import architecture.goldenboughs_lib.client.model.item.GeoItemModel
import architecture.goldenboughs_lib.client.renderer.GeoItemRenderProvider
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.Tier
import software.bernie.geckolib.animatable.GeoItem
import software.bernie.geckolib.animatable.client.GeoRenderProvider
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache
import software.bernie.geckolib.animation.AnimatableManager
import software.bernie.geckolib.model.GeoModel
import software.bernie.geckolib.util.GeckoLibUtil
import java.util.function.Consumer

class SwordsEgoWeaponGeoItem(
	tier: Tier,
	itemProperties: Properties,
	egoWeaponBuilder: IMeleeEgoWeaponItem.Builder,
	val model: GeoModel<MeleeEgoWeaponGeoItem>,
) : SwordsEgoWeaponItem(tier, itemProperties, egoWeaponBuilder), GeoItem {
	private val cache: AnimatableInstanceCache = GeckoLibUtil.createInstanceCache(this)

	constructor(
		tier: Tier,
		itemProperties: Properties,
		egoWeaponBuilder: IMeleeEgoWeaponItem.Builder,
		modPath: ResourceLocation
	) : this(tier, itemProperties, egoWeaponBuilder, GeoItemModel(modPath))

	override fun registerControllers(controllerRegistrar: AnimatableManager.ControllerRegistrar) {}
	override fun createGeoRenderer(consumer: Consumer<GeoRenderProvider>) {
		consumer.accept(GeoItemRenderProvider(this.model))
	}

	override fun getAnimatableInstanceCache(): AnimatableInstanceCache = cache
}
