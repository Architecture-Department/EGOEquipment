package architecture.ego_equipment.common.item.weapon.remote.crossbow

import architecture.ego_equipment.common.item.weapon.remote.RemoteEgoWeaponGeoItem
import architecture.goldenboughs_lib.api.world.item.IRemoteEgoWeaponItem
import architecture.goldenboughs_lib.client.model.item.GeoItemModel
import architecture.goldenboughs_lib.client.renderer.GeoItemRenderProvider
import net.minecraft.resources.ResourceLocation
import software.bernie.geckolib.animatable.GeoItem
import software.bernie.geckolib.animatable.client.GeoRenderProvider
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache
import software.bernie.geckolib.animation.AnimatableManager
import software.bernie.geckolib.model.GeoModel
import software.bernie.geckolib.util.GeckoLibUtil
import java.util.function.Consumer

class CrossbowEgoWeaponGeoItem : CrossbowEgoWeaponItem, GeoItem {
	private val cache: AnimatableInstanceCache = GeckoLibUtil.createInstanceCache(this)
	private val model: GeoModel<RemoteEgoWeaponGeoItem>

	constructor(
		itemProperties: Properties,
		egoWeaponBuilder: IRemoteEgoWeaponItem.Builder,
		modPath: ResourceLocation
	) : this(itemProperties, egoWeaponBuilder, GeoItemModel(modPath))

	constructor(
		itemProperties: Properties,
		egoWeaponBuilder: IRemoteEgoWeaponItem.Builder,
		geoModel: GeoModel<RemoteEgoWeaponGeoItem>
	) : super(itemProperties, egoWeaponBuilder) {
		this.model = geoModel
	}

	override fun createGeoRenderer(consumer: Consumer<GeoRenderProvider>) {
		consumer.accept(GeoItemRenderProvider(this.model))
	}

	override fun registerControllers(controllers: AnimatableManager.ControllerRegistrar) {}
	override fun getAnimatableInstanceCache(): AnimatableInstanceCache = cache
}
