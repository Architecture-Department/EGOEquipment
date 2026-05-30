package architecture.ego_equipment.datagen.tag

import architecture.ego_equipment.core.EGOEquipmentConstants
import net.minecraft.core.HolderLookup
import net.minecraft.data.PackOutput
import net.neoforged.neoforge.common.data.BlockTagsProvider
import net.neoforged.neoforge.common.data.ExistingFileHelper
import java.util.concurrent.CompletableFuture

class DatagenBlockTag(
	output: PackOutput,
	lookupProvider: CompletableFuture<HolderLookup.Provider>,
	existingFileHelper: ExistingFileHelper?
) : BlockTagsProvider(output, lookupProvider, EGOEquipmentConstants.ID, existingFileHelper) {

	override fun addTags(provider: HolderLookup.Provider) {
	}
}
