package sergey5588.mgtm;

import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.GpuTextureView;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.CraftingScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import sergey5588.mgtm.custom.screens.AltarCoreScreenHandler;

public class AltarCoreScreen extends HandledScreen<AltarCoreScreenHandler> {

    public static final Identifier GUI_TEXTURE = Identifier.of(MyGoldenToolsMod.MOD_ID, "textures/gui/altar_core/altar_core.png");
    public AltarCoreScreen(AltarCoreScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void drawBackground(DrawContext context, float deltaTicks, int mouseX, int mouseY) {
//        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
//        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
//        RenderSystem.setShaderTexture(0, );



        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;

        context.drawTexture(RenderPipelines.GUI_TEXTURED,GUI_TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight, 256, 256);
    }
}
