package architecture.ego_equipment.datagen

import architecture.ego_equipment.core.EGOEquipment
import architecture.ego_equipment.init.EGOArmorItems
import architecture.ego_equipment.init.EGOWeaponItems
import architecture.goldenboughs_lib.core.registry.client.LibItemPropertyRenderersRegistrar
import architecture.goldenboughs_lib.mixed.client.IModelBuilder
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.data.PackOutput
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.Item
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder
import net.neoforged.neoforge.client.model.generators.ItemModelProvider
import net.neoforged.neoforge.client.model.generators.ModelFile
import net.neoforged.neoforge.common.data.ExistingFileHelper
import net.neoforged.neoforge.registries.DeferredRegister
import java.util.*

class DatagenItemModel(output: PackOutput, existingFileHelper: ExistingFileHelper) :
	ItemModelProvider(output, EGOEquipment.ID, existingFileHelper) {

	override fun registerModels() {
		withExistingParent(EGOArmorItems.REGISTRY, "item/armor/")
		EGOWeaponItems.REGISTRY.entries.map { it.get() }.forEach { item ->
			val path = item.toString()
			val outputLoc = extendWithFolder(
				if (path.contains(":")) ResourceLocation.parse(path) else ResourceLocation.fromNamespaceAndPath(
					modid,
					path
				)
			)
			if (!existingFileHelper.exists(outputLoc, MODEL)) {
				geoItem(item)
			}
		}
	}

	private fun extendWithFolder(rl: ResourceLocation): ResourceLocation =
		if (rl.path.contains("/")) rl else ResourceLocation.fromNamespaceAndPath(rl.namespace, "$folder/${rl.path}")

	private fun egoArmorItems() {
		withExistingParent(EGOArmorItems.REGISTRY, "item/armor/")
	}

	private fun withExistingParent(registry: DeferredRegister.Items, pathPrefix: String) {
		registry.entries.map { it.id }.forEach {
			IModelBuilder.of(this.withExistingParent(it.path, "item/generated"))
				.`goldenboughs_lib$getTexture`()["layer0"] = it.withPrefix(pathPrefix).toString()
		}
	}

	@Suppress("unused")
	private fun chaosSword(item: Item) {
		val map = linkedMapOf(
			0F to "physics",
			0.1F to "spirit",
			0.2F to "erosion",
			0.3F to "the_soul"
		)
		createModelFile(
			item,
			"weapon/",
			map,
			getParent("item/handheld"),
			LibItemPropertyRenderersRegistrar.CURRENT_LC_DAMAGE_TYPE
		)
	}

	@Suppress("unused")
	private fun creativeRationalityTool(item: Item) {
		val map = linkedMapOf(
			0F to "add",
			1F to "decrease"
		)
		createModelFile(item, "tool/", map, parent = null, LibItemPropertyRenderersRegistrar.MODE_BOOLEAN)
	}

	private fun getParent(name: String): ModelFile.UncheckedModelFile =
		ModelFile.UncheckedModelFile(ResourceLocation.withDefaultNamespace(name))

	fun createModelFile(
		item: Item, prefix: String, textures: Map<Float, String>, parent: ModelFile? = null,
		vararg predicates: ResourceLocation
	) {
		val resourceLocation = Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(item))
		val itemModId = resourceLocation.namespace
		val itemRl = "item/$prefix${resourceLocation.path}"

		val actualParent = parent ?: ModelFile.UncheckedModelFile("item/generated")
		val modelBuilder = getBuilder(item.toString())
			.parent(actualParent)
			.texture("layer0", ResourceLocation.fromNamespaceAndPath(itemModId, itemRl))

		var index = 0
		for ((key, value) in textures) {
			val overrideModelRl = getItemResourceLocation(item, value).withPrefix("item/")
			modelBuilder.override()
				.model(ModelFile.UncheckedModelFile(overrideModelRl))
				.predicate(predicates[Math.min(index, predicates.size - 1)], key)
				.end()

			getBuilder(overrideModelRl.toString())
				.parent(actualParent)
				.texture("layer0", ResourceLocation.fromNamespaceAndPath(itemModId, "${itemRl}_$value"))
			index++
		}
	}

	@Suppress("unused")
	fun createModelFile(item: Item, name: String): ModelFile.UncheckedModelFile =
		ModelFile.UncheckedModelFile(getItemResourceLocation(item, name).withPrefix("item/"))

	private fun getItemResourceLocation(item: Item, name: String): ResourceLocation =
		Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(item)).withSuffix("_$name")

	@Suppress("unused")
	fun specialItem(item: Item, name: String): ItemModelBuilder = basicItem(getItemResourceLocation(item, name))

	@Suppress("unused")
	fun createModelItem(item: Item, parent: ModelFile): ItemModelBuilder {
		val resourceLocation = Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(item))
		return getBuilder(item.toString())
			.parent(parent)
			.texture(
				"layer0",
				ResourceLocation.fromNamespaceAndPath(resourceLocation.namespace, "item/${resourceLocation.path}")
			)
	}

	fun geoItem(item: Item) {
		getBuilder(item.toString()).parent(ModelFile.UncheckedModelFile(ResourceLocation.parse("builtin/entity")))
	}

	@Suppress("unused")
	fun basicItem(item: Item, name: String): ItemModelBuilder =
		basicItem(Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(item)), name)

	@Suppress("unused")
	fun basicItem(item: ResourceLocation, name: String): ItemModelBuilder =
		getBuilder(item.toString())
			.parent(customModelFile("models/item/$name"))
			.texture("layer0", ResourceLocation.fromNamespaceAndPath(item.namespace, "item/${item.path}"))

	fun customModelFile(name: String): ModelFile =
		ModelFile.UncheckedModelFile(EGOEquipment.modRl(name))
}
