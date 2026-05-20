package architecture.ego_equipment.init

import architecture.ego_equipment.common.item.armor.EgoArmorItem
import architecture.ego_equipment.core.EGOEquipment
import architecture.ego_equipment.core.EGOEquipmentConstants
import architecture.ego_equipment.datagen.i18n.ZhCn
import architecture.goldenboughs_lib.api.Armors
import architecture.goldenboughs_lib.api.LcLevel
import architecture.goldenboughs_lib.client.model.armor.ModGeoArmorModel
import architecture.goldenboughs_lib.client.renderer.GeoArmourRenderProvider
import architecture.goldenboughs_lib.common.data_component.ItemVirtueUsageReq
import architecture.goldenboughs_lib.init.LibAttributes
import architecture.goldenboughs_lib.util.LcLevelUtil
import com.mojang.datafixers.util.Function5
import net.minecraft.core.Holder
import net.minecraft.world.item.ArmorItem
import net.minecraft.world.item.ArmorMaterial
import net.minecraft.world.item.Item
import net.neoforged.neoforge.registries.DeferredItem
import net.neoforged.neoforge.registries.DeferredRegister
import software.bernie.geckolib.animatable.client.GeoRenderProvider

object EGOArmorItems {
	val REGISTRY: DeferredRegister.Items = DeferredRegister.createItems(EGOEquipment.ID)

	//region ZAYIN
	val PENITENCE: Armors<EgoArmorItem> = registerSuit(
		"penitence", "忏悔", LcLevel.ZAYIN,
		ItemVirtueUsageReq.Builder(),
		EgoArmorItem.Builder(),
		Item.Properties(),
		GeoArmourRenderProvider(ModGeoArmorModel(EGOEquipment.modRl("penitence"))),
		0.9, 0.8, 0.9, 2.0
	)
	val SODA: Armors<EgoArmorItem> = registerSuit(
		"soda", "美味苏打", LcLevel.ZAYIN,
		ItemVirtueUsageReq.Builder(),
		EgoArmorItem.Builder(),
		Item.Properties(),
		GeoArmourRenderProvider(ModGeoArmorModel(EGOEquipment.modRl("soda"))),
		0.8, 1.0, 1.0, 2.0
	)
	val WINGBEAT: Armors<EgoArmorItem> = registerSuit(
		"wingbeat", "翅振", LcLevel.ZAYIN,
		ItemVirtueUsageReq.Builder(),
		EgoArmorItem.Builder(),
		Item.Properties(),
		GeoArmourRenderProvider(ModGeoArmorModel(EGOEquipment.modRl("wingbeat"))),
		0.8, 0.8, 1.0, 2.0
	)
	//endregion

	//region TETH
	val STANDARD_TRAINING_EGO: Armors<EgoArmorItem> = registerSuit(
		"standard_training_ego", "教学用E.G.O", LcLevel.TETH,
		ItemVirtueUsageReq.Builder(),
		EgoArmorItem.Builder(),
		Item.Properties(),
		GeoArmourRenderProvider(ModGeoArmorModel(EGOEquipment.modRl("standard_training_ego"))),
		0.5, 1.0, 1.5, 2.0
	)
	val FOURTH_MATCH_FLAME: Armors<EgoArmorItem> = registerSuit(
		"fourth_match_flame", "终末火柴之光", LcLevel.TETH,
		ItemVirtueUsageReq.Builder(),
		EgoArmorItem.Builder(),
		Item.Properties(),
		GeoArmourRenderProvider(ModGeoArmorModel(EGOEquipment.modRl("fourth_match_flame"))),
		0.6, 1.0, 1.5, 2.0
	)
	val IN_THE_NAME_OF_LOVE_AND_HATE: Armors<EgoArmorItem> = registerSuit(
		"in_the_name_of_love_and_hate", "以爱与恨之名", LcLevel.TETH,
		ItemVirtueUsageReq.Builder(),
		EgoArmorItem.Builder(),
		Item.Properties(),
		GeoArmourRenderProvider(ModGeoArmorModel(EGOEquipment.modRl("in_the_name_of_love_and_hate"))),
		0.7, 0.8, 0.4, 2.0
	)
	val RED_EYES: Armors<EgoArmorItem> = registerSuit(
		"red_eyes", "赤瞳", LcLevel.TETH,
		ItemVirtueUsageReq.Builder(),
		EgoArmorItem.Builder(),
		Item.Properties(),
		GeoArmourRenderProvider(ModGeoArmorModel(EGOEquipment.modRl("red_eyes"))),
		0.8, 0.8, 0.8, 2.0
	)
	val HORN: Armors<EgoArmorItem> = registerSuit(
		"horn", "犄角", LcLevel.TETH,
		ItemVirtueUsageReq.Builder(),
		EgoArmorItem.Builder(),
		Item.Properties(),
		GeoArmourRenderProvider(ModGeoArmorModel(EGOEquipment.modRl("horn"))),
		0.8, 0.8, 1.5, 2.0
	)
	val SOLITUDE: Armors<EgoArmorItem> = registerSuit(
		"solitude", "孤独", LcLevel.TETH,
		ItemVirtueUsageReq.Builder(),
		EgoArmorItem.Builder(),
		Item.Properties(),
		GeoArmourRenderProvider(ModGeoArmorModel(EGOEquipment.modRl("solitude"))),
		1.5, 0.8, 0.8, 2.0
	)
	val SCREAMING_WEDGE: Armors<EgoArmorItem> = registerSuit(
		"screaming_wedge", "刺耳嚎叫", LcLevel.TETH,
		ItemVirtueUsageReq.Builder(),
		EgoArmorItem.Builder(),
		Item.Properties(),
		GeoArmourRenderProvider(ModGeoArmorModel(EGOEquipment.modRl("screaming_wedge"))),
		1.2, 0.6, 1.0, 2.0
	)
	val NOISE: Armors<EgoArmorItem> = registerSuit(
		"noise", "噪音", LcLevel.TETH,
		ItemVirtueUsageReq.Builder(),
		EgoArmorItem.Builder(),
		Item.Properties(),
		GeoArmourRenderProvider(ModGeoArmorModel(EGOEquipment.modRl("noise"))),
		1.2, 0.7, 0.6, 2.0
	)
	val WRIST_CUTTER: Armors<EgoArmorItem> = registerSuit(
		"wrist_cutter", "割腕者", LcLevel.TETH,
		ItemVirtueUsageReq.Builder(),
		EgoArmorItem.Builder(),
		Item.Properties(),
		GeoArmourRenderProvider(ModGeoArmorModel(EGOEquipment.modRl("wrist_cutter"))),
		1.0, 0.6, 1.2, 2.0
	)
	val FRAGMENTS_FROM_SOMEWHERE: Armors<EgoArmorItem> = registerSuit(
		"fragments_from_somewhere", "彼方的裂片", LcLevel.TETH,
		ItemVirtueUsageReq.Builder(),
		EgoArmorItem.Builder(),
		Item.Properties(),
		GeoArmourRenderProvider(ModGeoArmorModel(EGOEquipment.modRl("fragments_from_somewhere"))),
		1.0, 1.2, 0.6, 2.0
	)
	val REGRET: Armors<EgoArmorItem> = registerSuit(
		"regret", "悔恨", LcLevel.TETH,
		ItemVirtueUsageReq.Builder(),
		EgoArmorItem.Builder(),
		Item.Properties(),
		GeoArmourRenderProvider(ModGeoArmorModel(EGOEquipment.modRl("regret"))),
		0.7, 1.2, 0.8, 2.0
	)
	val BEAK: Armors<EgoArmorItem> = registerSuit(
		"beak", "小喙", LcLevel.TETH,
		ItemVirtueUsageReq.Builder(),
		EgoArmorItem.Builder(),
		Item.Properties(),
		GeoArmourRenderProvider(ModGeoArmorModel(EGOEquipment.modRl("beak"))),
		0.7, 0.8, 1.2, 2.0
	)
	val LANTERN: Armors<EgoArmorItem> = registerSuit(
		"lantern", "诱捕幻灯", LcLevel.TETH,
		ItemVirtueUsageReq.Builder(),
		EgoArmorItem.Builder(),
		Item.Properties(),
		GeoArmourRenderProvider(ModGeoArmorModel(EGOEquipment.modRl("lantern"))),
		0.8, 0.7, 1.2, 2.0
	)
	val TODAY_IS_EXPRESSION: Armors<EgoArmorItem> = registerSuit(
		"today_is_expression", "此刻的神色", LcLevel.TETH,
		ItemVirtueUsageReq.Builder(),
		EgoArmorItem.Builder(),
		Item.Properties(),
		GeoArmourRenderProvider(ModGeoArmorModel(EGOEquipment.modRl("today_is_expression"))),
		0.7, 0.6, 1.5, 2.0
	)
	val SO_CUTE: Armors<EgoArmorItem> = registerSuit(
		"so_cute", "超特么可爱！！！", LcLevel.TETH,
		ItemVirtueUsageReq.Builder(),
		EgoArmorItem.Builder(),
		Item.Properties(),
		GeoArmourRenderProvider(ModGeoArmorModel(EGOEquipment.modRl("so_cute"))),
		0.8, 1.5, 0.8, 2.0
	)
	val LIFE_FOR_A_DAREDEVIL: Armors<EgoArmorItem> = registerSuit(
		"life_for_a_daredevil", "决死之心", LcLevel.TETH,
		ItemVirtueUsageReq.Builder(),
		EgoArmorItem.Builder(),
		Item.Properties(),
		GeoArmourRenderProvider(ModGeoArmorModel(EGOEquipment.modRl("life_for_a_daredevil"))),
		0.6, 0.9, 0.9, 2.0
	)
	val ENGULFING_DREAM: Armors<EgoArmorItem> = registerSuit(
		"engulfing_dream", "迷魂梦境", LcLevel.TETH,
		ItemVirtueUsageReq.Builder(),
		EgoArmorItem.Builder(),
		Item.Properties(),
		GeoArmourRenderProvider(ModGeoArmorModel(EGOEquipment.modRl("engulfing_dream"))),
		1.2, 0.8, 0.7, 2.0
	)
	val CHERRY_BLOSSOMS: Armors<EgoArmorItem> = registerSuit(
		"cherry_blossoms", "落樱", LcLevel.TETH,
		ItemVirtueUsageReq.Builder(),
		EgoArmorItem.Builder(),
		Item.Properties(),
		GeoArmourRenderProvider(ModGeoArmorModel(EGOEquipment.modRl("cherry_blossoms"))),
		1.2, 0.6, 0.7, 2.0
	)
	val TOUGH: Armors<EgoArmorItem> = registerSuit(
		"tough", "谢顶之灾", LcLevel.TETH,
		ItemVirtueUsageReq.Builder(),
		EgoArmorItem.Builder(),
		Item.Properties(),
		GeoArmourRenderProvider(ModGeoArmorModel(EGOEquipment.modRl("tough"))),
		1.0, 1.0, 0.8, 2.0
	)
	//endregion

	//region HE
	val BEAR_PAWS: Armors<EgoArmorItem> = registerSuit(
		"bear_paws", "熊熊抱", LcLevel.HE,
		ItemVirtueUsageReq.Builder(),
		EgoArmorItem.Builder(),
		Item.Properties(),
		GeoArmourRenderProvider(ModGeoArmorModel(EGOEquipment.modRl("bear_paws"))),
		0.8, 1.0, 1.0, 1.5
	)
	val SANGUINE_DESIRE: Armors<EgoArmorItem> = registerSuit(
		"sanguine_desire", "血之渴望", LcLevel.HE,
		ItemVirtueUsageReq.Builder(),
		EgoArmorItem.Builder(),
		Item.Properties(),
		GeoArmourRenderProvider(ModGeoArmorModel(EGOEquipment.modRl("sanguine_desire"))),
		0.5, 1.2, 0.8, 1.5
	)
	val SYRINX: Armors<EgoArmorItem> = registerSuit(
		"syrinx", "泣婴", LcLevel.HE,
		ItemVirtueUsageReq.Builder(),
		EgoArmorItem.Builder(),
		Item.Properties(),
		GeoArmourRenderProvider(ModGeoArmorModel(EGOEquipment.modRl("syrinx"))),
		1.2, 0.5, 0.8, 1.5
	)
	val DA_CAPO: Armors<EgoArmorItem> = registerSuit(
		"da_capo", "Da Capo", LcLevel.HE,
		ItemVirtueUsageReq.Builder(),
		EgoArmorItem.Builder(),
		Item.Properties(),
		GeoArmourRenderProvider(ModGeoArmorModel(EGOEquipment.modRl("da_capo"))),
		0.5, 0.2, 0.5, 1.5
	)
	val LOGGING: Armors<EgoArmorItem> = registerSuit(
		"logging", "伐木者", LcLevel.HE,
		ItemVirtueUsageReq.Builder(),
		EgoArmorItem.Builder(),
		Item.Properties(),
		GeoArmourRenderProvider(ModGeoArmorModel(EGOEquipment.modRl("logging"))),
		0.8, 1.2, 0.8, 1.5
	)
	val FROST_SPLINTER: Armors<EgoArmorItem> = registerSuit(
		"frost_splinter", "霜之碎片", LcLevel.HE,
		ItemVirtueUsageReq.Builder(),
		EgoArmorItem.Builder(),
		Item.Properties(),
		GeoArmourRenderProvider(ModGeoArmorModel(EGOEquipment.modRl("frost_splinter"))),
		1.3, 0.6, 0.8, 1.5
	)
	val GRINDER_MK4: Armors<EgoArmorItem> = registerSuit(
		"grinder_mk4", "粉碎机Mk4", LcLevel.HE,
		ItemVirtueUsageReq.Builder(),
		EgoArmorItem.Builder(),
		Item.Properties(),
		GeoArmourRenderProvider(ModGeoArmorModel(EGOEquipment.modRl("grinder_mk4"))),
		0.6, 1.3, 0.9, 1.5
	)
	val CHRISTMAS: Armors<EgoArmorItem> = registerSuit(
		"christmas", "悲惨圣诞", LcLevel.HE,
		ItemVirtueUsageReq.Builder(),
		EgoArmorItem.Builder(),
		Item.Properties(),
		GeoArmourRenderProvider(ModGeoArmorModel(EGOEquipment.modRl("christmas"))),
		0.8, 0.6, 1.3, 1.5
	)
	val HORNET: Armors<EgoArmorItem> = registerSuit(
		"hornet", "黄蜂", LcLevel.HE,
		ItemVirtueUsageReq.Builder(),
		EgoArmorItem.Builder(),
		Item.Properties(),
		GeoArmourRenderProvider(ModGeoArmorModel(EGOEquipment.modRl("hornet"))),
		0.7, 0.7, 0.7, 1.5
	)
	val OUR_GALAXY: Armors<EgoArmorItem> = registerSuit(
		"our_galaxy", "小小银河", LcLevel.HE,
		ItemVirtueUsageReq.Builder(),
		EgoArmorItem.Builder(),
		Item.Properties(),
		GeoArmourRenderProvider(ModGeoArmorModel(EGOEquipment.modRl("our_galaxy"))),
		0.8, 0.8, 1.2, 1.5
	)
	val LAETITIA: Armors<EgoArmorItem> = registerSuit(
		"laetitia", "蕾蒂希娅", LcLevel.HE,
		ItemVirtueUsageReq.Builder(),
		EgoArmorItem.Builder(),
		Item.Properties(),
		GeoArmourRenderProvider(ModGeoArmorModel(EGOEquipment.modRl("laetitia"))),
		0.7, 0.7, 0.7, 1.5
	)
	val SOLEMN_LAMENT: Armors<EgoArmorItem> = registerSuit(
		"solemn_lament", "圣宣", LcLevel.HE,
		ItemVirtueUsageReq.Builder(),
		EgoArmorItem.Builder(),
		Item.Properties(),
		GeoArmourRenderProvider(ModGeoArmorModel(EGOEquipment.modRl("solemn_lament"))),
		1.2, 0.8, 0.5, 1.5
	)
	val MAGIC_BULLET: Armors<EgoArmorItem> = registerSuit(
		"magic_bullet", "魔弹", LcLevel.HE,
		ItemVirtueUsageReq.Builder(),
		EgoArmorItem.Builder(),
		Item.Properties(),
		GeoArmourRenderProvider(ModGeoArmorModel(EGOEquipment.modRl("magic_bullet"))),
		0.7, 0.7, 0.7, 1.5
	)
	val BLACK_SWAN: Armors<EgoArmorItem> = registerSuit(
		"black_swan", "黑天鹅", LcLevel.HE,
		ItemVirtueUsageReq.Builder(),
		EgoArmorItem.Builder(),
		Item.Properties(),
		GeoArmourRenderProvider(ModGeoArmorModel(EGOEquipment.modRl("black_swan"))),
		0.6, 1.2, 0.8, 1.5
	)
	val PLEASURE: Armors<EgoArmorItem> = registerSuit(
		"pleasure", "因乐癫狂", LcLevel.HE,
		ItemVirtueUsageReq.Builder(),
		EgoArmorItem.Builder(),
		Item.Properties(),
		GeoArmourRenderProvider(ModGeoArmorModel(EGOEquipment.modRl("pleasure"))),
		1.2, 0.8, 0.8, 1.5
	)
	val GAZE: Armors<EgoArmorItem> = registerSuit(
		"gaze", "凝视", LcLevel.HE,
		ItemVirtueUsageReq.Builder(),
		EgoArmorItem.Builder(),
		Item.Properties(),
		GeoArmourRenderProvider(ModGeoArmorModel(EGOEquipment.modRl("gaze"))),
		1.0, 0.8, 1.0, 1.5
	)
	val HARVEST: Armors<EgoArmorItem> = registerSuit(
		"harvest", "猎头长耙", LcLevel.HE,
		ItemVirtueUsageReq.Builder(),
		EgoArmorItem.Builder(),
		Item.Properties(),
		GeoArmourRenderProvider(ModGeoArmorModel(EGOEquipment.modRl("harvest"))),
		0.6, 0.8, 1.3, 1.5
	)
	//endregion

	//region WAW
	val LAMP: Armors<EgoArmorItem> = registerSuit(
		"lamp", "目灯", LcLevel.WAW,
		ItemVirtueUsageReq.Builder(),
		EgoArmorItem.Builder(),
		Item.Properties(),
		GeoArmourRenderProvider(ModGeoArmorModel(EGOEquipment.modRl("lamp"))),
		0.8, 0.7, 0.4, 1.5
	)
	val GREEN_STEM: Armors<EgoArmorItem> = registerSuit(
		"green_stem", "绿色枝干", LcLevel.WAW,
		ItemVirtueUsageReq.Builder(),
		EgoArmorItem.Builder(),
		Item.Properties(),
		GeoArmourRenderProvider(ModGeoArmorModel(EGOEquipment.modRl("green_stem"))),
		0.8, 1.2, 0.6, 1.5
	)
	val CRIMSON_SCAR: Armors<EgoArmorItem> = registerSuit(
		"crimson_scar", "猩红创痕", LcLevel.WAW,
		ItemVirtueUsageReq.Builder(),
		EgoArmorItem.Builder(),
		Item.Properties(),
		GeoArmourRenderProvider(ModGeoArmorModel(EGOEquipment.modRl("crimson_scar"))),
		0.6, 0.6, 0.6, 1.5
	)
	val COBALT_SCAR: Armors<EgoArmorItem> = registerSuit(
		"cobalt_scar", "郁蓝创痕", LcLevel.WAW,
		ItemVirtueUsageReq.Builder(),
		EgoArmorItem.Builder(),
		Item.Properties(),
		GeoArmourRenderProvider(ModGeoArmorModel(EGOEquipment.modRl("cobalt_scar"))),
		0.4, 0.8, 0.7, 2.0
	)
	val FAINT_AROMA: Armors<EgoArmorItem> = registerSuit(
		"faint_aroma", "余香", LcLevel.WAW,
		ItemVirtueUsageReq.Builder(),
		EgoArmorItem.Builder(),
		Item.Properties(),
		GeoArmourRenderProvider(ModGeoArmorModel(EGOEquipment.modRl("faint_aroma"))),
		1.2, 0.6, 0.8, 1.5
	)
	val GOLD_RUSH: Armors<EgoArmorItem> = registerSuit(
		"gold_rush", "闪金冲锋", LcLevel.WAW,
		ItemVirtueUsageReq.Builder(),
		EgoArmorItem.Builder(),
		Item.Properties(),
		GeoArmourRenderProvider(ModGeoArmorModel(EGOEquipment.modRl("gold_rush"))),
		0.4, 0.7, 0.8, 2.0
	)
	val SPORE: Armors<EgoArmorItem> = registerSuit(
		"spore", "荧光菌孢", LcLevel.WAW,
		ItemVirtueUsageReq.Builder(),
		EgoArmorItem.Builder(),
		Item.Properties(),
		GeoArmourRenderProvider(ModGeoArmorModel(EGOEquipment.modRl("spore"))),
		0.8, 0.6, 1.2, 1.5
	)
	val ECSTASY: Armors<EgoArmorItem> = registerSuit(
		"ecstasy", "沉醉", LcLevel.WAW,
		ItemVirtueUsageReq.Builder(),
		EgoArmorItem.Builder(),
		Item.Properties(),
		GeoArmourRenderProvider(ModGeoArmorModel(EGOEquipment.modRl("ecstasy"))),
		0.8, 0.8, 0.8, 1.5
	)
	val HEAVEN: Armors<EgoArmorItem> = registerSuit(
		"heaven", "穿刺极乐", LcLevel.WAW,
		ItemVirtueUsageReq.Builder(),
		EgoArmorItem.Builder(),
		Item.Properties(),
		GeoArmourRenderProvider(ModGeoArmorModel(EGOEquipment.modRl("heaven"))),
		1.2, 0.8, 0.6, 1.5
	)
	val THE_SWORD_SHARPENED_WITH_TEARS: Armors<EgoArmorItem> = registerSuit(
		"the_sword_sharpened_with_tears", "盈泪之剑", LcLevel.WAW,
		ItemVirtueUsageReq.Builder(),
		EgoArmorItem.Builder(),
		Item.Properties(),
		GeoArmourRenderProvider(ModGeoArmorModel(EGOEquipment.modRl("the_sword_sharpened_with_tears"))),
		0.8, 0.8, 0.8, 0.8
	)
	val EXUVIAE: Armors<EgoArmorItem> = registerSuit(
		"exuviae", "脱落之皮", LcLevel.WAW,
		ItemVirtueUsageReq.Builder(),
		EgoArmorItem.Builder(),
		Item.Properties(),
		GeoArmourRenderProvider(ModGeoArmorModel(EGOEquipment.modRl("exuviae"))),
		0.6, 0.8, 1.2, 1.5
	)
	val FEATHER_OF_HONOR: Armors<EgoArmorItem> = registerSuit(
		"feather_of_honor", "荣耀之羽", LcLevel.WAW,
		ItemVirtueUsageReq.Builder(),
		EgoArmorItem.Builder(),
		Item.Properties(),
		GeoArmourRenderProvider(ModGeoArmorModel(EGOEquipment.modRl("feather_of_honor"))),
		0.6, 0.6, 1.3, 2.0
	)
	val DISCORD: Armors<EgoArmorItem> = registerSuit(
		"discord", "不和", LcLevel.WAW,
		ItemVirtueUsageReq.Builder(),
		EgoArmorItem.Builder(),
		Item.Properties(),
		GeoArmourRenderProvider(ModGeoArmorModel(EGOEquipment.modRl("discord"))),
		1.2, 0.8, 0.6, 1.5
	)
	val MOONLIGHT: Armors<EgoArmorItem> = registerSuit(
		"moonlight", "月光", LcLevel.WAW,
		ItemVirtueUsageReq.Builder(),
		EgoArmorItem.Builder(),
		Item.Properties(),
		GeoArmourRenderProvider(ModGeoArmorModel(EGOEquipment.modRl("moonlight"))),
		0.8, 0.4, 0.7, 2.0
	)
	val HYPOCRISY: Armors<EgoArmorItem> = registerSuit(
		"hypocrisy", "伪善", LcLevel.WAW,
		ItemVirtueUsageReq.Builder(),
		EgoArmorItem.Builder(),
		Item.Properties(),
		GeoArmourRenderProvider(ModGeoArmorModel(EGOEquipment.modRl("hypocrisy"))),
		0.7, 0.5, 1.3, 1.5
	)
	val AMITA: Armors<EgoArmorItem> = registerSuit(
		"amita", "无量", LcLevel.WAW,
		ItemVirtueUsageReq.Builder(),
		EgoArmorItem.Builder(),
		Item.Properties(),
		GeoArmourRenderProvider(ModGeoArmorModel(EGOEquipment.modRl("amita"))),
		0.5, 1.3, 0.7, 1.5
	)
	//endregion

	//region ALEPH
	val MIMICRY: Armors<EgoArmorItem> = registerSuit(
		"mimicry", "拟态", LcLevel.ALEPH,
		ItemVirtueUsageReq.Builder(),
		EgoArmorItem.Builder(),
		Item.Properties(),
		GeoArmourRenderProvider(ModGeoArmorModel(EGOEquipment.modRl("mimicry"))),
		0.2, 0.5, 0.5, 1.0
	)
	val PARADISE_LOST: Armors<EgoArmorItem> = registerSuit(
		"paradise_lost", "失乐园", LcLevel.ALEPH,
		ItemVirtueUsageReq.Builder(),
		EgoArmorItem.Builder(),
		Item.Properties(),
		GeoArmourRenderProvider(ModGeoArmorModel(EGOEquipment.modRl("paradise_lost"))),
		0.5, 0.5, 0.5, 0.3
	)
	val JUSTITIA: Armors<EgoArmorItem> = registerSuit(
		"justitia", "正义裁决者", LcLevel.ALEPH,
		ItemVirtueUsageReq.Builder(),
		EgoArmorItem.Builder(),
		Item.Properties(),
		GeoArmourRenderProvider(ModGeoArmorModel(EGOEquipment.modRl("justitia"))),
		0.5, 0.5, 0.5, 0.5
	)
	val TWILIGHT: Armors<EgoArmorItem> = registerSuit(
		"twilight", "薄暝", LcLevel.ALEPH,
		ItemVirtueUsageReq.Builder(),
		EgoArmorItem.Builder(),
		Item.Properties(),
		GeoArmourRenderProvider(ModGeoArmorModel(EGOEquipment.modRl("twilight"))),
		0.3, 0.3, 0.3, 0.5
	)
	val SMILE: Armors<EgoArmorItem> = registerSuit(
		"smile", "笑靥", LcLevel.ALEPH,
		ItemVirtueUsageReq.Builder(),
		EgoArmorItem.Builder(),
		Item.Properties(),
		GeoArmourRenderProvider(ModGeoArmorModel(EGOEquipment.modRl("smile"))),
		0.5, 0.5, 0.2, 1.0
	)
	val SOUND_OF_A_STAR: Armors<EgoArmorItem> = registerSuit(
		"sound_of_a_star", "新星之声", LcLevel.ALEPH,
		ItemVirtueUsageReq.Builder(),
		EgoArmorItem.Builder(),
		Item.Properties(),
		GeoArmourRenderProvider(ModGeoArmorModel(EGOEquipment.modRl("sound_of_a_star"))),
		0.4, 0.4, 0.4, 1.0
	)
	val ADORATION: Armors<EgoArmorItem> = registerSuit(
		"adoration", "爱慕", LcLevel.ALEPH,
		ItemVirtueUsageReq.Builder(),
		EgoArmorItem.Builder(),
		Item.Properties(),
		GeoArmourRenderProvider(ModGeoArmorModel(EGOEquipment.modRl("adoration"))),
		0.3, 0.6, 0.3, 1.0
	)
	val PINK: Armors<EgoArmorItem> = registerSuit(
		"pink", "粉红军备", LcLevel.ALEPH,
		ItemVirtueUsageReq.Builder(),
		EgoArmorItem.Builder(),
		Item.Properties(),
		GeoArmourRenderProvider(ModGeoArmorModel(EGOEquipment.modRl("pink"))),
		0.5, 0.3, 0.4, 1.0
	)
	//endregion

	@JvmStatic
	fun getArmorMaterialHolder(lcLevel: LcLevel): Holder<ArmorMaterial> = when (lcLevel) {
		LcLevel.ZAYIN -> EGOEquipmentArmorMaterials.ZAYIN
		LcLevel.TETH -> EGOEquipmentArmorMaterials.TETH
		LcLevel.HE -> EGOEquipmentArmorMaterials.HE
		LcLevel.WAW -> EGOEquipmentArmorMaterials.WAW
		LcLevel.ALEPH -> EGOEquipmentArmorMaterials.ALEPH
	}

	private fun registerSuit(
		id: String, zhName: String, lcLevel: LcLevel,
		virtueUsageReqBuilder: ItemVirtueUsageReq.Builder,
		builder: EgoArmorItem.Builder,
		properties: Item.Properties,
		renderProvider: GeoRenderProvider,
		physics: Double, spirit: Double, erosion: Double, theSoul: Double
	): Armors<EgoArmorItem> = registerSuit(
		id, zhName, lcLevel, virtueUsageReqBuilder,
		builder, properties, renderProvider, physics, spirit, erosion, theSoul
	) { mat, type, prop, bld, rp -> EgoArmorItem(mat, type, prop, bld, rp) }

	private fun <T : EgoArmorItem> registerSuit(
		id: String, zhName: String, lcLevel: LcLevel,
		virtueUsageReqBuilder: ItemVirtueUsageReq.Builder,
		builder: EgoArmorItem.Builder,
		properties: Item.Properties,
		renderProvider: GeoRenderProvider,
		physics: Double, spirit: Double, erosion: Double, theSoul: Double,
		function: Function5<Holder<ArmorMaterial>, ArmorItem.Type, Item.Properties, EgoArmorItem.Builder, GeoRenderProvider, T>
	): Armors<EgoArmorItem> = registerSuit(
		id, zhName, lcLevel, getArmorMaterialHolder(lcLevel), virtueUsageReqBuilder,
		builder, properties, renderProvider, physics, spirit, erosion, theSoul, function, function, function
	)

	private fun <C : EgoArmorItem, L : EgoArmorItem, B : EgoArmorItem> registerSuit(
		id: String, zhName: String, lcLevel: LcLevel,
		material: Holder<ArmorMaterial>,
		virtueUsageReqBuilder: ItemVirtueUsageReq.Builder,
		builder: EgoArmorItem.Builder,
		properties: Item.Properties,
		renderProvider: GeoRenderProvider,
		physics: Double, spirit: Double, erosion: Double, theSoul: Double,
		chestplateFunction: Function5<Holder<ArmorMaterial>, ArmorItem.Type, Item.Properties, EgoArmorItem.Builder, GeoRenderProvider, C>,
		leggingsFunction: Function5<Holder<ArmorMaterial>, ArmorItem.Type, Item.Properties, EgoArmorItem.Builder, GeoRenderProvider, L>,
		bootsFunction: Function5<Holder<ArmorMaterial>, ArmorItem.Type, Item.Properties, EgoArmorItem.Builder, GeoRenderProvider, B>
	): Armors<EgoArmorItem> {
		val physicsArray = splitIntoThreeUnequalParts(physics - LibAttributes.PHYSICS_VULNERABLE_DEFAULT_VALUE)
		val spiritArray = splitIntoThreeUnequalParts(spirit - LibAttributes.SPIRIT_VULNERABLE_DEFAULT_VALUE)
		val erosionArray = splitIntoThreeUnequalParts(erosion - LibAttributes.EROSION_VULNERABLE_DEFAULT_VALUE)
		val theSoulArray = splitIntoThreeUnequalParts(theSoul - LibAttributes.THE_SOUL_VULNERABLE_DEFAULT_VALUE)
		return Armors(
			register(
				id + "_" + ArmorItem.Type.CHESTPLATE.name,
				zhName,
				lcLevel,
				ArmorItem.Type.CHESTPLATE,
				material,
				virtueUsageReqBuilder,
				builder,
				properties,
				renderProvider,
				physicsArray[2],
				spiritArray[2],
				erosionArray[2],
				theSoulArray[2],
				chestplateFunction
			),
			register(
				id + "_" + ArmorItem.Type.LEGGINGS.name,
				zhName,
				lcLevel,
				ArmorItem.Type.LEGGINGS,
				material,
				virtueUsageReqBuilder,
				builder,
				properties,
				renderProvider,
				physicsArray[1],
				spiritArray[1],
				erosionArray[1],
				theSoulArray[1],
				leggingsFunction
			),
			register(
				id + "_" + ArmorItem.Type.BOOTS.name,
				zhName,
				lcLevel,
				ArmorItem.Type.BOOTS,
				material,
				virtueUsageReqBuilder,
				builder,
				properties,
				renderProvider,
				physicsArray[0],
				spiritArray[0],
				erosionArray[0],
				theSoulArray[0],
				bootsFunction
			)
		)
	}

	private fun <I : EgoArmorItem> register(
		id: String, zhName: String, lcLevel: LcLevel,
		armorItemType: ArmorItem.Type,
		material: Holder<ArmorMaterial>,
		virtueUsageReqBuilder: ItemVirtueUsageReq.Builder,
		builder: EgoArmorItem.Builder,
		properties: Item.Properties,
		renderProvider: GeoRenderProvider,
		physics: Double, spirit: Double, erosion: Double, theSoul: Double,
		item: Function5<Holder<ArmorMaterial>, ArmorItem.Type, Item.Properties, EgoArmorItem.Builder, GeoRenderProvider, I>
	): DeferredItem<I> {
		val deferredItem = REGISTRY.register(id) {
			item.apply(
				material, armorItemType, properties, builder
					.virtueUsageReqBuilder(virtueUsageReqBuilder)
					.vulnerable(physics, spirit, erosion, theSoul), renderProvider
			)
		}
		LcLevelUtil.addItemLcLevelCapability(lcLevel, deferredItem)
		when (armorItemType) {
			ArmorItem.Type.HELMET -> EGOEquipmentConstants.HEAD_ARMOR.add(deferredItem)
			ArmorItem.Type.CHESTPLATE -> EGOEquipmentConstants.CHEST_ARMOR.add(deferredItem)
			ArmorItem.Type.LEGGINGS -> EGOEquipmentConstants.LEG_ARMOR.add(deferredItem)
			ArmorItem.Type.BOOTS -> EGOEquipmentConstants.FOOT_ARMOR.add(deferredItem)
			else -> {}
		}
		EGOEquipmentConstants.EGO_ARMOUR.add(deferredItem)
		ZhCn.addI18nItemText(zhName) { deferredItem.get() }
		return deferredItem
	}

	private fun splitIntoThreeUnequalParts(n: Double): DoubleArray {
		val avg = n / 3.0
		return doubleArrayOf(avg - 0.01, avg, avg + 0.01)
	}
}
