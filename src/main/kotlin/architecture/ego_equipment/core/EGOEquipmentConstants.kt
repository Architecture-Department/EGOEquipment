package architecture.ego_equipment.core

import net.minecraft.world.item.Item
import net.neoforged.neoforge.registries.DeferredItem

object EGOEquipmentConstants {
	val EGO_ARMOUR: MutableSet<DeferredItem<out Item>> = HashSet()
	val EGO_WEAPON: MutableSet<DeferredItem<out Item>> = HashSet()
	val EGO_TOOL: MutableSet<DeferredItem<out Item>> = HashSet()

	val REMOTE: MutableSet<DeferredItem<out Item>> = HashSet()
	val MELEE: MutableSet<DeferredItem<out Item>> = HashSet()
	val SPECIAL: MutableSet<DeferredItem<out Item>> = HashSet()
	val GUN: MutableSet<DeferredItem<out Item>> = HashSet()
	val PISTOL: MutableSet<DeferredItem<out Item>> = HashSet()
	val RIFLE: MutableSet<DeferredItem<out Item>> = HashSet()
	val CANNON: MutableSet<DeferredItem<out Item>> = HashSet()
	val CROSSBOW: MutableSet<DeferredItem<out Item>> = HashSet()
	val BOW: MutableSet<DeferredItem<out Item>> = HashSet()
	val KNIFE: MutableSet<DeferredItem<out Item>> = HashSet()
	val HAMMER: MutableSet<DeferredItem<out Item>> = HashSet()
	val FIST: MutableSet<DeferredItem<out Item>> = HashSet()
	val SPEAR: MutableSet<DeferredItem<out Item>> = HashSet()
	val AXE: MutableSet<DeferredItem<out Item>> = HashSet()
	val MACE: MutableSet<DeferredItem<out Item>> = HashSet()
	val SWORDS: MutableSet<DeferredItem<out Item>> = HashSet()

	val HEAD_ARMOR: MutableSet<DeferredItem<out Item>> = HashSet()
	val CHEST_ARMOR: MutableSet<DeferredItem<out Item>> = HashSet()
	val LEG_ARMOR: MutableSet<DeferredItem<out Item>> = HashSet()
	val FOOT_ARMOR: MutableSet<DeferredItem<out Item>> = HashSet()
}
