/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarySearchTree;

/**
 *
 * @author DragonDream
 */

public class TreeNode {
    String output = "";
    
    // package access members
    TreeNode left;   // left node
    int data;        // data item  - data will differ depending on the application.
    TreeNode right;  // right node

    
    // Constructor: initialize data to d and make this a leaf node
    public TreeNode( int d ) { 
        data = d;              
        left = right = null;  // this node has no children
        //System.out.println(d + " inserted as TreeNode's leaf node");

    }//end TreeNode()

    
    // Insert a TreeNode into a Tree that contains nodes.( Ignore duplicate values).
    public synchronized void insert( int d ) {
        if ( d < data ) {
            	if ( left == null )
                {
               		left = new TreeNode( d );
                        //System.out.println(d + " inserted as TreeNode's NEW Left node"); 
                }
                else{
                    left.insert( d );   
                    //System.out.println(d + " inserted as TreeNode's left node");    
                }                        
        }
        else if ( d > data ) {
            if ( right == null ) {
                right = new TreeNode( d );
                //System.out.println(d + " inserted as TreeNode's NEW Right node"); 
            }
            else {
                right.insert( d );
                //System.out.println(d + " inserted as TreeNode's right node");  
            }
        }
      } //end insert TreeNode
   
    

    
    
    

 
}// end TreeNode class
