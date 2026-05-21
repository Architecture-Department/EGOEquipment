package architecture.ego_equipment.common.item.weapon.remote

import architecture.goldenboughs_lib.api.world.item.IRemoteEgoWeaponItem
import architecture.goldenboughs_lib.client.model.item.GeoItemModel
import architecture.goldenboughs_lib.client.model.item.GuiGeoItemModel
import architecture.goldenboughs_lib.client.renderer.GeoItemRenderProvider
import net.minecraft.resources.ResourceLocation
import software.bernie.geckolib.animatable.GeoItem
import software.bernie.geckolib.animatable.client.GeoRenderProvider
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache
import software.bernie.geckolib.animation.AnimatableManager
import software.bernie.geckolib.model.GeoModel
import software.bernie.geckolib.util.GeckoLibUtil
import java.util.function.Consumer

abstract class RemoteEgoWeaponGeoItem : RemoteEgoWeaponItem, GeoItem {
	private val cache: AnimatableInstanceCache = GeckoLibUtil.createInstanceCache(this)
	private val model: GeoModel<RemoteEgoWeaponGeoItem>
	private val guiModel: GeoModel<RemoteEgoWeaponGeoItem>?

	constructor(
		itemProperties: Properties,
		egoWeaponBuilder: IRemoteEgoWeaponItem.Builder,
		modPath: ResourceLocation
	) : this(itemProperties, egoWeaponBuilder, GeoItemModel(modPath), GuiGeoItemModel(modPath))

	constructor(
		itemProperties: Properties,
		egoWeaponBuilder: IRemoteEgoWeaponItem.Builder,
		geoModel: GeoModel<RemoteEgoWeaponGeoItem>,
		guiModel: GeoModel<RemoteEgoWeaponGeoItem>?
	) : super(itemProperties, egoWeaponBuilder) {
		this.model = geoModel
		this.guiModel = guiModel
	}

	override fun createGeoRenderer(consumer: Consumer<GeoRenderProvider>) {
		consumer.accept(GeoItemRenderProvider(this.model, this.guiModel))
	}

	override fun registerControllers(controllerRegistrar: AnimatableManager.ControllerRegistrar) {}

	override fun getAnimatableInstanceCache(): AnimatableInstanceCache = cache
}
