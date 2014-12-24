package owg.support;

import highlands.api.HighlandsBiomes;
import net.minecraft.world.biome.BiomeGenBase;

public class SupportHL 
{
	public static void init()
	{
		try
		{
			if(HighlandsBiomes.alps != null) { 				Support.biomes_snow.add(HighlandsBiomes.alps); }
			if(HighlandsBiomes.autumnForest != null) {		Support.biomes_cold.add(HighlandsBiomes.autumnForest); }
			if(HighlandsBiomes.badlands != null) { 			Support.biomes_hot.add(HighlandsBiomes.badlands); }
			if(HighlandsBiomes.birchHills != null) { 		Support.biomes_cold.add(HighlandsBiomes.birchHills); }
			if(HighlandsBiomes.bog != null) { 				Support.biomes_wet.add(HighlandsBiomes.bog); }
			if(HighlandsBiomes.cliffs != null) { 			Support.biomes_cold.add(HighlandsBiomes.cliffs); }
			if(HighlandsBiomes.desertMountains != null) {	Support.biomes_hot.add(HighlandsBiomes.desertMountains); }
			if(HighlandsBiomes.dunes != null) {				Support.biomes_hot.add(HighlandsBiomes.dunes); }
			if(HighlandsBiomes.estuary != null) {			Support.biomes_wet.add(HighlandsBiomes.estuary); }
			if(HighlandsBiomes.flyingMountains != null) {	Support.biomes_wet.add(HighlandsBiomes.flyingMountains); }
			if(HighlandsBiomes.glacier != null) { 			Support.biomes_snow.add(HighlandsBiomes.glacier); }
			if(HighlandsBiomes.highlandsb != null) {		Support.biomes_cold.add(HighlandsBiomes.highlandsb); }
			if(HighlandsBiomes.lowlands != null) {			Support.biomes_cold.add(HighlandsBiomes.lowlands); }
			if(HighlandsBiomes.meadow != null) {			Support.biomes_cold.add(HighlandsBiomes.meadow); }
			if(HighlandsBiomes.outback != null) {			Support.biomes_hot.add(HighlandsBiomes.outback); }
			if(HighlandsBiomes.pinelands != null) {			Support.biomes_cold.add(HighlandsBiomes.pinelands); }
			if(HighlandsBiomes.rainforest != null) {		Support.biomes_wet.add(HighlandsBiomes.rainforest); }
			if(HighlandsBiomes.redwoodForest != null) {		Support.biomes_cold.add(HighlandsBiomes.redwoodForest); }
			if(HighlandsBiomes.rockMountains != null) {		Support.biomes_hot.add(HighlandsBiomes.rockMountains); }
			if(HighlandsBiomes.sahel != null) {				Support.biomes_hot.add(HighlandsBiomes.sahel); }
			if(HighlandsBiomes.savannah != null) {			Support.biomes_hot.add(HighlandsBiomes.savannah); }
			if(HighlandsBiomes.snowMountains != null) {		Support.biomes_hot.add(HighlandsBiomes.snowMountains); }
			if(HighlandsBiomes.steppe != null) {			Support.biomes_hot.add(HighlandsBiomes.steppe); }
			if(HighlandsBiomes.tallPineForest != null) {	Support.biomes_snow.add(HighlandsBiomes.tallPineForest); }
			if(HighlandsBiomes.tropicalIslands != null) {	Support.biomes_wet.add(HighlandsBiomes.tropicalIslands); }
			if(HighlandsBiomes.tropics != null) {			Support.biomes_wet.add(HighlandsBiomes.tropics); }
			if(HighlandsBiomes.tundra != null) {			Support.biomes_snow.add(HighlandsBiomes.tundra); }
			if(HighlandsBiomes.woodlands != null) {			Support.biomes_cold.add(HighlandsBiomes.woodlands); }
			if(HighlandsBiomes.woodsMountains != null) {	Support.biomes_cold.add(HighlandsBiomes.woodsMountains); }
		}
		catch(Exception e)
		{
			System.out.println("Highlands support is broken!");
		}
	}
}
