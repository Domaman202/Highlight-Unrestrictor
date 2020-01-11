package io.github.haykam821.highlightunrestrictor.mixin;

import com.mojang.authlib.GameProfile;

import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;

@Mixin(ClientPlayerEntity.class)
public abstract class ClientPlayerEntityMixin extends AbstractClientPlayerEntity {
	public ClientPlayerEntityMixin(ClientWorld clientWorld, GameProfile gameProfile) {
		super(clientWorld, gameProfile);
	}

	public boolean isGlowing() {
		return super.isGlowing() || MinecraftClient.getInstance().options.keySpectatorOutlines.isPressed();
	}
}