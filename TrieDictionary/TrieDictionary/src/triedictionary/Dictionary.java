/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triedictionary;

/**
 *
 * @author bpeck
 */
public class Dictionary implements DictionaryInterface {
    
    TrieDictionary root;
    int numWords = 0;
    
    public Dictionary(){
        root = new TrieDictionary('*',false);
    }
    
    @Override
    public boolean addWord(String word) {
        if (root.addWord(word)) {
            numWords++;
            return true;
        }
        return false;
    }
    
    @Override
    public boolean hasWord(String word) {
        return root.hasWord(word);
    }
    
    @Override
    public int totalWordCount() {
        return numWords;
    }

    @Override
    public int getNodeCount() {
        return 0;
    }

    @Override
    public boolean deleteWord(String word) {
        if (hasWord(word)) {
            if (root.deleteWord(word)) {
                numWords--;
                return true;
            }
            return false;
        }
        return false;
    }
    
    @Override
    public void clearDictionary() {
        numWords = 0;
        root = new TrieDictionary('*',false);
    }
}
