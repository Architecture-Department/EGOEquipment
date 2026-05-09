package architecture.ego_equipment.common.item.weapon.melee.swords;

import architecture.ego_equipment.common.item.weapon.melee.MeleeEgoWeaponGeoItem;
import architecture.goldenboughs_lib.client.model.item.GeoItemModel;
import architecture.goldenboughs_lib.client.model.item.GuiGeoItemModel;
import architecture.goldenboughs_lib.client.renderer.GeoItemRenderProvider;
import net.minecraft.resources.ResourceLocation;
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

/**
 * 这玩意就是原版的剑
 */
public class SwordsEgoWeaponGeoItem extends SwordsEgoWeaponItem implements GeoItem {
	protected final GeoModel<MeleeEgoWeaponGeoItem> model;
	protected final @Nullable GeoModel<MeleeEgoWeaponGeoItem> guiModel;
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

	public SwordsEgoWeaponGeoItem(Tier tier, Properties itemProperties, Builder egoWeaponBuilder, ResourceLocation modPath) {
		this(tier, itemProperties, egoWeaponBuilder, new GeoItemModel<>(modPath), new GuiGeoItemModel<>(modPath));
	}

	public SwordsEgoWeaponGeoItem(Tier tier, Properties itemProperties, Builder egoWeaponBuilder, GeoModel<MeleeEgoWeaponGeoItem> geoModel, GeoModel<MeleeEgoWeaponGeoItem> guiModel) {
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
