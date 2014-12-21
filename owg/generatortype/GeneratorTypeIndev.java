package owg.generatortype;

import owg.biomes.BiomeList;
import owg.generator.ChunkGeneratorIndev;
import owg.gui.GuiGeneratorSettings;
import owg.gui.GuiSettingsButton;
import owg.gui.GuiSettingsSlider;
import net.minecraft.util.StatCollector;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class GeneratorTypeIndev extends GeneratorType
{
	public GeneratorTypeIndev(int id, int cat, String name, boolean c) 
	{
		super(id, cat, name, c);
	}
	
	@Override
	public boolean getSettings(GuiGeneratorSettings gui)
	{
		gui.settings.add(new GuiSettingsButton(new String[]{StatCollector.translateToLocal("owg.setting.theme") + ": " + StatCollector.translateToLocal("owg.theme.default"), StatCollector.translateToLocal("owg.setting.theme") + ": " + StatCollector.translateToLocal("owg.theme.hell"), StatCollector.translateToLocal("owg.setting.theme") + ": " + StatCollector.translateToLocal("owg.theme.paradise"), StatCollector.translateToLocal("owg.setting.theme") + ": " + StatCollector.translateToLocal("owg.theme.woods"), StatCollector.translateToLocal("owg.setting.theme") + ": " + StatCollector.translateToLocal("owg.theme.snow")}, new int[]{0, 1, 2, 3, 4}, 20, 50, gui.width));
		gui.settings.add(new GuiSettingsButton(new String[]{StatCollector.translateToLocal("owg.setting.type") + ": " + StatCollector.translateToLocal("owg.type.island"), StatCollector.translateToLocal("owg.setting.type") + ": " + StatCollector.translateToLocal("owg.type.floating"), StatCollector.translateToLocal("owg.setting.type") + ": " + StatCollector.translateToLocal("owg.type.inland")}, new int[]{0, 1, 2}, 21, 70, gui.width));
		gui.settings.add(new GuiSettingsSlider(new String[]{StatCollector.translateToLocal("owg.setting.size") + ": " + StatCollector.translateToLocal("owg.setting.small"), StatCollector.translateToLocal("owg.setting.size") + ": " + StatCollector.translateToLocal("owg.setting.default"), StatCollector.translateToLocal("owg.setting.size") + ": " + StatCollector.translateToLocal("owg.setting.large")}, new int[]{0, 1, 2}, 1, 22, 90, gui.width, 21, new int[]{0, 1}));
		gui.settings.add(new GuiSettingsSlider(new String[]{StatCollector.translateToLocal("owg.setting.layer") + ": 1", StatCollector.translateToLocal("owg.setting.layer") + ": 2", StatCollector.translateToLocal("owg.setting.layer") + ": 3", StatCollector.translateToLocal("owg.setting.layer") + ": 4", StatCollector.translateToLocal("owg.setting.layer") + ": 5"}, new int[]{0, 1, 2, 3, 4}, 1, 23, 110, gui.width, 21, new int[]{1}));
		gui.settings.add(new GuiSettingsButton(new String[]{StatCollector.translateToLocal("owg.setting.dungeon") + ": " + StatCollector.translateToLocal("owg.setting.on"), StatCollector.translateToLocal("owg.setting.dungeon") + ": " + StatCollector.translateToLocal("owg.setting.end"), StatCollector.translateToLocal("owg.setting.dungeon") + ": " + StatCollector.translateToLocal("owg.setting.off")}, new int[]{0, 1, 2}, 24, 130, gui.width, 21, new int[]{1}));
		return true;
	}
	
	@Override
	public WorldChunkManager getServerWorldChunkManager(World world)
    {
		if(trySetting(0, 4) == 4) 
		{ 
			return new WorldChunkManagerHell(BiomeList.CLASSICsnow, 0.5F); 
		}
		return new WorldChunkManagerHell(BiomeList.CLASSICnormal, 0.5F);
    }

	@Override
	public WorldChunkManager getClientWorldChunkManager(World world)
    {
		return new WorldChunkManagerHell(BiomeList.CLASSICnormal, 0.5F);
    }

	@Override
    public IChunkProvider getChunkGenerator(World world)
    {	
		int themeID = trySetting(0, 4) + 1;
		int typeID = trySetting(1, 2) + 1;
		int size = trySetting(2, 2) + 1;
		int layers = trySetting(3, 4) + 1;
		int dungeons = trySetting(4, 2);
		return new ChunkGeneratorIndev(world, world.getSeed(), world.getWorldInfo().isMapFeaturesEnabled(), typeID, themeID, size, layers, dungeons); 
    }
}
