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

import com.savoir.apache.karaf.ai.gateway.api.AIRequest;
import com.savoir.apache.karaf.ai.gateway.api.AIResponse;
import com.savoir.apache.karaf.ai.gateway.api.AIResource;

import com.savoir.apache.karaf.ai.gateway.spi.ExecutorPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/")
public class AIResourceImpl implements AIResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(AIResourceImpl.class);

    private AIKnowledgeBase knowledgeBase;

    public AIResourceImpl(AIKnowledgeBase knowledgeBase) {
        this.knowledgeBase = knowledgeBase;
    }

    @Override
    @Path("/")
    @Consumes("application/json")
    @Produces("application/json")
    @POST
    public AIResponse generate(AIRequest AIRequest) {
        LOGGER.info("Got order: {}, {}, {}", AIRequest.getId(), AIRequest.getSku(), AIRequest.getQuantity());
        try {
            ExecutorPlugin executorPlugin = knowledgeBase.getPlugin(AIRequest.getSku());
            return new AIResponse(executorPlugin.generate());
        } catch (Exception exception) {
            LOGGER.error("Unknown sku");
        }
        return null;
    }
}
