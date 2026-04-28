package architecture.ego_equipment.common.item.weapon.melee;

import architecture.goldenboughs_lib.api.world.item.IMeleeEgoWeaponItem;
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

public abstract class MeleeEgoWeaponGeoItem extends MeleeEgoWeaponItem implements GeoItem {
	protected final GeoModel<MeleeEgoWeaponGeoItem> model;
	protected final @Nullable GeoModel<MeleeEgoWeaponGeoItem> guiModel;
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

	public MeleeEgoWeaponGeoItem(Properties itemProperties, IMeleeEgoWeaponItem.Builder egoWeaponBuilder, ResourceLocation modPath) {
		this(itemProperties, egoWeaponBuilder, new GeoItemModel<>(modPath), new GuiGeoItemModel<>(modPath));
	}

	public MeleeEgoWeaponGeoItem(Properties itemProperties, IMeleeEgoWeaponItem.Builder egoWeaponBuilder, GeoModel<MeleeEgoWeaponGeoItem> geoModel, @Nullable GeoModel<MeleeEgoWeaponGeoItem> guiModel) {
		super(itemProperties, egoWeaponBuilder);
		this.model = geoModel;
		this.guiModel = guiModel;
	}

	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {

	}

	@Override
	public void createGeoRenderer(@NotNull Consumer<GeoRenderProvider> rendererConsumer) {
		rendererConsumer.accept(new GeoItemRenderProvider<>(this.model, this.guiModel));
	}

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return cache;
	}
}
