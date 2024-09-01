/*
 * Copyright (c) 2012-2024 Savoir Technologies, Inc.
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

package com.savoir.apache.karaf.ai.gateway.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class AIRequest {

    @JsonProperty
    private Long id;
    @JsonProperty
    private String plugin;
    @JsonProperty
    private String prompt;



    public Long getId() {
        return id;
    }

    public String getPlugin() {
        return plugin;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPlugin(String plugin) {
        this.plugin = plugin;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }
}
