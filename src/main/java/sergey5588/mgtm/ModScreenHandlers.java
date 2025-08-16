package sergey5588.mgtm;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import sergey5588.mgtm.custom.screens.AltarCoreScreenHandler;

public class ModScreenHandlers {
    public static final ScreenHandlerType<AltarCoreScreenHandler> ALTAR_CORE_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(MyGoldenToolsMod.MOD_ID, "altar_core_screen_handler"),
                    new ExtendedScreenHandlerType<>(AltarCoreScreenHandler::new, BlockPos.PACKET_CODEC));

    public static void initialize() {

    }
}
