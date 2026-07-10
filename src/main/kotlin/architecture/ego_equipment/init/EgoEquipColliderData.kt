package architecture.ego_equipment.init

import architecture.resonator_combat_framework.module.collision.OBBCollider

/**
 * EGO 武器共享碰撞体数据。
 * 定义各武器的 OBB 碰撞体尺寸与偏移，供 WeaponProperty 注册时引用。
 */
object EgoEquipColliderData {
	val LIFE_FOR_A_DAREDEVIL = OBBCollider(
		vertexX = 0.2, vertexY = 0.2, vertexZ = 0.8,
		centerX = 0.0, centerY = 0.0, centerZ = 0.5,
	)
}