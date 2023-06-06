/*
 * Copyright (C) 2023 Luke Bemish and contributors
 * SPDX-License-Identifier: LGPL-3.0-or-later
 */

package dev.lukebemish.scriptresources.api

import com.mojang.datafixers.util.Pair
import dev.lukebemish.scriptresources.impl.ScriptResourcesListener
import groovy.transform.CompileStatic
import groovy.transform.TupleConstructor
import groovy.transform.VisibilityOptions
import groovy.transform.options.Visibility
import groovy.transform.stc.ClosureParams
import groovy.transform.stc.FromAbstractTypeMethods
import net.minecraft.resources.ResourceLocation

@CompileStatic
final class ScriptResources {
    private ScriptResources() {}

    static <T> ScriptProvider<T> registerPrefix(ResourceLocation prefix, Class<? super T> clazz) {
        if (ScriptResourcesListener.PREFIXES.containsKey(prefix)) {
            throw new IllegalArgumentException("Prefix ${prefix} is already registered for context type ${ScriptResourcesListener.PREFIXES[prefix].name}")
        }
        ScriptResourcesListener.PREFIXES[prefix] = clazz
        return new ScriptProvider<>(prefix, clazz)
    }

    @CompileStatic
    @TupleConstructor(visibilityId = 'private')
    @VisibilityOptions(id = 'private', value = Visibility.PRIVATE)
    static final class ScriptProvider<T> {
        final ResourceLocation prefix
        final Class<? super T> clazz

        Closure getResource(ResourceLocation id) {
            return ScriptResourcesListener.SCRIPTS.getOrDefault(prefix, new LinkedHashMap<ResourceLocation, Closure>()).get(id)
        }

        void getResources(@ClosureParams(value = FromAbstractTypeMethods, options = ['dev.lukebemish.scriptresources.impl.ResourceConsumer']) Closure resourceConsumer) {
            ScriptResourcesListener.SCRIPTS.getOrDefault(prefix, new LinkedHashMap<ResourceLocation, Closure>()).each { id, closure ->
                if (resourceConsumer.getMaximumNumberOfParameters() == 2) {
                    resourceConsumer.call(id, closure)
                } else {
                    resourceConsumer.call(new Pair<>(id, closure))
                }
            }
        }
    }
}
