package com.azure.openai.completion;

import java.util.ArrayList;
import java.util.List;

import com.azure.ai.openai.OpenAIClient;
import com.azure.ai.openai.models.Choice;
import com.azure.ai.openai.models.Completions;
import com.azure.ai.openai.models.CompletionsOptions;
import com.azure.ai.openai.models.CompletionsUsage;
import com.azure.openai.client.AzureOpenAIClient;

public class AzureOpenAITextCompletions {

	private static OpenAIClient client = new AzureOpenAIClient().getOpenAIClient();


	public static void main(String[] args) {
		List<String> prompt = new ArrayList<>();
		prompt.add("Say this is a test");

		Completions completions = client.getCompletions(AzureOpenAIClient.COMPLETION_MODEL, new CompletionsOptions(prompt));

		System.out.printf("Model ID=%s is created at %d.%n", completions.getId(), completions.getCreated());
		for (Choice choice : completions.getChoices()) {
			System.out.printf("Index: %d, Text: %s.%n", choice.getIndex(), choice.getText());
		}

		CompletionsUsage usage = completions.getUsage();
		System.out.printf("Usage: number of prompt token is %d, "
				+ "number of completion token is %d, and number of total tokens in request and response is %d.%n",
				usage.getPromptTokens(), usage.getCompletionTokens(), usage.getTotalTokens());

	}

}
