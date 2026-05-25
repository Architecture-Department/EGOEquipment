package architecture.ego_equipment.datagen

import architecture.ego_equipment.core.EGOEquipmentConstants
import architecture.ego_equipment.init.item.EGOArmorItems
import architecture.ego_equipment.init.item.EGOWeaponItems
import architecture.goldenboughs_lib.util.LibUtil.rlOf
import architecture.goldenboughs_lib.util.client.DatagenItemModelUtil.geoItem
import architecture.goldenboughs_lib.util.client.DatagenItemModelUtil.withExistingParent
import architecture.goldenboughs_lib.util.client.ModelProviderUtil.extendWithFolder
import net.minecraft.data.PackOutput
import net.minecraft.resources.ResourceLocation
import net.neoforged.neoforge.client.model.generators.ItemModelProvider
import net.neoforged.neoforge.common.data.ExistingFileHelper

class DatagenItemModel(output: PackOutput, existingFileHelper: ExistingFileHelper) :
	ItemModelProvider(output, EGOEquipmentConstants.ID, existingFileHelper) {

	override fun registerModels() {
		withExistingParent("item/armor/", EGOArmorItems.REGISTRY)
		EGOWeaponItems.REGISTRY.entries.map { it.get() }.forEach { item ->
			val path = item.toString()
			val rl = if (path.contains(":")) rlOf(path)
			else rlOf(modid, path)
			val callExtendWithFolder = extendWithFolder(rl)
			val outputLoc: ResourceLocation = callExtendWithFolder
			if (!existingFileHelper.exists(outputLoc, MODEL)) {
				geoItem(item)
			}
		}
	}
}
