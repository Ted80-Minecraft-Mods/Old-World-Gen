package owg.gui;

import java.util.ArrayList;

import owg.data.DecodeGeneratorString;
import owg.generatortype.GeneratorType;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiCreateWorld;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.StatCollector;


public class GuiGeneratorSettings extends GuiScreen
{
	private final GuiCreateWorld createWorldGui;
	
	public GuiButton BUTTON_DONE;
	public GuiButton BUTTON_CATEGORY;
	
	public int generatorSelected = -1;
	public ArrayList<GuiGeneratorButton> generators;
	public ArrayList<GuiSettingsButton> settings;

	public boolean decodebool;
	public boolean setremember;
	public int[] rememberSettings;
	
	public boolean hasSettings = false;
	
	public String[] translatedDrawStrings;
	
	public GuiGeneratorSettings(GuiCreateWorld gcw, String gs)
	{
    	createWorldGui = gcw;
    	decodebool = true;

    	translatedDrawStrings = new String[2];
    	translatedDrawStrings[0] = StatCollector.translateToLocal("gui.selectGenerator");
    	translatedDrawStrings[1] = StatCollector.translateToLocal("gui.generatorSettings");
	}

	public void initGui()
	{
        buttonList.add(BUTTON_DONE = new GuiButton(0, width / 2 - 155, height - 24, 150, 20, StatCollector.translateToLocal("gui.done")));
        buttonList.add(new GuiButton(1, width / 2 + 5, height - 24, 150, 20, StatCollector.translateToLocal("gui.cancel")));

		System.out.println("INIT");
		
		if(decodebool)
		{
			decodebool = false;
			decodeString(createWorldGui.field_146334_a);
		}
		else
		{
			createList();
			
        	for(int i = 0; i < generators.size(); i++)
        	{
        		generators.get(i).button.enabled = true;
        		if(generators.get(i).generatorID == generatorSelected)
        		{
            		generators.get(i).button.enabled = false;
        		}
        	}
			selectGenerator();
		}
	}

	protected void actionPerformed(GuiButton button)
	{
        if (button.id == 0) //DONE
        {
        	createWorldGui.field_146334_a = createString();
        	mc.displayGuiScreen(this.createWorldGui); 
        }
        else if (button.id == 1) //CANCEL
        {
        	mc.displayGuiScreen(this.createWorldGui);
        }
        else if (button.id >= 10 && button.id < 20)
        {
        	for(int i = 0; i < generators.size(); i++)
        	{
        		generators.get(i).button.enabled = true;
        		if(generators.get(i).button.id == button.id)
        		{
            		generators.get(i).button.enabled = false;
        			generatorSelected = generators.get(i).generatorID;
        		}
        	}
    		selectGenerator();
        }
        else if (button.id >= 20 && button.id < 30)
        {
        	for(int i = 0; i < settings.size(); i++)
        	{
        		if(settings.get(i).button.id == button.id)
        		{
        			settings.get(i).click();
        		}
        	}
        	dependencies();
        }
	}
	
	public void drawScreen(int par1, int par2, float par3)
	{
		drawDefaultBackground();
		
		//title
		String title = "Old World Generator mod";
		drawString(fontRendererObj, title, (int) Math.floor(width / 2) - (int) Math.floor(fontRendererObj.getStringWidth(title) / 2), 10, 16777215);
		
		//select generator
    	drawString(fontRendererObj, translatedDrawStrings[0], width / 2 - 155 + 1, 40, 10526880);

    	if(hasSettings)
    	{
    		drawString(fontRendererObj, translatedDrawStrings[1], width / 2 + 6, 40, 10526880);
    	}
    	
    	drawString(fontRendererObj, "Server config: ", width / 2 - 155 + 1, 165, 16777215);
    	drawString(fontRendererObj, "level-type=OWG", width / 2 - 155 + 1, 182, 10526880);
    	drawString(fontRendererObj, "generator-settings=" + createString(), width / 2 - 155 + 1, 192, 10526880);
		
		super.drawScreen(par1, par2, par3);
	}
	
	public void createList()
	{
		if(generators != null)
		{
			for(int i = 0; i < generators.size(); i++)
			{
				buttonList.remove(generators.get(i).button);
			}
		}
		
		generators = new ArrayList<GuiGeneratorButton>();
		int count = 0;
		for(int g = 0; g < GeneratorType.generatortypes.length; g++)
		{
			if(GeneratorType.generatortypes[g] != null)
			{
				generators.add(new GuiGeneratorButton(StatCollector.translateToLocal("owg." + GeneratorType.generatortypes[g].GetName()), g, count + 10, 50 + (20 * count), width));
				buttonList.add(generators.get(generators.size() - 1).button);
				count++;
			}
		}
	}
	
	public void dependencies()
	{
		for(int i = 0; i < settings.size(); i++)
		{
    		if(settings.get(i).dependencie > -1)
    		{
    			settings.get(i).button.visible = false;
    			for(int p = 0; p < settings.get(i).depvalues.length; p++)
    			{
    				if(settings.get(settings.get(i).dependencie - 20).selected == settings.get(i).depvalues[p])
    				{
    					settings.get(i).button.visible = true;
    				}
    			}
    		}
		}
	}
	
	public void selectGenerator()
	{
		if(generatorSelected > -1)
		{
			BUTTON_DONE.enabled = true;
		}
		else
		{
			BUTTON_DONE.enabled = false;
		}
		
		if(settings != null)
		{
			for(int i = 0; i < settings.size(); i++)
			{
				buttonList.remove(settings.get(i).button);
			}
		}
		settings = new ArrayList<GuiSettingsButton>();
		
		if(generatorSelected > -1)
		{
			hasSettings = GeneratorType.generatortypes[generatorSelected].getSettings(this);
		}

		for(int s = 0; s < settings.size(); s++)
		{
			buttonList.add(settings.get(s).button);
		}
		
		dependencies();
		
		if(setremember)
		{
			for(int rs = 0; rs < settings.size(); rs++)
			{
				settings.get(rs).setOldValue(rememberSettings[rs]);
			}
			setremember = false;
		}
	}
	
	public void decodeString(String decodestring)
	{
		String[] genstring = decodestring.split("#");
		String[] gensettings = new String[0];
		if(genstring.length > 1 && genstring[1].length() > 0)
		{
			gensettings = genstring[1].split("&");
		}
		else
		{
			gensettings = new String[0];
		}
		
		int n = DecodeGeneratorString.getGeneratorIDFromName(genstring[0]);
		if(n > -1)
		{
			createList();
			generatorSelected = n;
			
        	for(int i = 0; i < generators.size(); i++)
        	{
        		generators.get(i).button.enabled = true;
        		if(generators.get(i).generatorID == generatorSelected)
        		{
            		generators.get(i).button.enabled = false;
        		}
        	}
			selectGenerator();
			
			for(int i = 0; i < settings.size(); i++)
			{
				if(i < gensettings.length)
				{
					settings.get(i).setOldValue(Integer.parseInt(gensettings[i]));
				}
			}
		}
		else
		{
			createList();
			generatorSelected = -1;
			selectGenerator();
		}
	}
	
	public String createString()
	{
		if(generatorSelected > -1 && generatorSelected < GeneratorType.generatortypes.length)
		{
			String genstring = GeneratorType.generatortypes[generatorSelected].GetName() + "#";
			for(int s = 0; s < settings.size(); s++)
			{
				genstring += s == 0 ? "" : "&";
				genstring += settings.get(s).valuearray[settings.get(s).selected];
			}
			
			return genstring;
		}
		else
		{
			return "BETA173#";
		}
	}
}