/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triedictionary;

/**
 *
 * @author Brenton
 */
public class TrieDictionary implements DictionaryInterface {
    TrieNode root = new RootNode();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    @Override
    public boolean addWord(String word) {
        if (!hasWord(word)) {
            for (int i = 0; i < word.length(); i++) {
                if(!root.findChar(word.charAt(i))){
                    if(i == word.length() - 1){
                        root.addTrieNode(word.charAt(i), true);
                        System.out.println("Adding " + word.charAt(i));
                        System.out.println("Word was added");
                        return true;
                    }else{
                        root.addTrieNode(word.charAt(i), false);
                        System.out.println("Adding " + word.charAt(i));
                    }
                }
                root = root.child[word.charAt(i) - 'a'];
            }
        }
        System.out.println("Word already exists");
        return false;
    }

    @Override
    public boolean hasWord(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (!root.findChar(word.charAt(i))) {
                return false;
            }
            root = root.child[word.charAt(i) - 'a'];
            if (root.isWord && i == word.length() - 1) {
                return true;
            }
        }
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
