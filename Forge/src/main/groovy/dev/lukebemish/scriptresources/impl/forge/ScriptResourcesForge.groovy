/*
 * Copyright (C) 2023 Luke Bemish and contributors
 * SPDX-License-Identifier: LGPL-3.0-or-later
 */

package dev.lukebemish.scriptresources.impl.forge


import dev.lukebemish.scriptresources.impl.Constants
import dev.lukebemish.scriptresources.impl.ScriptResourcesCommon
import dev.lukebemish.scriptresources.impl.ScriptResourcesListener
import groovy.transform.CompileStatic
import net.minecraftforge.event.AddReloadListenerEvent
import org.groovymc.gml.GMod

@GMod(Constants.MOD_ID)
@CompileStatic
class ScriptResourcesForge {
    ScriptResourcesForge() {
        ScriptResourcesCommon.init()
        forgeBus.addListener(AddReloadListenerEvent) { event ->
            event.addListener(new ScriptResourcesListener())
        }
    }
}
