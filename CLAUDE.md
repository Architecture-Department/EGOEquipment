# E.G.O.Equipment

E.G.O. 装备模组。~110 武器（近战/远程/特殊）+ ~30 护甲套装（5 风险等级）。

## 项目结构

```
src/main/
├── java/architecture/ego_equipment/
│   └── mixin/
│       └── MobEffectInstanceAccessorMixin.java  — 公开 MobEffectInstance.duration
│
└── kotlin/architecture/ego_equipment/
    ├── core/
    │   ├── EGOEquipment.kt         — @Mod("ego_equipment") 入口
    │   ├── EGOEquipmentClient.kt   — 客户端入口
    │   ├── EGOEquipmentConstants.kt — 运行时分类集合
    │   └── registry/
    │       ├── GuiLayerRegistry.kt
    │       ├── ParticleProvidersRegistry.kt
    │       └── client/EntityRenderersRegistry.kt
    ├── init/
    │   ├── EGOWeaponItems.kt       — ~110 武器 Builder 注册
    │   ├── EGOArmorItems.kt        — ~30 护甲套装 Builder 注册
    │   ├── EGOEquipmentArmorMaterials.kt — 5 护甲材料 (zayin/teth/he/waw/aleph)
    │   ├── EGOEquipmentMobEffects.kt — RED_EYES_HUNTING 状态效果
    │   ├── EGOEquipmentParticleTypes.kt — 4 粒子类型
    │   ├── EGOEquipmentSoundEvents.kt  — 9 音效
    │   ├── EGOEquipmentProjectileEntityTypes.kt — 2 弹射物实体类型
    │   └── tag/EquipmentItemTags.kt
    ├── common/
    │   ├── entity/projectile/
    │   │   ├── MagicBulletEntity.kt      — 追踪制导子弹（支持穿透）
    │   │   └── ParadiseLostSpikeweed.kt  — 失乐园尖刺
    │   └── item/
    │       ├── armor/EgoArmorItem.kt     — 护甲基类 (IEgoItem + IItemUsageReq)
    │       └── weapon/
    │           ├── EgoWeaponItem.kt      — 武器抽象基类
    │           ├── melee/                — 近战武器 (axe/fist/hammer/knife/mace/spear/swords/special)
    │           │   └── special/          — 特殊近战 (~27 种)
    │           └── remote/               — 远程武器 (cannon/crossbow/gun/special)
    │               └── gun/              — 枪械 (GunEgoWeaponItem 蓄力/瞄准)
    ├── client/
    │   ├── gui/hudlayers/
    │   │   ├── GunChargeUpHudLayer.kt   — 枪械蓄力条 HUD
    │   │   └── RedEyesTachiChopFlavor.kt — 赤瞳太刀斩击特效
    │   ├── particle/                    — 魔法阵/蝴蝶粒子
    │   └── renderer/
    │       ├── entity/MagicBulletRenderer.kt
    │       └── item/                     — 魔弹魔法阵/赤瞳太刀物品渲染器
    ├── events/
    │   ├── ClientEvents.kt
    │   └── client/PlayerRenderEvents.kt
    └── datagen/                         — 数据生成（物品模型/粒子/音效/标签/i18n）
```

## 武器系统

按模板类型分类，Builder 模式注册：

| 风险等级  | 数量  | 示例                                                 |
|-------|-----|----------------------------------------------------|
| ZAYIN | 3   | SODA, PENITENCE, WINGBEAT                          |
| TETH  | ~22 | RED_EYES, RED_EYES_TACHI, HORN, REGRET, LANTERN    |
| HE    | ~18 | CRIMSON_SCAR, COBALT_SCAR, GRINDER_MK4, OUR_GALAXY |
| WAW   | ~24 | MAGIC_BULLET, SOLEMN_LAMENT, TWILIGHT, ECSTASY     |
| ALEPH | ~9  | MIMICRY, JUSTITIA, PARADISE_LOST, CENSORED, PINK   |

武器类型层次：

- **Melee**: AXE / FIST / HAMMER / KNIFE / MACE / SPEAR / SWORDS + 27 特殊
- **Remote**: CANNON / PISTOL / RIFLE / CROSSBOW / GUN + 7 特殊
- 每种武器指定 LcLevel + LcDamageType + 美德使用要求

## 护甲系统

- 5 风险等级护甲材料 (zayin/teth/he/waw/aleph)
- 三件套（胸甲/护腿/靴子）* ~30 套装
- 四种伤害类型减免系数 (physics/spirit/erosion/theSoul)
- GeckoLib 3D 模型渲染

## 枪械系统

- `GunEgoWeaponItem` — 蓄力/瞄准/射击机制
- 支持主手/副手使用
- 基于 `DelayTaskHolder` 的射击执行
- 具体枪械：MagicBullet, SolemnLament, Pink(ALEPH), Adoration(ALEPH)

## 关键类

- `EGOWeaponItems` — 武器注册中心，模板工厂模式按类型创建
- `EGOArmorItems` — 护甲注册中心，Builder 模式配置减免系数
- `EgoWeaponItem` — 武器抽象基类 (implements IEgoWeaponItem, IItemUsageReq, IItemLcDamageType)
- `MagicBulletEntity` — 追踪弹射物（100 tick 飞行，支持穿透/穿墙）
- `MobEffectInstanceAccessorMixin` — 公开 duration 字段的 `@Accessor` Mixin

## 上游依赖

- **GoldenBoughsLib** — IEgoItem/IEgoWeaponItem/IMeleeEgoWeaponItem/IRemoteEgoWeaponItem
  接口，LcLevel/LcDamageType，GunWeaponUtil，LibAttributes
- **ResonatorCombatFramework** — 战斗框架
