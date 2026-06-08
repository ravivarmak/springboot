package com.example.ollamagaru.controller;


import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.ollama.api.OllamaChatOptions;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.beans.factory.annotation.Qualifier;

@RestController
public class AIController {
	private final ChatModel chatModel;
	public AIController(@Qualifier("ollamaChatModel") ChatModel chatModel) {
		this.chatModel = chatModel;
	}
	
	@GetMapping("/ask-ai")
	public String askAI(@RequestParam String prompt) {
		
		OllamaChatOptions options = OllamaChatOptions.builder()
				.model("mistral")	
				.temperature(0.4)
		        .build();
		ChatResponse response = chatModel.call(new Prompt(prompt,options));
		return response.getResult().getOutput().getText();
	}
}
