package sergey5588.mgtm;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import sergey5588.mgtm.custom.blockEntities.AltarCoreBlockEntity;

public class ModBlockEntityTypes {
    public static <T extends BlockEntityType<?>> T register(String path, T blockEntityType) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(MyGoldenToolsMod.MOD_ID, path), blockEntityType);
    }

    public static final BlockEntityType<AltarCoreBlockEntity> ALTAR_CORE = register(
            "altar_core",

            FabricBlockEntityTypeBuilder.create(AltarCoreBlockEntity::new, ModBlocks.ALTAR_CORE).build()
    );

    public static void initialize() {
    }
}
