# Azure OpenAI Java Boilerplate

The Azure OpenAI Java Boilerplate is a starter template designed to accelerate the process of integrating and utilizing Azure OpenAI's deployed models in your Java applications. It provides a foundation for quickly writing new use cases and leveraging the power of OpenAI's models for various tasks.

## Pre-requisite

```
Java version: 1.8
apache-maven-3.8.6
```

## Install

```
mvn clean package
```

## Configuration

update properties file located at **resources/azureopenai.properties** with below properties

- AZURE_OPENAI_KEY="YOUR OPEN AI API KEY"
- AZURE_OPENAI_ENDPOINT="YOUR OPEN AI ENDPOINT"
- AZURE_COMPLETION_MODEL="YOUR OPEN AI COMPLETION MODEL NAME"
- AZURE_EMBEDDINGS_MODEL="YOUR OPEN AI EMBEDDINGS MODEL NAME"

## Class

1. **AzureOpenAIClient** - 
   ./src/main/java/com/azure/openai/boilerplate/AzureOpenAIClient.java

	1. This class provides a client for accessing the OpenAI API using the configuration specified in the resources/azureopenai.properties file.
	2. Use the AzureOpenAIClient instance to access the OpenAI API methods.

#### Usage:

```
private static OpenAIClient client = new AzureOpenAIClient().getOpenAIClient();
```

## Run Text Completion

```
java -cp target/azure-openai-java-boilerplate-1.0.0-jar-with-dependencies.jar com.azure.openai.boilerplate.completion.AzureOpenAITextCompletions
```

## Run chatBot example

```
java -cp target/azure-openai-java-boilerplate-1.0.0-jar-with-dependencies.jar com.azure.openai.boilerplate.chatbot.AzureOpenAIChatBot
```

## Run Text Embedding

```
java -cp target/azure-openai-java-boilerplate-1.0.0-jar-with-dependencies.jar com.azure.openai.boilerplate.embeddings.AzureOpenTextEmbeddings
```

## Examples

### 1. Create Text Completion

```
private static OpenAIClient client = new AzureOpenAIClient().getOpenAIClient();

private static String MODEL_ID = "gpt-35-turbo-base";

public static void main(String[] args) {
		List<String> prompt = new ArrayList<>();
		prompt.add("What is Java ?");

		Completions completions = client.getCompletions(AzureOpenAIClient.COMPLETION_MODEL, new CompletionsOptions(prompt));
		for (Choice choice : completions.getChoices()) {
			System.out.printf("Index: %d, Text: %s.%n", choice.getIndex(), choice.getText());
		}
	}
```

> You can find a complete code snippet in the ./src/com/azure/openai/completion/AzureOpenAITextCompletions.java class.

### 2. Create Text Embeddings

```
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
	}

```
