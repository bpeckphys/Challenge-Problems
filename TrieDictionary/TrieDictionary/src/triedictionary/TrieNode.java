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
public class TrieNode {
    boolean isWord;
    char trieChar;
    
    TrieNode[] child = new TrieNode[26];
    
    public TrieNode(char c, boolean isWord){
        this.isWord = isWord;
        this.trieChar = c;
    }
    
    public boolean addTrieNode(char c, boolean isWord){
        if(child[c - 'a'] == null){
            child[c - 'a'] = new TrieNode(c,isWord);
        }
        if(child[c - 'a'].trieChar == c){
            return false;
        }
        return true;
    }
    
    public boolean deleteTrieNode(char c){
        if(child[c - 'a'] == null){
            return false;
        }
        if(child[c - 'a'].trieChar == c){
            child[c - 'a'] = null;
        }
        return true;
    }
    
    public boolean findChar(char c){
        if(child[c - 'a'] == null){
            return false;
        }
        if(child[c - 'a'].trieChar == c){
            return true;
        }
        return false;
    }
}

class RootNode extends TrieNode{

    public RootNode() {
        super('*', false);
    }
    
}
