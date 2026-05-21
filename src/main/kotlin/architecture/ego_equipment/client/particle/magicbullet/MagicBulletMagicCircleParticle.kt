package architecture.ego_equipment.client.particle.magicbullet

import architecture.ego_equipment.client.particle.DyeingMagicCircleParticle
import architecture.ego_equipment.init.EGOEquipmentParticleTypes
import com.mojang.serialization.Codec
import com.mojang.serialization.MapCodec
import com.mojang.serialization.codecs.RecordCodecBuilder
import io.netty.buffer.ByteBuf
import net.minecraft.client.multiplayer.ClientLevel
import net.minecraft.client.particle.Particle
import net.minecraft.client.particle.ParticleEngine
import net.minecraft.client.particle.ParticleProvider
import net.minecraft.client.particle.SpriteSet
import net.minecraft.client.renderer.texture.TextureAtlasSprite
import net.minecraft.core.particles.ParticleType
import net.minecraft.network.codec.ByteBufCodecs
import net.minecraft.network.codec.StreamCodec

class MagicBulletMagicCircleParticle(
	sprite: TextureAtlasSprite,
	level: ClientLevel,
	x: Double, y: Double, z: Double,
	xRot: Float, yRot: Float,
	radius: Float,
	particleLifeTime: Int
) : DyeingMagicCircleParticle(sprite, level, x, y, z, xRot, yRot, 0xFFFFFF, radius, particleLifeTime) {

	class Builder(xRot: Float, yRot: Float) : DyeingMagicCircleParticle.Builder(xRot, yRot) {
		override fun radius(radius: Float): Builder {
			super.radius(radius)
			return this
		}

		override fun particleLifeTime(particleLifeTime: Int): Builder {
			super.particleLifeTime(particleLifeTime)
			return this
		}

		override fun buildOptions(index: Int): Options =
			Options(this.xRot, this.yRot, this.radius, this.particleLifeTime, index)
	}

	class Options(
		override val xRot: Float,
		override val yRot: Float,
		override val radius: Float,
		override val particleLifeTime: Int,
		override val index: Int
	) : DyeingMagicCircleParticle.Options(
		xRot,
		yRot,
		-1,
		radius,
		particleLifeTime, index
	) {

		companion object {
			val CODEC: MapCodec<Options> = RecordCodecBuilder.mapCodec { instance ->
				instance.group(
					Codec.FLOAT.fieldOf("xRot").forGetter(Options::xRot),
					Codec.FLOAT.fieldOf("yRot").forGetter(Options::yRot),
					Codec.FLOAT.fieldOf("radius").forGetter(Options::radius),
					Codec.INT.fieldOf("particleLifeTime").forGetter(Options::particleLifeTime),
					Codec.INT.fieldOf("index").forGetter(Options::index)
				).apply(instance, ::Options)
			}

			val STREAM_CODEC: StreamCodec<ByteBuf, Options> = StreamCodec.composite(
				ByteBufCodecs.FLOAT, Options::xRot,
				ByteBufCodecs.FLOAT, Options::yRot,
				ByteBufCodecs.FLOAT, Options::radius,
				ByteBufCodecs.INT, Options::particleLifeTime,
				ByteBufCodecs.INT, Options::index,
				::Options
			)
		}

		override fun getType(): ParticleType<*> = EGOEquipmentParticleTypes.MAGIC_BULLET_MAGIC_CIRCLE.get()
	}

	class Provider(sprite: SpriteSet) : ParticleProvider<Options> {
		private val sprite = sprite

		override fun createParticle(
			options: Options, level: ClientLevel,
			x: Double, y: Double, z: Double,
			xSpeed: Double, ySpeed: Double, zSpeed: Double
		): Particle = MagicBulletMagicCircleParticle(
			spriteLis[options.index], level, x, y, z,
			options.xRot, options.yRot, options.radius, options.particleLifeTime
		)

		protected val spriteLis: List<TextureAtlasSprite>
			get() = (sprite as ParticleEngine.MutableSpriteSet).sprites
	}
}
