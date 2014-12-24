package owg.support;

import net.minecraft.world.biome.BiomeGenBase;
import biomesoplenty.api.content.BOPCBiomes;

public class SupportBOP
{
	public static void init()
	{
		try
		{
			Support.biomes_snow.add(BOPCBiomes.alps);
			Support.biomes_snow.add(BOPCBiomes.arctic);
			Support.biomes_wet.add(BOPCBiomes.bambooForest);
			Support.biomes_wet.add(BOPCBiomes.bayou);
			Support.biomes_cold.add(BOPCBiomes.bog);
			Support.biomes_cold.add(BOPCBiomes.borealForest);
			Support.biomes_hot.add(BOPCBiomes.brushland);
			Support.biomes_hot.add(BOPCBiomes.canyon);
			Support.biomes_hot.add(BOPCBiomes.chaparral);
			Support.biomes_cold.add(BOPCBiomes.cherryBlossomGrove);
			Support.biomes_cold.add(BOPCBiomes.coniferousForest);
			Support.biomes_snow.add(BOPCBiomes.snowyConiferousForest);
			Support.biomes_cold.add(BOPCBiomes.crag);
			Support.biomes_cold.add(BOPCBiomes.deadForest);
			Support.biomes_cold.add(BOPCBiomes.deadSwamp);
			Support.biomes_hot.add(BOPCBiomes.deciduousForest);
			Support.biomes_cold.add(BOPCBiomes.fen);
			Support.biomes_cold.add(BOPCBiomes.flowerField);
			Support.biomes_snow.add(BOPCBiomes.frostForest);
			Support.biomes_wet.add(BOPCBiomes.fungiForest);
			Support.biomes_cold.add(BOPCBiomes.garden);
			Support.biomes_cold.add(BOPCBiomes.grassland);
			Support.biomes_cold.add(BOPCBiomes.grove);
			Support.biomes_hot.add(BOPCBiomes.heathland);
			Support.biomes_cold.add(BOPCBiomes.highland);
			Support.biomes_cold.add(BOPCBiomes.jadeCliffs);
			Support.biomes_hot.add(BOPCBiomes.lavenderFields);
			Support.biomes_hot.add(BOPCBiomes.lushDesert);
			Support.biomes_wet.add(BOPCBiomes.lushSwamp);
			Support.biomes_cold.add(BOPCBiomes.mapleWoods);
			Support.biomes_wet.add(BOPCBiomes.marsh);
			Support.biomes_cold.add(BOPCBiomes.meadow);
			Support.biomes_cold.add(BOPCBiomes.moor);
			Support.biomes_cold.add(BOPCBiomes.mountain);
			Support.biomes_wet.add(BOPCBiomes.mysticGrove);
			Support.biomes_wet.add(BOPCBiomes.ominousWoods);
			Support.biomes_cold.add(BOPCBiomes.originValley);
			Support.biomes_hot.add(BOPCBiomes.outback);
			Support.biomes_hot.add(BOPCBiomes.prairie);
			Support.biomes_wet.add(BOPCBiomes.rainforest);
			Support.biomes_cold.add(BOPCBiomes.redwoodForest);
			Support.biomes_wet.add(BOPCBiomes.sacredSprings);
			Support.biomes_hot.add(BOPCBiomes.seasonalForest);
			Support.biomes_cold.add(BOPCBiomes.shield);
			Support.biomes_hot.add(BOPCBiomes.shrubland);
			Support.biomes_wet.add(BOPCBiomes.sludgepit);
			Support.biomes_hot.add(BOPCBiomes.steppe);
			Support.biomes_wet.add(BOPCBiomes.temperateRainforest);
			Support.biomes_hot.add(BOPCBiomes.thicket);
			Support.biomes_wet.add(BOPCBiomes.tropicalRainforest);
			Support.biomes_cold.add(BOPCBiomes.tundra);
			Support.biomes_cold.add(BOPCBiomes.wasteland);
			Support.biomes_wet.add(BOPCBiomes.wetland);
			Support.biomes_cold.add(BOPCBiomes.woodland);
		}
		catch(Exception e)
		{
			System.out.println("Bop support is broken!");
		}
	}
}
