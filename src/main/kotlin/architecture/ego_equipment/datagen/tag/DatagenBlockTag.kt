package architecture.ego_equipment.datagen.tag

import architecture.ego_equipment.core.EGOEquipment
import net.minecraft.core.HolderLookup
import net.minecraft.data.PackOutput
import net.neoforged.neoforge.common.data.BlockTagsProvider
import net.neoforged.neoforge.common.data.ExistingFileHelper

class DatagenBlockTag(
	output: PackOutput,
	lookupProvider: CompletableFuture<HolderLookup.Provider>,
	existingFileHelper: ExistingFileHelper?
) : BlockTagsProvider(output, lookupProvider, EGOEquipment.ID, existingFileHelper) {

	override fun addTags(provider: HolderLookup.Provider) {
	}
}
