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
    boolean isWord;
    char c;
    int children = 0;
    
    TrieDictionary[] trie = new TrieDictionary[26];
    
    public TrieDictionary(char c, boolean isWord){
        this.c = c;
        this.isWord = isWord;
    }
    
    @Override
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
        if (word.length() == 1) {
            trie[word.charAt(0) - 'a'].isWord = true;
            return true;
        }
        return trie[word.charAt(0) - 'a'].addWord(word.substring(1));
    }

    @Override
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
        if (!hasWord(word)) {
            return false;
        }
        if (trie[word.charAt(0) - 'a'].c == word.charAt(0) && word.length() == 1) {
            if (trie[word.charAt(0) - 'a'].isWord) {
                if (trie[word.charAt(0) - 'a'].trie == null || trie[word.charAt(0) - 'a'].children == 0) {
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

    @Override
    public void clearDictionary() {

    }
}

