/*
 * Copyright (C) 2023 Luke Bemish and contributors
 * SPDX-License-Identifier: LGPL-3.0-or-later
 */

package dev.lukebemish.scriptresources.impl.quilt


import dev.lukebemish.scriptresources.impl.ScriptResourcesCommon
import groovy.transform.CompileStatic
import net.minecraft.server.packs.PackType
import org.quiltmc.loader.api.ModContainer
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer
import org.quiltmc.qsl.resource.loader.api.ResourceLoader

@CompileStatic
class ScriptResourcesQuilt implements ModInitializer {

    @Override
    void onInitialize(ModContainer mod) {
        ScriptResourcesCommon.init()
        ResourceLoader.get(PackType.SERVER_DATA).registerReloader(new ScriptResourcesQuiltListener())
    }
}
