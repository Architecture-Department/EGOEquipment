package architecture.ego_equipment.init;

import architecture.ego_equipment.client.particle.DyeingMagicCircleParticle;
import architecture.ego_equipment.client.particle.magicbullet.MagicBulletMagicCircleParticle;
import architecture.ego_equipment.core.EGOEquipment;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

/**
 * 粒子类型
 */
public final class EGOEquipmentParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = EGOEquipment.modRegister(BuiltInRegistries.PARTICLE_TYPE);

	public static final Supplier<ParticleType<DyeingMagicCircleParticle.Options>> DYEING_MAGIC_CIRCLE = register(
		"dyeing_magic_circle", true, DyeingMagicCircleParticle.Options.CODEC, DyeingMagicCircleParticle.Options.STREAM_CODEC);

	public static final Supplier<ParticleType<MagicBulletMagicCircleParticle.Options>> MAGIC_BULLET_MAGIC_CIRCLE = register(
		"magic_bullet_magic_circle", true, MagicBulletMagicCircleParticle.Options.CODEC, MagicBulletMagicCircleParticle.Options.STREAM_CODEC);

	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> SOLEMN_LAMENT_BUTTERFLY_BLACK = registerSimpleParticle(
		"solemn_lament_butterfly_black", true);
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> SOLEMN_LAMENT_BUTTERFLY_WHITE = registerSimpleParticle(
		"solemn_lament_butterfly_white", true);

	private static <T extends ParticleOptions> @NotNull DeferredHolder<ParticleType<?>, ParticleType<T>> register(
		String id,
		boolean overrideLimiter,
		MapCodec<T> mapCodec,
		StreamCodec<? super RegistryFriendlyByteBuf, T> streamCodec
	) {
		return register(
			id, () -> new SpecialParticleType<>(overrideLimiter, mapCodec, streamCodec));
	}

	private static <O extends ParticleType<?>> DeferredHolder<ParticleType<?>, O> register(String id, Supplier<O> particleType) {
		return EGOEquipmentParticleTypes.REGISTRY.register(id, particleType);
	}

	private static DeferredHolder<ParticleType<?>, SimpleParticleType> registerSimpleParticle(String id, boolean overrideLimiter) {
		return register(id, () -> new SimpleParticleType(overrideLimiter));
	}

	private static class SpecialParticleType<T extends ParticleOptions> extends ParticleType<T> {
		private final StreamCodec<? super RegistryFriendlyByteBuf, T> streamCodec;
		private final MapCodec<T> codec;

		private SpecialParticleType(
			final boolean overrideLimitter,
			MapCodec<T> codec,
			StreamCodec<? super RegistryFriendlyByteBuf, T> streamCodec
		) {
			super(overrideLimitter);
			this.codec = codec;
			this.streamCodec = streamCodec;
		}

		@Override
		public MapCodec<T> codec() {
			return codec;
		}

		@Override
		public StreamCodec<? super RegistryFriendlyByteBuf, T> streamCodec() {
			return streamCodec;
		}
	}
}
