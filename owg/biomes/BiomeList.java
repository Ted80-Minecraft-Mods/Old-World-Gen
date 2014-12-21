package owg.biomes;

import owg.config.ConfigOWG;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeList 
{
	public static BiomeGenBase OLDrainforest;
	public static BiomeGenBase OLDswampland;
	public static BiomeGenBase OLDseasonalForest;
	public static BiomeGenBase OLDforest;
	public static BiomeGenBase OLDsavanna;
	public static BiomeGenBase OLDshrubland;
	public static BiomeGenBase OLDtaiga;
	public static BiomeGenBase OLDdesert;
	public static BiomeGenBase OLDplains;
	public static BiomeGenBase OLDtundra;
	
	public static BiomeGenBase CLASSICnormal;
	public static BiomeGenBase CLASSICsnow;	
	
	public static void init()
	{
		OLDdesert = (new BiomeBeta(ConfigOWG.biomeIDs[0], 7)).setColor(16421912).setBiomeName("desert").setTemperatureRainfall(0.95F, 0.1F).setDisableRain();
		OLDforest = (new BiomeBeta(ConfigOWG.biomeIDs[1], 3)).setColor(353825).setBiomeName("forest").setTemperatureRainfall(0.8F, 0.6F);
		OLDplains = (new BiomeBeta(ConfigOWG.biomeIDs[2], 8)).setColor(353825).setBiomeName("plains").setTemperatureRainfall(0.95F, 0.35F);
		OLDrainforest = (new BiomeBeta(ConfigOWG.biomeIDs[3], 0)).setColor(353825).setBiomeName("rainforest").setTemperatureRainfall(0.95F, 0.95F);
		OLDsavanna = (new BiomeBeta(ConfigOWG.biomeIDs[4], 4)).setColor(16421912).setBiomeName("savanna").setTemperatureRainfall(0.7F, 0.1F);
		OLDseasonalForest = (new BiomeBeta(ConfigOWG.biomeIDs[5], 2)).setColor(353825).setBiomeName("seasonalForest").setTemperatureRainfall(0.95F, 0.7F);
		OLDshrubland = (new BiomeBeta(ConfigOWG.biomeIDs[6], 5)).setColor(353825).setBiomeName("shrubland").setTemperatureRainfall(0.7F, 0.3F);
		OLDswampland = (new BiomeBeta(ConfigOWG.biomeIDs[7], 1)).setColor(353825).setBiomeName("swampland").setTemperatureRainfall(0.55F, 0.65F);
		OLDtaiga = (new BiomeBeta(ConfigOWG.biomeIDs[8], 6)).setColor(16777215).setBiomeName("taiga").setTemperatureRainfall(0.1F, 0.35F).setEnableSnow();
		OLDtundra = (new BiomeBeta(ConfigOWG.biomeIDs[9], 9)).setColor(16777215).setBiomeName("tundra").setTemperatureRainfall(0.1F, 0.1F).setEnableSnow();
		
		CLASSICnormal = (new BiomeClassic(ConfigOWG.biomeIDs[10])).setColor(353825).setBiomeName("Classic");
		CLASSICsnow = (new BiomeClassic(ConfigOWG.biomeIDs[11])).setColor(353825).setBiomeName("Classic_Snow").setEnableSnow().setTemperatureRainfall(0.0F, 0.5F);
	}
}
