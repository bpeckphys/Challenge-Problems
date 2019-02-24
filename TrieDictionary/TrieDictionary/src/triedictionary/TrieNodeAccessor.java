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
public class TrieNodeAccessor {
    
    public static void main(String[] args) {
        
        TrieNode root = new RootNode();
        System.out.println("find a: " + root.findChar('a'));
        
        root.addTrieNode('a', false);
        System.out.println("find a: " + root.findChar('a'));
        
        TrieDictionary test = new TrieDictionary();
        test.addWord("aam");
        System.out.println("Word 'aam' exists: " + test.hasWord("aam"));
        for (int i = 0; i < test.root.child.length; i++) {
            if (test.root.child[i] != null) {
                System.out.print(test.root.child[i].trieChar);
            }else{
                System.out.print(" null ");
            }
        }
        
        
    }
    
}
