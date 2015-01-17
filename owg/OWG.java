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

@Mod(modid="OWG", name="OldWorldGen", version="1.0.3")
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