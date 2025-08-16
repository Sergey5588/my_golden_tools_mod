package sergey5588.mgtm;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.fabricmc.fabric.api.client.screen.v1.Screens;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.realms.gui.screen.RealmsMainScreen;
import net.minecraft.text.Text;
import sergey5588.mgtm.utils.AltarCoreCraftC2SPayload;

public class MyGoldenToolsModClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {

		HandledScreens.register(ModScreenHandlers.ALTAR_CORE_SCREEN_HANDLER, AltarCoreScreen::new);
	}
}