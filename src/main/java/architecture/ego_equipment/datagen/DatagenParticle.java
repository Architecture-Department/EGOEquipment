package architecture.ego_equipment.datagen;

import architecture.ego_equipment.core.EGOEquipment;
import architecture.ego_equipment.init.EGOEquipmentParticleTypes;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.ParticleDescriptionProvider;

import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public final class DatagenParticle extends ParticleDescriptionProvider {
	public DatagenParticle(PackOutput output, ExistingFileHelper fileHelper) {
		super(output, fileHelper);
	}

	@Override
	protected void addDescriptions() {
		sprite(EGOEquipmentParticleTypes.DYEING_MAGIC_CIRCLE, "magic_circle/magic_circle16x", "magic_circle/magic_circle32x", "magic_circle/magic_circle128x");
		sprite(EGOEquipmentParticleTypes.MAGIC_BULLET_MAGIC_CIRCLE, "magic_bullet/magic_circle16x", "magic_bullet/magic_circle32x", "magic_bullet/magic_circle128x");
		sprite(EGOEquipmentParticleTypes.SOLEMN_LAMENT_BUTTERFLY_BLACK, "solemn_lament/butterfly_black");
		sprite(EGOEquipmentParticleTypes.SOLEMN_LAMENT_BUTTERFLY_WHITE, "solemn_lament/butterfly_white");
	}

	private <T extends ParticleType<?>> void sprite(Supplier<T> type, String name) {
		sprite(type.get(), EGOEquipment.modRl(name));
	}

	private <T extends ParticleType<?>> void sprite(Supplier<T> type, String... names) {
		spriteSet(type.get(), Arrays.stream(names)
			.map(EGOEquipment::modRl)
			.collect(Collectors.toList()));
	}
}
