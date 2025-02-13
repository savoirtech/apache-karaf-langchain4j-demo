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
package com.savoir.apache.karaf.ai.command;

import com.savoir.apache.karaf.ai.gateway.api.AIRequest;
import com.savoir.apache.karaf.ai.gateway.api.AIResource;

import java.util.Random;
import org.apache.karaf.shell.api.action.Action;
import org.apache.karaf.shell.api.action.Argument;
import org.apache.karaf.shell.api.action.Command;
import org.apache.karaf.shell.api.action.lifecycle.Reference;
import org.apache.karaf.shell.api.action.lifecycle.Service;

@Service
@Command(scope = "ai", name = "ask", description = "Ask an ai a question.")
public class AiCommand implements Action {

    private Random r = new Random();

    @Reference
    private AIResource aiResource;

    @Argument(index = 0, name = "plugin", description = "Plugin", required = true, multiValued = false)
    String plugin;

    @Argument(index = 1, name = "question", description = "User question", required = true, multiValued = false)
    String question;

    @Override
    public Object execute() throws Exception {
        AIRequest request = new AIRequest();
        request.setId(r.nextLong());
        request.setPlugin(plugin);
        request.setPrompt(question);
        System.out.println(aiResource.generate(request).getResponse());
        return null;
    }
}
