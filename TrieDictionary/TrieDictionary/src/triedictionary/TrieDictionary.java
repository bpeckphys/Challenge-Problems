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
    
    public TrieDictionary(char c, boolean isWord){
        this.trie = new HashMap<>();
        this.c = c;
        this.isWord = isWord;
    }
    
    public boolean addWord(String word) {
        if (!trie.containsKey(word.charAt(0))) {
            trie.put(word.charAt(0), new TrieDictionary(word.charAt(0),false));
        }
        if (word.length() == 1) {
            if (trie.get(word.charAt(0)).isWord) {
                return false;
            }
            trie.get(word.charAt(0)).isWord = true;
            return true;
        }
        return trie.get(word.charAt(0)).addWord(word.substring(1));
    }

    public boolean hasWord(String word) {
        if (!trie.containsKey(word.charAt(0))) {
            return false;
        }
        if (word.length() == 1) {
            if (trie.get(word.charAt(0)).isWord) {
                return true;
            }
            return false;
        }
        return trie.get(word.charAt(0)).hasWord(word.substring(1));
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
        if (trie.get(word.charAt(0)).c == word.charAt(0)) {
            if (trie.get(word.charAt(0)).isWord) {
                if (trie.get(word.charAt(0)).trie.isEmpty() || trie.get(word.charAt(0)).children == 0) {
                    children--;
                    trie.remove(word.charAt(0));
                    return true;
                }
                if (trie.get(word.charAt(0)).trie != null) {
                    trie.get(word.charAt(0)).isWord = false;
                    return true;
                }
            }
            if (trie.get(word.charAt(0)).isWord) {
                return false;
            }
        }
        return trie.get(word.charAt(0)).deleteWord(word.substring(1));
    }
}

