package owg.generatortype;

import owg.biomes.BiomeList;
import owg.generator.ChunkGeneratorBeta;
import owg.gui.GuiGeneratorSettings;
import owg.world.ManagerOWG;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;;

public class GeneratorTypeBeta extends GeneratorType
{
	public GeneratorTypeBeta(int id, int cat, String name, boolean c) 
	{
		super(id, cat, name, c);
	}
	
	@Override
	public WorldChunkManager getServerWorldChunkManager(World world)
    {
		return new ManagerOWG(world, true);
    }

	@Override
	public WorldChunkManager getClientWorldChunkManager(World world)
    {
		return new WorldChunkManagerHell(BiomeList.OLDplains, 0.5F);
    }

	@Override
    public IChunkProvider getChunkGenerator(World world)
    {	
        return new ChunkGeneratorBeta(world, world.getSeed(), world.getWorldInfo().isMapFeaturesEnabled(), trySetting(0, 1) + 1);
    }
}
