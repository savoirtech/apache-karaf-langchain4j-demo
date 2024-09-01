package com.savoir.apache.karaf.ai.gateway.plugins;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;

import com.savoir.apache.karaf.ai.gateway.spi.ExecutorPlugin;

public class OpenAiChatSimplePrompt implements ExecutorPlugin {
//----------------------------------------------------------------------------------------------------------------------
// Fields
//----------------------------------------------------------------------------------------------------------------------

    ChatLanguageModel model;

//----------------------------------------------------------------------------------------------------------------------
// Constructors
//----------------------------------------------------------------------------------------------------------------------

    public OpenAiChatSimplePrompt() {
        model = OpenAiChatModel.withApiKey("demo");
    }

//----------------------------------------------------------------------------------------------------------------------
// Implementation
//----------------------------------------------------------------------------------------------------------------------


    @Override
    public String describe() {
        return "This is an OpenAi Chat Simple Prompt plugin.";
    }

    @Override
    public String generate(String prompt) {
        return model.generate(prompt);
    }
}

