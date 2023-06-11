package com.azure.openai.boilerplate.chatbot;

import java.util.Scanner;

import com.azure.ai.openai.OpenAIClient;
import com.azure.ai.openai.models.Choice;
import com.azure.ai.openai.models.Completions;
import com.azure.openai.boilerplate.AzureOpenAIClient;

public class AzureOpenAIChatBot {

	private static OpenAIClient client = new AzureOpenAIClient().getOpenAIClient();

	public static void main(String[] args) {

		System.out.println(
				"Welcome to Azure OpenAI ChatBot. \n Enter prompt to chat with the model. \n Enter \"Q\" or \"QUIT\" to end chat.");

		while (true) {

			System.out.println("Prompt: ");

			Scanner scanner = new Scanner(System.in);
			String prompt = scanner.nextLine();

			if (prompt.equals("Q") || prompt.equals("QUIT")) {
				System.out.println("Ending Chat...Thanks You..!!!");
				System.exit(0);
			}

			Completions completions = client.getCompletions(AzureOpenAIClient.COMPLETION_MODEL, prompt);

			for (Choice choice : completions.getChoices()) {
				System.out.printf("Answer:", choice.getText());
				System.out.printf("%s.%n", choice.getText());
			}
		}

	}

}
