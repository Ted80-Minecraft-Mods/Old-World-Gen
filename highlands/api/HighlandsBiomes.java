package highlands.api;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.world.biome.BiomeGenBase;


/*
 * Highlands biomes - Highlands API
 * 
 * This class contains all of the biomes for Highlands.
 * Only access this class in Post Initialization!
 * The values are populated during Highlands initialization.
 */
public class HighlandsBiomes {

	//main biomes
	public static BiomeGenBase woodsMountains;
    public static BiomeGenBase highlandsb;
    public static BiomeGenBase tundra;
    public static BiomeGenBase cliffs;
    public static BiomeGenBase pinelands;
    public static BiomeGenBase autumnForest;
    public static BiomeGenBase alps;
    public static BiomeGenBase tallPineForest;
    public static BiomeGenBase meadow;
    public static BiomeGenBase savannah;
    public static BiomeGenBase tropics;
    public static BiomeGenBase outback;
    public static BiomeGenBase woodlands;
    public static BiomeGenBase bog;
    public static BiomeGenBase redwoodForest;
    public static BiomeGenBase dunes;
    public static BiomeGenBase lowlands;
    public static BiomeGenBase sahel;
    public static BiomeGenBase birchHills;
    public static BiomeGenBase tropicalIslands;
    public static BiomeGenBase rainforest;
    public static BiomeGenBase estuary;
    public static BiomeGenBase badlands;
    public static BiomeGenBase flyingMountains;
    public static BiomeGenBase snowMountains;
    public static BiomeGenBase rockMountains;
    public static BiomeGenBase desertMountains;
    public static BiomeGenBase steppe;
    public static BiomeGenBase glacier;
    //public static BiomeGenBase everglades;
    
    //improved ocean biome
    public static BiomeGenBase ocean2;
    
    //Sub Biomes
    public static BiomeGenBase forestIsland;
    public static BiomeGenBase jungleIsland;
    public static BiomeGenBase desertIsland;
    public static BiomeGenBase volcanoIsland;
    public static BiomeGenBase snowIsland;
    public static BiomeGenBase windyIsland;
    public static BiomeGenBase rockIsland;
    public static BiomeGenBase valley;
    public static BiomeGenBase lake;
    public static BiomeGenBase mesa;
    public static BiomeGenBase baldHill;
    public static BiomeGenBase oasis;
    public static BiomeGenBase canyon;
    
    //Border Biomes
    public static BiomeGenBase shrubland;
    
    
    //ArrayList of biomes for the Highlands worldtype
    public static ArrayList<BiomeGenBase> biomesForHighlands;
    
    //ArrayList of Highlands biomes (not including default ones, these will be added to the default world
    public static ArrayList<BiomeGenBase> biomesForDefault;
    
    //ArrayList of all Highlands sub-biomes (not vanilla ones)
    public static ArrayList<BiomeGenBase> subBiomes;
    
    
    public static void initBiomeArrays(){
    	biomesForHighlands = new ArrayList<BiomeGenBase>();
    	biomesForDefault = new ArrayList<BiomeGenBase>();
    	subBiomes = new ArrayList<BiomeGenBase>();
    }
}







