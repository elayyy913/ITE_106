import java.io.*;
import java.util.*;

public class TextAnalyzer{
	public static void main (String [] args) {
		try { 
			File file = new File ("mikaela.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			StringBuilder text = new StringBuilder();
			String line;
			int lineNumber = 1;
			
			while ((line = reader.readLine()) != null) {
				System.out.println("Line" + lineNumber + ":"+ line);
				text.append(line).append("");
				lineNumber++;
			}
			reader.close();
			
			String content = text.toString();
			
			String [] words = content.split("\\s+");
			int wordCount = words.length ;
			
			String [] sentences = content.split("[.!?]");
			int sentenceCount = sentences.lenght;
			
			String upperCaseContent = content.toUpperCase();
			
			String longestWord = "";
			for (String word : words) {
				word = word.replaceAll ("[^a-A-Z]","");
				if (word.length () > longestWord.length()) {
					longestWord = word;
				}
			}
			HashMap<String, Integer> wordFrequency = new HashMap<> ();
			for (String word : words){
				word = word.replaceAll("[^a-A-Z]","").toLowerCase();
				wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
			}
			System.out.println("wordCount:" + wordCount);
			System.out.println("sentenceCount" + sentenceCount);
			System.out.println("Text in Uppercase:\n"+ upperCaseContent);
			System.out.println("longestWord" +longestWord);
			System.out.println("wordFrequency" + wordFrequency);
			
	}catch (IOException e) {
		System.out.println("Error reading file: " + e.getMessage()) ;
		}
	}
}
