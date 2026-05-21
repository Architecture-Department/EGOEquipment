package architecture.ego_equipment.init

import architecture.ego_equipment.common.item.weapon.melee.MeleeEgoWeaponItem
import architecture.ego_equipment.common.item.weapon.melee.axe.AxeEgoWeaponGeoItem
import architecture.ego_equipment.common.item.weapon.melee.fist.FistEgoWeaponItem
import architecture.ego_equipment.common.item.weapon.melee.hammer.HammerEgoWeaponItem
import architecture.ego_equipment.common.item.weapon.melee.knife.KnifeEgoWeaponItem
import architecture.ego_equipment.common.item.weapon.melee.mace.MaceEgoWeaponItem
import architecture.ego_equipment.common.item.weapon.melee.spear.SpearEgoWeaponItem
import architecture.ego_equipment.common.item.weapon.melee.special.*
import architecture.ego_equipment.common.item.weapon.melee.swords.SwordsEgoWeaponGeoItem
import architecture.ego_equipment.common.item.weapon.remote.RemoteEgoWeaponItem
import architecture.ego_equipment.common.item.weapon.remote.cannon.CannonEgoWeaponItem
import architecture.ego_equipment.common.item.weapon.remote.crossbow.CrossbowEgoWeaponGeoItem
import architecture.ego_equipment.common.item.weapon.remote.gun.MagicBulletWeaponItem
import architecture.ego_equipment.common.item.weapon.remote.gun.PistolEgoWeaponItem
import architecture.ego_equipment.common.item.weapon.remote.gun.SolemnLamentWeaponItem
import architecture.ego_equipment.common.item.weapon.remote.gun.pistol.PinkWeaponItem
import architecture.ego_equipment.common.item.weapon.remote.gun.rifle.RifleEgoWeaponItem
import architecture.ego_equipment.common.item.weapon.remote.special.*
import architecture.ego_equipment.core.EGOEquipment
import architecture.ego_equipment.core.EGOEquipmentConstants
import architecture.ego_equipment.datagen.i18n.ZhCn
import architecture.goldenboughs_lib.api.LcDamageType
import architecture.goldenboughs_lib.api.LcLevel
import architecture.goldenboughs_lib.api.virtue.VirtueRating
import architecture.goldenboughs_lib.api.world.item.IEgoItem
import architecture.goldenboughs_lib.api.world.item.IMeleeEgoWeaponItem
import architecture.goldenboughs_lib.api.world.item.IRemoteEgoWeaponItem
import architecture.goldenboughs_lib.util.LcLevelUtil
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.BlockTags
import net.minecraft.tags.TagKey
import net.minecraft.world.item.Item
import net.minecraft.world.item.crafting.Ingredient
import net.minecraft.world.level.block.Block
import net.neoforged.neoforge.common.SimpleTier
import net.neoforged.neoforge.registries.DeferredItem
import net.neoforged.neoforge.registries.DeferredRegister
import java.util.function.BiFunction
import java.util.function.Function

object EGOWeaponItems {
	val REGISTRY = DeferredRegister.createItems(EGOEquipment.ID)

	//region ZAYIN
	val SODA = onRemote<RemoteEgoWeaponItem>()
		.id("soda_weapon")
		.zhName("美味苏打")
		.lcLevelType(LcLevel.ZAYIN)
		.type(RemoteTemplateType.PISTOL)
		.properties(Item.Properties())
		.weaponBuilder {
			it
				.damage(0.667f)
				.meleeLcDamageType(LcDamageType.PHYSICS)
				.virtueUsageReq(null, null, null, null, null)
		}
		.model(EGOEquipment.modRl("weapon/soda"))
		.buildAndRegister()

	val PENITENCE = onMelee<MeleeEgoWeaponItem>()
		.id("penitence_weapon")
		.zhName("忏悔")
		.lcLevelType(LcLevel.ZAYIN)
		.type(MeleeTemplateType.MACE)
		.properties(Item.Properties())
		.properties {
			it
				.damage(6f)
				.meleeLcDamageType(LcDamageType.SPIRIT)
				.virtueUsageReq(null, null, null, null, null)
		}
		.model(EGOEquipment.modRl("weapon/penitence"))
		.buildAndRegister()

	val WINGBEAT = onMelee<MeleeEgoWeaponItem>()
		.id("wingbeat_weapon")
		.zhName("翅振")
		.lcLevelType(LcLevel.ZAYIN)
		.type(MeleeTemplateType.MACE)
		.properties(Item.Properties())
		.properties {
			it
				.damage(6f)
				.meleeLcDamageType(LcDamageType.PHYSICS)
				.virtueUsageReq(null, null, null, null, null)
		}
		.model(EGOEquipment.modRl("weapon/wingbeat"))
		.buildAndRegister()
	//endregion

	//region TETH
	// TODO 理解 的数值需要调整
	// TODO 实装效果
	val COMPREHENSION_TETH = onMelee<MeleeEgoWeaponItem>()
		.id("comprehension_teth_weapon")
		.zhName("理解")
		.lcLevelType(LcLevel.TETH)
		.type(MeleeTemplateType.SWORDS)
		.properties(Item.Properties())
		.properties {
			it
				.damage(6f)
				.meleeLcDamageType(LcDamageType.EROSION)
				.virtueUsageReq(null, null, null, null, null)
		}
		.model(EGOEquipment.modRl("weapon/comprehension_teth"))
		.buildAndRegister()

	// TODO 理解 的数值需要调整
	// TODO 实装效果
	val COMPREHENSION_HE = onMelee<MeleeEgoWeaponItem>()
		.id("comprehension_he_weapon")
		.zhName("理解")
		.lcLevelType(LcLevel.HE)
		.type(MeleeTemplateType.SWORDS)
		.properties(Item.Properties())
		.properties {
			it
				.damage(6f)
				.meleeLcDamageType(LcDamageType.EROSION)
				.virtueUsageReq(null, null, null, null, null)
		}
		.model(EGOEquipment.modRl("weapon/comprehension_he"))
		.buildAndRegister()

	val FOURTH_MATCH_FLAME = onRemote<RemoteEgoWeaponItem>()
		.id("fourth_match_flame_weapon")
		.zhName("终末火柴之光")
		.lcLevelType(LcLevel.TETH)
		.type(RemoteTemplateType.CANNON)
		.properties(Item.Properties())
		.weaponBuilder {
			it
				.damage(25f)
				.meleeLcDamageType(LcDamageType.PHYSICS)
				.virtueUsageReq(null, null, null, null, null)
		}
		.model(EGOEquipment.modRl("weapon/fourth_match_flame"))
		.buildAndRegister()

	val SOLITUDE = onRemote<RemoteEgoWeaponItem>()
		.id("solitude_weapon")
		.zhName("孤独")
		.lcLevelType(LcLevel.TETH)
		.type(RemoteTemplateType.PISTOL)
		.properties(Item.Properties())
		.weaponBuilder {
			it
				.damage(2.5f)
				.meleeLcDamageType(LcDamageType.SPIRIT)
				.virtueUsageReq(null, null, null, null, null)
		}
		.model(EGOEquipment.modRl("weapon/solitude"))
		.buildAndRegister()

	val BEAK = onRemote<RemoteEgoWeaponItem>()
		.id("beak_weapon")
		.zhName("小喙")
		.lcLevelType(LcLevel.TETH)
		.type(RemoteTemplateType.PISTOL)
		.properties(Item.Properties())
		.weaponBuilder {
			it
				.damage(2.5f)
				.meleeLcDamageType(LcDamageType.PHYSICS)
				.virtueUsageReq(null, null, null, null, null)
		}
		.model(EGOEquipment.modRl("weapon/beak"))
		.buildAndRegister()

	val TODAY_IS_EXPRESSION = onRemote<RemoteEgoWeaponItem>()
		.id("today_is_expression_weapon")
		.zhName("此刻的神色")
		.lcLevelType(LcLevel.TETH)
		.type(RemoteTemplateType.PISTOL)
		.properties(Item.Properties())
		.weaponBuilder {
			it
				.damage(2.5f)
				.meleeLcDamageType(LcDamageType.EROSION)
				.virtueUsageReq(null, null, null, null, null)
		}
		.model(EGOEquipment.modRl("weapon/today_is_expression"))
		.buildAndRegister()

	// TODO 只有秃顶或是地中海的帅气员工才能使用这件屌爆的装备！
	// 这是什么阴的没边的效果（
	val TOUGH = onRemote<RemoteEgoWeaponItem>()
		.id("tough_weapon")
		.zhName("谢顶之灾")
		.lcLevelType(LcLevel.TETH)
		.type(RemoteTemplateType.PISTOL)
		.properties(Item.Properties())
		.weaponBuilder {
			it
				.damage(3f)
				.meleeLcDamageType(LcDamageType.SPIRIT)
				.virtueUsageReq(null, null, null, null, null)
		} // TODO 光头（
		.buildAndRegister()

	// TODO 这把武器一次攻击动画会造成三次伤害。
	val ENGULFING_DREAM = onRemote<EngulfingDreamWeaponItem>()
		.id("engulfing_dream_weapon")
		.zhName("迷魂梦境")
		.lcLevelType(LcLevel.TETH)
		.properties(Item.Properties())
		.weaponBuilder {
			it
				.damage(1.5f)
				.attackIntervalMainHand(minuteToSpeedConversion(1f))
				.attackDistance(8f)
				.meleeLcDamageType(LcDamageType.SPIRIT)
				.virtueUsageReq(null, null, null, null, null)
		}
		.model(EGOEquipment.modRl("weapon/engulfing_dream"))
		.buildAndRegister { p, b ->
			EngulfingDreamWeaponItem(
				p,
				b,
				EGOEquipment.modRl("weapon/engulfing_dream")
			)
		}

	// TODO 这把武器一次攻击动画会造成三次伤害。
	val CHERRY_BLOSSOMS = onRemote<CherryBlossomsWeaponItem>()
		.id("cherry_blossoms_weapon")
		.zhName("落樱")
		.lcLevelType(LcLevel.TETH)
		.properties(Item.Properties())
		.weaponBuilder {
			it
				.damage(1.5f)
				.attackIntervalMainHand(minuteToSpeedConversion(1f))
				.attackDistance(5f)
				.meleeLcDamageType(LcDamageType.SPIRIT)
				.virtueUsageReq(null, null, null, null, null)
		}
		.model(EGOEquipment.modRl("weapon/cherry_blossoms"))
		.buildAndRegister { p, b ->
			CherryBlossomsWeaponItem(
				p,
				b,
				EGOEquipment.modRl("weapon/cherry_blossoms")
			)
		}

	// TODO 如果持有者的勇气等级高于2级，进入战斗后会提高2.5点移动速度。
	val RED_EYES = onMelee<MeleeEgoWeaponItem>()
		.id("red_eyes_weapon")
		.zhName("赤瞳")
		.lcLevelType(LcLevel.TETH)
		.type(MeleeTemplateType.MACE)
		.properties(Item.Properties())
		.properties {
			it
				.damage(8f)
				.meleeLcDamageType(LcDamageType.PHYSICS)
				.virtueUsageReq(null, null, null, null, null)
		}
		.model(EGOEquipment.modRl("weapon/red_eyes"))
		.buildAndRegister()

	val RED_EYES_TACHI = onMelee<MeleeEgoWeaponItem>()
		.id("red_eyes_tachi_weapon")
		.zhName("赤瞳-太刀")
		.lcLevelType(LcLevel.TETH)
		.type(MeleeTemplateType.SWORDS)
		.properties(Item.Properties())
		.properties {
			it
				.damage(8f)
				.meleeLcDamageType(LcDamageType.PHYSICS)
				.virtueUsageReq(null, null, null, null, null)
		}
		.buildAndRegister { p, b ->
			RedEyesTachiItem(
				p,
				b,
				EGOEquipment.modRl("weapon/red_eyes_tachi")
			)
		}

	val HORN = onMelee<MeleeEgoWeaponItem>()
		.id("horn_weapon")
		.zhName("犄角")
		.lcLevelType(LcLevel.TETH)
		.type(MeleeTemplateType.SPEAR)
		.properties(Item.Properties())
		.properties {
			it
				.damage(7f)
				.meleeLcDamageType(LcDamageType.PHYSICS)
				.virtueUsageReq(null, null, null, null, null)
		}
		.model(EGOEquipment.modRl("weapon/horn"))
		.buildAndRegister()

	val WRIST_CUTTER = onMelee<MeleeEgoWeaponItem>()
		.id("wrist_cutter_weapon")
		.zhName("割腕者")
		.lcLevelType(LcLevel.TETH)
		.type(MeleeTemplateType.KNIFE)
		.properties(Item.Properties())
		.properties {
			it
				.damage(2.5f)
				.meleeLcDamageType(LcDamageType.SPIRIT)
				.virtueUsageReq(null, null, null, null, null)
		}
		.model(EGOEquipment.modRl("weapon/wrist_cutter"))
		.buildAndRegister()

	val REGRET = onMelee<MeleeEgoWeaponItem>()
		.id("regret_weapon")
		.zhName("悔恨")
		.lcLevelType(LcLevel.TETH)
		.type(MeleeTemplateType.HAMMER)
		.properties(Item.Properties())
		.properties {
			it
				.damage(15f)
				.meleeLcDamageType(LcDamageType.PHYSICS)
				.virtueUsageReq(null, null, null, null, null)
		}
		.model(EGOEquipment.modRl("weapon/regret"))
		.buildAndRegister()

	// TODO 如果持有者的谨慎等级低于5级，进入战斗后有10%的概率提升40%的最大精神值。该效果持续30秒。
	val FRAGMENTS_FROM_SOMEWHERE = onMelee<MeleeEgoWeaponItem>()
		.id("fragments_from_somewhere_weapon")
		.zhName("彼方的裂片")
		.lcLevelType(LcLevel.TETH)
		.type(MeleeTemplateType.SPEAR)
		.properties(Item.Properties())
		.properties {
			it
				.damage(7f)
				.meleeLcDamageType(LcDamageType.EROSION)
				.virtueUsageReq(null, null, null, null, null)
		}
		.model(EGOEquipment.modRl("weapon/fragments_from_somewhere"))
		.buildAndRegister()

	val LANTERN = onMelee<MeleeEgoWeaponItem>()
		.id("lantern_weapon")
		.zhName("诱捕幻灯")
		.lcLevelType(LcLevel.TETH)
		.type(MeleeTemplateType.HAMMER)
		.properties(Item.Properties())
		.properties {
			it
				.damage(15f)
				.meleeLcDamageType(LcDamageType.EROSION)
				.virtueUsageReq(null, null, null, null, null)
		}
		.model(EGOEquipment.modRl("weapon/lantern"))
		.buildAndRegister()

	val SO_CUTE = onMelee<MeleeEgoWeaponItem>()
		.id("so_cute_weapon")
		.zhName("超特么可爱！！！")
		.lcLevelType(LcLevel.TETH)
		.type(MeleeTemplateType.FIST)
		.properties(Item.Properties())
		.properties {
			it
				.damage(5f)
				.meleeLcDamageType(LcDamageType.PHYSICS)
				.virtueUsageReq(null, null, null, null, null)
		}
		.model(EGOEquipment.modRl("weapon/so_cute"))
		.buildAndRegister()

	val STANDARD_TRAINING_EGO = onMelee<MeleeEgoWeaponItem>()
		.id("standard_training_ego_weapon")
		.zhName("教学用E.G.O武器")
		.lcLevelType(LcLevel.TETH)
		.type(MeleeTemplateType.MACE)
		.properties(Item.Properties())
		.properties {
			it
				.damage(6f)
				.meleeLcDamageType(LcDamageType.SPIRIT)
				.virtueUsageReq(null, null, null, null, null)
		}
		.model(EGOEquipment.modRl("weapon/standard_training_ego"))
		.buildAndRegister()
	//endregion

	//region HE
	val SCREAMING_WEDGE = onRemote<RemoteEgoWeaponItem>()
		.id("screaming_wedge_weapon")
		.zhName("刺耳嚎叫")
		.lcLevelType(LcLevel.HE)
		.type(RemoteTemplateType.CROSSBOW)
		.properties(Item.Properties())
		.weaponBuilder {
			it
				.damage(12f)
				.meleeLcDamageType(LcDamageType.SPIRIT)
				.virtueUsageReq(null, VirtueRating.II, null, null, null)
		}
		.model(EGOEquipment.modRl("weapon/screaming_wedge"))
		.buildAndRegister()

	// TODO 如果持有者的生命值维持在10%及以上，那么持有者将消耗一定生命值发动更加强大的攻击。（造成30%的额外伤害）
	val HARMONY = onRemote<RemoteEgoWeaponItem>()
		.id("harmony_weapon")
		.zhName("谐奏放射器")
		.lcLevelType(LcLevel.HE)
		.type(RemoteTemplateType.CANNON)
		.properties(Item.Properties())
		.weaponBuilder {
			it
				.damage(40f)
				.meleeLcDamageType(LcDamageType.SPIRIT)
				.virtueUsageReq(VirtueRating.II, null, null, null, VirtueRating.II)
		}
		.model(EGOEquipment.modRl("weapon/harmony"))
		.buildAndRegister()

	val LAETITIA = onRemote<RemoteEgoWeaponItem>()
		.id("laetitia_weapon")
		.zhName("蕾蒂希娅")
		.lcLevelType(LcLevel.HE)
		.type(RemoteTemplateType.RIFLE)
		.properties(Item.Properties())
		.weaponBuilder {
			it
				.damage(5.5f)
				.meleeLcDamageType(LcDamageType.EROSION)
				.virtueUsageReq(null, null, VirtueRating.II, null, null)
		}
		.model(EGOEquipment.modRl("weapon/laetitia"))
		.buildAndRegister()

	val SYRINX = onRemote<SyrinxWeaponItem>()
		.id("syrinx_weapon")
		.zhName("泣婴")
		.lcLevelType(LcLevel.HE)
		.properties(Item.Properties())
		.weaponBuilder {
			it
				.damage(3f)
				.attackIntervalMainHand(minuteToSpeedConversion(0.5f))
				.attackDistance(10f)
				.meleeLcDamageType(LcDamageType.SPIRIT)
				.virtueUsageReq(null, null, VirtueRating.III, null, null)
		}
		.model(EGOEquipment.modRl("weapon/syrinx"))
		.buildAndRegister { p, b ->
			SyrinxWeaponItem(p, b, EGOEquipment.modRl("weapon/syrinx"))
		}

	// TODO 这把武器一次攻击会造成6次伤害。
	val GRINDER_MK4 = onMelee<GrinderMk4WeaponItem>()
		.id("grinder_mk4_weapon")
		.zhName("粉碎机Mk4")
		.lcLevelType(LcLevel.HE)
		.properties(Item.Properties())
		.properties {
			it
				.damage(1.5f)
				.attackSpeed(minuteToSpeedConversion(1.67f))
				.attackDistance(4f)
				.meleeLcDamageType(LcDamageType.PHYSICS)
				.virtueUsageReq(VirtueRating.II, null, null, null, null)
		}
		.model(EGOEquipment.modRl("weapon/grinder_mk4"))
		.buildAndRegister { p, b ->
			GrinderMk4WeaponItem(p, b, EGOEquipment.modRl("weapon/grinder_mk4"))
		}

	val OUR_GALAXY = onMelee<OurGalaxyWeaponItem>()
		.id("our_galaxy_weapon")
		.zhName("小小银河")
		.lcLevelType(LcLevel.HE)
		.properties(Item.Properties())
		.properties {
			it
				.damage(11f)
				.attackSpeed(minuteToSpeedConversion(2f))
				.attackDistance(8f)
				.meleeLcDamageType(LcDamageType.EROSION)
				.virtueUsageReq(null, VirtueRating.II, null, null, VirtueRating.II)
		}
		.model(EGOEquipment.modRl("weapon/our_galaxy"))
		.buildAndRegister { p, b ->
			OurGalaxyWeaponItem(p, b, EGOEquipment.modRl("weapon/our_galaxy"))
		}

	val LIFE_FOR_A_DAREDEVIL = onMelee<LifeForADaredevilWeaponItem>()
		.id("life_for_a_daredevil_weapon")
		.zhName("决死之心")
		.lcLevelType(LcLevel.HE)
		.properties(Item.Properties())
		.properties {
			it
				.damage(8f)
				.attackSpeed(minuteToSpeedConversion(1.33f))
				.attackDistance(4f)
				.meleeLcDamageType(LcDamageType.THE_SOUL)
				.virtueUsageReq(null, null, null, VirtueRating.II, null)
		}
		.model(EGOEquipment.modRl("weapon/life_for_a_daredevil"))
		.buildAndRegister { p, b ->
			LifeForADaredevilWeaponItem(
				p,
				b,
				EGOEquipment.modRl("weapon/life_for_a_daredevil")
			)
		}

	// TODO 这把武器每次攻击会造成9次伤害。
	// TODO 在攻击到敌人时，为敌人附加一个每秒受到2点物理伤害的dot，持续5秒，不可叠加。
	val GAZE = onMelee<GazeWeaponItem>()
		.id("gaze_weapon")
		.zhName("凝视")
		.lcLevelType(LcLevel.HE)
		.properties(Item.Properties())
		.properties {
			it
				.damage(3f)
				.attackSpeed(minuteToSpeedConversion(2.9f))
				.attackDistance(4f)
				.meleeLcDamageType(LcDamageType.PHYSICS)
				.virtueUsageReq(null, VirtueRating.II, VirtueRating.II, null, null)
		}
		.model(EGOEquipment.modRl("weapon/gaze"))
		.buildAndRegister { p, b ->
			GazeWeaponItem(p, b, EGOEquipment.modRl("weapon/gaze"))
		}

	// TODO 这把武器击中目标时，会给目标附加每秒受到2点精神伤害的dot，持续5秒，不可叠加。
	val PLEASURE = onMelee<PleasureWeaponItem>()
		.id("pleasure_weapon")
		.zhName("因乐癫狂")
		.lcLevelType(LcLevel.HE)
		.properties(Item.Properties())
		.properties {
			it
				.damage(2.5f)
				.attackSpeed(minuteToSpeedConversion(1.67f))
				.attackDistance(5f)
				.meleeLcDamageType(LcDamageType.EROSION)
				.virtueUsageReq(null, null, VirtueRating.III, null, null)
		}
		.model(EGOEquipment.modRl("weapon/pleasure"))
		.buildAndRegister { p, b ->
			PleasureWeaponItem(p, b, EGOEquipment.modRl("weapon/pleasure"))
		}

	val BEAR_PAWS = onMelee<MeleeEgoWeaponItem>()
		.id("bear_paws_weapon")
		.zhName("熊熊抱")
		.lcLevelType(LcLevel.HE)
		.type(MeleeTemplateType.FIST)
		.properties(Item.Properties())
		.properties {
			it
				.damage(7f)
				.meleeLcDamageType(LcDamageType.PHYSICS)
				.virtueUsageReq(VirtueRating.II, null, null, null, null)
		}
		.model(EGOEquipment.modRl("weapon/bear_paws"))
		.buildAndRegister()

	// TODO 如果持有者的自律等级低于3级，每次攻击都会提高最大与最小攻击力。但代价是每次攻击都会丧失等同于最大精神值4%的精神值。
	val SANGUINE_DESIRE = onMelee<MeleeEgoWeaponItem>()
		.id("sanguine_desire_weapon")
		.zhName("血之渴望")
		.lcLevelType(LcLevel.HE)
		.type(MeleeTemplateType.AXE)
		.properties(Item.Properties())
		.properties {
			it
				.damage(6f)
				.meleeLcDamageType(LcDamageType.PHYSICS)
				.virtueUsageReq(null, null, null, null, null)
		}
		.model(EGOEquipment.modRl("weapon/sanguine_desire"))
		.buildAndRegister()

	val LOGGING = onMelee<MeleeEgoWeaponItem>()
		.id("logging_weapon")
		.zhName("伐木者")
		.lcLevelType(LcLevel.HE)
		.type(MeleeTemplateType.HAMMER)
		.properties(Item.Properties())
		.properties {
			it
				.damage(17f)
				.meleeLcDamageType(LcDamageType.PHYSICS)
				.virtueUsageReq(null, null, VirtueRating.II, null, null)
		}
		.model(EGOEquipment.modRl("weapon/logging"))
		.buildAndRegister()

	// TODO 被这支武器刺中的目标会减少30%的移动速度，持续3秒。需要单独效果。
	val FROST_SPLINTER = onMelee<MeleeEgoWeaponItem>()
		.id("frost_splinter_weapon")
		.zhName("霜之碎片")
		.lcLevelType(LcLevel.HE)
		.type(MeleeTemplateType.SPEAR)
		.properties(Item.Properties())
		.properties {
			it
				.damage(7f)
				.meleeLcDamageType(LcDamageType.SPIRIT)
				.virtueUsageReq(null, null, null, null, null)
		}
		.model(EGOEquipment.modRl("weapon/frost_splinter"))
		.buildAndRegister()

	val CHRISTMAS = onMelee<MeleeEgoWeaponItem>()
		.id("christmas_weapon")
		.zhName("悲惨圣诞")
		.lcLevelType(LcLevel.HE)
		.type(MeleeTemplateType.MACE)
		.properties(Item.Properties())
		.properties {
			it
				.damage(12f)
				.meleeLcDamageType(LcDamageType.SPIRIT)
				.virtueUsageReq(null, null, null, null, null)
		}
		.model(EGOEquipment.modRl("weapon/christmas"))
		.buildAndRegister()

	val HARVEST = onMelee<MeleeEgoWeaponItem>()
		.id("harvest_weapon")
		.zhName("猎头长耙")
		.lcLevelType(LcLevel.HE)
		.type(MeleeTemplateType.SPEAR)
		.properties(Item.Properties())
		.properties {
			it
				.damage(8f)
				.meleeLcDamageType(LcDamageType.EROSION)
				.virtueUsageReq(null, null, null, null, null)
		}
		.model(EGOEquipment.modRl("weapon/harvest"))
		.buildAndRegister()
	//endregion

	//region WAW
	val HORNET = onRemote<RemoteEgoWeaponItem>()
		.id("hornet_weapon")
		.zhName("黄蜂")
		.lcLevelType(LcLevel.WAW)
		.type(RemoteTemplateType.RIFLE)
		.properties(Item.Properties())
		.weaponBuilder {
			it
				.damage(7.5f)
				.meleeLcDamageType(LcDamageType.PHYSICS)
				.virtueUsageReq(VirtueRating.III, null, null, null, null)
		}
		.model(EGOEquipment.modRl("weapon/hornet"))
		.buildAndRegister()

	val FAINT_AROMA = onRemote<RemoteEgoWeaponItem>()
		.id("faint_aroma_weapon")
		.zhName("余香")
		.lcLevelType(LcLevel.WAW)
		.type(RemoteTemplateType.CROSSBOW)
		.properties(Item.Properties())
		.weaponBuilder {
			it
				.damage(15f)
				.meleeLcDamageType(LcDamageType.SPIRIT)
				.virtueUsageReq(null, VirtueRating.III, null, null, null)
		}
		.model(EGOEquipment.modRl("weapon/faint_aroma"))
		.buildAndRegister()

	// TODO 攻击时有25%的概率给目标添加一个易伤效果，使其受到的物理伤害加深。
	val EXUVIAE = onRemote<RemoteEgoWeaponItem>()
		.id("exuviae_weapon")
		.zhName("脱落之皮")
		.lcLevelType(LcLevel.WAW)
		.type(RemoteTemplateType.CANNON)
		.properties(Item.Properties())
		.weaponBuilder {
			it
				.damage(42.5f)
				.meleeLcDamageType(LcDamageType.PHYSICS)
				.virtueUsageReq(null, null, null, null, VirtueRating.IV)
		}
		.model(EGOEquipment.modRl("weapon/exuviae"))
		.buildAndRegister()

	val HYPOCRISY = onRemote<RemoteEgoWeaponItem>()
		.id("hypocrisy_weapon")
		.zhName("伪善")
		.lcLevelType(LcLevel.WAW)
		.type(RemoteTemplateType.CROSSBOW)
		.properties(Item.Properties())
		.weaponBuilder {
			it
				.damage(15f)
				.meleeLcDamageType(LcDamageType.PHYSICS)
				.virtueUsageReq(null, VirtueRating.III, null, null, null)
		}
		.model(EGOEquipment.modRl("weapon/hypocrisy"))
		.buildAndRegister()

	// TODO 这件E.G.O在攻击时会造成随机类型的伤害。这件E.G.O命中员工时，会根据伤害类型为员工恢复生命值和精神值。
	val IN_THE_NAME_OF_LOVE_AND_HATE = onRemote<InTheNameOfLoveAndHateWeaponItem>()
		.id("in_the_name_of_love_and_hate_weapon")
		.zhName("以爱与恨之名")
		.lcLevelType(LcLevel.WAW)
		.properties(Item.Properties())
		.weaponBuilder {
			it
				.damage(6.5f)
				.attackIntervalMainHand(minuteToSpeedConversion(0.83f))
				.attackDistance(80f)
				.meleeLcDamageType(
					null,
					LcDamageType.PHYSICS,
					LcDamageType.SPIRIT,
					LcDamageType.EROSION,
					LcDamageType.THE_SOUL
				)
				.virtueUsageReq(VirtueRating.III, null, null, VirtueRating.III, VirtueRating.IV)
		}
		.model(EGOEquipment.modRl("weapon/in_the_name_of_love_and_hate"))
		.buildAndRegister { p, b ->
			InTheNameOfLoveAndHateWeaponItem(
				p,
				b,
				EGOEquipment.modRl("weapon/in_the_name_of_love_and_hate")
			)
		}

	// TODO 如果持有者的生命值低于50%，武器的伤害会额外增加50%。但是，持有者在该状态下攻击时会对其他员工造成无差别伤害。
	val CRIMSON_SCAR = onMelee<CrimsonScarWeaponItem>()
		.id("crimson_scar_weapon")
		.zhName("猩红创痕")
		.lcLevelType(LcLevel.WAW)
		.properties(Item.Properties())
		.properties {
			it
				.damage(12f)
				.attackSpeed(minuteToSpeedConversion(1.53f))
				.attackDistance(-12f) // 3 - 15 = -12
				.meleeLcDamageType(LcDamageType.PHYSICS)
				.virtueUsageReq(VirtueRating.III, null, null, VirtueRating.III, VirtueRating.III)
		}
		.model(EGOEquipment.modRl("weapon/crimson_scar"))
		.buildAndRegister { p, b ->
			CrimsonScarWeaponItem(p, b, EGOEquipment.modRl("weapon/crimson_scar"))
		}

	// TODO 持有者攻击时会在一定时间内增加物理伤害。如果持有者的生命值小于或等于50%，武器的伤害会额外增加50%。但是，持有者在该状态下攻击时会对其他员工造成无差别伤害。
	val COBALT_SCAR = onMelee<CobaltScarWeaponItem>()
		.id("cobalt_scar_weapon")
		.zhName("郁蓝创痕")
		.lcLevelType(LcLevel.WAW)
		.properties(Item.Properties())
		.properties {
			it
				.damage(15f)
				.attackSpeed(minuteToSpeedConversion(1.83f))
				.attackDistance(0f)
				.meleeLcDamageType(LcDamageType.PHYSICS)
				.virtueUsageReq(VirtueRating.III, null, VirtueRating.III, null, VirtueRating.II)
		}
		.model(EGOEquipment.modRl("weapon/cobalt_scar"))
		.buildAndRegister { p, b ->
			CobaltScarWeaponItem(p, b, EGOEquipment.modRl("weapon/cobalt_scar"))
		}

	val SOLEMN_LAMENT_BLACK = onRemote<SolemnLamentWeaponItem>()
		.id("solemn_lament_black_weapon")
		.zhName("圣宣-黑")
		.lcLevelType(LcLevel.WAW)
		.properties(Item.Properties())
		.weaponBuilder {
			it
				.damage(2f)
				.attackIntervalHand(minuteToSpeedConversion(0.5f))
				.attackDistance(10f)
				.meleeLcDamageType(LcDamageType.EROSION)
				.virtueUsageReq(null, null, null, VirtueRating.III, null)
		}
		.model(EGOEquipment.modRl("weapon/solemn_lament_black"))
		.buildAndRegister { p, b ->
			SolemnLamentWeaponItem(
				p,
				b,
				EGOEquipment.modRl("weapon/solemn_lament_black")
			)
		}

	val SOLEMN_LAMENT_WHITE = onRemote<SolemnLamentWeaponItem>()
		.id("solemn_lament_white_weapon")
		.zhName("圣宣-白")
		.lcLevelType(LcLevel.WAW)
		.properties(Item.Properties())
		.weaponBuilder {
			it
				.damage(2f)
				.attackIntervalHand(minuteToSpeedConversion(0.5f))
				.attackDistance(10f)
				.meleeLcDamageType(LcDamageType.SPIRIT)
				.virtueUsageReq(null, null, null, VirtueRating.III, null)
		}
		.model(EGOEquipment.modRl("weapon/solemn_lament_white"))
		.buildAndRegister { p, b ->
			SolemnLamentWeaponItem(
				p,
				b,
				EGOEquipment.modRl("weapon/solemn_lament_white")
			)
		}

	val MAGIC_BULLET = onRemote<MagicBulletWeaponItem>()
		.id("magic_bullet_weapon")
		.zhName("魔弹")
		.lcLevelType(LcLevel.WAW)
		.properties(Item.Properties())
		.weaponBuilder {
			it
				.damage(21f)
				.attackIntervalMainHand(minuteToSpeedConversion(2.33f))
				.attackDistance(50f)
				.meleeLcDamageType(LcDamageType.EROSION)
				.virtueUsageReq(null, null, VirtueRating.III, null, null)
		}
		.model(EGOEquipment.modRl("weapon/magic_bullet"))
		.buildAndRegister { p, b ->
			MagicBulletWeaponItem(p, b, EGOEquipment.modRl("weapon/magic_bullet"))
		}

	// TODO 这把武器一次攻击动画会造成2次侵蚀伤害。
	// TODO 持有者进入战斗后，有一定概率反弹自身受到的伤害。
	val BLACK_SWAN = onMelee<BlackSwanWeaponItem>()
		.id("black_swan_weapon")
		.zhName("黑天鹅")
		.lcLevelType(LcLevel.WAW)
		.properties(Item.Properties())
		.properties {
			it
				.damage(6f)
				.attackSpeed(minuteToSpeedConversion(1.63f))
				.attackDistance(0f)
				.meleeLcDamageType(LcDamageType.EROSION)
				.virtueUsageReq(null, VirtueRating.III, null, null, null)
		}
		.model(EGOEquipment.modRl("weapon/black_swan"))
		.buildAndRegister { p, b ->
			BlackSwanWeaponItem(p, b, EGOEquipment.modRl("weapon/black_swan"))
		}

	val ECSTASY = onMelee<EcstasyWeaponItem>()
		.id("ecstasy_weapon")
		.zhName("沉醉")
		.lcLevelType(LcLevel.WAW)
		.properties(Item.Properties())
		.properties {
			it
				.damage(3f)
				.attackSpeed(minuteToSpeedConversion(0.83f))
				.attackDistance(10f)
				.meleeLcDamageType(LcDamageType.SPIRIT)
				.virtueUsageReq(VirtueRating.II, null, null, null, VirtueRating.II)
		}
		.model(EGOEquipment.modRl("weapon/ecstasy"))
		.buildAndRegister { p, b ->
			EcstasyWeaponItem(p, b, EGOEquipment.modRl("weapon/ecstasy"))
		}

	// TODO 这把武器攻击时有30%的概率使用特殊攻击，持有者先举起刺剑，然后对目标进行快速戳刺，造成9次1-2点精神伤害和1次9-12点精神伤害。
	val THE_SWORD_SHARPENED_WITH_TEARS = onMelee<TheSwordSharpenedWithTearsWeaponItem>()
		.id("the_sword_sharpened_with_tears_weapon")
		.zhName("盈泪之剑")
		.lcLevelType(LcLevel.WAW)
		.properties(Item.Properties())
		.properties {
			it
				.damage(10.5f)
				.attackSpeed(minuteToSpeedConversion(1.33f))
				.attackDistance(4f)
				.meleeLcDamageType(LcDamageType.SPIRIT)
				.virtueUsageReq(null, null, null, null, VirtueRating.IV)
		}
		.model(EGOEquipment.modRl("weapon/the_sword_sharpened_with_tears"))
		.buildAndRegister { p, b ->
			TheSwordSharpenedWithTearsWeaponItem(
				p,
				b,
				EGOEquipment.modRl("weapon/the_sword_sharpened_with_tears")
			)
		}

	val FEATHER_OF_HONOR = onRemote<FeatherOfHonorWeaponItem>()
		.id("feather_of_honor_weapon")
		.zhName("荣耀之羽")
		.lcLevelType(LcLevel.WAW)
		.properties(Item.Properties())
		.weaponBuilder {
			it
				.damage(4.5f)
				.attackIntervalMainHand(minuteToSpeedConversion(0.5f))
				.attackDistance(15f)
				.meleeLcDamageType(LcDamageType.SPIRIT)
				.virtueUsageReq(VirtueRating.III, null, null, null, null)
		}
		.model(EGOEquipment.modRl("weapon/feather_of_honor"))
		.buildAndRegister { p, b ->
			FeatherOfHonorWeaponItem(
				p,
				b,
				EGOEquipment.modRl("weapon/feather_of_honor")
			)
		}

	// TODO 这把武器在攻击时有10%的概率使用特殊攻击，具体效果为：持有者对目标进行4次快速戳刺和一次劈砍，造成4次2.5点侵蚀伤害和一次9-12点侵蚀伤害。
	val DISCORD = onMelee<DiscordWeaponItem>()
		.id("discord_weapon")
		.zhName("不和")
		.lcLevelType(LcLevel.WAW)
		.properties(Item.Properties())
		.properties {
			it
				.damage(9f)
				.attackSpeed(minuteToSpeedConversion(1.33f))
				.attackDistance(5f)
				.meleeLcDamageType(LcDamageType.EROSION)
				.virtueUsageReq(null, null, VirtueRating.III, null, VirtueRating.III)
		}
		.model(EGOEquipment.modRl("weapon/discord"))
		.buildAndRegister { p, b ->
			DiscordWeaponItem(p, b, EGOEquipment.modRl("weapon/discord"))
		}

	// TODO 这把武器在攻击时有15%的概率使用特殊攻击，持有者对目标进行一次快速上挑和下砸然后以拐杖点地，造成2次5.5点侵蚀伤害和10点侵蚀伤害。
	// TODO 这把武器发动特殊攻击时，能够为同房间的所有职员附加一层和中央本部科技完全相同的反侵蚀力场盾。这层反侵蚀力场盾不会影响其余类型护盾的效果并可以和它们共存，若已经存在附加的反侵蚀力场盾，那么该护盾的承伤能力将恢复为最大值。
	val MOONLIGHT = onMelee<MoonlightWeaponItem>()
		.id("moonlight_weapon")
		.zhName("月光")
		.lcLevelType(LcLevel.WAW)
		.properties(Item.Properties())
		.properties {
			it
				.damage(9f)
				.attackSpeed(minuteToSpeedConversion(1.17f))
				.attackDistance(0f)
				.meleeLcDamageType(LcDamageType.SPIRIT)
				.virtueUsageReq(VirtueRating.III, null, null, null, VirtueRating.IV)
		}
		.model(EGOEquipment.modRl("weapon/moonlight"))
		.buildAndRegister { p, b ->
			MoonlightWeaponItem(p, b, EGOEquipment.modRl("weapon/moonlight"))
		}

	// TODO 这把武器每次攻击时会造成3次物理伤害。
	val AMITA = onMelee<AmitaWeaponItem>()
		.id("amita_weapon")
		.zhName("无量")
		.lcLevelType(LcLevel.WAW)
		.properties(Item.Properties())
		.properties {
			it
				.damage(3.5f)
				.attackSpeed(minuteToSpeedConversion(2.33f))
				.attackDistance(4f)
				.meleeLcDamageType(LcDamageType.PHYSICS)
				.virtueUsageReq(null, null, VirtueRating.III, null, VirtueRating.III)
		}
		.model(EGOEquipment.modRl("weapon/amita"))
		.buildAndRegister { p, b ->
			AmitaWeaponItem(p, b, EGOEquipment.modRl("weapon/amita"))
		}

	val LAMP = onMelee<MeleeEgoWeaponItem>()
		.id("lamp_weapon")
		.zhName("目灯")
		.lcLevelType(LcLevel.WAW)
		.type(MeleeTemplateType.HAMMER)
		.properties(Item.Properties())
		.properties {
			it
				.damage(24f)
				.meleeLcDamageType(LcDamageType.EROSION)
				.virtueUsageReq(VirtueRating.III, VirtueRating.III, null, null, null)
		}
		.model(EGOEquipment.modRl("weapon/lamp"))
		.buildAndRegister()

	val GREEN_STEM = onMelee<MeleeEgoWeaponItem>()
		.id("green_stem_weapon")
		.zhName("绿色枝干")
		.lcLevelType(LcLevel.WAW)
		.type(MeleeTemplateType.SPEAR)
		.properties(Item.Properties())
		.properties {
			it
				.damage(12f)
				.meleeLcDamageType(LcDamageType.EROSION)
				.virtueUsageReq(null, null, VirtueRating.III, null, null)
		}
		.model(EGOEquipment.modRl("weapon/green_stem"))
		.buildAndRegister()

	// TODO 持有者攻击时有25%的概率给目标添加一个易伤效果，使其受到的精神伤害加深。
	val SPORE = onMelee<MeleeEgoWeaponItem>()
		.id("spore_weapon")
		.zhName("荧光菌孢")
		.lcLevelType(LcLevel.WAW)
		.type(MeleeTemplateType.SPEAR)
		.properties(Item.Properties())
		.properties {
			it
				.damage(12f)
				.meleeLcDamageType(LcDamageType.SPIRIT)
				.virtueUsageReq(null, null, VirtueRating.II, null, VirtueRating.II)
		}
		.model(EGOEquipment.modRl("weapon/spore"))
		.buildAndRegister()

	val HEAVEN = onMelee<MeleeEgoWeaponItem>()
		.id("heaven_weapon")
		.zhName("穿刺极乐")
		.lcLevelType(LcLevel.WAW)
		.type(MeleeTemplateType.SPEAR)
		.properties(Item.Properties())
		.properties {
			it
				.damage(10f)
				.meleeLcDamageType(LcDamageType.PHYSICS)
				.virtueUsageReq(null, null, null, null, VirtueRating.III)
		}
		.model(EGOEquipment.modRl("weapon/heaven"))
		.buildAndRegister()

	val DIFFRACTION = onMelee<MeleeEgoWeaponItem>()
		.id("diffraction_weapon")
		.zhName("虚无衍射体")
		.lcLevelType(LcLevel.WAW)
		.type(MeleeTemplateType.MACE)
		.properties(Item.Properties())
		.properties {
			it
				.damage(16f)
				.meleeLcDamageType(LcDamageType.SPIRIT)
				.virtueUsageReq(null, VirtueRating.III, null, null, null)
		}
		.model(EGOEquipment.modRl("weapon/diffraction"))
		.buildAndRegister()
	//endregion

	//region ALEPH
	// TODO 造成伤害的25%会转化成生命值。
	val MIMICRY = onMelee<MimicryWeaponItem>()
		.id("mimicry_weapon")
		.zhName("拟态")
		.lcLevelType(LcLevel.ALEPH)
		.properties(Item.Properties())
		.properties {
			it
				.damage(12f)
				.attackSpeed(minuteToSpeedConversion(1.7f))
				.attackDistance(4f)
				.meleeLcDamageType(LcDamageType.PHYSICS)
				.virtueUsageReq(VirtueRating.V, null, null, null, VirtueRating.V)
		}
		.model(EGOEquipment.modRl("weapon/mimicry"))
		.buildAndRegister { p, b ->
			MimicryWeaponItem(p, b, EGOEquipment.modRl("weapon/mimicry"))
		}

	// TODO 这把武器每次攻击时会造成5次灵魂伤害。
	val JUSTITIA = onMelee<JustitiaWeaponItem>()
		.id("justitia_weapon")
		.zhName("正义裁决者")
		.lcLevelType(LcLevel.ALEPH)
		.properties(Item.Properties())
		.properties {
			it
				.damage(3f)
				.attackSpeed(minuteToSpeedConversion(2f))
				.attackDistance(4f)
				.meleeLcDamageType(LcDamageType.THE_SOUL)
				.virtueUsageReq(null, null, null, VirtueRating.V, VirtueRating.V)
		}
		.model(EGOEquipment.modRl("weapon/justitia"))
		.buildAndRegister { p, b ->
			JustitiaWeaponItem(p, b, EGOEquipment.modRl("weapon/justitia"))
		}

	// TODO 持有者无法通过各部门的"再生反应堆"恢复生命值和精神值。
	// TODO 发起普通攻击时，这把武器能减少被击中单位的移动速度，同时恢复持有者的生命值和精神值。(伤害量和恢复量取决于击中单位的数量。)
	// TODO 发起特殊攻击时，这把武器会生成一个力场盾，减少受到的所有类型的伤害。(如果设施内没有收容"白夜"，就不能发起特殊攻击。)
	val PARADISE_LOST = onRemote<ParadiseLostWeaponItem>()
		.id("paradise_lost_weapon")
		.zhName("失乐园")
		.lcLevelType(LcLevel.ALEPH)
		.properties(Item.Properties())
		.weaponBuilder {
			it
				.damage(24f)
				.attackIntervalMainHand(minuteToSpeedConversion(2f))
				.attackDistance(80f)
				.meleeLcDamageType(LcDamageType.THE_SOUL)
				.virtueUsageReq(VirtueRating.V, VirtueRating.V, VirtueRating.V, VirtueRating.V, null)
		}
		.model(EGOEquipment.modRl("weapon/paradise_lost"))
		.buildAndRegister { p, b ->
			ParadiseLostWeaponItem(
				p,
				b,
				EGOEquipment.modRl("weapon/paradise_lost")
			)
		}

	// TODO 只有全属性超过110的员工才能拿起这把武器。
	// TODO 这把武器会同时造成物理，精神，侵蚀和灵魂伤害。
	// TODO 这把武器每隔一段时间会进行一次特殊攻击。
	val TWILIGHT = onMelee<TwilightWeaponItem>()
		.id("twilight_weapon")
		.zhName("薄暝")
		.lcLevelType(LcLevel.ALEPH)
		.properties(Item.Properties())
		.properties {
			it
				.damage(14f)
				.attackSpeed(minuteToSpeedConversion(2f))
				.attackDistance(6f)
				.meleeLcDamageType(
					null,
					LcDamageType.PHYSICS,
					LcDamageType.SPIRIT,
					LcDamageType.EROSION,
					LcDamageType.THE_SOUL
				)
				.virtueUsageReq(111, 111, 111, 111, 0)
		}
		.model(EGOEquipment.modRl("weapon/twilight"))
		.buildAndRegister { p, b ->
			TwilightWeaponItem(p, b, EGOEquipment.modRl("weapon/twilight"))
		}

	// TODO 持有者每次攻击时都有10%的概提高5点最大与最小攻击力，该效果持续12秒。代价是，120秒内，持有者的自律相关属性会降低50%。
	// TODO 这把武器每次攻击时会造成3次物理伤害。
	val GOLD_RUSH = onMelee<GoldRushWeaponItem>()
		.id("gold_rush_weapon")
		.zhName("闪金冲锋")
		.lcLevelType(LcLevel.ALEPH)
		.properties(Item.Properties())
		.properties {
			it
				.damage(5.5f)
				.attackSpeed(minuteToSpeedConversion(1.5f))
				.attackDistance(2f)
				.meleeLcDamageType(LcDamageType.PHYSICS)
				.virtueUsageReq(VirtueRating.V, null, null, null, VirtueRating.V)
		}
		.model(EGOEquipment.modRl("weapon/gold_rush"))
		.buildAndRegister { p, b ->
			GoldRushWeaponItem(p, b, EGOEquipment.modRl("weapon/gold_rush"))
		}

	// TODO 每击杀一个目标，持有者的勇气与正义的相关属性会提高3点。该效果仅在当天有效。
	// TODO 发起普通攻击时，这把武器能减少被击中单位的移动速度。
	// TODO 发起特殊攻击时，这把武器能减少当前区域中所有敌对单位的移动速度。
	// TODO 这把武器在攻击时有30%的概率使用特殊攻击，持有者举起武器，跳起后重砸，对小范围内的目标造成1次35-45点侵蚀伤害和5次4点侵蚀伤害。
	val SMILE = onMelee<SmileWeaponItem>()
		.id("smile_weapon")
		.zhName("笑靥")
		.lcLevelType(LcLevel.ALEPH)
		.properties(Item.Properties())
		.properties {
			it
				.damage(13f)
				.attackSpeed(minuteToSpeedConversion(1.5f))
				.attackDistance(5f)
				.meleeLcDamageType(LcDamageType.EROSION)
				.virtueUsageReq(null, null, VirtueRating.V, null, VirtueRating.V)
		}
		.model(EGOEquipment.modRl("weapon/smile"))
		.buildAndRegister { p, b ->
			SmileWeaponItem(p, b, EGOEquipment.modRl("weapon/smile"))
		}

	// TODO 每次攻击造成2次伤害
	// TODO 持有这「CENSORED」的员工受到伤害时，「CENSORED」会为其恢复相当于伤害数值40%的生命
	// TODO 这把武器的持有者在受到伤害时，会立刻得到和伤害类型相对应，且等同于伤害量40%的治疗效果。但若持有者在受到伤害后死亡，则无法得到对应的回复。(任何类型的伤害都会计入，包括恐惧伤害)
	val CENSORED = onMelee<CensoredWeaponItem>()
		.id("censored_weapon")
		.zhName("CENSORED")
		.lcLevelType(LcLevel.ALEPH)
		.properties(Item.Properties())
		.properties {
			it
				.damage(9f)
				.attackSpeed(minuteToSpeedConversion(1.5f))
				.attackDistance(0f)
				.meleeLcDamageType(LcDamageType.EROSION)
				.virtueUsageReq(VirtueRating.V, null, null, null, VirtueRating.V)
		}
		.model(EGOEquipment.modRl("weapon/censored"))
		.buildAndRegister { p, b ->
			CensoredWeaponItem(p, b, EGOEquipment.modRl("weapon/censored"))
		}

	// TODO 这把武器在攻击时会造成贯穿伤害，但该武器的伤害不会伤害到中立目标和友方目标。
	// TODO 这把武器的伤害和攻击次数与员工的最大精神值数值无关，仅与员工当前精神值占最大精神值的百分比有关。
	// TODO 持有者的精神值在低于最大精神值的30%时，武器产生的"新星之声"仅有一个，伤害为和面板相同的8-12点精神伤害。
	// TODO 持有者的精神值大于最大精神值的30%且小于60%时，每次攻击时武器产生的"新星之声"变为2个，增加的"新星之声"伤害为9-11点精神伤害
	// TODO 持有者的精神值大于最大精神值的60%时，每次攻击时武器产生的"新星之声"变为3个，再额外增加的"新星之声"伤害为11-16点精神伤害
	val SOUND_OF_A_STAR = onRemote<SoundOfAStarWeaponItem>()
		.id("sound_of_a_star_weapon")
		.zhName("新星之声")
		.lcLevelType(LcLevel.ALEPH)
		.properties(Item.Properties())
		.weaponBuilder {
			it
				.damage(9f)
				.attackIntervalMainHand(minuteToSpeedConversion(1.67f))
				.attackDistance(25f)
				.meleeLcDamageType(LcDamageType.SPIRIT)
				.virtueUsageReq(null, VirtueRating.V, VirtueRating.V, null, VirtueRating.V)
		}
		.model(EGOEquipment.modRl("weapon/sound_of_a_star"))
		.buildAndRegister { p, b ->
			SoundOfAStarWeaponItem(
				p,
				b,
				EGOEquipment.modRl("weapon/sound_of_a_star")
			)
		}

	// TODO 这把武器每次攻击之前需要花费等同于一次攻击间隔的时间趴下来准备攻击；若目标始终处于射程范围内且保持与武器持有者相对方向相同，则不需要再次准备。
	val PINK = onRemote<PinkWeaponItem>()
		.id("pink_weapon")
		.zhName("粉红军备")
		.lcLevelType(LcLevel.ALEPH)
		.properties(Item.Properties())
		.weaponBuilder {
			it
				.damage(22f)
				.attackIntervalMainHand(minuteToSpeedConversion(2f))
				.attackDistance(35f)
				.meleeLcDamageType(LcDamageType.PHYSICS)
				.virtueUsageReq(null, VirtueRating.V, null, null, VirtueRating.V)
		}
		.model(EGOEquipment.modRl("weapon/pink"))
		.buildAndRegister { p, b ->
			PinkWeaponItem(p, b, EGOEquipment.modRl("weapon/pink"))
		}

	// TODO 这把武器的子弹命中时，会给目标附加每秒受到 2 点侵蚀伤害的dot，持续 5 秒，不可叠加。
	// TODO 这把武器的子弹命中时，会使目标的移动速度在 5 秒内降低 30%。
	val ADORATION = onRemote<AdorationWeaponItem>()
		.id("adoration_weapon")
		.zhName("爱慕")
		.lcLevelType(LcLevel.ALEPH)
		.properties(Item.Properties())
		.weaponBuilder {
			it
				.damage(33f)
				.attackIntervalMainHand(minuteToSpeedConversion(3.47f))
				.attackDistance(15f)
				.meleeLcDamageType(LcDamageType.PHYSICS)
				.virtueUsageReq(null, null, VirtueRating.V, null, VirtueRating.V)
		}
		.model(EGOEquipment.modRl("weapon/adoration"))
		.buildAndRegister { p, b ->
			AdorationWeaponItem(p, b, EGOEquipment.modRl("weapon/adoration"))
		}
	//endregion

	private fun <I> onRemote() where I : Item, I : IRemoteEgoWeaponItem = RemoteEgoWeaponBuilder<I>()
	private fun <I> onMelee() where I : Item, I : IMeleeEgoWeaponItem = MeleeEgoWeaponBuilder<I>()

	private fun <I> register(
		id: String,
		zhName: String,
		lcLevel: LcLevel,
		templateType: TemplateType,
		properties: Item.Properties,
		builder: IEgoItem.Builder<*>,
		itemFactory: BiFunction<Item.Properties, IEgoItem.Builder<*>, I>,
	): DeferredItem<I> where I : Item, I : IEgoItem {
		@Suppress("UNCHECKED_CAST")
		val deferredItem = REGISTRY.register(id) { ->
			itemFactory.apply(properties, builder as IEgoItem.Builder<Nothing>)
		}
		LcLevelUtil.addItemLcLevelCapability(lcLevel, deferredItem)
		EGOEquipmentConstants.EGO_WEAPON.add(deferredItem)
		templateType.addItem(deferredItem)
		ZhCn.addI18nItemText(zhName, deferredItem)
		return deferredItem
	}

	private fun minuteToSpeedConversion(attackSpeed: Float) = attackSpeed - 4

	private enum class SpecialTemplateType(
		private val nameType: String,
		private val set: MutableSet<DeferredItem<out Item>>,
	) : TemplateType {
		SPECIAL("special", EGOEquipmentConstants.SPECIAL),
		MELEE("melee", EGOEquipmentConstants.MELEE),
		REMOTE("remote", EGOEquipmentConstants.REMOTE);

		override fun getName() = nameType
		override fun addItem(item: DeferredItem<out Item>) {
			set.add(item)
		}
	}

	private enum class RemoteTemplateType(
		private val nameType: String,
		private val set: MutableSet<DeferredItem<out Item>>,
		private val attackSpeed: Float,
		private val attackDistance: Float,
	) : TemplateType {
		CANNON("cannon", EGOEquipmentConstants.CANNON, 5f, 15f),
		GUN("gun", EGOEquipmentConstants.GUN, -1f, -1f),
		PISTOL("pistol", EGOEquipmentConstants.PISTOL, 0.667f, 10f),
		RIFLE("rifle", EGOEquipmentConstants.RIFLE, 1f, 15f),
		CROSSBOW("crossbow", EGOEquipmentConstants.CROSSBOW, 2f, 20f);

		override fun getName() = nameType
		override fun addItem(item: DeferredItem<out Item>) {
			set.add(item)
		}

		fun getAttackSpeed() = minuteToSpeedConversion(attackSpeed)
		fun getAttackDistance() = if (attackDistance != -1f) attackDistance - 3 else -1f
	}

	private enum class MeleeTemplateType(
		private val nameType: String,
		private val set: MutableSet<DeferredItem<out Item>>,
		private val attackSpeed: Float,
		private val attackDistance: Float,
	) : TemplateType {
		AXE("axe", EGOEquipmentConstants.AXE, 1f, 2f),
		FIST("fist", EGOEquipmentConstants.FIST, 4f, 2f),
		HAMMER("hammer", EGOEquipmentConstants.HAMMER, 1.15f, 5f),
		KNIFE("knife", EGOEquipmentConstants.KNIFE, 2.4f, 2f),
		MACE("mace", EGOEquipmentConstants.MACE, 1.6f, 3f),
		SPEAR("spear", EGOEquipmentConstants.SPEAR, 1.2f, 4f),
		SWORDS("swords", EGOEquipmentConstants.SWORDS, 1.6f, 0f);

		override fun getName() = nameType
		override fun addItem(item: DeferredItem<out Item>) {
			set.add(item)
		}

		fun getAttackSpeed() = minuteToSpeedConversion(attackSpeed)
		fun getAttackDistance() = if (attackDistance != -1f) attackDistance - 3 else -1f
	}

	private interface TemplateType {
		fun getName(): String
		fun addItem(item: DeferredItem<out Item>)
	}

	@Suppress("UNCHECKED_CAST")
	private abstract class EgoWeaponBuilder<I : EgoWeaponBuilder<I>> {
		protected var id: String? = null
		protected var zhName: String? = null
		protected var lcLevel: LcLevel? = null
		protected var properties: Item.Properties? = null
		protected var modelPath: ResourceLocation = ResourceLocation.parse("")

		fun id(id: String): I {
			this.id = id; return this as I
		}

		fun zhName(zhName: String): I {
			this.zhName = zhName; return this as I
		}

		fun lcLevelType(lcLevel: LcLevel): I {
			this.lcLevel = lcLevel; return this as I
		}

		fun properties(properties: Item.Properties): I {
			this.properties = properties; return this as I
		}

		fun model(modelPath: ResourceLocation): I {
			this.modelPath = modelPath; return this as I
		}

		fun getEnchantmentValue() = when (lcLevel) {
			LcLevel.ZAYIN -> 0
			LcLevel.TETH -> 2
			LcLevel.HE -> 4
			LcLevel.WAW -> 8
			LcLevel.ALEPH -> 12
			else -> 0
		}

		fun getIncorrectBlocksForDrops(): TagKey<Block> = when (lcLevel) {
			LcLevel.ZAYIN, LcLevel.TETH -> BlockTags.INCORRECT_FOR_IRON_TOOL
			LcLevel.HE -> BlockTags.INCORRECT_FOR_DIAMOND_TOOL
			LcLevel.WAW, LcLevel.ALEPH -> BlockTags.INCORRECT_FOR_NETHERITE_TOOL
			else -> BlockTags.INCORRECT_FOR_WOODEN_TOOL
		}
	}

	private class RemoteEgoWeaponBuilder<I> :
		EgoWeaponBuilder<RemoteEgoWeaponBuilder<I>>() where I : Item, I : IRemoteEgoWeaponItem {
		var templateType: RemoteTemplateType? = null; private set
		var weaponBuilder = IRemoteEgoWeaponItem.Builder(); private set

		fun type(templateType: RemoteTemplateType) = apply {
			this.templateType = templateType
			weaponBuilder.attackIntervalMainHand(templateType.getAttackSpeed())
				.attackDistance(templateType.getAttackDistance())
		}

		fun weaponBuilder(builder: Function<IRemoteEgoWeaponItem.Builder, IRemoteEgoWeaponItem.Builder>) = apply {
			this.weaponBuilder = builder.apply(weaponBuilder)
		}

		fun buildAndRegister(): DeferredItem<I> {
			validateRequiredFields()
			val type = templateType ?: throw IllegalStateException("Template type is required when using template")
			@Suppress("UNCHECKED_CAST")
			return register(id!!, zhName!!, lcLevel!!, type, properties!!, weaponBuilder, getRemoteItemFactory(type))
				as DeferredItem<I>
		}

		@Suppress("UNCHECKED_CAST")
		private fun <I : Item> getRemoteItemFactory(type: RemoteTemplateType): BiFunction<Item.Properties, IEgoItem.Builder<*>, I> =
			when (type) {
				RemoteTemplateType.CANNON -> BiFunction { p: Item.Properties, b: IEgoItem.Builder<*> ->
					CannonEgoWeaponItem(p, b as IRemoteEgoWeaponItem.Builder, modelPath) as I
				}

				RemoteTemplateType.PISTOL -> BiFunction { p: Item.Properties, b: IEgoItem.Builder<*> ->
					PistolEgoWeaponItem(p, b as IRemoteEgoWeaponItem.Builder, modelPath) as I
				}

				RemoteTemplateType.RIFLE -> BiFunction { p: Item.Properties, b: IEgoItem.Builder<*> ->
					RifleEgoWeaponItem(p, b as IRemoteEgoWeaponItem.Builder, modelPath) as I
				}

				RemoteTemplateType.CROSSBOW -> BiFunction { p: Item.Properties, b: IEgoItem.Builder<*> ->
					CrossbowEgoWeaponGeoItem(p, b as IRemoteEgoWeaponItem.Builder, modelPath) as I
				}

				else -> throw IllegalStateException("Unsupported remote template type: $type")
			}

		private fun validateRequiredFields() {
			if (id == null || zhName == null || lcLevel == null || properties == null) {
				throw IllegalStateException("Missing required fields for remote weapon registration")
			}
		}

		fun <I> buildAndRegister(
			itemFactory: BiFunction<Item.Properties, IRemoteEgoWeaponItem.Builder, I>,
		): DeferredItem<I> where I : Item, I : IRemoteEgoWeaponItem {
			this.templateType = null
			validateRequiredFields()
			@Suppress("UNCHECKED_CAST")
			return register(
				id!!, zhName!!, lcLevel!!, SpecialTemplateType.MELEE, properties!!, weaponBuilder,
				itemFactory as BiFunction<Item.Properties, IEgoItem.Builder<*>, I>,
			)
		}
	}

	private class MeleeEgoWeaponBuilder<I> :
		EgoWeaponBuilder<MeleeEgoWeaponBuilder<I>>() where I : Item, I : IMeleeEgoWeaponItem {
		var templateType: MeleeTemplateType? = null; private set
		var weaponBuilder = IMeleeEgoWeaponItem.Builder(); private set

		fun type(templateType: MeleeTemplateType) = apply {
			this.templateType = templateType
			weaponBuilder.attackSpeed(templateType.getAttackSpeed())
				.attackDistance(templateType.getAttackDistance())
		}

		fun properties(builder: Function<IMeleeEgoWeaponItem.Builder, IMeleeEgoWeaponItem.Builder>) = apply {
			this.weaponBuilder = builder.apply(weaponBuilder)
		}

		fun buildAndRegister(): DeferredItem<I> {
			validateRequiredFields()
			val type = templateType ?: throw IllegalStateException("Template type is required when using template")
			@Suppress("UNCHECKED_CAST")
			return register(id!!, zhName!!, lcLevel!!, type, properties!!, weaponBuilder, getMeleeItemFactory())
		}

		@Suppress("UNCHECKED_CAST")
		private fun <I : Item> getMeleeItemFactory(): BiFunction<Item.Properties, IEgoItem.Builder<*>, I> =
			when (templateType) {
				MeleeTemplateType.AXE -> BiFunction { p: Item.Properties, b: IEgoItem.Builder<*> ->
					AxeEgoWeaponGeoItem(getSimpleTier(weaponBuilder), p, b as IMeleeEgoWeaponItem.Builder, modelPath) as I
				}

				MeleeTemplateType.FIST -> BiFunction { p: Item.Properties, b: IEgoItem.Builder<*> ->
					FistEgoWeaponItem(p, b as IMeleeEgoWeaponItem.Builder, modelPath) as I
				}

				MeleeTemplateType.HAMMER -> BiFunction { p: Item.Properties, b: IEgoItem.Builder<*> ->
					HammerEgoWeaponItem(p, b as IMeleeEgoWeaponItem.Builder, modelPath) as I
				}

				MeleeTemplateType.KNIFE -> BiFunction { p: Item.Properties, b: IEgoItem.Builder<*> ->
					KnifeEgoWeaponItem(p, b as IMeleeEgoWeaponItem.Builder, modelPath) as I
				}

				MeleeTemplateType.MACE -> BiFunction { p: Item.Properties, b: IEgoItem.Builder<*> ->
					MaceEgoWeaponItem(p, b as IMeleeEgoWeaponItem.Builder, modelPath) as I
				}

				MeleeTemplateType.SPEAR -> BiFunction { p: Item.Properties, b: IEgoItem.Builder<*> ->
					SpearEgoWeaponItem(p, b as IMeleeEgoWeaponItem.Builder, modelPath) as I
				}

				MeleeTemplateType.SWORDS -> BiFunction { p: Item.Properties, b: IEgoItem.Builder<*> ->
					SwordsEgoWeaponGeoItem(getSimpleTier(weaponBuilder), p, b as IMeleeEgoWeaponItem.Builder, modelPath) as I
				}

				null -> throw IllegalStateException("Template type is null")
			}

		private fun getSimpleTier(b: IMeleeEgoWeaponItem.Builder) =
			SimpleTier(
				getIncorrectBlocksForDrops(),
				0,
				b.attackSpeed,
				b.weaponDamage,
				getEnchantmentValue(),
				Ingredient::of
			)

		private fun validateRequiredFields() {
			if (id == null || zhName == null || lcLevel == null || properties == null) {
				throw IllegalStateException("Missing required fields for melee weapon registration")
			}
		}

		fun <I> buildAndRegister(
			itemFactory: BiFunction<Item.Properties, IMeleeEgoWeaponItem.Builder, I>,
		): DeferredItem<I> where I : Item, I : IMeleeEgoWeaponItem {
			validateRequiredFields()
			@Suppress("UNCHECKED_CAST")
			return register(
				id!!, zhName!!, lcLevel!!, SpecialTemplateType.REMOTE, properties!!, weaponBuilder,
				itemFactory as BiFunction<Item.Properties, IEgoItem.Builder<*>, I>,
			)
		}
	}
}
