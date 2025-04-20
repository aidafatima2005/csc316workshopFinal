package edu.ncsu.csc316.dsa.tree;

import edu.ncsu.csc316.dsa.Position;

/**
 * A skeletal implementation of the Binary Tree abstract data type. This class
 * provides implementation for common methods that can be implemented the same
 * no matter what specific type of concrete data structure is used to implement
 * the binary tree abstract data type.
 * 
 * @author Dr. King
 * @author Aida Fatima
 *
 * @param <E> the type of elements stored in the binary tree
 */
public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E> {
    
    @Override
    public Iterable<Position<E>> inOrder() {
        PositionCollection traversal = new PositionCollection();
        if (!isEmpty()) {
            inOrderHelper(root(), traversal);
        }
        return traversal;
    }

    private void inOrderHelper(Position<E> p, PositionCollection traversal) {
        // Traverse the left subtree if it exists
        if (left(p) != null) {
            inOrderHelper(left(p), traversal);
        }

        // Visit the current node
        if(p.getElement() != null) { 
        	traversal.add(p);
        }

        // Traverse the right subtree if it exists
        if (right(p) != null) {
            inOrderHelper(right(p), traversal);
        }
    }
    
    /**
     * Returns the number of children of position p
     * 
     * @return the number of children of position p
     */
    @Override
    public int numChildren(Position<E> p) {
    	int count = 0;
    	
    	if(right(p) != null) {
    		count++;
    	}
    	
    	if(left(p) != null) {
    		count++;
    	}
    	
    	return count;
    }
    
    /**
     * Returns the position of the sibling of p 
     * 	or null if p has no sibling
     */
    @Override
    public Position<E> sibling(Position<E> p) {
    	Position<E> parent = parent(p);
    	
    	if (parent == null) {
    		return null;
    	}
    	
    	if (p == left(parent)) {
    		return right(parent);
    	} else {
    		return left(parent);
    	}
    }
    
    @Override
    public Iterable<Position<E>> children(Position<E> p) {
        AbstractTreeNode<E> node = validate(p);
        PositionCollection childrenCollection = new PositionCollection();
        if (left(node) != null) {
            childrenCollection.add(left(node));
        }
        if (right(node) != null) {
            childrenCollection.add(right(node));
        }
        return childrenCollection;
    }
}
