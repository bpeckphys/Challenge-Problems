/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triedictionary;

import java.util.HashMap;

/**
 *
 * @author Brenton
 */
public class TrieDictionary {
    boolean isWord;
    char c;
    int children = 0;
    
    // update trie to something like childNodes
    HashMap<Character, TrieDictionary> trie;
    
    public TrieDictionary() {
        this.trie = new HashMap<>();
        this.isWord = false;
    }
    
    public TrieDictionary(char c, boolean isWord){
        this.trie = new HashMap<>();
        this.isWord = isWord;
    }
    
    public boolean addWord(String word) {
        char firstChar = word.charAt(0);

        if (!trie.containsKey(firstChar)) {
                trie.put(firstChar, new TrieDictionary(firstChar,false));
        }

        if (word.length() == 1) {
                if (trie.get(firstChar).isWord) {
                        return false;
                }

                trie.get(firstChar).isWord = true;
                return true;
        }

        return trie.get(firstChar).addWord(word.substring(1));
    }

    public boolean hasWord(String word) {
            char firstChar = word.charAt(0);

            if (!trie.containsKey(firstChar)) {
                    return false;
            }

            if (word.length() == 1) {
                    return trie.get(firstChar).isWord;
            }

            return trie.get(firstChar).hasWord(word.substring(1));
    }

    public int getNodeCount() {
        int count = 1;
        for (Character c : trie.keySet()) {
            if (trie.isEmpty()) {
                return count;
            }
            if (!trie.isEmpty()) {
                count = count + trie.get(c).getNodeCount();
            }
        }
        return count;
    }

    public boolean deleteWord(String word) {
            char firstChar = word.charAt(0);

            // Base case
            if (!trie.containsKey(firstChar)) {
                    return false;
            }

            TrieDictionary subTree = trie.get(firstChar);

            if (word.length() == 1) {
                    if (!subTree.isWord) {
                            return false;
                    }

                    if (subTree.trie.isEmpty()) {
                            trie.remove(firstChar);
                            return true;
                    }

                    subTree.isWord = false;
                    return true;
            }

            // Recursive case
            if (subTree.deleteWord(word.substring(1)) && subTree.trie.isEmpty()) {
                    trie.remove(firstChar);
                    return true;
            }

            return false;
    }
}

