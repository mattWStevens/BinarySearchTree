package bstdriver;

/**
 * Represents a Tree which can have left or right children and contains an
 * element.
 * 
 * @author Matthew Stevens
 * @version 04/29/18
 */
public class Tree<E extends Comparable<E>> implements Comparable<E> 
{
    protected E element;
    protected Tree<E> left, right;
    
    /**
     * Constructs a Tree object without any children references and sets
     * its element to the passed in parameter.
     * 
     * @param element the element to be assigned to the Tree's element instance
     * variable
     */
    public Tree(E element)
    {
        left = null;
        right = null;
        this.element = element;
    }
    
    /*
        Accessor Methods
    */
    /**
     * Returns the Tree's element.
     * 
     * @return the Tree's element
     */
    
    public E getElement()
    {
        return element;
    }
    
    /**
     * Returns the left child of the Tree.
     * 
     * @return the left child of the Tree
     */
    public Tree<E> getLeft()
    {
        return left;
    }
    
    /**
     * Returns the right child of the Tree.
     * 
     * @return the right child of the Tree
     */
    public Tree<E> getRight()
    {
        return right;
    }
    
    /*
        Mutator Methods
    */
    /**
     * Sets the Tree's element to the passed in parameter.
     * 
     * @param e the element to assign to the Tree's element instance variable
     */
    public void setElement(E e)
    {
        element = e;
    }
    
    /**
     * Sets the left child of the Tree to point to the passed in parameter.
     * 
     * @param t the Tree to become the left child of the current Tree
     */
    public void setLeft(Tree t)
    {
        left = t;
    }
    
    /**
     * Sets the right child of the Tree to point to the passed in parameter.
     * 
     * @param t the Tree to become the right child of the current Tree
     */
    
    public void setRight(Tree t)
    {
        right = t;
    }
    
    /**
     * Returns a negative number if the current element is less than the
     * passed in element, a positive number if the current element is greater
     * than the passed in element or zero if they are equal.
     * 
     * @param other the element to be compared to
     * @return a negative number if the current element is less than the
     * passed in element, a positive number if the current element is greater
     * than the passed in element or zero if they are equal
     */
    @Override
    public int compareTo(E other)
    {
       return element.compareTo(other);
    }
}