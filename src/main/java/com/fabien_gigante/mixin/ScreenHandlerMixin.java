package com.fabien_gigante.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import net.minecraft.inventory.Inventory;
import net.minecraft.screen.ScreenHandler;

import com.fabien_gigante.IDisableableSlots;

@Mixin(ScreenHandler.class)
public abstract class ScreenHandlerMixin {
	@Redirect(method = "calculateComparatorOutput(Lnet/minecraft/inventory/Inventory;)I", 
		at = @At(value = "INVOKE", target = "Lnet/minecraft/inventory/Inventory;size()I", ordinal = 1))
	private static int capacity(Inventory inventory) { return IDisableableSlots.getCapacity(inventory); }
}
