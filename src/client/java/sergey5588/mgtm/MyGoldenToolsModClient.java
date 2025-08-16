package sergey5588.mgtm;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class MyGoldenToolsModClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		HandledScreens.register(ModScreenHandlers.ALTAR_CORE_SCREEN_HANDLER, AltarCoreScreen::new);
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
	}
}