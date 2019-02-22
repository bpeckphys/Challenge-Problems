package triedictionary;

import java.io.File;
import java.util.Scanner;

public class TrieTestRunner {

    public static void main(String args[]) {


        DictionaryInterface dictionary = new tempDictionary();  //Put your class here

        File testFile = new File("/tests.txt");
        Scanner scanner = null;

        try {
            scanner = new Scanner(testFile);
        } catch(Exception e) {
            System.out.println("Test file was not found, check the file path and try again");
            return;
        }

        while(scanner.hasNextLine()) {
            String input = scanner.nextLine();
            String[] arguments = input.split(" ");

            switch(arguments[0]) {
                case "add":
                    testEquality(dictionary.addWord(arguments[1]), Boolean.parseBoolean(arguments[2]), input);
                    break;
                case "contains":
                    testEquality(dictionary.hasWord(arguments[1]), Boolean.parseBoolean(arguments[2]), input);
                    break;
                case "clear":
                    dictionary.clearDictionary();
                    break;
                case "nodeCount":
                    testEquality(dictionary.getNodeCount(), Integer.parseInt(arguments[1]), input);
                    break;
                case "delete":
                    testEquality(dictionary.deleteWord(arguments[1]), Boolean.parseBoolean(arguments[2]), input);
                    break;
                case "wordCount":
                    testEquality(dictionary.totalWordCount(), Integer.parseInt(arguments[1]), input);
                    break;
                default:
                    System.out.println(input);
            }


        }

    }

    public static <T> void testEquality(T a, T b, String inputLine) {
        if(!a.equals(b)) {
            System.out.println("Test Fail, " + inputLine + " should be " + a + " instead returned " + b);
        }
    }



    public static class tempDictionary implements DictionaryInterface {

        @Override
        public boolean addWord(String word) {
            return false;
        }

        @Override
        public boolean hasWord(String word) {
            return false;
        }

        @Override
        public int totalWordCount() {
            return 0;
        }

        @Override
        public int getNodeCount() {
            return 0;
        }

        @Override
        public boolean deleteWord(String word) {
            return false;
        }

        @Override
        public void clearDictionary() {

        }
    }

}
