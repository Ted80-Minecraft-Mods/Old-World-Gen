package owg.support;

import java.util.ArrayList;

import net.minecraft.world.biome.BiomeGenBase;
import biomesoplenty.api.Biomes;

import com.google.common.base.Optional;

public class SupportBOP
{
	public static void init()
	{
		try
		{
			if(Biomes.woodland.isPresent()) {				Support.biomes_cold.add(Biomes.woodland.get()); }
			if(Biomes.wetland.isPresent()) {				Support.biomes_wet.add(Biomes.wetland.get()); }
			if(Biomes.wasteland.isPresent()) {				Support.biomes_hot.add(Biomes.wasteland.get()); }
			if(Biomes.tundra.isPresent()) {					Support.biomes_snow.add(Biomes.tundra.get()); }
			if(Biomes.tropics.isPresent()) {				Support.biomes_wet.add(Biomes.tropics.get()); }
			if(Biomes.tropicalRainforest.isPresent()) {		Support.biomes_wet.add(Biomes.tropicalRainforest.get()); }
			if(Biomes.timber.isPresent()) {					Support.biomes_cold.add(Biomes.timber.get()); }
			if(Biomes.thicket.isPresent()) {				Support.biomes_cold.add(Biomes.thicket.get()); }
			if(Biomes.temperateRainforest.isPresent()) {	Support.biomes_wet.add(Biomes.temperateRainforest.get()); }
			if(Biomes.steppe.isPresent()) { 				Support.biomes_hot.add(Biomes.steppe.get()); }
			if(Biomes.spruceWoods.isPresent()) { 			Support.biomes_cold.add(Biomes.spruceWoods.get()); }
			if(Biomes.sludgepit.isPresent()) { 				Support.biomes_wet.add(Biomes.sludgepit.get()); }
			if(Biomes.shrubland.isPresent()) { 				Support.biomes_cold.add(Biomes.shrubland.get()); }
			if(Biomes.shield.isPresent()) { 				Support.biomes_cold.add(Biomes.shield.get()); }
			if(Biomes.seasonalForest.isPresent()) { 		Support.biomes_cold.add(Biomes.seasonalForest.get()); }
			if(Biomes.scrubland.isPresent()) { 				Support.biomes_hot.add(Biomes.scrubland.get()); }
			if(Biomes.savanna.isPresent()) { 				Support.biomes_hot.add(Biomes.savanna.get()); }
			if(Biomes.sacredSprings.isPresent()) { 			Support.biomes_wet.add(Biomes.sacredSprings.get()); }
			if(Biomes.redwoodForest.isPresent()) { 			Support.biomes_cold.add(Biomes.redwoodForest.get()); }
			if(Biomes.rainforest.isPresent()) { 			Support.biomes_wet.add(Biomes.rainforest.get()); }
			if(Biomes.quagmire.isPresent()) { 				Support.biomes_hot.add(Biomes.quagmire.get()); }
			if(Biomes.prairie.isPresent()) {				Support.biomes_cold.add(Biomes.prairie.get()); }
			if(Biomes.polar.isPresent()) {					Support.biomes_snow.add(Biomes.polar.get()); }
			if(Biomes.pasture.isPresent()) { 				Support.biomes_cold.add(Biomes.pasture.get()); }
			if(Biomes.outback.isPresent()) {				Support.biomes_hot.add(Biomes.outback.get()); }
			if(Biomes.originValley.isPresent()) { 			Support.biomes_cold.add(Biomes.originValley.get()); }
			if(Biomes.orchard.isPresent()) { 				Support.biomes_cold.add(Biomes.orchard.get()); }
			if(Biomes.ominousWoods.isPresent()) { 			Support.biomes_cold.add(Biomes.ominousWoods.get()); }
			if(Biomes.oasis.isPresent()) { 					Support.biomes_hot.add(Biomes.oasis.get()); }
			if(Biomes.mysticGrove.isPresent()) { 			Support.biomes_wet.add(Biomes.mysticGrove.get()); }
			if(Biomes.mountain.isPresent()) { 				Support.biomes_cold.add(Biomes.mountain.get()); }
			if(Biomes.moor.isPresent()) { 					Support.biomes_cold.add(Biomes.moor.get()); }
			if(Biomes.mesa.isPresent()) { 					Support.biomes_hot.add(Biomes.mesa.get()); }
			if(Biomes.meadow.isPresent()) { 				Support.biomes_cold.add(Biomes.meadow.get()); }
			if(Biomes.marsh.isPresent()) { 					Support.biomes_cold.add(Biomes.marsh.get()); }
			if(Biomes.mapleWoods.isPresent()) { 			Support.biomes_cold.add(Biomes.mapleWoods.get()); }
			if(Biomes.mangrove.isPresent()) { 				Support.biomes_cold.add(Biomes.mangrove.get()); }
			if(Biomes.lushSwamp.isPresent()) { 				Support.biomes_wet.add(Biomes.lushSwamp.get()); }
			if(Biomes.lushDesert.isPresent()) { 			Support.biomes_hot.add(Biomes.lushDesert.get()); }
			if(Biomes.jadeCliffs.isPresent()) { 			Support.biomes_cold.add(Biomes.jadeCliffs.get()); }
			if(Biomes.icyHills.isPresent()) { 				Support.biomes_snow.add(Biomes.icyHills.get()); }
			if(Biomes.hotSprings.isPresent()) { 			Support.biomes_cold.add(Biomes.hotSprings.get()); }
			if(Biomes.highland.isPresent()) { 				Support.biomes_cold.add(Biomes.highland.get()); }
			if(Biomes.heathland.isPresent()) { 				Support.biomes_hot.add(Biomes.heathland.get()); }
			if(Biomes.grove.isPresent()) { 					Support.biomes_cold.add(Biomes.grove.get()); }
			if(Biomes.grassland.isPresent()) {				Support.biomes_cold.add(Biomes.grassland.get()); }
			if(Biomes.glacier.isPresent()) {				Support.biomes_snow.add(Biomes.glacier.get()); }
			if(Biomes.garden.isPresent()) {					Support.biomes_cold.add(Biomes.garden.get()); }
			if(Biomes.frostForest.isPresent()) {			Support.biomes_snow.add(Biomes.frostForest.get()); }
			if(Biomes.fungiForest.isPresent()) { 			Support.biomes_wet.add(Biomes.fungiForest.get()); }
			if(Biomes.field.isPresent()) { 					Support.biomes_cold.add(Biomes.field.get()); }
			if(Biomes.fen.isPresent()) { 					Support.biomes_cold.add(Biomes.fen.get()); }
			if(Biomes.dunes.isPresent()) { 					Support.biomes_hot.add(Biomes.dunes.get()); }
			if(Biomes.deciduousForest.isPresent()) { 		Support.biomes_cold.add(Biomes.deciduousForest.get()); }
			if(Biomes.deadlands.isPresent()) { 				Support.biomes_hot.add(Biomes.deadlands.get()); }
			if(Biomes.deadSwamp.isPresent()) { 				Support.biomes_cold.add(Biomes.deadSwamp.get()); }
			if(Biomes.deadForestSnow.isPresent()) { 		Support.biomes_snow.add(Biomes.deadForestSnow.get()); }
			if(Biomes.deadForest.isPresent()) { 			Support.biomes_cold.add(Biomes.deadForest.get()); }
			if(Biomes.crag.isPresent()) { 					Support.biomes_cold.add(Biomes.crag.get()); }
			if(Biomes.coniferousForestSnow.isPresent()) { 	Support.biomes_snow.add(Biomes.coniferousForestSnow.get()); }
			if(Biomes.coniferousForest.isPresent()) { 		Support.biomes_cold.add(Biomes.coniferousForest.get()); }
			if(Biomes.cherryBlossomGrove.isPresent()) { 	Support.biomes_cold.add(Biomes.cherryBlossomGrove.get()); }
			if(Biomes.chaparral.isPresent()) { 				Support.biomes_cold.add(Biomes.chaparral.get()); }
			if(Biomes.canyon.isPresent()) { 				Support.biomes_hot.add(Biomes.canyon.get()); }
			if(Biomes.brushland.isPresent()) { 				Support.biomes_hot.add(Biomes.brushland.get()); }
			if(Biomes.borealForest.isPresent()) { 			Support.biomes_cold.add(Biomes.borealForest.get()); }
			if(Biomes.bog.isPresent()) { 					Support.biomes_wet.add(Biomes.bog.get()); }
			if(Biomes.birchForest.isPresent()) { 			Support.biomes_cold.add(Biomes.birchForest.get()); }
			if(Biomes.bayou.isPresent()) { 					Support.biomes_wet.add(Biomes.bayou.get()); }
			if(Biomes.bambooForest.isPresent()) { 			Support.biomes_wet.add(Biomes.bambooForest.get()); }
			if(Biomes.badlands.isPresent()) { 				Support.biomes_hot.add(Biomes.badlands.get()); }
			if(Biomes.arctic.isPresent()) { 				Support.biomes_snow.add(Biomes.arctic.get()); }
			if(Biomes.alps.isPresent()) { 					Support.biomes_snow.add(Biomes.alps.get()); }
		}
		catch(Exception e)
		{
			System.out.println("Bop support is broken!");
		}
	}
}
