package architecture.ego_equipment.client.particle.solemnlament

import net.minecraft.client.multiplayer.ClientLevel
import net.minecraft.client.particle.ParticleProvider
import net.minecraft.client.particle.ParticleRenderType
import net.minecraft.client.particle.SpriteSet
import net.minecraft.client.particle.TextureSheetParticle
import net.minecraft.core.particles.SimpleParticleType
import net.neoforged.api.distmarker.Dist
import net.neoforged.api.distmarker.OnlyIn

class ButterflyParticle(
	private val spriteSet: SpriteSet,
	level: ClientLevel,
	x: Double, y: Double, z: Double,
	xSpeed: Double, ySpeed: Double, zSpeed: Double
) : TextureSheetParticle(level, x, y, z, xSpeed, ySpeed, zSpeed) {

	init {
		this.setSpriteFromAge(spriteSet)
		this.lifetime = 8 + this.random.nextInt(4)
		this.quadSize = 0.15F + (this.random.nextFloat() * 0.1f)
		this.setSize(quadSize, quadSize)
	}

	override fun getQuadSize(scaleFactor: Float): Float {
		val f = (this.age.toFloat() + scaleFactor) / this.lifetime.toFloat()
		return this.quadSize * (1.0F - f * f * 0.5F)
	}

	override fun getRenderType(): ParticleRenderType = ParticleRenderType.PARTICLE_SHEET_OPAQUE

	override fun tick() {
		if (this.age++ >= this.lifetime) {
			this.remove()
		} else {
			this.setSpriteFromAge(this.spriteSet)
		}
	}

	@OnlyIn(Dist.CLIENT)
	class Provider(private val sprites: SpriteSet) : ParticleProvider<SimpleParticleType> {
		override fun createParticle(
			type: SimpleParticleType, level: ClientLevel,
			x: Double, y: Double, z: Double,
			xSpeed: Double, ySpeed: Double, zSpeed: Double
		): ButterflyParticle = ButterflyParticle(sprites, level, x, y, z, xSpeed, ySpeed, zSpeed)
	}
}
