package architecture.ego_equipment.mixin;

import net.minecraft.world.effect.MobEffectInstance;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(MobEffectInstance.class)
public interface MobEffectInstanceAccessorMixin {
	@Accessor
	int getDuration();

	@Accessor
	void setDuration(int value);
}
