/*
 * Copyright (C) 2023 Luke Bemish and contributors
 * SPDX-License-Identifier: LGPL-3.0-or-later
 */

package dev.lukebemish.scriptresources.impl.quilt

import dev.lukebemish.scriptresources.impl.Constants
import dev.lukebemish.scriptresources.impl.ScriptResourcesListener
import net.minecraft.resources.ResourceLocation
import org.quiltmc.qsl.resource.loader.api.reloader.IdentifiableResourceReloader

class ScriptResourcesQuiltListener extends ScriptResourcesListener implements IdentifiableResourceReloader {
    public static final ResourceLocation QUILT_ID = new ResourceLocation(Constants.MOD_ID, "load_scripts")

    @Override
    ResourceLocation getQuiltId() {
        return QUILT_ID
    }
}
