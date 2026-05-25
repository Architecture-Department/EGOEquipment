package architecture.ego_equipment.core

import architecture.goldenboughs_lib.util.LibUtil.rlOf
import net.minecraft.core.Registry
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.neoforged.neoforge.registries.DeferredRegister
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import net.minecraft.world.item.Item
import net.neoforged.neoforge.registries.DeferredItem
import org.jetbrains.annotations.Contract

object EGOEquipmentConstants {
	const val ID: String = "ego_equipment"
	const val NAME: String = "E.G.O.Equipment"

	@JvmField
	val LOGGER: Logger = LogManager.getLogger(ID)

	@JvmStatic
	@Contract("_ -> new")
	fun modRl(name: String): ResourceLocation {
		return rlOf(ID, name)
	}

	@JvmStatic
	@Contract(pure = true)
	fun modRlText(name: String): String {
		return "$ID:$name"
	}

	@JvmStatic
	fun <T> modRegister(registry: Registry<T>): DeferredRegister<T> {
		return DeferredRegister.create<T>(registry, ID)
	}

	@JvmStatic
	fun <T> modRegister(registry: ResourceKey<Registry<T>>): DeferredRegister<T> {
		return DeferredRegister.create<T>(registry, ID)
	}

	// Item collection sets for tag generation
	@JvmField
	val EGO_ARMOUR: MutableSet<DeferredItem<out Item>> = HashSet()

	@JvmField
	val EGO_TOOL: MutableSet<DeferredItem<out Item>> = HashSet()

	@JvmField
	val EGO_WEAPON: MutableSet<DeferredItem<out Item>> = HashSet()

	@JvmField
	val HEAD_ARMOR: MutableSet<DeferredItem<out Item>> = HashSet()

	@JvmField
	val CHEST_ARMOR: MutableSet<DeferredItem<out Item>> = HashSet()

	@JvmField
	val LEG_ARMOR: MutableSet<DeferredItem<out Item>> = HashSet()

	@JvmField
	val FOOT_ARMOR: MutableSet<DeferredItem<out Item>> = HashSet()

	@JvmField
	val MELEE: MutableSet<DeferredItem<out Item>> = HashSet()

	@JvmField
	val KNIFE: MutableSet<DeferredItem<out Item>> = HashSet()

	@JvmField
	val HAMMER: MutableSet<DeferredItem<out Item>> = HashSet()

	@JvmField
	val FIST: MutableSet<DeferredItem<out Item>> = HashSet()

	@JvmField
	val SPEAR: MutableSet<DeferredItem<out Item>> = HashSet()

	@JvmField
	val MACE: MutableSet<DeferredItem<out Item>> = HashSet()

	@JvmField
	val SWORDS: MutableSet<DeferredItem<out Item>> = HashSet()

	@JvmField
	val GUN: MutableSet<DeferredItem<out Item>> = HashSet()

	@JvmField
	val CANNON: MutableSet<DeferredItem<out Item>> = HashSet()

	@JvmField
	val PISTOL: MutableSet<DeferredItem<out Item>> = HashSet()

	@JvmField
	val RIFLE: MutableSet<DeferredItem<out Item>> = HashSet()

	@JvmField
	val REMOTE: MutableSet<DeferredItem<out Item>> = HashSet()

	@JvmField
	val SPECIAL: MutableSet<DeferredItem<out Item>> = HashSet()

	@JvmField
	val BOW: MutableSet<DeferredItem<out Item>> = HashSet()

	@JvmField
	val CROSSBOW: MutableSet<DeferredItem<out Item>> = HashSet()

	@JvmField
	val AXE: MutableSet<DeferredItem<out Item>> = HashSet()

}
