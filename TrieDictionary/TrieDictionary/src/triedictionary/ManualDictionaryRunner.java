package triedictionary;

import java.sql.SQLOutput;
import java.util.Scanner;

public class ManualDictionaryRunner {

    public static void main(String args[]) {
        DictionaryInterface dictionary = new TrieTestRunner.tempDictionary();   //put your dictionary instantiation here

        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("Please enter a command: add, contains, wordCount, nodeCount, delete, clear, quit");
            String command = scanner.next();
            String word;

            switch(command) {
                case "add":
                    System.out.println("Please enter a word to add");
                    word = scanner.next();
                    System.out.println(dictionary.addWord(word));
                    break;
                case "contains":
                    System.out.println("Please enter a word to find");
                    word = scanner.next();
                    System.out.println(dictionary.hasWord(word));
                    break;
                case "clear":
                    dictionary.clearDictionary();
                    break;
                case "nodeCount":
                    System.out.println(dictionary.getNodeCount());
                    break;
                case "delete":
                    System.out.println("Please enter a word to delete");
                    word = scanner.next();
                    System.out.println(dictionary.deleteWord(word));
                    break;
                case "wordCount":
                    System.out.println(dictionary.totalWordCount());
                    break;
                case "break":
                    return;
                default:
                    System.out.println("You must have mistyped a command, try again");
            }



        }




    }

}
