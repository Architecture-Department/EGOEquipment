package architecture.ego_equipment.datagen

import architecture.ego_equipment.init.EgoEquipParticleTypes
import architecture.ego_equipment.util.EgoEquipUtil
import net.minecraft.core.particles.ParticleType
import net.minecraft.data.PackOutput
import net.neoforged.neoforge.common.data.ExistingFileHelper
import net.neoforged.neoforge.common.data.ParticleDescriptionProvider
import java.util.function.Supplier

class DatagenParticle(output: PackOutput, fileHelper: ExistingFileHelper) :
	ParticleDescriptionProvider(output, fileHelper) {

	override fun addDescriptions() {
		sprite(
			EgoEquipParticleTypes.DYEING_MAGIC_CIRCLE,
			"magic_circle/magic_circle16x",
			"magic_circle/magic_circle32x",
			"magic_circle/magic_circle128x"
		)
		sprite(
			EgoEquipParticleTypes.MAGIC_BULLET_MAGIC_CIRCLE,
			"magic_bullet/magic_circle16x",
			"magic_bullet/magic_circle32x",
			"magic_bullet/magic_circle128x"
		)
		sprite(EgoEquipParticleTypes.SOLEMN_LAMENT_BUTTERFLY_BLACK, "solemn_lament/butterfly_black")
		sprite(EgoEquipParticleTypes.SOLEMN_LAMENT_BUTTERFLY_WHITE, "solemn_lament/butterfly_white")
	}

	private fun <T : ParticleType<*>> sprite(type: Supplier<T>, name: String) {
		sprite(type.get(), EgoEquipUtil.modRl(name))
	}

	private fun <T : ParticleType<*>> sprite(type: Supplier<T>, vararg names: String) {
		spriteSet(type.get(), names.map { EgoEquipUtil.modRl(it) }.toList())
	}
}
