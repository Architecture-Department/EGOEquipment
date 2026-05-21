package architecture.ego_equipment.datagen

import architecture.ego_equipment.core.EGOEquipment
import architecture.ego_equipment.datagen.i18n.ZhCn
import architecture.ego_equipment.datagen.tag.DatagenBlockTag
import architecture.ego_equipment.datagen.tag.DatagenItemTag
import net.minecraft.core.RegistrySetBuilder
import net.minecraft.data.DataGenerator
import net.minecraft.data.DataProvider
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.neoforge.data.event.GatherDataEvent

@EventBusSubscriber(modid = EGOEquipment.ID)
object Datagen {
	@SubscribeEvent
	fun gatherData(event: GatherDataEvent) {
		val generator = event.generator
		val output = generator.packOutput
		val completableFuture = event.lookupProvider
		val existingFileHelper = event.existingFileHelper

		buildServer(event, generator, ModDatagenDatapackBuiltinEntries(output, completableFuture, RegistrySetBuilder()))

		val blockTag = DatagenBlockTag(output, completableFuture, existingFileHelper)
		buildServer(event, generator, blockTag)
		buildServer(
			event,
			generator,
			DatagenItemTag(output, completableFuture, blockTag.contentsGetter(), existingFileHelper)
		)

		buildClient(event, generator, DatagenParticle(output, existingFileHelper))
		buildClient(event, generator, ZhCn(output))
		buildClient(event, generator, DatagenItemModel(output, existingFileHelper))
	}

	private fun <T : DataProvider> buildClient(event: GatherDataEvent, generator: DataGenerator, provider: T): T =
		generator.addProvider(event.includeClient(), provider)

	private fun <T : DataProvider> buildServer(event: GatherDataEvent, generator: DataGenerator, provider: T): T =
		generator.addProvider(event.includeServer(), provider)
}
