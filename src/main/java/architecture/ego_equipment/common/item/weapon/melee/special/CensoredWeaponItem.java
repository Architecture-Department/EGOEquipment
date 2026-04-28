package architecture.ego_equipment.common.item.weapon.melee.special;

import architecture.ego_equipment.common.item.weapon.melee.MeleeEgoWeaponGeoItem;
import architecture.goldenboughs_lib.api.world.item.IMeleeEgoWeaponItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CensoredWeaponItem extends MeleeEgoWeaponGeoItem {

	public CensoredWeaponItem(Properties itemProperties, IMeleeEgoWeaponItem.Builder egoWeaponBuilder, GeoModel<MeleeEgoWeaponGeoItem> geoModel, GeoModel<MeleeEgoWeaponGeoItem> guiModel) {
		super(itemProperties, egoWeaponBuilder, geoModel, guiModel);
	}

	public CensoredWeaponItem(Properties itemProperties, IMeleeEgoWeaponItem.Builder egoWeaponBuilder, ResourceLocation modPath) {
		super(itemProperties, egoWeaponBuilder, modPath);
	}
}
