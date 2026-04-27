package architecture.ego_equipment.common.item.weapon.melee.axe;

import architecture.ego_equipment.common.item.weapon.melee.MeleeEgoWeaponGeoItem;
import architecture.goldenboughs_lib.api.world.item.IMeleeEgoWeaponItem;
import architecture.goldenboughs_lib.client.model.item.GuiItemModel;
import architecture.goldenboughs_lib.client.model.item.ModGeoItemModel;
import architecture.goldenboughs_lib.client.renderer.GeoItemRenderProvider;
import net.minecraft.world.item.Tier;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.function.Consumer;

public class AxeEgoWeaponGeoItem extends AxeEgoWeaponItem implements GeoItem {
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
	private final GeoModel<MeleeEgoWeaponGeoItem> model;
	private final @Nullable GeoModel<MeleeEgoWeaponGeoItem> guiModel;

	public AxeEgoWeaponGeoItem(Tier tier, Properties itemProperties, IMeleeEgoWeaponItem.Builder egoWeaponBuilder, String modPath) {
		this(tier, itemProperties, egoWeaponBuilder, new ModGeoItemModel<>(modPath), new GuiItemModel<>(modPath));
	}

	public AxeEgoWeaponGeoItem(Tier tier, Properties itemProperties, IMeleeEgoWeaponItem.Builder egoWeaponBuilder, GeoModel<MeleeEgoWeaponGeoItem> geoModel, GeoModel<MeleeEgoWeaponGeoItem> guiModel) {
		super(tier, itemProperties, egoWeaponBuilder);
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

