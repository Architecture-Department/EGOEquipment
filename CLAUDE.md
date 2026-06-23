# E.G.O.Equipment

Mod ID: `ego_equipment`

装备模组。~110 武器（近战/远程/特殊）+ ~30 护甲套装（5 风险等级），GeckoLib 3D 模型渲染。

## 包结构

- `core/` — `EGOEquipment.kt`(@Mod), `EGOEquipmentClient.kt`, 常量, 注册表
- `init/` — 物品注册（EGOWeaponItems, EGOArmorItems）, 状态效果, 粒子类型, 音效, 弹射物, 标签
  - `init/item/` — 武器/护甲模板注册
- `common/`
  - `entity/projectile/` — 弹射物实体（MagicBullet, ParadiseLostSpikeweed）
  - `item/armor/` — 护甲基类
  - `item/weapon/` — 武器基类 + melee/remote 子分类（axe, fist, hammer, knife, mace, spear, swords, special, cannon,
    crossbow, gun）
- `client/` — HUD层（蓄力条、斩击特效）、粒子（魔法阵、蝴蝶）、渲染器（弹射物、物品）
- `events/` — 事件监听器（ClientEvents, PlayerRenderEvents）
- `datagen/` — 数据生成
- `mixin/java/` — `MobEffectInstanceAccessor`

## 武器系统

Builder 模式注册，按模板类型分类，指定 LcLevel + LcDamageType + 美德要求。

## 护甲系统

5 风险等级材料（zayin/teth/he/waw/aleph），三件套，四色伤害减免系数。

## 依赖

- **GoldenBoughsLib** — 接口、伤害系统、属性
- **ResonatorCombatFramework** — 战斗框架

由 ImaginaryCraft 模块 jarJar 聚合。
