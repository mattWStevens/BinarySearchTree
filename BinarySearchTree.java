package bstdriver;

/**
 * Represents a BinarySearchTree.
 * 
 * @author Matthew Stevens
 * @version 04/29/30
 */
public class BinarySearchTree<E extends Comparable<E>>
{
    protected Tree<E> root;
    
    /**
     * Constructs an empty BinarySearchTree.
     */
    public BinarySearchTree()
    {
        root = null;
    }
    
    /**
     * Returns the root of the BinarySearchTree
     * 
     * @return the root
     */
    public Tree<E> getRoot()
    {
        return root;
    }
    
    /**
     * Sets the root of the BinarySearchTree to point to
     * the passed in Tree.
     * 
     * @param t the Tree to be assigned to the root
     */
    public void setRoot(Tree<E> t)
    {
        root = t;
    }
    
    /*
        Printing/Traversal Methods
    */
    /**
     * Prints the BinarySearchTree by Inorder traversal so that the
     * elements are printed in ascending order.
     * 
     * @param t the Tree to start traversing at
     */
    public void print(Tree<E> t)
    {
        if (t != null)
        {
            if (t.getLeft() != null)
            {
                print(t.getLeft());
            }
            
            System.out.println(t.getElement());
            
            if (t.getRight() != null)
            {
                print(t.getRight());
            }
        }
    }
    
    /**
     * Prints the BinarySearchTree by Preorder traversal.
     * 
     * @param t the Tree to begin traversing at
     */
    public void preorder(Tree<E> t)
    {
        if (t != null)
        {
            System.out.println(t.getElement());
            
            if (t.getLeft() != null)
            {
                preorder(t.getLeft());
            }
            
            if (t.getRight() != null)
            {
                preorder(t.getRight());
            }
        }
    }
    
    /**
     * Prints the BinarySearchTree by Postorder traversal.
     * 
     * @param t the Tree to begin traversing at
     */
    public void postorder(Tree<E> t)
    {
        if (t != null)
        {
            if (t.getLeft() != null)
            {
                postorder(t.getLeft());
            }
            
            if (t.getRight() != null)
            {
                postorder(t.getRight());
            }
            
            System.out.println(t.getElement());
        }
    }
    
    /**
     * Inserts the given element while maintaining
     * the proper order for a BinarySearchTree.
     * 
     * @param e the element to be inserted
     */
    public void insert(E e)
    {
        Tree<E> newest = new Tree<E>(e);
        
        if (root == null)
        {
            setRoot(newest);
        }
        
        else
        {
            add(root, e);
        }
    }
    
    /**
     * Deletes the given element from the BinarySearchTree while
     * maintaining proper order.
     * 
     * @param e the element to be deleted
     */
    public void delete(E e)
    {
        setRoot(remove(root, e));
    }
    
    /**
     * Returns true if a given element is in the BinarySearchTree
     * or false otherwise.
     * 
     * @param t the Tree to begin searching at.
     * @param e the element to search for
     * @return true if the element is in the BinarySearchTree, false
     * otherwise
     */
    public boolean search(Tree<E> t, E e)
    {   
        if (t == null)
        {
            return false;
        }
        
        if (e.compareTo(t.getElement()) == 0)
        {
            return true;
        }
        
        if (e.compareTo(t.getElement()) < 0)
        {
            return search(t.getLeft(), e);
        }
        
        else
        {
            return search(t.getRight(), e);
        }
    }
    
    /**
     * Returns the number of Trees in the BinarySearchTree that do not
     * have any children.
     * 
     * @param t the Tree to begin checking at
     * @return the number of leafs in the BinarySearchTree
     */
    public int numLeafs(Tree<E> t)
    {
        if (t == null)
        {
            return 0;
        }
        
        if (t.getLeft() == null && t.getRight() == null)
        {
            return 1;
        }
        
        else
        {
            return numLeafs(t.getLeft()) + numLeafs(t.getRight());
        }
    }
    
    /**
     * Returns the height of the given Tree.
     * 
     * @param t the Tree to begin counting at
     * @return the height of the given Tree
     */
    public int height(Tree<E> t)
    {
        if (t == null)
        {
            return -1;
        }
        
        else
        {
            int left = height(t.getLeft());
            int right = height(t.getRight());
            
            // returns the maximum height plus one
            return 1 + java.lang.Math.max(left, right);
        }
    }
    
    /*
        Private Helper Methods
    */
    /**
     * Adds the given element to the BinarySearchTree while
     * maintaining proper order.
     * 
     * @param t the Tree to begin looking to add at
     * @param e the element to be added
     */
    private void add(Tree<E> t, E e)
    {
        Tree<E> newest = new Tree<E>(e);
        
        /*
            check left subtree if given element is less than
            current Tree's element
        */
        if (e.compareTo(t.getElement()) < 0)
        {
            if (t.getLeft() == null)
            {
                t.setLeft(newest);
            }
            
            else
            {
                add(t.getLeft(), e);
            }
        }
        
        /*
            check right subtree if given element is greater than
            current Tree's element
        */
        else
        {
            if (e.compareTo(t.getElement()) > 0)
            {
                if (t.getRight() == null)
                {
                    t.setRight(newest);
                }
                
                else
                {
                    add(t.getRight(), e);
                }
            }
        }
    } 
    
    /**
     * Removes the given element from the BinarySearchTree while
     * maintaining proper order.
     * 
     * @param t the Tree to begin looking to remove at
     * @param e the element to be removed
     * @return the Tree to be replace the removed Tree or null if the
     * given Tree is empty
     */
    private Tree<E> remove(Tree<E> t, E e)
    {
        if (t == null)
        {
            return t;
        }
        
        // check left subtree if given element is less than current element
        if (e.compareTo(t.getElement()) < 0)
        {
            t.setLeft(remove(t.getLeft(), e));
            return t;
        }
        
        // check right subtree if given element is greater than current element
        if (e.compareTo(t.getElement()) > 0)
        {
            t.setRight(remove(t.getRight(), e));
            return t;
        }
        
        else
        {
            if (t.getLeft() == null && t.getRight() == null)
            {
                return null;
            }
            
            if (t.getRight() == null)
            {
                return t.getLeft();
            }
            
            if (t.getLeft() == null)
            {
                return t.getRight();
            }
            
            else
            {
                // find minimum element in right subtree
                Tree<E> min = getMin(t.getRight());
                t.setElement(min.getElement()); // assign minimum to current
                
                // call remove on that minimum element
                t.setRight(remove(t.getRight(), min.getElement()));
                
                return t;
            }
        }
    }
   
    /**
     * Returns the Tree containing the minimum element.
     * 
     * @param t the Tree to begin looking for the minimum element at
     * @return the Tree with the minimum element
     */
    private Tree<E> getMin(Tree<E> t)
    {
        if (t.getLeft() == null)
        {
            return t;
        }
        
        else
        {
            return getMin(t.getLeft());
        }
    }
}