package io.github.haykam821.highlightunrestrictor.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {
	@Redirect(method = "hasOutline", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/network/ClientPlayerEntity;isSpectator()Z"))
	private boolean removeSpectatorRestriction(ClientPlayerEntity player) {
		return true;
	}
}
