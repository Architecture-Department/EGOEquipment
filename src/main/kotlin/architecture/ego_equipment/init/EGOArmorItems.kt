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

import net.minecraft.core.Holder
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.ArmorItem
import net.minecraft.world.item.ArmorMaterial
import net.minecraft.world.item.Item
import net.neoforged.neoforge.registries.DeferredItem
import net.neoforged.neoforge.registries.DeferredRegister
import software.bernie.geckolib.animatable.client.GeoRenderProvider

object EGOArmorItems {
	val REGISTRY: DeferredRegister.Items = DeferredRegister.createItems(EGOEquipment.ID)

	//region ZAYIN
	val PENITENCE = onArmor()
		.id("penitence").zhName("忏悔").lcLevelType(LcLevel.ZAYIN)
		.physics(0.9).spirit(0.8).erosion(0.9).theSoul(2.0)
		.buildAndRegister()

	val SODA = onArmor()
		.id("soda").zhName("美味苏打").lcLevelType(LcLevel.ZAYIN)
		.physics(0.8).spirit(1.0).erosion(1.0).theSoul(2.0)
		.buildAndRegister()

	val WINGBEAT = onArmor()
		.id("wingbeat").zhName("翅振").lcLevelType(LcLevel.ZAYIN)
		.physics(0.8).spirit(0.8).erosion(1.0).theSoul(2.0)
		.buildAndRegister()
	//endregion

	//region TETH
	val STANDARD_TRAINING_EGO = onArmor()
		.id("standard_training_ego").zhName("教学用E.G.O").lcLevelType(LcLevel.TETH)
		.physics(0.5).spirit(1.0).erosion(1.5).theSoul(2.0)
		.buildAndRegister()

	val FOURTH_MATCH_FLAME = onArmor()
		.id("fourth_match_flame").zhName("终末火柴之光").lcLevelType(LcLevel.TETH)
		.physics(0.6).spirit(1.0).erosion(1.5).theSoul(2.0)
		.buildAndRegister()

	val IN_THE_NAME_OF_LOVE_AND_HATE = onArmor()
		.id("in_the_name_of_love_and_hate").zhName("以爱与恨之名").lcLevelType(LcLevel.TETH)
		.physics(0.7).spirit(0.8).erosion(0.4).theSoul(2.0)
		.buildAndRegister()

	val RED_EYES = onArmor()
		.id("red_eyes").zhName("赤瞳").lcLevelType(LcLevel.TETH)
		.physics(0.8).spirit(0.8).erosion(0.8).theSoul(2.0)
		.buildAndRegister()

	val HORN = onArmor()
		.id("horn").zhName("犄角").lcLevelType(LcLevel.TETH)
		.physics(0.8).spirit(0.8).erosion(1.5).theSoul(2.0)
		.buildAndRegister()

	val SOLITUDE = onArmor()
		.id("solitude").zhName("孤独").lcLevelType(LcLevel.TETH)
		.physics(1.5).spirit(0.8).erosion(0.8).theSoul(2.0)
		.buildAndRegister()

	val SCREAMING_WEDGE = onArmor()
		.id("screaming_wedge").zhName("刺耳嚎叫").lcLevelType(LcLevel.TETH)
		.physics(1.2).spirit(0.6).erosion(1.0).theSoul(2.0)
		.buildAndRegister()

	val NOISE = onArmor()
		.id("noise").zhName("噪音").lcLevelType(LcLevel.TETH)
		.physics(1.2).spirit(0.7).erosion(0.6).theSoul(2.0)
		.buildAndRegister()

	val WRIST_CUTTER = onArmor()
		.id("wrist_cutter").zhName("割腕者").lcLevelType(LcLevel.TETH)
		.physics(1.0).spirit(0.6).erosion(1.2).theSoul(2.0)
		.buildAndRegister()

	val FRAGMENTS_FROM_SOMEWHERE = onArmor()
		.id("fragments_from_somewhere").zhName("彼方的裂片").lcLevelType(LcLevel.TETH)
		.physics(1.0).spirit(1.2).erosion(0.6).theSoul(2.0)
		.buildAndRegister()

	val REGRET = onArmor()
		.id("regret").zhName("悔恨").lcLevelType(LcLevel.TETH)
		.physics(0.7).spirit(1.2).erosion(0.8).theSoul(2.0)
		.buildAndRegister()

	val BEAK = onArmor()
		.id("beak").zhName("小喙").lcLevelType(LcLevel.TETH)
		.physics(0.7).spirit(0.8).erosion(1.2).theSoul(2.0)
		.buildAndRegister()

	val LANTERN = onArmor()
		.id("lantern").zhName("诱捕幻灯").lcLevelType(LcLevel.TETH)
		.physics(0.8).spirit(0.7).erosion(1.2).theSoul(2.0)
		.buildAndRegister()

	val TODAY_IS_EXPRESSION = onArmor()
		.id("today_is_expression").zhName("此刻的神色").lcLevelType(LcLevel.TETH)
		.physics(0.7).spirit(0.6).erosion(1.5).theSoul(2.0)
		.buildAndRegister()

	val SO_CUTE = onArmor()
		.id("so_cute").zhName("超特么可爱！！！").lcLevelType(LcLevel.TETH)
		.physics(0.8).spirit(1.5).erosion(0.8).theSoul(2.0)
		.buildAndRegister()

	val LIFE_FOR_A_DAREDEVIL = onArmor()
		.id("life_for_a_daredevil").zhName("决死之心").lcLevelType(LcLevel.TETH)
		.physics(0.6).spirit(0.9).erosion(0.9).theSoul(2.0)
		.buildAndRegister()

	val ENGULFING_DREAM = onArmor()
		.id("engulfing_dream").zhName("迷魂梦境").lcLevelType(LcLevel.TETH)
		.physics(1.2).spirit(0.8).erosion(0.7).theSoul(2.0)
		.buildAndRegister()

	val CHERRY_BLOSSOMS = onArmor()
		.id("cherry_blossoms").zhName("落樱").lcLevelType(LcLevel.TETH)
		.physics(1.2).spirit(0.6).erosion(0.7).theSoul(2.0)
		.buildAndRegister()

	val TOUGH = onArmor()
		.id("tough").zhName("谢顶之灾").lcLevelType(LcLevel.TETH)
		.physics(1.0).spirit(1.0).erosion(0.8).theSoul(2.0)
		.buildAndRegister()
	//endregion

	//region HE
	val BEAR_PAWS = onArmor()
		.id("bear_paws").zhName("熊熊抱").lcLevelType(LcLevel.HE)
		.physics(0.8).spirit(1.0).erosion(1.0).theSoul(1.5)
		.buildAndRegister()

	val SANGUINE_DESIRE = onArmor()
		.id("sanguine_desire").zhName("血之渴望").lcLevelType(LcLevel.HE)
		.physics(0.5).spirit(1.2).erosion(0.8).theSoul(1.5)
		.buildAndRegister()

	val SYRINX = onArmor()
		.id("syrinx").zhName("泣婴").lcLevelType(LcLevel.HE)
		.physics(1.2).spirit(0.5).erosion(0.8).theSoul(1.5)
		.buildAndRegister()

	val DA_CAPO = onArmor()
		.id("da_capo").zhName("Da Capo").lcLevelType(LcLevel.HE)
		.physics(0.5).spirit(0.2).erosion(0.5).theSoul(1.5)
		.buildAndRegister()

	val LOGGING = onArmor()
		.id("logging").zhName("伐木者").lcLevelType(LcLevel.HE)
		.physics(0.8).spirit(1.2).erosion(0.8).theSoul(1.5)
		.buildAndRegister()

	val FROST_SPLINTER = onArmor()
		.id("frost_splinter").zhName("霜之碎片").lcLevelType(LcLevel.HE)
		.physics(1.3).spirit(0.6).erosion(0.8).theSoul(1.5)
		.buildAndRegister()

	val GRINDER_MK4 = onArmor()
		.id("grinder_mk4").zhName("粉碎机Mk4").lcLevelType(LcLevel.HE)
		.physics(0.6).spirit(1.3).erosion(0.9).theSoul(1.5)
		.buildAndRegister()

	val CHRISTMAS = onArmor()
		.id("christmas").zhName("悲惨圣诞").lcLevelType(LcLevel.HE)
		.physics(0.8).spirit(0.6).erosion(1.3).theSoul(1.5)
		.buildAndRegister()

	val HORNET = onArmor()
		.id("hornet").zhName("黄蜂").lcLevelType(LcLevel.HE)
		.physics(0.7).spirit(0.7).erosion(0.7).theSoul(1.5)
		.buildAndRegister()

	val OUR_GALAXY = onArmor()
		.id("our_galaxy").zhName("小小银河").lcLevelType(LcLevel.HE)
		.physics(0.8).spirit(0.8).erosion(1.2).theSoul(1.5)
		.buildAndRegister()

	val LAETITIA = onArmor()
		.id("laetitia").zhName("蕾蒂希娅").lcLevelType(LcLevel.HE)
		.physics(0.7).spirit(0.7).erosion(0.7).theSoul(1.5)
		.buildAndRegister()

	val SOLEMN_LAMENT = onArmor()
		.id("solemn_lament").zhName("圣宣").lcLevelType(LcLevel.HE)
		.physics(1.2).spirit(0.8).erosion(0.5).theSoul(1.5)
		.buildAndRegister()

	val MAGIC_BULLET = onArmor()
		.id("magic_bullet").zhName("魔弹").lcLevelType(LcLevel.HE)
		.physics(0.7).spirit(0.7).erosion(0.7).theSoul(1.5)
		.buildAndRegister()

	val BLACK_SWAN = onArmor()
		.id("black_swan").zhName("黑天鹅").lcLevelType(LcLevel.HE)
		.physics(0.6).spirit(1.2).erosion(0.8).theSoul(1.5)
		.buildAndRegister()

	val PLEASURE = onArmor()
		.id("pleasure").zhName("因乐癫狂").lcLevelType(LcLevel.HE)
		.physics(1.2).spirit(0.8).erosion(0.8).theSoul(1.5)
		.buildAndRegister()

	val GAZE = onArmor()
		.id("gaze").zhName("凝视").lcLevelType(LcLevel.HE)
		.physics(1.0).spirit(0.8).erosion(1.0).theSoul(1.5)
		.buildAndRegister()

	val HARVEST = onArmor()
		.id("harvest").zhName("猎头长耙").lcLevelType(LcLevel.HE)
		.physics(0.6).spirit(0.8).erosion(1.3).theSoul(1.5)
		.buildAndRegister()
	//endregion

	//region WAW
	val LAMP = onArmor()
		.id("lamp").zhName("目灯").lcLevelType(LcLevel.WAW)
		.physics(0.8).spirit(0.7).erosion(0.4).theSoul(1.5)
		.buildAndRegister()

	val GREEN_STEM = onArmor()
		.id("green_stem").zhName("绿色枝干").lcLevelType(LcLevel.WAW)
		.physics(0.8).spirit(1.2).erosion(0.6).theSoul(1.5)
		.buildAndRegister()

	val CRIMSON_SCAR = onArmor()
		.id("crimson_scar").zhName("猩红创痕").lcLevelType(LcLevel.WAW)
		.physics(0.6).spirit(0.6).erosion(0.6).theSoul(1.5)
		.buildAndRegister()

	val COBALT_SCAR = onArmor()
		.id("cobalt_scar").zhName("郁蓝创痕").lcLevelType(LcLevel.WAW)
		.physics(0.4).spirit(0.8).erosion(0.7).theSoul(2.0)
		.buildAndRegister()

	val FAINT_AROMA = onArmor()
		.id("faint_aroma").zhName("余香").lcLevelType(LcLevel.WAW)
		.physics(1.2).spirit(0.6).erosion(0.8).theSoul(1.5)
		.buildAndRegister()

	val GOLD_RUSH = onArmor()
		.id("gold_rush").zhName("闪金冲锋").lcLevelType(LcLevel.WAW)
		.physics(0.4).spirit(0.7).erosion(0.8).theSoul(2.0)
		.buildAndRegister()

	val SPORE = onArmor()
		.id("spore").zhName("荧光菌孢").lcLevelType(LcLevel.WAW)
		.physics(0.8).spirit(0.6).erosion(1.2).theSoul(1.5)
		.buildAndRegister()

	val ECSTASY = onArmor()
		.id("ecstasy").zhName("沉醉").lcLevelType(LcLevel.WAW)
		.physics(0.8).spirit(0.8).erosion(0.8).theSoul(1.5)
		.buildAndRegister()

	val HEAVEN = onArmor()
		.id("heaven").zhName("穿刺极乐").lcLevelType(LcLevel.WAW)
		.physics(1.2).spirit(0.8).erosion(0.6).theSoul(1.5)
		.buildAndRegister()

	val THE_SWORD_SHARPENED_WITH_TEARS = onArmor()
		.id("the_sword_sharpened_with_tears").zhName("盈泪之剑").lcLevelType(LcLevel.WAW)
		.physics(0.8).spirit(0.8).erosion(0.8).theSoul(0.8)
		.buildAndRegister()

	val EXUVIAE = onArmor()
		.id("exuviae").zhName("脱落之皮").lcLevelType(LcLevel.WAW)
		.physics(0.6).spirit(0.8).erosion(1.2).theSoul(1.5)
		.buildAndRegister()

	val FEATHER_OF_HONOR = onArmor()
		.id("feather_of_honor").zhName("荣耀之羽").lcLevelType(LcLevel.WAW)
		.physics(0.6).spirit(0.6).erosion(1.3).theSoul(2.0)
		.buildAndRegister()

	val DISCORD = onArmor()
		.id("discord").zhName("不和").lcLevelType(LcLevel.WAW)
		.physics(1.2).spirit(0.8).erosion(0.6).theSoul(1.5)
		.buildAndRegister()

	val MOONLIGHT = onArmor()
		.id("moonlight").zhName("月光").lcLevelType(LcLevel.WAW)
		.physics(0.8).spirit(0.4).erosion(0.7).theSoul(2.0)
		.buildAndRegister()

	val HYPOCRISY = onArmor()
		.id("hypocrisy").zhName("伪善").lcLevelType(LcLevel.WAW)
		.physics(0.7).spirit(0.5).erosion(1.3).theSoul(1.5)
		.buildAndRegister()

	val AMITA = onArmor()
		.id("amita").zhName("无量").lcLevelType(LcLevel.WAW)
		.physics(0.5).spirit(1.3).erosion(0.7).theSoul(1.5)
		.buildAndRegister()
	//endregion

	//region ALEPH
	val MIMICRY = onArmor()
		.id("mimicry").zhName("拟态").lcLevelType(LcLevel.ALEPH)
		.physics(0.2).spirit(0.5).erosion(0.5).theSoul(1.0)
		.buildAndRegister()

	val PARADISE_LOST = onArmor()
		.id("paradise_lost").zhName("失乐园").lcLevelType(LcLevel.ALEPH)
		.physics(0.5).spirit(0.5).erosion(0.5).theSoul(0.3)
		.buildAndRegister()

	val JUSTITIA = onArmor()
		.id("justitia").zhName("正义裁决者").lcLevelType(LcLevel.ALEPH)
		.physics(0.5).spirit(0.5).erosion(0.5).theSoul(0.5)
		.buildAndRegister()

	val TWILIGHT = onArmor()
		.id("twilight").zhName("薄暝").lcLevelType(LcLevel.ALEPH)
		.physics(0.3).spirit(0.3).erosion(0.3).theSoul(0.5)
		.buildAndRegister()

	val SMILE = onArmor()
		.id("smile").zhName("笑靥").lcLevelType(LcLevel.ALEPH)
		.physics(0.5).spirit(0.5).erosion(0.2).theSoul(1.0)
		.buildAndRegister()

	val SOUND_OF_A_STAR = onArmor()
		.id("sound_of_a_star").zhName("新星之声").lcLevelType(LcLevel.ALEPH)
		.physics(0.4).spirit(0.4).erosion(0.4).theSoul(1.0)
		.buildAndRegister()

	val ADORATION = onArmor()
		.id("adoration").zhName("爱慕").lcLevelType(LcLevel.ALEPH)
		.physics(0.3).spirit(0.6).erosion(0.3).theSoul(1.0)
		.buildAndRegister()

	val PINK = onArmor()
		.id("pink").zhName("粉红军备").lcLevelType(LcLevel.ALEPH)
		.physics(0.5).spirit(0.3).erosion(0.4).theSoul(1.0)
		.buildAndRegister()
	//endregion

	@JvmStatic
	fun getArmorMaterialHolder(lcLevel: LcLevel): Holder<ArmorMaterial> = when (lcLevel) {
		LcLevel.ZAYIN -> EGOEquipmentArmorMaterials.ZAYIN
		LcLevel.TETH -> EGOEquipmentArmorMaterials.TETH
		LcLevel.HE -> EGOEquipmentArmorMaterials.HE
		LcLevel.WAW -> EGOEquipmentArmorMaterials.WAW
		LcLevel.ALEPH -> EGOEquipmentArmorMaterials.ALEPH
	}

	private fun onArmor() = EgoArmorBuilder()

	@Suppress("ClassName")
	class EgoArmorBuilder {
		private var id: String? = null
		private var zhName: String? = null
		private var lcLevel: LcLevel? = null
		private var physics: Double = 0.0
		private var spirit: Double = 0.0
		private var erosion: Double = 0.0
		private var theSoul: Double = 0.0
		private var virtueUsageReqBuilder = ItemVirtueUsageReq.Builder()
		private var armorItemBuilder = EgoArmorItem.Builder()
		private var properties = Item.Properties()
		private var modelPath: ResourceLocation? = null

		fun id(id: String) = apply { this.id = id }
		fun zhName(zhName: String) = apply { this.zhName = zhName }
		fun lcLevelType(lcLevel: LcLevel) = apply { this.lcLevel = lcLevel }
		fun physics(physics: Double) = apply { this.physics = physics }
		fun spirit(spirit: Double) = apply { this.spirit = spirit }
		fun erosion(erosion: Double) = apply { this.erosion = erosion }
		fun theSoul(theSoul: Double) = apply { this.theSoul = theSoul }

		fun virtueUsageReqBuilder(builder: ItemVirtueUsageReq.Builder) = apply {
			this.virtueUsageReqBuilder = builder
		}

		fun armorItemBuilder(builder: EgoArmorItem.Builder) = apply {
			this.armorItemBuilder = builder
		}

		fun properties(properties: Item.Properties) = apply {
			this.properties = properties
		}

		fun model(modelPath: ResourceLocation) = apply {
			this.modelPath = modelPath
		}

		fun buildAndRegister(): Armors<EgoArmorItem> {
			val id = id ?: throw IllegalStateException("id is required")
			val zhName = zhName ?: throw IllegalStateException("zhName is required")
			val lcLevel = lcLevel ?: throw IllegalStateException("lcLevel is required")
			val renderProvider = GeoArmourRenderProvider(
				ModGeoArmorModel(modelPath ?: EGOEquipment.modRl(id))
			)

			return registerSuit(
				id, zhName, lcLevel,
				virtueUsageReqBuilder, armorItemBuilder, properties, renderProvider,
				physics, spirit, erosion, theSoul
			)
		}
	}

	private fun registerSuit(
		id: String, zhName: String, lcLevel: LcLevel,
		virtueUsageReqBuilder: ItemVirtueUsageReq.Builder,
		builder: EgoArmorItem.Builder,
		properties: Item.Properties,
		renderProvider: GeoRenderProvider,
		physics: Double, spirit: Double, erosion: Double, theSoul: Double
	): Armors<EgoArmorItem> {
		val material = getArmorMaterialHolder(lcLevel)
		val p = splitIntoThree(physics - LibAttributes.PHYSICS_VULNERABLE_DEFAULT_VALUE)
		val s = splitIntoThree(spirit - LibAttributes.SPIRIT_VULNERABLE_DEFAULT_VALUE)
		val e = splitIntoThree(erosion - LibAttributes.EROSION_VULNERABLE_DEFAULT_VALUE)
		val t = splitIntoThree(theSoul - LibAttributes.THE_SOUL_VULNERABLE_DEFAULT_VALUE)
		return Armors(
			register(
				id + "_" + ArmorItem.Type.CHESTPLATE.getName(),
				zhName,
				lcLevel,
				ArmorItem.Type.CHESTPLATE,
				material,
				virtueUsageReqBuilder,
				builder,
				properties,
				renderProvider,
				p.third,
				s.third,
				e.third,
				t.third
			),
			register(
				id + "_" + ArmorItem.Type.LEGGINGS.getName(),
				zhName,
				lcLevel,
				ArmorItem.Type.LEGGINGS,
				material,
				virtueUsageReqBuilder,
				builder,
				properties,
				renderProvider,
				p.second,
				s.second,
				e.second,
				t.second
			),
			register(
				id + "_" + ArmorItem.Type.BOOTS.getName(),
				zhName,
				lcLevel,
				ArmorItem.Type.BOOTS,
				material,
				virtueUsageReqBuilder,
				builder,
				properties,
				renderProvider,
				p.first,
				s.first,
				e.first,
				t.first
			),
		)
	}

	private fun register(
		id: String, zhName: String, lcLevel: LcLevel,
		armorItemType: ArmorItem.Type,
		material: Holder<ArmorMaterial>,
		virtueUsageReqBuilder: ItemVirtueUsageReq.Builder,
		builder: EgoArmorItem.Builder,
		properties: Item.Properties,
		renderProvider: GeoRenderProvider,
		physics: Double, spirit: Double, erosion: Double, theSoul: Double,
	): DeferredItem<EgoArmorItem> {
		val deferredItem = REGISTRY.register(id) { ->
			EgoArmorItem(
				material, armorItemType, properties,
				builder.virtueUsageReqBuilder(virtueUsageReqBuilder).vulnerable(physics, spirit, erosion, theSoul),
				renderProvider
			)
		}
		LcLevelUtil.addItemLcLevelCapability(lcLevel, deferredItem)
		when (armorItemType) {
			ArmorItem.Type.CHESTPLATE -> EGOEquipmentConstants.CHEST_ARMOR.add(deferredItem)
			ArmorItem.Type.LEGGINGS -> EGOEquipmentConstants.LEG_ARMOR.add(deferredItem)
			ArmorItem.Type.BOOTS -> EGOEquipmentConstants.FOOT_ARMOR.add(deferredItem)
			else -> {}
		}
		EGOEquipmentConstants.EGO_ARMOUR.add(deferredItem)
		ZhCn.addI18nItemText(zhName) { deferredItem.get() }
		return deferredItem
	}

	private fun splitIntoThree(n: Double): Triple<Double, Double, Double> {
		val avg = n / 3.0
		return Triple(avg - 0.01, avg, avg + 0.01)
	}
}
