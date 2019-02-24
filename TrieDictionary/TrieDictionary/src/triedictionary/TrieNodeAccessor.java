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
        
        TrieDictionary root = new TrieDictionary('*',false);
        
        System.out.println("Find 'bad': " + root.hasWord("bad"));
        System.out.println("Add 'bad': " + root.addWord("bad"));
        System.out.println("Find 'bad': " + root.hasWord("bad"));
        System.out.println("Add 'bad': " + root.addWord("bad"));
        System.out.println("Find 'ba': " + root.hasWord("ba"));
        System.out.println("Add 'boy': " + root.addWord("boy"));
        System.out.println("Add 'boys': " + root.addWord("boys"));
        System.out.println("Find 'bossy': " + root.hasWord("bossy"));
    }
    
}
