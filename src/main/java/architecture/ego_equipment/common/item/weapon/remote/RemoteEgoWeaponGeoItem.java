package architecture.ego_equipment.common.item.weapon.remote;

import architecture.goldenboughs_lib.client.model.item.GeoItemModel;
import architecture.goldenboughs_lib.client.model.item.GuiGeoItemModel;
import architecture.goldenboughs_lib.client.renderer.GeoItemRenderProvider;
import net.minecraft.resources.ResourceLocation;
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
 * 远程EGO武器
 */
public abstract class RemoteEgoWeaponGeoItem extends RemoteEgoWeaponItem implements GeoItem {
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
	private final GeoModel<RemoteEgoWeaponGeoItem> model;
	private final @Nullable GeoModel<RemoteEgoWeaponGeoItem> guiModel;

	public RemoteEgoWeaponGeoItem(Properties itemProperties, Builder egoWeaponBuilder, ResourceLocation modPath) {
		this(itemProperties, egoWeaponBuilder, new GeoItemModel<>(modPath), new GuiGeoItemModel<>(modPath));
	}

	public RemoteEgoWeaponGeoItem(Properties itemProperties, Builder egoWeaponBuilder, GeoModel<RemoteEgoWeaponGeoItem> geoModel, GeoModel<RemoteEgoWeaponGeoItem> guiModel) {
		super(itemProperties, egoWeaponBuilder);
		this.model = geoModel;
		this.guiModel = guiModel;
	}

	@Override
	public void createGeoRenderer(@NotNull Consumer<GeoRenderProvider> rendererConsumer) {
		rendererConsumer.accept(new GeoItemRenderProvider<>(this.model, this.guiModel));
	}

	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {

	}

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return cache;
	}
}
