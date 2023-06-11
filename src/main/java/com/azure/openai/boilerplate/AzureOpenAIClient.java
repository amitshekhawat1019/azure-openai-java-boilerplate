package com.azure.openai.boilerplate;

import java.io.IOException;
import java.io.InputStream;
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


    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
    public final OpenAIClient getOpenAIClient() {

        OpenAIClient client = new OpenAIClientBuilder()
                .credential(new AzureKeyCredential(prop.getProperty("AZURE_OPENAI_KEY")))
                .endpoint(prop.getProperty("AZURE_OPENAI_ENDPOINT")).buildClient();
        return client;
    }

    static void loadProperties() {
        try {
            InputStream root = AzureOpenAIClient.class.getClassLoader().getResourceAsStream("azureopenai.properties");
            prop.load(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
