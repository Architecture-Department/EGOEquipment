package architecture.ego_equipment.common.item.weapon.remote.special;

import architecture.ego_equipment.common.item.weapon.remote.RemoteEgoWeaponGeoItem;
import architecture.ego_equipment.core.EGOEquipment;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.model.GeoModel;

public class InTheNameOfLoveAndHateWeaponItem extends RemoteEgoWeaponGeoItem {
	public static final ResourceLocation STANDBY = EGOEquipment.modRl("in_the_name_of_love_and_hate_weapon.standby");
	public static final ResourceLocation GALLOP = EGOEquipment.modRl("in_the_name_of_love_and_hate_weapon.gallop");
	public static final ResourceLocation NORMAL_SHOOTING = EGOEquipment.modRl("in_the_name_of_love_and_hate_weapon.normal_shooting");
	public static final ResourceLocation NORMAL_SHOOTING1 = EGOEquipment.modRl("in_the_name_of_love_and_hate_weapon.normal_shooting.1");
	public static final ResourceLocation NORMAL_SHOOTING2 = EGOEquipment.modRl("in_the_name_of_love_and_hate_weapon.normal_shooting.2");
	public static final ResourceLocation SKILL = EGOEquipment.modRl("in_the_name_of_love_and_hate_weapon.skill");
	public static final ResourceLocation SKILL1 = EGOEquipment.modRl("in_the_name_of_love_and_hate_weapon.skill.1");
	public static final ResourceLocation SKILL2 = EGOEquipment.modRl("in_the_name_of_love_and_hate_weapon.skill.2");
	public static final ResourceLocation FINISHING_SKILL = EGOEquipment.modRl("in_the_name_of_love_and_hate_weapon.finishing_skill");
	public static final ResourceLocation FINISHING_SKILL1 = EGOEquipment.modRl("in_the_name_of_love_and_hate_weapon.finishing_skill.1");
	public static final ResourceLocation FINISHING_SKILL2 = EGOEquipment.modRl("in_the_name_of_love_and_hate_weapon.finishing_skill.2");
	public static final ResourceLocation FINISHING_SKILL3 = EGOEquipment.modRl("in_the_name_of_love_and_hate_weapon.finishing_skill.3");
	public static final ResourceLocation FINISHING_SKILL4 = EGOEquipment.modRl("in_the_name_of_love_and_hate_weapon.finishing_skill.4");

	public InTheNameOfLoveAndHateWeaponItem(Properties itemProperties, Builder egoWeaponBuilder, GeoModel<RemoteEgoWeaponGeoItem> geoModel, GeoModel<RemoteEgoWeaponGeoItem> guiModel) {
		super(itemProperties, egoWeaponBuilder, geoModel, guiModel);
	}

	public InTheNameOfLoveAndHateWeaponItem(Properties itemProperties, Builder egoWeaponBuilder, String modPath) {
		super(itemProperties, egoWeaponBuilder, modPath);
	}


	@Override
	protected void shootProjectile(LivingEntity shooterEntity, Projectile projectileEntity, int projectileIndex, float projectileVelocity, float projectileInaccuracy, float shootingAngle, @Nullable LivingEntity targetEntity) {

	}
}
