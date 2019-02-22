package TrieDictionary;

public interface DictionaryInterface {

    //Adds a word to the dictionary.  Returns true if the word was added, false if the word already existed in the dictionary
    boolean addWord(String word);

    //Returns true if the word exists in the dictionary, false otherwise
    boolean hasWord(String word);

    //Returns the number of unique words in your dictionary
    int totalWordCount();

    //Gets the total Nodes that are used to make up your dictionary
    int getNodeCount();

    //Deletes a word from the dictionary.  Returns true if the word was deleted, false if the word did not exist
    boolean deleteWord(String word);

    //completely starts over, clearing the dictionary
    void clearDictionary();


}
