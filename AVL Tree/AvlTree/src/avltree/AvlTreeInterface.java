/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avltree;

/**
 *
 * @author bpeck
 */
public interface AvlTreeInterface {
    
    // Add a node
    boolean add(int number);
    
    // Delete a node
    boolean remove(int number);
    
    // Contains a node
    boolean containsNode(int number);
    
    // Clear all nodes
    void clearTree();
    
    // Get root node; if no root node return null
    AvlNodeInterface getRoot();
    
}
