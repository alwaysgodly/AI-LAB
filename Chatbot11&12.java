
import java.util.*;

public class AdvancedChatbot {

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    // Intent structure
    static class Intent {
        List<String> patterns;
        List<String> responses;

        Intent(List<String> patterns, List<String> responses) {
            this.patterns = patterns;
            this.responses = responses;
        }
    }

    // Intent map
    static Map<String, Intent> intents = new HashMap<>();

    // Context memory
    static String lastIntent = "";

    // -----------------------------
    // Initialize intents
    // -----------------------------
    static void initIntents() {
        intents.put("greeting", new Intent(
                Arrays.asList("hello", "hi", "hey"),
                Arrays.asList("Hello! How can I help you?", "Hi there!", "Hey! What can I do for you?")
        ));

        intents.put("products", new Intent(
                Arrays.asList("product", "items", "sell"),
                Arrays.asList("We offer laptops, smartphones, and accessories.")
        ));

        intents.put("price", new Intent(
                Arrays.asList("price", "cost", "rate"),
                Arrays.asList("Prices range from ₹10,000 to ₹1,00,000.")
        ));

        intents.put("service", new Intent(
                Arrays.asList("service", "support", "help"),
                Arrays.asList("We provide 24/7 customer support.")
        ));

        intents.put("hours", new Intent(
                Arrays.asList("time", "hours", "open"),
                Arrays.asList("We are open from 9 AM to 9 PM.")
        ));

        intents.put("location", new Intent(
                Arrays.asList("where", "location", "address"),
                Arrays.asList("We operate online and in major cities.")
        ));

        intents.put("thanks", new Intent(
                Arrays.asList("thanks", "thank you"),
                Arrays.asList("You're welcome!", "Happy to help!")
        ));

        intents.put("bye", new Intent(
                Arrays.asList("bye", "exit", "goodbye"),
                Arrays.asList("Goodbye! Have a great day!")
        ));
    }

    // -----------------------------
    // Preprocess input
    // -----------------------------
    static String preprocess(String input) {
        return input.toLowerCase().replaceAll("[^a-z0-9\\s]", "");
    }

    // -----------------------------
    // Detect intent
    // -----------------------------
    static String detectIntent(String input) {
        for (String intent : intents.keySet()) {
            for (String pattern : intents.get(intent).patterns) {
                if (input.contains(pattern)) {
                    return intent;
                }
            }
        }
        return null;
    }

    // -----------------------------
    // Get random response
    // -----------------------------
    static String getResponse(String intent) {
        List<String> responses = intents.get(intent).responses;
        return responses.get(random.nextInt(responses.size()));
    }

    // -----------------------------
    // Chatbot main logic
    // -----------------------------
    public static void main(String[] args) {

        initIntents();

        System.out.println("Bot: Hello! Ask me anything (type 'bye' to exit).");

        while (true) {
            System.out.print("You: ");
            String userInput = sc.nextLine();

            String cleaned = preprocess(userInput);
            String intent = detectIntent(cleaned);

            if (intent != null) {
                lastIntent = intent;
                System.out.println("Bot: " + getResponse(intent));

                if (intent.equals("bye")) {
                    break;
                }

            } else {
                // Context-aware fallback
                if (lastIntent.equals("products")) {
                    System.out.println("Bot: Are you asking about price or features?");
                } else {
                    System.out.println("Bot: Sorry, I didn't understand. Can you rephrase?");
                }
            }
        }
    }
}
