package owg.support;

import extrabiomes.api.BiomeManager;

public class SupportEBXL 
{
	public static void init()
	{
		if(BiomeManager.alpine.isPresent())
		{
			Support.biomes_snow.add(BiomeManager.alpine.get());
		}
		
		if(BiomeManager.autumnwoods.isPresent())
		{
			Support.biomes_cold.add(BiomeManager.autumnwoods.get());
		}
		
		if(BiomeManager.birchforest.isPresent())
		{
			Support.biomes_cold.add(BiomeManager.birchforest.get());
		}
		
		if(BiomeManager.extremejungle.isPresent())
		{
			Support.biomes_wet.add(BiomeManager.extremejungle.get());
		}
		
		if(BiomeManager.forestedisland.isPresent())
		{
			Support.biomes_cold.add(BiomeManager.forestedisland.get());
		}
		
		if(BiomeManager.forestedhills.isPresent())
		{
			Support.biomes_cold.add(BiomeManager.forestedhills.get());
		}
		
		if(BiomeManager.glacier.isPresent())
		{
			Support.biomes_snow.add(BiomeManager.glacier.get());
		}
		
		if(BiomeManager.greenhills.isPresent())
		{
			Support.biomes_cold.add(BiomeManager.greenhills.get());
		}
		
		if(BiomeManager.icewasteland.isPresent())
		{
			Support.biomes_snow.add(BiomeManager.icewasteland.get());
		}
		
		if(BiomeManager.greenswamp.isPresent())
		{
			Support.biomes_wet.add(BiomeManager.greenswamp.get());
		}
		
		if(BiomeManager.marsh.isPresent())
		{
			Support.biomes_wet.add(BiomeManager.marsh.get());
		}
		
		if(BiomeManager.meadow.isPresent())
		{
			Support.biomes_cold.add(BiomeManager.meadow.get());
		}
		
		if(BiomeManager.minijungle.isPresent())
		{
			Support.biomes_wet.add(BiomeManager.minijungle.get());
		}
		
		if(BiomeManager.mountaindesert.isPresent())
		{
			Support.biomes_hot.add(BiomeManager.mountaindesert.get());
		}
		
		if(BiomeManager.mountainridge.isPresent())
		{
			Support.biomes_hot.add(BiomeManager.mountainridge.get());
		}
		
		if(BiomeManager.mountaintaiga.isPresent())
		{
			Support.biomes_snow.add(BiomeManager.mountaintaiga.get());
		}
		
		if(BiomeManager.pineforest.isPresent())
		{
			Support.biomes_cold.add(BiomeManager.pineforest.get());
		}
		
		if(BiomeManager.rainforest.isPresent())
		{
			Support.biomes_wet.add(BiomeManager.rainforest.get());
		}
		
		if(BiomeManager.redwoodforest.isPresent())
		{
			Support.biomes_cold.add(BiomeManager.redwoodforest.get());
		}
		
		if(BiomeManager.redwoodlush.isPresent())
		{
			Support.biomes_wet.add(BiomeManager.redwoodlush.get());
		}
		
		if(BiomeManager.savanna.isPresent())
		{
			Support.biomes_hot.add(BiomeManager.savanna.get());
		}
		
		if(BiomeManager.shrubland.isPresent())
		{
			Support.biomes_cold.add(BiomeManager.shrubland.get());
		}
		
		if(BiomeManager.snowforest.isPresent())
		{
			Support.biomes_snow.add(BiomeManager.snowforest.get());
		}
		
		if(BiomeManager.snowyrainforest.isPresent())
		{
			Support.biomes_snow.add(BiomeManager.snowyrainforest.get());
		}
		
		if(BiomeManager.temperaterainforest.isPresent())
		{
			Support.biomes_wet.add(BiomeManager.temperaterainforest.get());
		}
		
		if(BiomeManager.tundra.isPresent())
		{
			Support.biomes_cold.add(BiomeManager.tundra.get());
		}
		
		if(BiomeManager.wasteland.isPresent())
		{
			Support.biomes_hot.add(BiomeManager.wasteland.get());
		}
		
		if(BiomeManager.woodlands.isPresent())
		{
			Support.biomes_cold.add(BiomeManager.woodlands.get());
		}
	}
}