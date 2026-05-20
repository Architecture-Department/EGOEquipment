package architecture.ego_equipment.common.item.weapon.melee.swords

import architecture.ego_equipment.common.item.weapon.melee.MeleeEgoWeaponGeoItem
import architecture.goldenboughs_lib.api.world.item.IMeleeEgoWeaponItem
import architecture.goldenboughs_lib.client.model.item.GeoItemModel
import architecture.goldenboughs_lib.client.model.item.GuiGeoItemModel
import architecture.goldenboughs_lib.client.renderer.GeoItemRenderProvider
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.Tier
import software.bernie.geckolib.animatable.GeoItem
import software.bernie.geckolib.animatable.client.GeoRenderProvider
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache
import software.bernie.geckolib.animation.AnimatableManager
import software.bernie.geckolib.model.GeoModel
import software.bernie.geckolib.util.GeckoLibUtil

class SwordsEgoWeaponGeoItem : SwordsEgoWeaponItem, GeoItem {
	protected val model: GeoModel<MeleeEgoWeaponGeoItem>
	protected val guiModel: GeoModel<MeleeEgoWeaponGeoItem>?
	private val cache: AnimatableInstanceCache = GeckoLibUtil.createInstanceCache(this)

	constructor(
		tier: Tier,
		itemProperties: Properties,
		egoWeaponBuilder: IMeleeEgoWeaponItem.Builder,
		modPath: ResourceLocation
	) : this(tier, itemProperties, egoWeaponBuilder, GeoItemModel(modPath), GuiGeoItemModel(modPath))

	constructor(
		tier: Tier,
		itemProperties: Properties,
		egoWeaponBuilder: IMeleeEgoWeaponItem.Builder,
		geoModel: GeoModel<MeleeEgoWeaponGeoItem>,
		guiModel: GeoModel<MeleeEgoWeaponGeoItem>?
	) : super(tier, itemProperties, egoWeaponBuilder) {
		this.model = geoModel
		this.guiModel = guiModel
	}

	override fun registerControllers(controllerRegistrar: AnimatableManager.ControllerRegistrar) {}
	override fun createGeoRenderer(rendererConsumer: (GeoRenderProvider) -> Unit) {
		rendererConsumer(GeoItemRenderProvider(this.model, this.guiModel))
	}

	override fun getAnimatableInstanceCache(): AnimatableInstanceCache = cache
}
