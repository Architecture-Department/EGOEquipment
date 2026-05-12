package architecture.ego_equipment.init;

import architecture.ego_equipment.common.item.armor.EgoArmorItem;
import architecture.ego_equipment.core.EGOEquipment;
import architecture.ego_equipment.core.EGOEquipmentConstants;
import architecture.ego_equipment.datagen.i18n.ZhCn;
import architecture.goldenboughs_lib.api.Armors;
import architecture.goldenboughs_lib.api.LcLevel;
import architecture.goldenboughs_lib.client.model.armor.ModGeoArmorModel;
import architecture.goldenboughs_lib.client.renderer.GeoArmourRenderProvider;
import architecture.goldenboughs_lib.common.data_component.ItemVirtueUsageReq;
import architecture.goldenboughs_lib.init.LibAttributes;
import architecture.goldenboughs_lib.util.LcLevelUtil;
import com.mojang.datafixers.util.Function5;
import net.minecraft.core.Holder;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;

public final class EGOArmorItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(EGOEquipment.ID);

	//region ZAYIN

	public static final Armors<EgoArmorItem> PENITENCE = registerSuit(
		"penitence", "忏悔", LcLevel.ZAYIN,
		new ItemVirtueUsageReq.Builder(),
		new EgoArmorItem.Builder(),
		new Item.Properties(),
		new GeoArmourRenderProvider<>(new ModGeoArmorModel<>(EGOEquipment.modRl("penitence"))),
		0.9, 0.8, 0.9, 2.0);

	public static final Armors<EgoArmorItem> SODA = registerSuit(
		"soda", "美味苏打", LcLevel.ZAYIN,
		new ItemVirtueUsageReq.Builder(),
		new EgoArmorItem.Builder(),
		new Item.Properties(),
		new GeoArmourRenderProvider<>(new ModGeoArmorModel<>(EGOEquipment.modRl("soda"))),
		0.8, 1.0, 1.0, 2.0);

	public static final Armors<EgoArmorItem> WINGBEAT = registerSuit(
		"wingbeat", "翅振", LcLevel.ZAYIN,
		new ItemVirtueUsageReq.Builder(),
		new EgoArmorItem.Builder(),
		new Item.Properties(),
		new GeoArmourRenderProvider<>(new ModGeoArmorModel<>(EGOEquipment.modRl("wingbeat"))),
		0.8, 0.8, 1.0, 2.0);
	//endregion

	//region TETH

	public static final Armors<EgoArmorItem> STANDARD_TRAINING_EGO = registerSuit(
		"standard_training_ego", "教学用E.G.O", LcLevel.TETH,
		new ItemVirtueUsageReq.Builder(),
		new EgoArmorItem.Builder(),
		new Item.Properties(),
		new GeoArmourRenderProvider<>(new ModGeoArmorModel<>(EGOEquipment.modRl("standard_training_ego"))),
		0.5, 1.0, 1.5, 2.0);

	public static final Armors<EgoArmorItem> FOURTH_MATCH_FLAME = registerSuit(
		"fourth_match_flame", "终末火柴之光", LcLevel.TETH,
		new ItemVirtueUsageReq.Builder(),
		new EgoArmorItem.Builder(),
		new Item.Properties(),
		new GeoArmourRenderProvider<>(new ModGeoArmorModel<>(EGOEquipment.modRl("fourth_match_flame"))),
		0.6, 1.0, 1.5, 2.0);

	public static final Armors<EgoArmorItem> IN_THE_NAME_OF_LOVE_AND_HATE = registerSuit(
		"in_the_name_of_love_and_hate", "以爱与恨之名", LcLevel.TETH,
		new ItemVirtueUsageReq.Builder(),
		new EgoArmorItem.Builder(),
		new Item.Properties(),
		new GeoArmourRenderProvider<>(new ModGeoArmorModel<>(EGOEquipment.modRl("in_the_name_of_love_and_hate"))),
		0.7, 0.8, 0.4, 2.0);

	public static final Armors<EgoArmorItem> RED_EYES = registerSuit(
		"red_eyes", "赤瞳", LcLevel.TETH,
		new ItemVirtueUsageReq.Builder(),
		new EgoArmorItem.Builder(),
		new Item.Properties(),
		new GeoArmourRenderProvider<>(new ModGeoArmorModel<>(EGOEquipment.modRl("red_eyes"))),
		0.8, 0.8, 0.8, 2.0);

	public static final Armors<EgoArmorItem> HORN = registerSuit(
		"horn", "犄角", LcLevel.TETH,
		new ItemVirtueUsageReq.Builder(),
		new EgoArmorItem.Builder(),
		new Item.Properties(),
		new GeoArmourRenderProvider<>(new ModGeoArmorModel<>(EGOEquipment.modRl("horn"))),
		0.8, 0.8, 1.5, 2.0);

	public static final Armors<EgoArmorItem> SOLITUDE = registerSuit(
		"solitude", "孤独", LcLevel.TETH,
		new ItemVirtueUsageReq.Builder(),
		new EgoArmorItem.Builder(),
		new Item.Properties(),
		new GeoArmourRenderProvider<>(new ModGeoArmorModel<>(EGOEquipment.modRl("solitude"))),
		1.5, 0.8, 0.8, 2.0);

	public static final Armors<EgoArmorItem> SCREAMING_WEDGE = registerSuit(
		"screaming_wedge", "刺耳嚎叫", LcLevel.TETH,
		new ItemVirtueUsageReq.Builder(),
		new EgoArmorItem.Builder(),
		new Item.Properties(),
		new GeoArmourRenderProvider<>(new ModGeoArmorModel<>(EGOEquipment.modRl("screaming_wedge"))),
		1.2, 0.6, 1.0, 2.0);

	public static final Armors<EgoArmorItem> NOISE = registerSuit(
		"noise", "噪音", LcLevel.TETH,
		new ItemVirtueUsageReq.Builder(),
		new EgoArmorItem.Builder(),
		new Item.Properties(),
		new GeoArmourRenderProvider<>(new ModGeoArmorModel<>(EGOEquipment.modRl("noise"))),
		1.2, 0.7, 0.6, 2.0);

	public static final Armors<EgoArmorItem> WRIST_CUTTER = registerSuit(
		"wrist_cutter", "割腕者", LcLevel.TETH,
		new ItemVirtueUsageReq.Builder(),
		new EgoArmorItem.Builder(),
		new Item.Properties(),
		new GeoArmourRenderProvider<>(new ModGeoArmorModel<>(EGOEquipment.modRl("wrist_cutter"))),
		1.0, 0.6, 1.2, 2.0);

	public static final Armors<EgoArmorItem> FRAGMENTS_FROM_SOMEWHERE = registerSuit(
		"fragments_from_somewhere", "彼方的裂片", LcLevel.TETH,
		new ItemVirtueUsageReq.Builder(),
		new EgoArmorItem.Builder(),
		new Item.Properties(),
		new GeoArmourRenderProvider<>(new ModGeoArmorModel<>(EGOEquipment.modRl("fragments_from_somewhere"))),
		1.0, 1.2, 0.6, 2.0);

	public static final Armors<EgoArmorItem> REGRET = registerSuit(
		"regret", "悔恨", LcLevel.TETH,
		new ItemVirtueUsageReq.Builder(),
		new EgoArmorItem.Builder(),
		new Item.Properties(),
		new GeoArmourRenderProvider<>(new ModGeoArmorModel<>(EGOEquipment.modRl("regret"))),
		0.7, 1.2, 0.8, 2.0);

	public static final Armors<EgoArmorItem> BEAK = registerSuit(
		"beak", "小喙", LcLevel.TETH,
		new ItemVirtueUsageReq.Builder(),
		new EgoArmorItem.Builder(),
		new Item.Properties(),
		new GeoArmourRenderProvider<>(new ModGeoArmorModel<>(EGOEquipment.modRl("beak"))),
		0.7, 0.8, 1.2, 2.0);

	public static final Armors<EgoArmorItem> LANTERN = registerSuit(
		"lantern", "诱捕幻灯", LcLevel.TETH,
		new ItemVirtueUsageReq.Builder(),
		new EgoArmorItem.Builder(),
		new Item.Properties(),
		new GeoArmourRenderProvider<>(new ModGeoArmorModel<>(EGOEquipment.modRl("lantern"))),
		0.8, 0.7, 1.2, 2.0);

	public static final Armors<EgoArmorItem> TODAY_IS_EXPRESSION = registerSuit(
		"today_is_expression", "此刻的神色", LcLevel.TETH,
		new ItemVirtueUsageReq.Builder(),
		new EgoArmorItem.Builder(),
		new Item.Properties(),
		new GeoArmourRenderProvider<>(new ModGeoArmorModel<>(EGOEquipment.modRl("today_is_expression"))),
		0.7, 0.6, 1.5, 2.0);

	public static final Armors<EgoArmorItem> SO_CUTE = registerSuit(
		"so_cute", "超特么可爱！！！", LcLevel.TETH,
		new ItemVirtueUsageReq.Builder(),
		new EgoArmorItem.Builder(),
		new Item.Properties(),
		new GeoArmourRenderProvider<>(new ModGeoArmorModel<>(EGOEquipment.modRl("so_cute"))),
		0.8, 1.5, 0.8, 2.0);

	public static final Armors<EgoArmorItem> LIFE_FOR_A_DAREDEVIL = registerSuit(
		"life_for_a_daredevil", "决死之心", LcLevel.TETH,
		new ItemVirtueUsageReq.Builder(),
		new EgoArmorItem.Builder(),
		new Item.Properties(),
		new GeoArmourRenderProvider<>(new ModGeoArmorModel<>(EGOEquipment.modRl("life_for_a_daredevil"))),
		0.6, 0.9, 0.9, 2.0);

	public static final Armors<EgoArmorItem> ENGULFING_DREAM = registerSuit(
		"engulfing_dream", "迷魂梦境", LcLevel.TETH,
		new ItemVirtueUsageReq.Builder(),
		new EgoArmorItem.Builder(),
		new Item.Properties(),
		new GeoArmourRenderProvider<>(new ModGeoArmorModel<>(EGOEquipment.modRl("engulfing_dream"))),
		1.2, 0.8, 0.7, 2.0);

	public static final Armors<EgoArmorItem> CHERRY_BLOSSOMS = registerSuit(
		"cherry_blossoms", "落樱", LcLevel.TETH,
		new ItemVirtueUsageReq.Builder(),
		new EgoArmorItem.Builder(),
		new Item.Properties(),
		new GeoArmourRenderProvider<>(new ModGeoArmorModel<>(EGOEquipment.modRl("cherry_blossoms"))),
		1.2, 0.6, 0.7, 2.0);

	public static final Armors<EgoArmorItem> TOUGH = registerSuit(
		"tough", "谢顶之灾", LcLevel.TETH,
		new ItemVirtueUsageReq.Builder(),
		new EgoArmorItem.Builder(),
		new Item.Properties(),
		new GeoArmourRenderProvider<>(new ModGeoArmorModel<>(EGOEquipment.modRl("tough"))),
		1.0, 1.0, 0.8, 2.0);
	//endregion

	//region HE

	public static final Armors<EgoArmorItem> BEAR_PAWS = registerSuit(
		"bear_paws", "熊熊抱", LcLevel.HE,
		new ItemVirtueUsageReq.Builder(),
		new EgoArmorItem.Builder(),
		new Item.Properties(),
		new GeoArmourRenderProvider<>(new ModGeoArmorModel<>(EGOEquipment.modRl("bear_paws"))),
		0.8, 1.0, 1.0, 1.5);

	public static final Armors<EgoArmorItem> SANGUINE_DESIRE = registerSuit(
		"sanguine_desire", "血之渴望", LcLevel.HE,
		new ItemVirtueUsageReq.Builder(),
		new EgoArmorItem.Builder(),
		new Item.Properties(),
		new GeoArmourRenderProvider<>(new ModGeoArmorModel<>(EGOEquipment.modRl("sanguine_desire"))),
		0.5, 1.2, 0.8, 1.5);

	public static final Armors<EgoArmorItem> SYRINX = registerSuit(
		"syrinx", "泣婴", LcLevel.HE,
		new ItemVirtueUsageReq.Builder(),
		new EgoArmorItem.Builder(),
		new Item.Properties(),
		new GeoArmourRenderProvider<>(new ModGeoArmorModel<>(EGOEquipment.modRl("syrinx"))),
		1.2, 0.5, 0.8, 1.5);

	public static final Armors<EgoArmorItem> DA_CAPO = registerSuit(
		"da_capo", "Da Capo", LcLevel.HE,
		new ItemVirtueUsageReq.Builder(),
		new EgoArmorItem.Builder(),
		new Item.Properties(),
		new GeoArmourRenderProvider<>(new ModGeoArmorModel<>(EGOEquipment.modRl("da_capo"))),
		0.5, 0.2, 0.5, 1.5);

	public static final Armors<EgoArmorItem> LOGGING = registerSuit(
		"logging", "伐木者", LcLevel.HE,
		new ItemVirtueUsageReq.Builder(),
		new EgoArmorItem.Builder(),
		new Item.Properties(),
		new GeoArmourRenderProvider<>(new ModGeoArmorModel<>(EGOEquipment.modRl("logging"))),
		0.8, 1.2, 0.8, 1.5);

	public static final Armors<EgoArmorItem> FROST_SPLINTER = registerSuit(
		"frost_splinter", "霜之碎片", LcLevel.HE,
		new ItemVirtueUsageReq.Builder(),
		new EgoArmorItem.Builder(),
		new Item.Properties(),
		new GeoArmourRenderProvider<>(new ModGeoArmorModel<>(EGOEquipment.modRl("frost_splinter"))),
		1.3, 0.6, 0.8, 1.5);

	public static final Armors<EgoArmorItem> GRINDER_MK4 = registerSuit(
		"grinder_mk4", "粉碎机Mk4", LcLevel.HE,
		new ItemVirtueUsageReq.Builder(),
		new EgoArmorItem.Builder(),
		new Item.Properties(),
		new GeoArmourRenderProvider<>(new ModGeoArmorModel<>(EGOEquipment.modRl("grinder_mk4"))),
		0.6, 1.3, 0.9, 1.5);

	public static final Armors<EgoArmorItem> CHRISTMAS = registerSuit(
		"christmas", "悲惨圣诞", LcLevel.HE,
		new ItemVirtueUsageReq.Builder(),
		new EgoArmorItem.Builder(),
		new Item.Properties(),
		new GeoArmourRenderProvider<>(new ModGeoArmorModel<>(EGOEquipment.modRl("christmas"))),
		0.8, 0.6, 1.3, 1.5);

	public static final Armors<EgoArmorItem> HORNET = registerSuit(
		"hornet", "黄蜂", LcLevel.HE,
		new ItemVirtueUsageReq.Builder(),
		new EgoArmorItem.Builder(),
		new Item.Properties(),
		new GeoArmourRenderProvider<>(new ModGeoArmorModel<>(EGOEquipment.modRl("hornet"))),
		0.7, 0.7, 0.7, 1.5);

	public static final Armors<EgoArmorItem> OUR_GALAXY = registerSuit(
		"our_galaxy", "小小银河", LcLevel.HE,
		new ItemVirtueUsageReq.Builder(),
		new EgoArmorItem.Builder(),
		new Item.Properties(),
		new GeoArmourRenderProvider<>(new ModGeoArmorModel<>(EGOEquipment.modRl("our_galaxy"))),
		0.8, 0.8, 1.2, 1.5);

	public static final Armors<EgoArmorItem> LAETITIA = registerSuit(
		"laetitia", "蕾蒂希娅", LcLevel.HE,
		new ItemVirtueUsageReq.Builder(),
		new EgoArmorItem.Builder(),
		new Item.Properties(),
		new GeoArmourRenderProvider<>(new ModGeoArmorModel<>(EGOEquipment.modRl("laetitia"))),
		0.7, 0.7, 0.7, 1.5);

	public static final Armors<EgoArmorItem> SOLEMN_LAMENT = registerSuit(
		"solemn_lament", "圣宣", LcLevel.HE,
		new ItemVirtueUsageReq.Builder(),
		new EgoArmorItem.Builder(),
		new Item.Properties(),
		new GeoArmourRenderProvider<>(new ModGeoArmorModel<>(EGOEquipment.modRl("solemn_lament"))),
		1.2, 0.8, 0.5, 1.5);

	// TODO 披风适配
	public static final Armors<EgoArmorItem> MAGIC_BULLET = registerSuit(
		"magic_bullet", "魔弹", LcLevel.HE,
		new ItemVirtueUsageReq.Builder(),
		new EgoArmorItem.Builder(),
		new Item.Properties(),
		new GeoArmourRenderProvider<>(new ModGeoArmorModel<>(EGOEquipment.modRl("magic_bullet"))),
		0.7, 0.7, 0.7, 1.5);

	public static final Armors<EgoArmorItem> BLACK_SWAN = registerSuit(
		"black_swan", "黑天鹅", LcLevel.HE,
		new ItemVirtueUsageReq.Builder(),
		new EgoArmorItem.Builder(),
		new Item.Properties(),
		new GeoArmourRenderProvider<>(new ModGeoArmorModel<>(EGOEquipment.modRl("black_swan"))),
		0.6, 1.2, 0.8, 1.5);

	public static final Armors<EgoArmorItem> PLEASURE = registerSuit(
		"pleasure", "因乐癫狂", LcLevel.HE,
		new ItemVirtueUsageReq.Builder(),
		new EgoArmorItem.Builder(),
		new Item.Properties(),
		new GeoArmourRenderProvider<>(new ModGeoArmorModel<>(EGOEquipment.modRl("pleasure"))),
		1.2, 0.8, 0.8, 1.5);

	public static final Armors<EgoArmorItem> GAZE = registerSuit(
		"gaze", "凝视", LcLevel.HE,
		new ItemVirtueUsageReq.Builder(),
		new EgoArmorItem.Builder(),
		new Item.Properties(),
		new GeoArmourRenderProvider<>(new ModGeoArmorModel<>(EGOEquipment.modRl("gaze"))),
		1.0, 0.8, 1.0, 1.5);

	public static final Armors<EgoArmorItem> HARVEST = registerSuit(
		"harvest", "猎头长耙", LcLevel.HE,
		new ItemVirtueUsageReq.Builder(),
		new EgoArmorItem.Builder(),
		new Item.Properties(),
		new GeoArmourRenderProvider<>(new ModGeoArmorModel<>(EGOEquipment.modRl("harvest"))),
		0.6, 0.8, 1.3, 1.5);
	//endregion

	//region WAW

	public static final Armors<EgoArmorItem> LAMP = registerSuit(
		"lamp", "目灯", LcLevel.WAW,
		new ItemVirtueUsageReq.Builder(),
		new EgoArmorItem.Builder(),
		new Item.Properties(),
		new GeoArmourRenderProvider<>(new ModGeoArmorModel<>(EGOEquipment.modRl("lamp"))),
		0.8, 0.7, 0.4, 1.5);

	public static final Armors<EgoArmorItem> GREEN_STEM = registerSuit(
		"green_stem", "绿色枝干", LcLevel.WAW,
		new ItemVirtueUsageReq.Builder(),
		new EgoArmorItem.Builder(),
		new Item.Properties(),
		new GeoArmourRenderProvider<>(new ModGeoArmorModel<>(EGOEquipment.modRl("green_stem"))),
		0.8, 1.2, 0.6, 1.5);

	public static final Armors<EgoArmorItem> CRIMSON_SCAR = registerSuit(
		"crimson_scar", "猩红创痕", LcLevel.WAW,
		new ItemVirtueUsageReq.Builder(),
		new EgoArmorItem.Builder(),
		new Item.Properties(),
		new GeoArmourRenderProvider<>(new ModGeoArmorModel<>(EGOEquipment.modRl("crimson_scar"))),
		0.6, 0.6, 0.6, 1.5);

	public static final Armors<EgoArmorItem> COBALT_SCAR = registerSuit(
		"cobalt_scar", "郁蓝创痕", LcLevel.WAW,
		new ItemVirtueUsageReq.Builder(),
		new EgoArmorItem.Builder(),
		new Item.Properties(),
		new GeoArmourRenderProvider<>(new ModGeoArmorModel<>(EGOEquipment.modRl("cobalt_scar"))),
		0.4, 0.8, 0.7, 2.0);

	public static final Armors<EgoArmorItem> FAINT_AROMA = registerSuit(
		"faint_aroma", "余香", LcLevel.WAW,
		new ItemVirtueUsageReq.Builder(),
		new EgoArmorItem.Builder(),
		new Item.Properties(),
		new GeoArmourRenderProvider<>(new ModGeoArmorModel<>(EGOEquipment.modRl("faint_aroma"))),
		1.2, 0.6, 0.8, 1.5);

	public static final Armors<EgoArmorItem> GOLD_RUSH = registerSuit(
		"gold_rush", "闪金冲锋", LcLevel.WAW,
		new ItemVirtueUsageReq.Builder(),
		new EgoArmorItem.Builder(),
		new Item.Properties(),
		new GeoArmourRenderProvider<>(new ModGeoArmorModel<>(EGOEquipment.modRl("gold_rush"))),
		0.4, 0.7, 0.8, 2.0);

	public static final Armors<EgoArmorItem> SPORE = registerSuit(
		"spore", "荧光菌孢", LcLevel.WAW,
		new ItemVirtueUsageReq.Builder(),
		new EgoArmorItem.Builder(),
		new Item.Properties(),
		new GeoArmourRenderProvider<>(new ModGeoArmorModel<>(EGOEquipment.modRl("spore"))),
		0.8, 0.6, 1.2, 1.5);

	public static final Armors<EgoArmorItem> ECSTASY = registerSuit(
		"ecstasy", "沉醉", LcLevel.WAW,
		new ItemVirtueUsageReq.Builder(),
		new EgoArmorItem.Builder(),
		new Item.Properties(),
		new GeoArmourRenderProvider<>(new ModGeoArmorModel<>(EGOEquipment.modRl("ecstasy"))),
		0.8, 0.8, 0.8, 1.5);

	public static final Armors<EgoArmorItem> HEAVEN = registerSuit(
		"heaven", "穿刺极乐", LcLevel.WAW,
		new ItemVirtueUsageReq.Builder(),
		new EgoArmorItem.Builder(),
		new Item.Properties(),
		new GeoArmourRenderProvider<>(new ModGeoArmorModel<>(EGOEquipment.modRl("heaven"))),
		1.2, 0.8, 0.6, 1.5);

	public static final Armors<EgoArmorItem> THE_SWORD_SHARPENED_WITH_TEARS = registerSuit(
		"the_sword_sharpened_with_tears", "盈泪之剑", LcLevel.WAW,
		new ItemVirtueUsageReq.Builder(),
		new EgoArmorItem.Builder(),
		new Item.Properties(),
		new GeoArmourRenderProvider<>(new ModGeoArmorModel<>(EGOEquipment.modRl("the_sword_sharpened_with_tears"))),
		0.8, 0.8, 0.8, 0.8);

	public static final Armors<EgoArmorItem> EXUVIAE = registerSuit(
		"exuviae", "脱落之皮", LcLevel.WAW,
		new ItemVirtueUsageReq.Builder(),
		new EgoArmorItem.Builder(),
		new Item.Properties(),
		new GeoArmourRenderProvider<>(new ModGeoArmorModel<>(EGOEquipment.modRl("exuviae"))),
		0.6, 0.8, 1.2, 1.5);

	public static final Armors<EgoArmorItem> FEATHER_OF_HONOR = registerSuit(
		"feather_of_honor", "荣耀之羽", LcLevel.WAW,
		new ItemVirtueUsageReq.Builder(),
		new EgoArmorItem.Builder(),
		new Item.Properties(),
		new GeoArmourRenderProvider<>(new ModGeoArmorModel<>(EGOEquipment.modRl("feather_of_honor"))),
		0.6, 0.6, 1.3, 2.0);

	public static final Armors<EgoArmorItem> DISCORD = registerSuit(
		"discord", "不和", LcLevel.WAW,
		new ItemVirtueUsageReq.Builder(),
		new EgoArmorItem.Builder(),
		new Item.Properties(),
		new GeoArmourRenderProvider<>(new ModGeoArmorModel<>(EGOEquipment.modRl("discord"))),
		1.2, 0.8, 0.6, 1.5);

	public static final Armors<EgoArmorItem> MOONLIGHT = registerSuit(
		"moonlight", "月光", LcLevel.WAW,
		new ItemVirtueUsageReq.Builder(),
		new EgoArmorItem.Builder(),
		new Item.Properties(),
		new GeoArmourRenderProvider<>(new ModGeoArmorModel<>(EGOEquipment.modRl("moonlight"))),
		0.8, 0.4, 0.7, 2.0);

	public static final Armors<EgoArmorItem> HYPOCRISY = registerSuit(
		"hypocrisy", "伪善", LcLevel.WAW,
		new ItemVirtueUsageReq.Builder(),
		new EgoArmorItem.Builder(),
		new Item.Properties(),
		new GeoArmourRenderProvider<>(new ModGeoArmorModel<>(EGOEquipment.modRl("hypocrisy"))),
		0.7, 0.5, 1.3, 1.5);

	public static final Armors<EgoArmorItem> AMITA = registerSuit(
		"amita", "无量", LcLevel.WAW,
		new ItemVirtueUsageReq.Builder(),
		new EgoArmorItem.Builder(),
		new Item.Properties(),
		new GeoArmourRenderProvider<>(new ModGeoArmorModel<>(EGOEquipment.modRl("amita"))),
		0.5, 1.3, 0.7, 1.5);
	//endregion

	//region ALEPH

	public static final Armors<EgoArmorItem> MIMICRY = registerSuit(
		"mimicry", "拟态", LcLevel.ALEPH,
		new ItemVirtueUsageReq.Builder(),
		new EgoArmorItem.Builder(),
		new Item.Properties(),
		new GeoArmourRenderProvider<>(new ModGeoArmorModel<>(EGOEquipment.modRl("mimicry"))),
		0.2, 0.5, 0.5, 1.0);

	public static final Armors<EgoArmorItem> PARADISE_LOST = registerSuit(
		"paradise_lost", "失乐园", LcLevel.ALEPH,
		new ItemVirtueUsageReq.Builder(),
		new EgoArmorItem.Builder(),
		new Item.Properties(),
		new GeoArmourRenderProvider<>(new ModGeoArmorModel<>(EGOEquipment.modRl("paradise_lost"))),
		0.5, 0.5, 0.5, 0.3);

	public static final Armors<EgoArmorItem> JUSTITIA = registerSuit(
		"justitia", "正义裁决者", LcLevel.ALEPH,
		new ItemVirtueUsageReq.Builder(),
		new EgoArmorItem.Builder(),
		new Item.Properties(),
		new GeoArmourRenderProvider<>(new ModGeoArmorModel<>(EGOEquipment.modRl("justitia"))),
		0.5, 0.5, 0.5, 0.5);

	public static final Armors<EgoArmorItem> TWILIGHT = registerSuit(
		"twilight", "薄暝", LcLevel.ALEPH,
		new ItemVirtueUsageReq.Builder(),
		new EgoArmorItem.Builder(),
		new Item.Properties(),
		new GeoArmourRenderProvider<>(new ModGeoArmorModel<>(EGOEquipment.modRl("twilight"))),
		0.3, 0.3, 0.3, 0.5);

	public static final Armors<EgoArmorItem> SMILE = registerSuit(
		"smile", "笑靥", LcLevel.ALEPH,
		new ItemVirtueUsageReq.Builder(),
		new EgoArmorItem.Builder(),
		new Item.Properties(),
		new GeoArmourRenderProvider<>(new ModGeoArmorModel<>(EGOEquipment.modRl("smile"))),
		0.5, 0.5, 0.2, 1.0);

	public static final Armors<EgoArmorItem> SOUND_OF_A_STAR = registerSuit(
		"sound_of_a_star", "新星之声", LcLevel.ALEPH,
		new ItemVirtueUsageReq.Builder(),
		new EgoArmorItem.Builder(),
		new Item.Properties(),
		new GeoArmourRenderProvider<>(new ModGeoArmorModel<>(EGOEquipment.modRl("sound_of_a_star"))),
		0.4, 0.4, 0.4, 1.0);

	public static final Armors<EgoArmorItem> ADORATION = registerSuit(
		"adoration", "爱慕", LcLevel.ALEPH,
		new ItemVirtueUsageReq.Builder(),
		new EgoArmorItem.Builder(),
		new Item.Properties(),
		new GeoArmourRenderProvider<>(new ModGeoArmorModel<>(EGOEquipment.modRl("adoration"))),
		0.3, 0.6, 0.3, 1.0);

	public static final Armors<EgoArmorItem> PINK = registerSuit(
		"pink", "粉红军备", LcLevel.ALEPH,
		new ItemVirtueUsageReq.Builder(),
		new EgoArmorItem.Builder(),
		new Item.Properties(),
		new GeoArmourRenderProvider<>(new ModGeoArmorModel<>(EGOEquipment.modRl("pink"))),
		0.5, 0.3, 0.4, 1.0);
	//endregion

	private static Armors<EgoArmorItem> registerSuit(
		String id,
		String zhName,
		LcLevel lcLevel,
		ItemVirtueUsageReq.Builder virtueUsageReqBuilder,
		EgoArmorItem.Builder builder,
		Item.Properties properties,
		GeoRenderProvider renderProvider,
		double physics,
		double spirit,
		double erosion,
		double theSoul
	) {
		return registerSuit(id, zhName, lcLevel, virtueUsageReqBuilder,
			builder, properties, renderProvider, physics, spirit, erosion, theSoul, EgoArmorItem::new);
	}

	private static <T extends EgoArmorItem> Armors<EgoArmorItem> registerSuit(
		String id,
		String zhName,
		LcLevel lcLevel,
		ItemVirtueUsageReq.Builder virtueUsageReqBuilder,
		EgoArmorItem.Builder builder,
		Item.Properties properties,
		GeoRenderProvider renderProvider,
		double physics,
		double spirit,
		double erosion,
		double theSoul,
		Function5<Holder<ArmorMaterial>, ArmorItem.Type, Item.Properties, EgoArmorItem.Builder, GeoRenderProvider, ? extends T> function
	) {
		return registerSuit(id, zhName, lcLevel, getArmorMaterialHolder(lcLevel), virtueUsageReqBuilder,
			builder, properties, renderProvider, physics, spirit, erosion, theSoul, function, function, function);
	}

	public static Holder<ArmorMaterial> getArmorMaterialHolder(LcLevel lcLevel) {
		return switch (lcLevel) {
			case ZAYIN -> EGOEquipmentArmorMaterials.ZAYIN;
			case TETH -> EGOEquipmentArmorMaterials.TETH;
			case HE -> EGOEquipmentArmorMaterials.HE;
			case WAW -> EGOEquipmentArmorMaterials.WAW;
			case ALEPH -> EGOEquipmentArmorMaterials.ALEPH;
		};
	}

	private static <C extends EgoArmorItem, L extends EgoArmorItem, B extends EgoArmorItem> Armors<EgoArmorItem> registerSuit(
		String id,
		String zhName,
		LcLevel lcLevel,
		Holder<ArmorMaterial> material,
		ItemVirtueUsageReq.Builder virtueUsageReqBuilder,
		EgoArmorItem.Builder builder,
		Item.Properties properties,
		GeoRenderProvider renderProvider,
		double physics,
		double spirit,
		double erosion,
		double theSoul,
		Function5<Holder<ArmorMaterial>, ArmorItem.Type, Item.Properties, EgoArmorItem.Builder, GeoRenderProvider, ? extends C> chestplateFunction,
		Function5<Holder<ArmorMaterial>, ArmorItem.Type, Item.Properties, EgoArmorItem.Builder, GeoRenderProvider, ? extends L> leggingsFunction,
		Function5<Holder<ArmorMaterial>, ArmorItem.Type, Item.Properties, EgoArmorItem.Builder, GeoRenderProvider, ? extends B> bootsFunction
	) {
		double[] physicsArray = splitIntoThreeUnequalParts(physics - LibAttributes.PHYSICS_VULNERABLE_DEFAULT_VALUE);
		double[] spiritArray = splitIntoThreeUnequalParts(spirit - LibAttributes.SPIRIT_VULNERABLE_DEFAULT_VALUE);
		double[] erosionArray = splitIntoThreeUnequalParts(erosion - LibAttributes.EROSION_VULNERABLE_DEFAULT_VALUE);
		double[] theSoulArray = splitIntoThreeUnequalParts(theSoul - LibAttributes.THE_SOUL_VULNERABLE_DEFAULT_VALUE);
		return new Armors<>(
			register(id + "_" + ArmorItem.Type.CHESTPLATE.getName(), zhName, lcLevel, ArmorItem.Type.CHESTPLATE, material, virtueUsageReqBuilder, builder, properties, renderProvider, physicsArray[2], spiritArray[2], erosionArray[2], theSoulArray[2], chestplateFunction),
			register(id + "_" + ArmorItem.Type.LEGGINGS.getName(), zhName, lcLevel, ArmorItem.Type.LEGGINGS, material, virtueUsageReqBuilder, builder, properties, renderProvider, physicsArray[1], spiritArray[1], erosionArray[1], theSoulArray[1], leggingsFunction),
			register(id + "_" + ArmorItem.Type.BOOTS.getName(), zhName, lcLevel, ArmorItem.Type.BOOTS, material, virtueUsageReqBuilder, builder, properties, renderProvider, physicsArray[0], spiritArray[0], erosionArray[0], theSoulArray[0], bootsFunction));
	}

	/**
	 * 注册一个EGO护甲物品
	 *
	 * @param id                    物品的唯一标识符
	 * @param zhName                物品的中文名称
	 * @param lcLevel               Lobotomy Corporation中的等级类型（ZAYIN, TETH, HE, WAW, ALEPH）
	 * @param builder               EGO护甲构建器
	 * @param physics               物理属性值
	 * @param spirit                理性属性值
	 * @param erosion               侵蚀属性值
	 * @param theSoul               灵魂属性值
	 * @param virtueUsageReqBuilder 德性使用需求构建器
	 * @param item                  用于创建具体EGO护甲物品的函数
	 * @return 返回注册后的EGO护甲物品DeferredItem对象
	 */
	@NotNull
	private static <I extends EgoArmorItem> DeferredItem<I> register(
		String id,
		String zhName,
		LcLevel lcLevel,
		ArmorItem.Type armorItemType,
		Holder<ArmorMaterial> material,
		ItemVirtueUsageReq.Builder virtueUsageReqBuilder,
		EgoArmorItem.Builder builder,
		Item.Properties properties,
		GeoRenderProvider renderProvider,
		double physics,
		double spirit,
		double erosion,
		double theSoul,
		Function5<Holder<ArmorMaterial>, ArmorItem.Type, Item.Properties, EgoArmorItem.Builder, GeoRenderProvider, ? extends I> item
	) {
		DeferredItem<I> deferredItem = EGOArmorItems.REGISTRY.register(id, () -> item.apply(material, armorItemType, properties, builder
			.virtueUsageReqBuilder(virtueUsageReqBuilder)
			.vulnerable(physics, spirit, erosion, theSoul), renderProvider));
		LcLevelUtil.addItemLcLevelCapability(lcLevel, deferredItem);
		switch (armorItemType) {
			case HELMET -> EGOEquipmentConstants.HEAD_ARMOR.add(deferredItem);
			case CHESTPLATE -> EGOEquipmentConstants.CHEST_ARMOR.add(deferredItem);
			case LEGGINGS -> EGOEquipmentConstants.LEG_ARMOR.add(deferredItem);
			case BOOTS -> EGOEquipmentConstants.FOOT_ARMOR.add(deferredItem);
		}
		EGOEquipmentConstants.EGO_ARMOUR.add(deferredItem);
		ZhCn.addI18nItemText(zhName, deferredItem);
		return deferredItem;
	}

	/**
	 * 拆分数值为不等的三份（无无限循环小数，优先整数）
	 *
	 * @param n 待拆分数值（整数/小数均可）
	 * @return 三个不等的数（数组顺序：小、中、大）
	 */
	private static double[] splitIntoThreeUnequalParts(double n) {
		double avg = n / 3.0;
		return new double[]{avg - 0.01, avg, avg + 0.01};
	}

	private static Armors<EgoArmorItem> registerSuit(
		String id,
		String zhName,
		LcLevel lcLevel,
		Holder<ArmorMaterial> material,
		ItemVirtueUsageReq.Builder virtueUsageReqBuilder,
		EgoArmorItem.Builder builder,
		Item.Properties properties,
		GeoRenderProvider renderProvider,
		double physics,
		double spirit,
		double erosion,
		double theSoul
	) {
		return registerSuit(id, zhName, lcLevel, material, virtueUsageReqBuilder,
			builder, properties, renderProvider, physics, spirit, erosion, theSoul, EgoArmorItem::new);
	}

	private static <T extends EgoArmorItem> Armors<EgoArmorItem> registerSuit(
		String id,
		String zhName,
		LcLevel lcLevel,
		Holder<ArmorMaterial> material,
		ItemVirtueUsageReq.Builder virtueUsageReqBuilder,
		EgoArmorItem.Builder builder,
		Item.Properties properties,
		GeoRenderProvider renderProvider,
		double physics,
		double spirit,
		double erosion,
		double theSoul,
		Function5<Holder<ArmorMaterial>, ArmorItem.Type, Item.Properties, EgoArmorItem.Builder, GeoRenderProvider, ? extends T> function
	) {
		return registerSuit(id, zhName, lcLevel, material, virtueUsageReqBuilder, builder, properties,
			renderProvider, physics, spirit, erosion, theSoul, function, function, function);
	}
}
