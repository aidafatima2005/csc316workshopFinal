package edu.ncsu.csc316.dsa.map;

import java.util.Comparator;
import java.util.Random;

/**
 * A SkipListMap is an ordered (meaning entries are stored in a sorted order
 * based on the keys of the entries) linked-memory representation of the Map
 * abstract data type. This link-based map maintains several levels of linked
 * lists to help approximate the performance of binary search using a
 * linked-memory structure. SkipListMap ensures a O(logn) expected/average
 * runtime for lookUps, insertions, and deletions.
 *
 * The SkipListMap class is based on algorithms developed for
 * use with the textbook:
 *
 * Data Structures and Algorithms in Java, Sixth Edition Michael T. Goodrich,
 * Roberto Tamassia, and Michael H. Goldwasser John Wiley and Sons, 2014
 *
 * @author Dr. King
 * @author Aida Fatima 
 *
 * @param <K> the type of keys stored in the map
 * @param <V> the type of values that are associated with keys in the map
 */
public class SkipListMap<K extends Comparable<K>, V> extends AbstractOrderedMap<K, V> {

    /**
     * Coin tosses are used when inserting entries into the data structure to ensure
     * 50/50 probability that an entry will be added to the current level of the
     * skip list structure
     */
    private Random coinToss;

    /**
     * Start references the topmost, leftmost corner of the skip list. In other
     * words, start references the sentinel front node at the top level of the skip
     * list
     */
    private SkipListNode<K, V> start;

    /**
     * The number of entries stored in the map
     */
    private int size;

    /**
     * The number of levels of the skip list data structure
     */
    private int height;

    /**
     * Constructs a new SkipListMap where keys of entries are compared based on
     * their natural ordering based on {@link Comparable#compareTo}
     */
    public SkipListMap() {
        this(null);
    }

    /**
     * Constructs a new SkipListMap where keys of entries are compared based on a
     * provided {@link Comparator}
     *
     * @param compare a Comparator that defines comparisons rules for keys in the
     *                map
     */
    public SkipListMap(Comparator<K> compare) {
        super(compare);
        coinToss = new Random();
        // Create a dummy head node for the left "-INFINITY" sentinel tower
        start = new SkipListNode<K, V>(null);
        // Create a dummy tail node for the right "+INFINITY" sentinel tower
        start.setNext(new SkipListNode<K, V>(null));
        // Set the +INFINITY tower's previous to be the "start" node
        start.getNext().setPrevious(start);
        size = 0;
        height = 0;
    }

    /**
     * Helper method to determine if an entry is one of the sentinel
     * -INFINITY or +INFINITY nodes (containing a null key)
     * 
     * @param node to check if it is Sentinel node
     * @return the entry at node
     */
    private boolean isSentinel(SkipListNode<K, V> node) {
        return node.getEntry() == null;
    }

    /**
     * Searches for the node containing the largest key less than or equal to the specified key.
     *
     * @param key the key to search for
     * @return the node with the largest key less than or equal to the search key
     */
    private SkipListNode<K, V> lookUp(K key) {
        SkipListNode<K, V> current = start;
        while (current.below != null) {
            current = current.below;
            while (!isSentinel(current.next) && compare(key, current.next.getEntry().getKey()) >= 0) {
                current = current.next;
            }
        }
        
        return current;
    }

    /**
     * Retrieves the value associated with the specified key.
     *
     * @param key the key whose associated value is to be returned
     * @return the value associated with the key, or null if the key is not found
     */
    @Override
    public V get(K key) {
        SkipListNode<K, V> temp = lookUp(key);
        if(temp != null && temp.getEntry() != null && compare(temp.getEntry().getKey(), key) == 0) {
        	return temp.getEntry().getValue();
        }
        return null;
    }

    /**
     * Inserts a new node with the given entry after the specified previous node and above the specified below node.
     *
     * @param prev  the node after which the new node will be inserted
     * @param down  the node below the new node
     * @param entry the entry to be inserted
     * @return the newly inserted node
     */
    private SkipListNode<K, V> insertAfterAbove(SkipListNode<K, V> prev, SkipListNode<K, V> down, Entry<K, V> entry) {
    	
    	// Create a new skip list node
    	SkipListNode<K, V> newNode = new SkipListNode<K, V>(entry);
    	
    	// Set the below and previous entries
    	newNode.setBelow(down);
    	newNode.setPrevious(prev);
    	
    	// Update the next and previous entry pointers
    	if(prev != null) {
    		newNode.setNext(prev.getNext());
    		newNode.getPrevious().setNext(newNode);
    	}
    	
    	if(newNode.getNext() != null) {
    		newNode.getNext().setPrevious(newNode);
    	}
    	
    	// Update the below entry pointers
    	if(down != null) {
    		down.setAbove(newNode);
    	}
    	
    	return newNode;
    }

    /**
     * Associates the specified value with the specified key in this map.
     * If the map previously contained a mapping for the key, the old value is replaced.
     *
     * @param key   the key with which the specified value is to be associated
     * @param value the value to be associated with the specified key
     * @return the previous value associated with the key, or null if the key was not previously in the map
     */
    @Override
    public V put(K key, V value) {
        SkipListNode<K, V> p = lookUp(key);
        
        if(p != null && p.getEntry() != null && p.getEntry().getKey().equals(key)) {
            V originalValue = p.getEntry().getValue();
            while(p != null) {
                ((MapEntry<K, V>) p.getEntry()).setValue(value);
                p = p.getAbove();
            }
            
            return originalValue;
        }
        //Use q to represent the new entry as we move to the level "above" after inserting into the bottom-most list
        SkipListNode<K, V> q = null;
        //Keep track of the current level we are at	
        int currentLevel = -1;
        do {
            currentLevel = currentLevel + 1;
            //Check if we need to add a new level to the top of the skip list
            if(currentLevel >= height) {
                // Increase the height of the skip list
                height = height + 1;
                // Create a pointer to the current "tail" of the topmost list
                SkipListNode<K, V> tail = start.getNext();
                // Insert a new sentinel start node above
                start = insertAfterAbove(null, start, null);
                // Insert a new sentinel tail node above
                insertAfterAbove(start, tail, null);
            }
            // Insert the new entry into current level of the list
            q = insertAfterAbove(p, q, new MapEntry<K, V>(key, value));
            //Backtrack to the entry immediately before the insertion location in the level "above"
            while(p.getAbove() == null) {
                p = p.getPrevious();
            }
            p = p.getAbove();
        } while (coinToss.nextBoolean());

        size++;
        return null;
        	
    }

    /**
     * Removes the mapping for the specified key from this map if it is present.
     *
     * @param key the key whose mapping is to be removed
     * @return the previous value associated with the key, or null if the key was not in the map
     */
    @Override
    public V remove(K key) {
        SkipListNode<K, V> temp = lookUp(key);

        // If the key does not exist, return null
        if (temp == null || temp.getEntry() == null || !temp.getEntry().getKey().equals(key)) {
            return null;
        }

        // Save the value to return
        V removedValue = temp.getEntry().getValue();

        // Remove the node from all levels where it appears
        while (temp != null) {
            // Get the previous and next nodes at the current level
            SkipListNode<K, V> prevNode = temp.getPrevious();
            SkipListNode<K, V> nextNode = temp.getNext();

            // Update the pointers to bypass the node to remove
            if (prevNode != null) {
                prevNode.setNext(nextNode);
            }
            if (nextNode != null) {
                nextNode.setPrevious(prevNode);
            }

            // Move to the level above
            temp = temp.getAbove();
        }

        // Reduce the height of the skip list if necessary
        while (height > 0 && start.getNext().getEntry() == null) {
            // Remove the topmost level
            start = start.below;
            start.setAbove(null);
            height--;
        }

        size--; // Decrement the size of the skip list
        return removedValue; // Return the removed value
    }

    /**
     * Returns the number of key-value mappings in this map.
     *
     * @return the number of key-value mappings in this map
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns an iterable collection of all entries in the map.
     *
     * @return an iterable collection of entries
     */
    @Override
    public Iterable<Entry<K, V>> entrySet() {
        EntryCollection set = new EntryCollection();
        SkipListNode<K, V> current = start;
        while (current.below != null) {
            current = current.below;
        }
        current = current.next;
        while (!isSentinel(current)) {
            set.add(current.getEntry());
            current = current.next;
        }
        return set;
    }

    /**
     * Returns a string representation of the skip list, showing the keys in order.
     *
     * @return a string representation of the skip list
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("SkipListMap[");
        SkipListNode<K, V> cursor = start;
        while (cursor.below != null) {
            cursor = cursor.below;
        }
        cursor = cursor.next;
        while (cursor != null && !isSentinel(cursor) && cursor.getEntry().getKey() != null) {
            sb.append(cursor.getEntry().getKey());
            if (!isSentinel(cursor.next)) {
                sb.append(", ");
            }
            cursor = cursor.next;
        }
        sb.append("]");

        return sb.toString();
    }

    /**
     * Returns a detailed string representation of the skip list, including all levels and sentinel nodes.
     * This method is primarily useful for debugging and testing purposes.
     *
     * @return a detailed string representation of the skip list
     */
    public String toFullString() {
        StringBuilder sb = new StringBuilder("SkipListMap[\n");
        SkipListNode<K, V> cursor = start;
        SkipListNode<K, V> firstInList = start;
        while (cursor != null) {
            firstInList = cursor;
            sb.append("-INF -> ");
            cursor = cursor.next;
            while (cursor != null && !isSentinel(cursor)) {
                sb.append(cursor.getEntry().getKey() + " -> ");
                cursor = cursor.next;
            }
            sb.append("+INF\n");
            cursor = firstInList.below;
        }
        sb.append("]");
        return sb.toString();
    }
    
    /**
     * Represents a node in the skip list. Each node contains an entry (key-value pair)
     * and maintains references to nodes above, below, previous, and next in the skip list.
     *
     * @param <K> the type of the key
     * @param <V> the type of the value
     */
    private static class SkipListNode<K, V> {

    	/** The entry stored in this node. */
        private Entry<K, V> entry;
        
        /** Reference to the node above this node in the skip list. */
        private SkipListNode<K, V> above;
        
        /** Reference to the node below this node in the skip list. */
        private SkipListNode<K, V> below;
        
        /** Reference to the previous node in the same level of the skip list. */
        private SkipListNode<K, V> prev;
        
        /** Reference to the next node in the same level of the skip list. */
        private SkipListNode<K, V> next;

        /**
         * Constructor for SkipListNode
         * @param entry the entry to store in this node
         */
        public SkipListNode(Entry<K, V> entry) {
            setEntry(entry);
            setAbove(null);
            setBelow(null);
            setPrevious(null);
            setNext(null);
        }

        /**
         * Returns the node above this node in the skip list.
         *
         * @return the node above this node, or null if this node is at the top level
         */
        public SkipListNode<K, V> getAbove() {
            return above;
        }

        /**
         * Returns the entry (key-value pair) stored in this node.
         *
         * @return the entry stored in this node
         */
        public Entry<K, V> getEntry() {
            return entry;
        }

        /**
         * Returns the next node in the same level of the skip list.
         *
         * @return the next node, or null if this node is the last in its level
         */
        public SkipListNode<K, V> getNext() {
            return next;
        }

        /**
         * Returns the previous node in the same level of the skip list.
         *
         * @return the previous node, or null if this node is the first in its level
         */
        public SkipListNode<K, V> getPrevious() {
            return prev;
        }

        /**
         * Sets the node above this node in the skip list.
         *
         * @param up the node to set as the node above this node
         */
        public void setAbove(SkipListNode<K, V> up) {
            this.above = up;
        }

        /**
         * Sets the node below this node in the skip list.
         *
         * @param down the node to set as the node below this node
         */
        public void setBelow(SkipListNode<K, V> down) {
            this.below = down;
        }

        /**
         * Sets the entry (key-value pair) stored in this node.
         *
         * @param entry the entry to store in this node
         */
        public void setEntry(Entry<K, V> entry) {
            this.entry = entry;
        }

        /**
         * Sets the next node in the same level of the skip list.
         *
         * @param next the node to set as the next node
         */
        public void setNext(SkipListNode<K, V> next) {
            this.next = next;
        }

        /**
         * Sets the previous node in the same level of the skip list.
         *
         * @param prev the node to set as the previous node
         */
        public void setPrevious(SkipListNode<K, V> prev) {
            this.prev = prev;
        }
    }
    
}
