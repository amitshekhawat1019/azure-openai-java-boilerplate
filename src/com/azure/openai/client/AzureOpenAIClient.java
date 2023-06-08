package com.azure.openai.client;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.azure.ai.openai.OpenAIClient;
import com.azure.ai.openai.OpenAIClientBuilder;
import com.azure.core.credential.AzureKeyCredential;

public class AzureOpenAIClient {

	static Properties prop = new Properties();

	static {
		loadProperties();
	}
	public static final String COMPLETION_MODEL = prop.getProperty("AZURE_COMPLETION_MODEL");

	public static final String EMBEDDINGS_MODEL = prop.getProperty("AZURE_EMBEDDINGS_MODEL");



	public final OpenAIClient getOpenAIClient() {

		OpenAIClient client = new OpenAIClientBuilder()
				.credential(new AzureKeyCredential(prop.getProperty("AZURE_OPENAI_KEY")))
				.endpoint(prop.getProperty("AZURE_OPENAI_ENDPOINT")).buildClient();
		return client;
	}

	static void loadProperties() {
		try {
			prop.load(new FileInputStream("resources/azureopenai.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
