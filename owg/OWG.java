package owg;

import owg.biomes.BiomeList;
import owg.config.ConfigOWG;
import owg.support.Support;
import owg.world.WorldTypeOWG;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid="OWG", name="OldWorldGen", version="1.0.2")
public class OWG
{	
	@Instance("OWG")
	public static OWG instance;
	
	public static final WorldTypeOWG worldtype = (new WorldTypeOWG("OWG"));  
	
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) 
	{
		instance = this;
		
		ConfigOWG.init(event);
		BiomeList.init();
		
		LanguageRegistry lr = LanguageRegistry.instance();
		
		lr.addStringLocalization("generator.BWG4", "BWG4");
		
		lr.addStringLocalization("generator.OWG", "Old World Gen");

		lr.addStringLocalization("gui.selectGenerator", "Select a world generator:");
		lr.addStringLocalization("gui.generatorSettings", "Generator settings:");
		lr.addStringLocalization("gui.copystring", "Copy generator-settings to Clipboard");

		lr.addStringLocalization("owg.setting.size", "Size");
		lr.addStringLocalization("owg.setting.small", "Small");
		lr.addStringLocalization("owg.setting.default", "Default");
		lr.addStringLocalization("owg.setting.large", "Large");
		lr.addStringLocalization("owg.setting.snow", "Snow World");
		lr.addStringLocalization("owg.setting.water", "Water");
		lr.addStringLocalization("owg.setting.on", "ON");
		lr.addStringLocalization("owg.setting.off", "OFF");
		lr.addStringLocalization("owg.setting.theme", "Theme");
		lr.addStringLocalization("owg.setting.type", "Type");
		lr.addStringLocalization("owg.setting.layer", "Layer");
		lr.addStringLocalization("owg.setting.dungeon", "Dungeons");
		lr.addStringLocalization("owg.setting.end", "End portal only");

		lr.addStringLocalization("owg.biomes.biomes", "Biomes");
		lr.addStringLocalization("owg.biomes.original", "Original");
		lr.addStringLocalization("owg.biomes.vanilla", "Vanilla");
		lr.addStringLocalization("owg.biomes.all", "Vanilla + Mods");

		lr.addStringLocalization("owg.theme.default", "Default");
		lr.addStringLocalization("owg.theme.snow", "Snow");
		lr.addStringLocalization("owg.theme.jungle", "Jungle");
		lr.addStringLocalization("owg.theme.tropical", "Tropical");
		lr.addStringLocalization("owg.theme.paradise", "Paradise");
		lr.addStringLocalization("owg.theme.hell", "Hell");
		lr.addStringLocalization("owg.theme.woods", "Woods");

		lr.addStringLocalization("owg.type.island", "Island");
		lr.addStringLocalization("owg.type.floating", "Floating");
		lr.addStringLocalization("owg.type.inland", "Inland");

		lr.addStringLocalization("owg.BETA173", "Beta 1.7.3");
		lr.addStringLocalization("owg.ALPHA12", "Alpha 1.2.0");
		lr.addStringLocalization("owg.ALPHA11", "Alpha 1.1.0");
		lr.addStringLocalization("owg.INFDEV", "Infdev");
		lr.addStringLocalization("owg.INDEV", "Indev");
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent event)
	{
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) 
	{
		Support.init();
	}
}