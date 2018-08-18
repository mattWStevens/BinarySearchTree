package bstdriver;

/**
 * Instantiates an empty BinarySearchTree object, inserts elements
 * into it, and tests its methods.
 * 
 * @author Matthew Stevens
 * @version 04/29/18
 */
public class BSTDRIVER 
{
    /**
     * Instantiates an empty BinarySearchTree object and fills it
     * with Trees and then tests its methods.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {   
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        
        // demonstrating that Tree is initially empty
        System.out.println("Initial Tree: ");
        System.out.println("------------------");
        tree.print(tree.root);
        
        System.out.println();
        System.out.println();
        System.out.println();
        
        /*
            Insertion Tests
        */
        // adding elements to Tree
        tree.insert(5);
        tree.insert(4);
        tree.insert(10);
        
        System.out.println("Tree After Adding Three Elements(Inorder): ");
        System.out.println("-------------------------------------------");
        tree.print(tree.root);
        
        // add the rest of the elements
        tree.insert(3);
        tree.insert(7);
        tree.insert(15);
       
        System.out.println();
        System.out.println();
        
        System.out.println("Tree Adding Rest of the Elements(Inorder):");
        System.out.println("---------------------------------------------");
        tree.print(tree.root);
        
        /*
            Height and numLeafs Tests
        */
        System.out.println();
        System.out.println();
        System.out.println("Height of Tree: " + tree.height(tree.root));
        tree.insert(18);
        
        System.out.println();
        System.out.println("Inorder Print After Insertion of 18: ");
        System.out.println("-------------------------------------");
        tree.print(tree.root);
        
        System.out.println();
        System.out.println("Height of Tree After Inserting 18: " + 
                           tree.height(tree.root));
       
        System.out.println();
        
        System.out.println("Number of Leafs: " + tree.numLeafs(tree.root));
        
        /*
            Traversal Tests
        */
        System.out.println();
        System.out.println();
        System.out.println("Preorder Traversal: ");
        System.out.println("---------------------");
        tree.preorder(tree.root);
        System.out.println();
        
        System.out.println("Inorder Traversal: ");
        System.out.println("---------------------");
        tree.print(tree.root);
        System.out.println();
        
        System.out.println("Postorder Traversal: ");
        System.out.println("----------------------");
        tree.postorder(tree.root);
        System.out.println();
        
        /*
            Searching Tests
        */
        System.out.println("Result of Search for 46: " + 
                           tree.search(tree.root, 46));
        System.out.println("Result of Search for 3: " + 
                           tree.search(tree.root, 3));
        
        // empty BST for purposes of testing search on empty Tree
        BinarySearchTree<Integer> tree2 = new BinarySearchTree<Integer>();
        
        System.out.println("Result of Search for 5 on Empty BST: " + 
                           tree2.search(tree2.root, 5));
        System.out.println();
        System.out.println();
        
        /*
            Deletion Tests with Original BST
        */
        System.out.println("Result of Searching for 5 (the root) in Original " 
                           + "BST: " + tree.search(tree.root, 5));
        tree.delete(5); // delete the root
        System.out.println("Result of Searching for 5 After Deletion: " + 
                           tree.search(tree.root, 5));
        System.out.println();
        System.out.println("Preorder Traversal After Deletion of Root: ");
        System.out.println("-------------------------------------------");
        tree.preorder(tree.root);
        System.out.println();
        System.out.println();
        
        
        System.out.println("Result of Searching for 10 Before Deletion: " + 
                           tree.search(tree.root, 10));
        tree.delete(10);    // delete a child with multiple children
        System.out.println("Result of Searching for 10 After Deletion: " + 
                           tree.search(tree.root, 10));
        System.out.println();
        System.out.println("Inorder Traversal After Deletion of 10: ");
        System.out.println("-------------------------------------------");
        tree.print(tree.root);
        
        // delete Tree without any children
        tree.delete(3);
        System.out.println();
        System.out.println("Inorder Traversal After Deletion of 3: ");
        System.out.println("-------------------------------------------");
        tree.print(tree.root);
        
        // delete Tree with only one child
        tree.delete(7);
        System.out.println();
        System.out.println("Preorder Traversal After Deletion of 7: ");
        System.out.println("-------------------------------------------");
        tree.preorder(tree.root);
        
        tree.delete(4);
        tree.delete(15);
        
        System.out.println();
        System.out.println();
        System.out.println("Inorder Traversal After Deletion of All Elements " +
                           "Except for One: ");
        System.out.println("-------------------------------------------------" +
                           "-----------------");
        tree.print(tree.root);
        
        // delete an element in BST with only a root
        tree.delete(18);
        System.out.println();
        System.out.println("Search for root in a BST That Only Contained Root" +
                           " After Deletion: " + tree.search(tree.root, 18));
    }
}