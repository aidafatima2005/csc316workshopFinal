package edu.ncsu.csc316.dsa.map;

import java.util.Iterator;
import edu.ncsu.csc316.dsa.Position;
import edu.ncsu.csc316.dsa.list.positional.PositionalLinkedList;
import edu.ncsu.csc316.dsa.list.positional.PositionalList;

/**
 * An unordered link-based map is an unordered (meaning keys are not used to
 * order entries) linked-memory representation of the Map abstract data type.
 * This link-based map delegates to an existing doubly-linked positional list.
 * To help self-organizing entries to improve efficiency of lookUps, the
 * unordered link-based map implements the move-to-front heuristic: each time an
 * entry is accessed, it is shifted to the front of the internal list.
 * 
 * @author Dr. King
 * @author Aida Fatima 
 *
 * @param <K> the type of keys stored in the map
 * @param <V> the type of values that are associated with keys in the map
 */
public class UnorderedLinkedMap<K, V> extends AbstractMap<K, V> {

	/** a PostionalList to store entries */
    private PositionalList<Entry<K, V>> list;
    
    /**
     * Constructs an empty UnorderedLinkedMap.
     */
    public UnorderedLinkedMap() {
        this.list = new PositionalLinkedList<Entry<K, V>>();
    }
    
    /**
     * Looks up the position of an entry with the given key.
     *
     * @param key the key to search for
     * @return the position of the entry if found, otherwise null
     */
    private Position<Entry<K, V>> lookUp(K key) {
        for (Position<Entry<K, V>> p : list.positions()) {
            if (p.getElement().getKey().equals(key)) {
                return p;
            }
        }
        return null; // Key not found
    }

    /**
     * Retrieves the value associated with the given key.
     * Moves the accessed entry to the front for optimization.
     *
     * @param key the key whose associated value is to be returned
     * @return the value associated with the specified key, or null if the key is not found
     */
    @Override
    public V get(K key) {
        Position<Entry<K, V>> p = lookUp(key);
        
        if (p != null) {
        	V oldValue = p.getElement().getValue();
        	moveToFront(p); // Move the updated entry to the front
        	return oldValue;
        }
        
        return null;
    }
    
    /**
     * Moves the specified entry to the front of the list to optimize access time.
     *
     * @param position the position of the entry to move
     */
    private void moveToFront(Position<Entry<K, V>> position) {
    	if (position != null && position != list.first()) {
            Entry<K, V> entry = list.remove(position);
            list.addFirst(entry);
        }
    }

    /**
     * Inserts a key-value pair into the map.
     * If the key already exists, its value is updated, and the entry is moved to the front.
     *
     * @param key the key of the entry to insert
     * @param value the value to associate with the key
     * @return the previous value associated with the key, or null if the key was not present
     */
    @Override
    public V put(K key, V value) {
        Position<Entry<K, V>> p = lookUp(key);
        if(p != null) {
            // Key already exists, update the value
            V oldValue = p.getElement().getValue();
            list.set(p, new AbstractMap.MapEntry<K, V>(key, value)); // Update the entry
            //p.getElement().(MapEntry)setValue(value);
            moveToFront(p); // Move the updated entry to the front
            return oldValue;
        } else {
            // Key does not exist, add a new entry
            list.addFirst(new AbstractMap.MapEntry<K, V>(key, value));
            return null;
        }
    }
    
    /**
     * Removes the entry associated with the specified key from the map.
     *
     * @param key the key whose mapping is to be removed
     * @return the previous value associated with the key, or null if the key was not found
     */
    @Override
    public V remove(K key) {
       Position<Entry<K, V>> p = lookUp(key);
       
       if (p != null) {
    	   V value = p.getElement().getValue();
           list.remove(p); // Remove the entry
           return value;
       }
       
       return null;
    }
    
    /**
     * Returns the number of key-value mappings in this map.
     *
     * @return the number of entries in the map
     */
    @Override
    public int size() {
        return list.size();
    }
    
    /**
     * Returns a collection view of the mappings contained in this map.
     *
     * @return an iterable collection of key-value entries
     */
    @Override
    public Iterable<Entry<K, V>> entrySet() {
        EntryCollection collection = new EntryCollection();
        for(Entry<K, V> entry : list) {
            collection.add(entry);
        }
        return collection;
    }
    
    /**
     * Returns a string representation of the map, showing the keys in order.
     *
     * @return a string representation of this map
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("UnorderedLinkedMap[");
        Iterator<Entry<K, V>> it = list.iterator();
        while(it.hasNext()) {
            sb.append(it.next().getKey());
            if(it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
