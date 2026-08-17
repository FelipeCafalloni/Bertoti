import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.ollama.OllamaChatModel;

public class DataFaker {
    public static void main(String[] args) {
        // Conecta ao modelo Qwen no Ollama
        ChatLanguageModel model = OllamaChatModel.builder()
                .baseUrl("http://localhost:11434")
                .modelName("qwen2.5:1.5b")
                .temperature(0.8) // Temperatura maior gera dados mais variados/criativos
                .build();

        // Instrução para a IA gerar os dados falsos
        String prompt = """
                Gere os dados fictícios de um perfil de usuário brasileiro no formato JSON.
                Inclua os seguintes campos:
                - Nome completo
                - E-mail
                - Endereço completo (Rua, Número, Bairro, Cidade, Estado, CEP)
                - Profissão
                - Empresa
                
                Retorne APENAS o JSON, sem explicações adicionais.
                """;

        System.out.println("Gerando dados fictícios via IA...");
        String dadosFicticios = model.generate(prompt);

        System.out.println("\nDados Gerados:");
        System.out.println(dadosFicticios);
    }
}