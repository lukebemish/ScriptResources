package dev.lukebemish.scriptresources.impl

import com.mojang.datafixers.util.Pair
import net.minecraft.resources.ResourceLocation

abstract class ResourceConsumer {
    abstract void accept(ResourceLocation id, Closure resource)
    abstract void accept(Pair<ResourceLocation, Closure> resource)
}
