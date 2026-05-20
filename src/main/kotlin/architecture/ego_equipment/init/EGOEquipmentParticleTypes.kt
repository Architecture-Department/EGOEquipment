package architecture.ego_equipment.init

import architecture.ego_equipment.client.particle.DyeingMagicCircleParticle
import architecture.ego_equipment.client.particle.magicbullet.MagicBulletMagicCircleParticle
import architecture.ego_equipment.core.EGOEquipment
import com.mojang.serialization.MapCodec
import net.minecraft.core.particles.ParticleOptions
import net.minecraft.core.particles.ParticleType
import net.minecraft.core.particles.SimpleParticleType
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.network.RegistryFriendlyByteBuf
import net.minecraft.network.codec.StreamCodec
import net.neoforged.neoforge.registries.DeferredHolder
import net.neoforged.neoforge.registries.DeferredRegister
import java.util.function.Supplier

object EGOEquipmentParticleTypes {
	val REGISTRY: DeferredRegister<ParticleType<*>> = EGOEquipment.modRegister(BuiltInRegistries.PARTICLE_TYPE)

	val DYEING_MAGIC_CIRCLE: Supplier<ParticleType<DyeingMagicCircleParticle.Options>> = register(
		"dyeing_magic_circle", true, DyeingMagicCircleParticle.Options.CODEC, DyeingMagicCircleParticle.Options.STREAM_CODEC
	)

	val MAGIC_BULLET_MAGIC_CIRCLE: Supplier<ParticleType<MagicBulletMagicCircleParticle.Options>> = register(
		"magic_bullet_magic_circle",
		true,
		MagicBulletMagicCircleParticle.Options.CODEC,
		MagicBulletMagicCircleParticle.Options.STREAM_CODEC
	)

	val SOLEMN_LAMENT_BUTTERFLY_BLACK: DeferredHolder<ParticleType<*>, SimpleParticleType> = registerSimpleParticle(
		"solemn_lament_butterfly_black", true
	)
	val SOLEMN_LAMENT_BUTTERFLY_WHITE: DeferredHolder<ParticleType<*>, SimpleParticleType> = registerSimpleParticle(
		"solemn_lament_butterfly_white", true
	)

	private fun <T : ParticleOptions> register(
		id: String,
		overrideLimiter: Boolean,
		mapCodec: MapCodec<T>,
		streamCodec: StreamCodec<in RegistryFriendlyByteBuf, T>
	): DeferredHolder<ParticleType<*>, ParticleType<T>> =
		register(id) { SpecialParticleType(overrideLimiter, mapCodec, streamCodec) }

	private fun <O : ParticleType<*>> register(
		id: String,
		particleType: Supplier<O>
	): DeferredHolder<ParticleType<*>, O> =
		REGISTRY.register(id, particleType)

	private fun registerSimpleParticle(
		id: String,
		overrideLimiter: Boolean
	): DeferredHolder<ParticleType<*>, SimpleParticleType> =
		register(id) { SimpleParticleType(overrideLimiter) }

	private class SpecialParticleType<T : ParticleOptions>(
		overrideLimitter: Boolean,
		private val codec: MapCodec<T>,
		private val streamCodec: StreamCodec<in RegistryFriendlyByteBuf, T>
	) : ParticleType<T>(overrideLimitter) {
		override fun codec(): MapCodec<T> = codec
		override fun streamCodec(): StreamCodec<in RegistryFriendlyByteBuf, T> = streamCodec
	}
}
