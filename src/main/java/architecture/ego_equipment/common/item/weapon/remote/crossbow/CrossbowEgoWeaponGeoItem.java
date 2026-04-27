package architecture.ego_equipment.common.item.weapon.remote.crossbow;

import architecture.ego_equipment.common.item.weapon.remote.RemoteEgoWeaponGeoItem;
import architecture.goldenboughs_lib.api.world.item.IRemoteEgoWeaponItem;
import architecture.goldenboughs_lib.client.model.item.GuiItemModel;
import architecture.goldenboughs_lib.client.model.item.ModGeoItemModel;
import architecture.goldenboughs_lib.client.renderer.GeoItemRenderProvider;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.function.Consumer;

/**
 * 弩型EGO武器物品类
 */
public class CrossbowEgoWeaponGeoItem extends CrossbowEgoWeaponItem implements GeoItem {
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
	private final GeoModel<RemoteEgoWeaponGeoItem> model;
	private final @Nullable GeoModel<RemoteEgoWeaponGeoItem> guiModel;

	public CrossbowEgoWeaponGeoItem(Properties itemProperties, IRemoteEgoWeaponItem.Builder egoWeaponBuilder, String modPath) {
		this(itemProperties, egoWeaponBuilder, new ModGeoItemModel<>(modPath), new GuiItemModel<>(modPath));
	}

	public CrossbowEgoWeaponGeoItem(Properties itemProperties, IRemoteEgoWeaponItem.Builder egoWeaponBuilder, GeoModel<RemoteEgoWeaponGeoItem> geoModel, GeoModel<RemoteEgoWeaponGeoItem> guiModel) {
		super(itemProperties, egoWeaponBuilder);
		this.model = geoModel;
		this.guiModel = guiModel;
	}

	@Override
	public void createGeoRenderer(@NotNull Consumer<GeoRenderProvider> rendererConsumer) {
		rendererConsumer.accept(new GeoItemRenderProvider<>(this.model, this.guiModel));
	}

	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {

	}

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return cache;
	}
}
