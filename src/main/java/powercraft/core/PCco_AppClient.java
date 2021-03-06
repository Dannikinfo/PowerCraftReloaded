package powercraft.core;

import java.util.List;

import powercraft.api.gres.PC_IGresClient;
import powercraft.api.registry.PC_LangRegistry.LangEntry;
import powercraft.api.utils.PC_Struct2;
import powercraft.launcher.loader.PC_ClientModule;
import powercraft.launcher.loader.PC_ClientModule.PC_AddSplashes;
import powercraft.launcher.loader.PC_ClientModule.PC_InitLanguage;
import powercraft.launcher.loader.PC_ClientModule.PC_RegisterGuis;

@PC_ClientModule
public class PCco_AppClient extends PCco_App {

	@PC_AddSplashes
	public List<String> addSplashes(List<String> list) {
		list.add("Sniffing diamonds!");
		return list;
	}

	@PC_RegisterGuis
	public List<PC_Struct2<String, Class<? extends PC_IGresClient>>> registerGuis(
			List<PC_Struct2<String, Class<? extends PC_IGresClient>>> guis) {
		guis.add(new PC_Struct2<String, Class<? extends PC_IGresClient>>("CraftingTool", PCco_GuiCraftingTool.class));
		guis.add(new PC_Struct2<String, Class<? extends PC_IGresClient>>("OreSnifferResultScreen",
				PCco_GuiOreSnifferResultScreen.class));
		guis.add(new PC_Struct2<String, Class<? extends PC_IGresClient>>("SpawnerEditor", PCco_GuiSpawnerEditor.class));
		return guis;
	}

}
