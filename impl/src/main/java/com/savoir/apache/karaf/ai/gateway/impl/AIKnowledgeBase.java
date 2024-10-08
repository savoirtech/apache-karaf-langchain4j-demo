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

public interface AIKnowledgeBase {

    /**
     *  Returns the executor plugin from the whiteboard
     * @param pluginType type
     * @return plugin
     */
    ExecutorPlugin getPlugin(String pluginType) throws Exception;
}
