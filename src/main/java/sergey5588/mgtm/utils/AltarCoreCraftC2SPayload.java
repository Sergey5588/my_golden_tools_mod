package sergey5588.mgtm.utils;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;
import org.joml.Vector3f;
import sergey5588.mgtm.MyGoldenToolsMod;

public record AltarCoreCraftC2SPayload(Vector3f pos) implements CustomPayload {
    public static final Identifier GIVE_GLOWING_EFFECT_PAYLOAD_ID = Identifier.of(MyGoldenToolsMod.MOD_ID, "altar_core_notify");
    public static final CustomPayload.Id<AltarCoreCraftC2SPayload> ID = new CustomPayload.Id<>(GIVE_GLOWING_EFFECT_PAYLOAD_ID);
    public static final PacketCodec<RegistryByteBuf, AltarCoreCraftC2SPayload> CODEC = PacketCodec.tuple(PacketCodecs.VECTOR_3F, AltarCoreCraftC2SPayload::pos, AltarCoreCraftC2SPayload::new);

    @Override
    public CustomPayload.Id<? extends CustomPayload> getId() {
        return ID;
    }
}
