/*
 * Copyright (C) 2023 Luke Bemish and contributors
 * SPDX-License-Identifier: LGPL-3.0-or-later
 */

package dev.lukebemish.scriptresources.impl.forge

import com.matyrobbrt.gml.GMod
import dev.lukebemish.scriptresources.impl.Constants
import dev.lukebemish.scriptresources.impl.ScriptResourcesCommon
import groovy.transform.CompileStatic

@GMod(Constants.MOD_ID)
@CompileStatic
class ScriptResourcesForge {
    ScriptResourcesForge() {
        ScriptResourcesCommon.init()
    }
}
