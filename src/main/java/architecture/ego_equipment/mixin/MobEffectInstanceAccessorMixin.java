package architecture.ego_equipment.mixin;

import net.minecraft.world.effect.MobEffectInstance;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(MobEffectInstance.class)
public interface MobEffectInstanceAccessorMixin {
	@Accessor("duration")
	int ego_equipment$getDuration();

	@Accessor("duration")
	void ego_equipment$setDuration(int value);
}
