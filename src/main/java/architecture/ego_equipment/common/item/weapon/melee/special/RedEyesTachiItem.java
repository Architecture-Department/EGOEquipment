package architecture.ego_equipment.common.item.weapon.melee.special;

import architecture.ego_equipment.client.renderer.item.RedEyesTachiItemWeaponRenderer;
import architecture.ego_equipment.common.item.weapon.melee.MeleeEgoWeaponGeoItem;
import architecture.ego_equipment.init.EGOEquipmentMobEffects;
import architecture.ego_equipment.mixin.MobEffectInstanceAccessorMixin;
import architecture.goldenboughs_lib.api.world.item.IMeleeEgoWeaponItem;
import architecture.goldenboughs_lib.client.renderer.GeoItemRenderProvider;
import architecture.goldenboughs_lib.mixin.world.entity.LivingEntityAccessorMixin;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.model.GeoModel;

import java.util.function.Consumer;

// TODO 补充特效
public class RedEyesTachiItem extends MeleeEgoWeaponGeoItem {

	public RedEyesTachiItem(Properties itemProperties, IMeleeEgoWeaponItem.Builder egoWeaponBuilder, GeoModel<MeleeEgoWeaponGeoItem> geoModel, GeoModel<MeleeEgoWeaponGeoItem> guiModel) {
		super(itemProperties, egoWeaponBuilder, geoModel, guiModel);
	}

	public RedEyesTachiItem(Properties itemProperties, IMeleeEgoWeaponItem.Builder egoWeaponBuilder, ResourceLocation modPath) {
		super(itemProperties, egoWeaponBuilder, modPath);
	}

	public static void phaseSwitch() {
//		EpicFightEventHooks.Player.CAST_SKILL.registerContextAwareEvent((event, eventContext) -> {
//			if (!FMLEnvironment.dist.isClient()) {
//				return;
//			}
//			PlayerPatch<?> playerPatch = event.getPlayerPatch();
//			ItemStack itemStack = playerPatch.getValidItemInHand(InteractionHand.MAIN_HAND);
//			if (!(itemStack.getItem() instanceof RedEyesTachiItem)) {
//				return;
//			}
//			SkillContainer skill = playerPatch.getSkill(SkillSlots.WEAPON_INNATE);
//			if (skill == null) {
//				return;
//			}
//			if (!event.getSkillContainer().equals(skill)) {
//				return;
//			}
//			ChopFlavorLayer.INSTANCE.castSkill();
//		});
//		EpicFightEventHooks.Player.TICK_EPICFIGHT_MODE.registerEvent(event -> {
//			PlayerPatch<?> playerPatch = event.getPlayerPatch();
//			Player original = playerPatch.getOriginal();
//			if (!(original.level() instanceof ServerLevel)) {
//				return;
//			}
//			ItemStack itemStack = playerPatch.getValidItemInHand(InteractionHand.MAIN_HAND);
//			if (!(itemStack.getItem() instanceof RedEyesTachiItem)) {
//				return;
//			}
//			if (!playerPatch.getEntityState().getState(EntityState.ATTACKING)) {
//				return;
//			}
//			if (!(playerPatch.getSkill(SkillSlots.WEAPON_INNATE).getSkill() instanceof BattojutsuSkill battojutsuSkill)) {
//				return;
//			}
//			if (!playerPatch.getServerAnimator().animationPlayer.getRealAnimation().get().in(((ConditionalWeaponInnateSkillAccessorMixin) battojutsuSkill).imaginarycraft$getAttackAnimations())) {
//				return;
//			}
//			// TODO EGO共鸣后改成 400
//			original.addEffect(new MobEffectInstance(LibMobEffects.RED_EYES_HUNTING, 200));
//		});
	}

	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
		controllerRegistrar.add(new AnimationController<>(this, (state) -> PlayState.STOP));
	}

	@Override
	public void createGeoRenderer(@NotNull Consumer<GeoRenderProvider> rendererConsumer) {
		rendererConsumer.accept(new GeoItemRenderProvider<>((GeoModel<RedEyesTachiItem>) (GeoModel<?>) model, (GeoModel<RedEyesTachiItem>) (GeoModel<?>) guiModel, RedEyesTachiItemWeaponRenderer::new));
	}

	@Override
	public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		MobEffectInstance effect = attacker.getEffect(EGOEquipmentMobEffects.RED_EYES_HUNTING);
		if (effect != null) {
			return true;
		}
		return super.hurtEnemy(stack, target, attacker);
	}

	@Override
	public void postHurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		MobEffectInstance effect = attacker.getEffect(EGOEquipmentMobEffects.RED_EYES_HUNTING);
		if (effect != null) {
			int effectDuration = effect.getDuration();
			// TODO EGO共鸣后改成 20
			int increase = 10;
			// TODO EGO共鸣后改成 200
			int max = 100;
			((MobEffectInstanceAccessorMixin) effect).ego_equipment$setDuration(Math.clamp(effectDuration + increase, 0, Math.max(effectDuration, max)));
			((LivingEntityAccessorMixin) attacker).goldenboughs_lib$onEffectUpdated(effect, true, attacker);
		}
	}
}
