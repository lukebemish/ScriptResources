/*
 * Copyright (C) 2023 Luke Bemish and contributors
 * SPDX-License-Identifier: LGPL-3.0-or-later
 */

package dev.lukebemish.scriptresources.impl


import groovy.transform.CompileStatic
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@CompileStatic
class Constants {
    private Constants() {}

    public static final String MOD_ID = "scriptresources"
    public static final String MOD_NAME = "ScriptResources"
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME)
}
