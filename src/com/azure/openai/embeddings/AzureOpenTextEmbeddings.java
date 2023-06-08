package com.azure.openai.embeddings;

import java.util.Arrays;

import com.azure.ai.openai.OpenAIClient;
import com.azure.ai.openai.models.EmbeddingItem;
import com.azure.ai.openai.models.Embeddings;
import com.azure.ai.openai.models.EmbeddingsOptions;
import com.azure.ai.openai.models.EmbeddingsUsage;
import com.azure.openai.client.AzureOpenAIClient;

public class AzureOpenTextEmbeddings {
	
	private static OpenAIClient client = new AzureOpenAIClient().getOpenAIClient();

	public static void main(String[] args) {
		EmbeddingsOptions embeddingsOptions = new EmbeddingsOptions(Arrays.asList("Your text string goes here"));

		Embeddings embeddings = client.getEmbeddings(AzureOpenAIClient.EMBEDDINGS_MODEL, embeddingsOptions);

		for (EmbeddingItem item : embeddings.getData()) {
			System.out.printf("Index: %d.%n", item.getIndex());
			for (Double embedding : item.getEmbedding()) {
				System.out.printf("%f;", embedding);
			}
		}

		EmbeddingsUsage usage = embeddings.getUsage();
		System.out.printf(
				"Usage: number of prompt token is %d and number of total tokens in request and response is %d.%n",
				usage.getPromptTokens(), usage.getTotalTokens());

	}

}
