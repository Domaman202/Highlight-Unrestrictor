package io.github.haykam821.highlightunrestrictor.mixin;

import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {
	protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
		super(entityType, world);
	}

	public boolean isGlowing() {
		return super.isGlowing() || MinecraftClient.getInstance().options.keySpectatorOutlines.isPressed();
	}
}