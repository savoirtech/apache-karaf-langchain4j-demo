/*
 * Copyright (c) 2012-2023 Savoir Technologies, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.savoir.apache.karaf.ai.gateway.impl;

import com.savoir.apache.karaf.ai.gateway.spi.ExecutorPlugin;
import com.savoirtech.eos.pattern.whiteboard.KeyedWhiteboard;
import org.osgi.framework.BundleContext;

public class AIKnowledgeBaseImpl extends KeyedWhiteboard<String, ExecutorPlugin> implements AIKnowledgeBase {
//----------------------------------------------------------------------------------------------------------------------
// Fields
//----------------------------------------------------------------------------------------------------------------------


//----------------------------------------------------------------------------------------------------------------------
// Constructors
//----------------------------------------------------------------------------------------------------------------------

    public AIKnowledgeBaseImpl(BundleContext bundleContext) {
        super(bundleContext, ExecutorPlugin.class, (svc, props) -> props.getProperty("pluginType"));
    }

//----------------------------------------------------------------------------------------------------------------------
// Implementation
//----------------------------------------------------------------------------------------------------------------------

    @Override
    public ExecutorPlugin getPlugin(String pluginType) throws Exception {
        if (null == pluginType) {
            throw new Exception("Plugin type is required");
        }
        ExecutorPlugin plugin = getService(pluginType);
        if (null == plugin) {
            throw new Exception("Executor plugin with type \"" + pluginType + "\" not found");
        }
        return plugin;
    }
}
