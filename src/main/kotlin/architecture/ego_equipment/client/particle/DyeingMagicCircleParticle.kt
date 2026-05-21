package architecture.ego_equipment.client.particle

import architecture.ego_equipment.init.EGOEquipmentParticleTypes
import architecture.goldenboughs_lib.api.AllOpe
import architecture.goldenboughs_lib.client.LibParticleRenderTypes
import com.mojang.blaze3d.vertex.VertexConsumer
import com.mojang.serialization.Codec
import com.mojang.serialization.MapCodec
import com.mojang.serialization.codecs.RecordCodecBuilder
import io.netty.buffer.ByteBuf
import net.minecraft.client.Camera
import net.minecraft.client.multiplayer.ClientLevel
import net.minecraft.client.particle.*
import net.minecraft.client.renderer.LightTexture
import net.minecraft.client.renderer.texture.TextureAtlasSprite
import net.minecraft.core.particles.ParticleOptions
import net.minecraft.core.particles.ParticleType
import net.minecraft.network.codec.ByteBufCodecs
import net.minecraft.network.codec.StreamCodec
import net.minecraft.util.Mth
import org.joml.Quaternionf

open class DyeingMagicCircleParticle : TextureSheetParticle {

	var xRot: Float
	var yRot: Float
	var color: Int = 0xFFFFFF
		set(value) {
			field = value
			setColor((value shl 24).toFloat(), (value shl 16).toFloat(), (value shl 8).toFloat())
		}

	constructor(
		sprite: TextureAtlasSprite,
		level: ClientLevel,
		x: Double,
		y: Double,
		z: Double,
		xRot: Float,
		yRot: Float,
		color: Int,
		radius: Float,
		particleLifeTime: Int
	) : super(level, x, y, z) {
		this.xRot = xRot
		this.yRot = yRot
		this.color = color
		lifetime = particleLifeTime
		setSprite(sprite)
		quadSize = radius
		setSize(radius, radius)
	}

	override fun render(buffer: VertexConsumer, renderInfo: Camera, partialTicks: Float) {
		val quaternionf = Quaternionf()
		quaternionf.rotateX(xRot * Mth.DEG_TO_RAD)
		quaternionf.rotateY(yRot * Mth.DEG_TO_RAD)
		this.renderRotatedQuad(buffer, renderInfo, quaternionf, partialTicks)
	}

	override fun getLightColor(partialTick: Float): Int = LightTexture.FULL_BRIGHT

	override fun getRenderType(): ParticleRenderType = LibParticleRenderTypes.MAGIC_CIRCLE_PARTICLE

	@AllOpe
	class Builder(
		protected val xRot: Float,
		protected val yRot: Float
	) {
		protected var color: Int = 0xFFFFFF
		protected var radius: Float = 0f
		protected var particleLifeTime: Int = 20

		fun color(color: Int): Builder {
			this.color = color
			return this
		}

		fun radius(radius: Float): Builder {
			this.radius = radius
			return this
		}

		fun particleLifeTime(particleLifeTime: Int): Builder {
			this.particleLifeTime = particleLifeTime
			return this
		}

		fun buildOptions(index: Int): Options =
			Options(this.xRot, this.yRot, this.color, this.radius, this.particleLifeTime, index)
	}

	@AllOpe
	data class Options(
		val xRot: Float, val yRot: Float, val color: Int,
		val radius: Float, val particleLifeTime: Int, val index: Int
	) : ParticleOptions {
		companion object {
			val CODEC: MapCodec<Options> = RecordCodecBuilder.mapCodec { instance ->
				instance.group(
					Codec.FLOAT.fieldOf("xRot").forGetter(Options::xRot),
					Codec.FLOAT.fieldOf("yRot").forGetter(Options::yRot),
					Codec.INT.fieldOf("color").forGetter(Options::color),
					Codec.FLOAT.fieldOf("radius").forGetter(Options::radius),
					Codec.INT.fieldOf("particleLifeTime").forGetter(Options::particleLifeTime),
					Codec.INT.fieldOf("index").forGetter(Options::index)
				).apply(instance, ::Options)
			}

			val STREAM_CODEC: StreamCodec<ByteBuf, Options> = StreamCodec.composite(
				ByteBufCodecs.FLOAT, Options::xRot,
				ByteBufCodecs.FLOAT, Options::yRot,
				ByteBufCodecs.INT, Options::color,
				ByteBufCodecs.FLOAT, Options::radius,
				ByteBufCodecs.INT, Options::particleLifeTime,
				ByteBufCodecs.INT, Options::index,
				::Options
			)
		}

		override fun getType(): ParticleType<*> = EGOEquipmentParticleTypes.DYEING_MAGIC_CIRCLE.get()
	}

	open class Provider(private val sprite: SpriteSet) : ParticleProvider<Options> {
		override fun createParticle(
			options: Options, level: ClientLevel, x: Double, y: Double, z: Double,
			xSpeed: Double, ySpeed: Double, zSpeed: Double
		): Particle = DyeingMagicCircleParticle(
			spriteLis[options.index], level, x, y, z,
			options.xRot, options.yRot, options.color, options.radius, options.particleLifeTime
		)

		protected val spriteLis: List<TextureAtlasSprite>
			get() = (sprite as ParticleEngine.MutableSpriteSet).sprites
	}
}
