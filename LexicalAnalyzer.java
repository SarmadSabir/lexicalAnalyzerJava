package Assignment2;

import java.io.IOException;
import java.util.*;
import java.util.regex.*;

// The LexicalAnalyzer class tokenizes source code into a list of lexemes
public class LexicalAnalyzer {

	// Tokenizes the given input string into recognized lexemes
    public static List<String> tokenize(String input) {
        List<String> tokens = new ArrayList<>();

        // Regular expressions for various lexemes
        String regex = "\\b(public|private|protected|static|final|class|void|int|double|char|boolean|true|false|return|if|else|while|for|do)\\b|[a-zA-Z_][a-zA-Z0-9_]*|\\d+|[{}()<>;,\\[\\].=+\\-*/%&|!]+|\".*?\"|'.?'";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        // Iterate over matches and add each matched lexeme to the list of tokens.
        while (matcher.find()) {
            tokens.add(matcher.group());
        }

        return tokens;
    }

    // Displays the identified lexemes to the console
    public static void displayTokens(List<String> tokens) {
        // List of undesired tokens which you don't want to display
        List<String> excludeTokens = Arrays.asList("String", "motor", "sensorValue", "args", "in1", "[]");

        for (String token : tokens) {
            if(!excludeTokens.contains(token)) { // Only display if the token is not in the exclude list
                System.out.println("Lexeme: " + token);
            }
        }
    }


    // Main method to drive the lexical analysis process
    public static void main(String[] args) throws IOException {
    	 // Ensure that a file is provided as an argument
    	if (args.length < 1) {
            System.err.println("Usage: java LexicalAnalyzer <input_file>");
            System.exit(1);
        }
    	// Read content from the provided file
        String input_file = args[0];
        String content = Preprocessor.readFile(input_file);
        
        // Tokenize and display the content.
        List<String> tokens = tokenize(content);
        displayTokens(tokens);
    }
}

