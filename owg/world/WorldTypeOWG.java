package owg.world;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import owg.OWG;
import owg.biomes.BiomeList;
import owg.data.DecodeGeneratorString;
import owg.generatortype.GeneratorType;
import owg.gui.GuiGeneratorSettings;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiCreateWorld;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldTypeOWG extends WorldType
{
	public WorldTypeOWG(String n)
	{
		super(n);
	}
	
    public WorldChunkManager getChunkManager(World world)
    {
		if(!world.isRemote)
		{
			System.out.println("OLD WORLD GEN - GENERATORSTRING: " + world.getWorldInfo().getGeneratorOptions());
			if(world.getWorldInfo().getGeneratorOptions().length() > 2)
			{
				DecodeGeneratorString.decode(world.getWorldInfo().getGeneratorOptions());
			}
			else
			{
				DecodeGeneratorString.decode("BETA173#");
			}
			
			return GeneratorType.currentGenerator.getServerWorldChunkManager(world);
		}
		else
		{
			if(GeneratorType.currentGenerator == null)
			{
				return new WorldChunkManagerHell(BiomeList.OLDplains, 0.5F);
			}
			else
			{
				return GeneratorType.currentGenerator.getClientWorldChunkManager(world);
			}
		}
    }

    public IChunkProvider getChunkGenerator(World world, String generatorOptions)
    {
    	return GeneratorType.currentGenerator.getChunkGenerator(world);
    }
	
    public float getCloudHeight()
    {
        return 107F;
    }
	
    @SideOnly(Side.CLIENT)
    public void onCustomizeButton(Minecraft instance, GuiCreateWorld guiCreateWorld)
    {
    	instance.displayGuiScreen(new GuiGeneratorSettings(guiCreateWorld, guiCreateWorld.field_146334_a));
    }
    
    public boolean isCustomizable()
    {
        return true;
    }
}