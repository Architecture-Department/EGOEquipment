package architecture.ego_equipment.common.item.weapon.remote.special;

import architecture.ego_equipment.common.item.weapon.remote.RemoteEgoWeaponGeoItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.model.GeoModel;

public class CherryBlossomsWeaponItem extends RemoteEgoWeaponGeoItem {

	public CherryBlossomsWeaponItem(Properties itemProperties, Builder egoWeaponBuilder, GeoModel<RemoteEgoWeaponGeoItem> geoModel, GeoModel<RemoteEgoWeaponGeoItem> guiModel) {
		super(itemProperties, egoWeaponBuilder, geoModel, guiModel);
	}

	public CherryBlossomsWeaponItem(Properties itemProperties, Builder egoWeaponBuilder, ResourceLocation modPath) {
		super(itemProperties, egoWeaponBuilder, modPath);
	}


	@Override
	protected void shootProjectile(LivingEntity shooterEntity, Projectile projectileEntity, int projectileIndex, float projectileVelocity, float projectileInaccuracy, float shootingAngle, @Nullable LivingEntity targetEntity) {

	}
}
