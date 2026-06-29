package architecture.ego_equipment.datagen

import architecture.ego_equipment.init.item.EgoArmorItems
import architecture.ego_equipment.init.item.EgoWeaponItems
import architecture.ego_equipment.util.EgoEquipUtil
import architecture.goldenboughs_lib.util.LibUtil.rlOf
import architecture.goldenboughs_lib.util.datagen.ItemModelUtil.geoItem
import architecture.goldenboughs_lib.util.datagen.ItemModelUtil.withExistingParent
import architecture.goldenboughs_lib.util.datagen.ModelProviderUtil.extendWithFolder
import net.minecraft.data.PackOutput
import net.minecraft.resources.ResourceLocation
import net.neoforged.neoforge.client.model.generators.ItemModelProvider
import net.neoforged.neoforge.common.data.ExistingFileHelper

class DatagenItemModel(output: PackOutput, existingFileHelper: ExistingFileHelper) :
	ItemModelProvider(output, EgoEquipUtil.ID, existingFileHelper) {

	override fun registerModels() {
		withExistingParent(pathPrefix = "item/armor/", registry = EgoArmorItems.REGISTRY)
		EgoWeaponItems.REGISTRY.entries.map { it.get() }.forEach { item ->
			val path = item.toString()
			val rl = if (path.contains(":")) rlOf(path)
			else rlOf(modid, path)
			val callExtendWithFolder = extendWithFolder(rl)
			val outputLoc: ResourceLocation = callExtendWithFolder
			if (!existingFileHelper.exists(outputLoc, MODEL)) {
				geoItem(item)
			}
			withExistingParent("item/weapon/", "", "gui/", "", item)
		}
	}
}
