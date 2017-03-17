/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarySearchTree;

import javax.swing.JOptionPane;

/**
 * 
 * @author k00223361 Vincent Lee [DragonDream]
 */
public class Tree {
    private static String output = "";

    /*--- getter and setter for output String to be accessed by GUI ---*/
    public static String getOutput() { return output; }
    public static void setOutput(String output) { Tree.output = output; }

    
    private TreeNode root;

   // Construct an empty Tree of integers
    public Tree() { root = null; }
   
   // Insert a new node in the binary search tree. If the root node is null, create the    
   // root node here. Otherwise, call the insert method of class TreeNode.
    public synchronized void insertNode( int d ) {
        if ( root == null ){
            root = new TreeNode( d );
            //System.out.println(d + " I am Root");
        }
        else{
            root.insert( d );
            //System.out.println(d + " inserted onto root");
        }
        
    } //end insertNode
    
    /*================*/
    // Preorder Traversal - visit each node in the tree in preorder. VLR
    /*================*/
    // Pre:	The binary tree to which root points has been created
    // Post:	The function Visit has been performed on every entry in the binary tree in preorder sequence. 
    public synchronized void preorderTraversal( ) { preorderHelper( root ); }

    // Recursive method to perform preorder traversal
    private void preorderHelper( TreeNode node ) {
        if ( node == null )
            return;
        System.out.print( node.data + " " );
        preorderHelper( node.left );
        preorderHelper( node.right );
        
    }//end PREORDER traversal   
    
    /*================*/
    // Inorder Traversal - visit each node in the tree in inorder. LVR
    /*================*/
    // Pre:	The binary tree to which root points has been created
    // Post:	The function Visit has been performed on every entry in the binary tree in inorder sequence. 
    public synchronized void inorderTraversal() { inorderHelper( root ); }
   
   // Recursive method to perform inorder traversal
    private void inorderHelper( TreeNode node ) {
       if ( node == null )
          return;
       inorderHelper( node.left );
       System.out.print( node.data + " " );
       inorderHelper( node.right );
    } //end INORDER traversal
    
    
    /*================*/
    //InOrder traversal modified to output leaf/left/right/both branch status and node values
    /*----------------*/

    // resultsCheck - pass in this node in the InOrder Traversal instead of printing it, return it's position and it's left or right positions
    public synchronized void inorderCheck() {
        inorderCheckHelper( root ); 
        //printResult();
    }
    private void inorderCheckHelper( TreeNode node ) {
        if ( node == null ){
            return;
        } else{
            inorderCheckHelper( node.left );
            System.out.print( node.data + " " );
            output += resultsCheck(node); 
            output += "\n";
            //setOutput(output);
            inorderCheckHelper( node.right );
        }
        setOutput(output);
    } //end INORDER traversal Status Checking
    
    private String resultsCheck(TreeNode node){ 
        //1 Leaf
        if( node.left == null && node.right == null ){
            return node.data + " is a leaf";
        }

        //2 has Left
        else if( node.left != null && node.right == null ){
            return node.data + " has left node: " + node.left.data;
        }
        
        //3 has Right
        else if( node.left == null && node.right != null ){
            return node.data + " has right node: " + node.right.data;
        }
        
        //4 has both left and right
        else{
            return node.data + " : has left: " + node.left.data + " and right: " + node.right.data;
        }
    }// end resultsCheck
    

    public void printResult(){
        JOptionPane.showMessageDialog(null, output);
        //BuildTreeGUI.outputTextArea.setText(output); //private textArea can't be accessed, better to use getter/setter for output
    }
    
    /*----------------*/
    /*================*/
    
    /*================*/
    // Postorder Traversal - visit each node in the tree in postorder. LRV
    /*================*/
    // Pre:	The binary tree to which root points has been created
    // Post:	The function Visit has been performed on every entry in the binary tree in postorder sequence. 
    public synchronized void postorderTraversal() { 
        postorderHelper( root ); 
    }
   
    // Recursive method to perform postorder traversal
    private void postorderHelper( TreeNode node ) {  
        if ( node == null )
            return;
        postorderHelper( node.left );
        postorderHelper( node.right );
        System.out.print( node.data + " " );
        
    } //end POSTORDER traversal
    
} //end Tree
