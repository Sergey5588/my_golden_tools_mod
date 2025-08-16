package sergey5588.mgtm;

import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.GpuTextureView;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.screen.ingame.CraftingScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.tooltip.BundleTooltipSubmenuHandler;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.GridWidget;
import net.minecraft.client.gui.widget.LayoutWidget;
import net.minecraft.client.realms.gui.screen.RealmsMainScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket;
import net.minecraft.server.command.GiveCommand;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import org.joml.Vector3f;
import sergey5588.mgtm.custom.screens.AltarCoreScreenHandler;
import sergey5588.mgtm.utils.AltarCoreCraftC2SPayload;

public class AltarCoreScreen extends HandledScreen<AltarCoreScreenHandler> {
    private ButtonWidget craftButton;
    public static final Identifier GUI_TEXTURE = Identifier.of(MyGoldenToolsMod.MOD_ID, "textures/gui/altar_core/altar_core.png");
    public AltarCoreScreen(AltarCoreScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }
    public void init() {
        this.x = (this.width - this.backgroundWidth) / 2;
        this.y = (this.height - this.backgroundHeight) / 2;
        this.addTooltipSubmenuHandler(new BundleTooltipSubmenuHandler(this.client));

        this.craftButton = ButtonWidget.builder(Text.of("Magic"), (btn)->{
            BlockPos pos = this.getScreenHandler().bEntity.getPos();
            AltarCoreCraftC2SPayload payload = new AltarCoreCraftC2SPayload(new Vector3f(pos.getX(), pos.getY(), pos.getZ()));
            ClientPlayNetworking.send(payload);


        }).size(54,16).position(this.x+61,this.y + 57).build();
        this.addDrawableChild(craftButton);
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
