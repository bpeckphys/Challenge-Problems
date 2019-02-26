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
public class TrieDictionary {
    boolean isWord;
    char c;
    int children = 0;
    
    TrieDictionary[] trie = new TrieDictionary[26];
    
    public TrieDictionary(char c, boolean isWord){
        this.c = c;
        this.isWord = isWord;
    }
    
    public boolean addWord(String word) {
        if (trie[word.charAt(0) - 'a'] == null) {
            children++;
            trie[word.charAt(0) - 'a'] = new TrieDictionary(word.charAt(0),false);
        }
        if (trie[word.charAt(0) - 'a'].c == word.charAt(0) && word.length() == 1) {
            if (trie[word.charAt(0) - 'a'].isWord) {
                return false;
            }
            trie[word.charAt(0) - 'a'].isWord = true;
            return true;
        }
        return trie[word.charAt(0) - 'a'].addWord(word.substring(1));
    }

    public boolean hasWord(String word) {
        if (trie[word.charAt(0) - 'a'] == null) {
            return false;
        }
        if (word.length() == 1) {
            if (trie[word.charAt(0) - 'a'].isWord) {
                return true;
            }
            return false;
        }
        return trie[word.charAt(0) - 'a'].hasWord(word.substring(1));
    }

    public int getNodeCount() {
        int count = 1;
        for (int i = 0; i < 26; i++) {
            if (trie[i] == null) {
                if (i == 25) {
                    return count;
                }
                continue;
            }
            if (trie[i] != null) {
                count = count + trie[i].getNodeCount();
            }
        }
        return count;
    }

    public boolean deleteWord(String word) {
        if (trie[word.charAt(0) - 'a'].c == word.charAt(0) && word.length() == 1) {
            if (trie[word.charAt(0) - 'a'].isWord) {
                if (trie[word.charAt(0) - 'a'].trie == null || trie[word.charAt(0) - 'a'].children == 0) {
                    children--;
                    trie[word.charAt(0) - 'a'] = null;
                    return true;
                }
                if (trie[word.charAt(0) - 'a'].trie != null) {
                    trie[word.charAt(0) - 'a'].isWord = false;
                    return true;
                }
            }
            if (trie[word.charAt(0) - 'a'].isWord) {
                return false;
            }
        }
        return trie[word.charAt(0) - 'a'].deleteWord(word.substring(1));
    }
}

