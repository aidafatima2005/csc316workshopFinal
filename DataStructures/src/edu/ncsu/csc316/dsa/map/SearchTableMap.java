package edu.ncsu.csc316.dsa.map;

import java.util.Comparator;
import java.util.Iterator;
import edu.ncsu.csc316.dsa.list.ArrayBasedList;

/**
 * A Search Table map is an ordered (meaning entries are stored in a sorted
 * order based on the keys of the entries) contiguous-memory representation of
 * the Map abstract data type. This array-based map delegates to an existing
 * array-based list. To improve efficiency of lookUps, the search table map
 * implements binary search to locate entries in O(logn) worst-case runtime.
 * Insertions and deletions have O(n) worst-case runtime.
 * 
 * @author Dr. King
 * @author Aida Fatima
 *
 * @param <K> the type of keys stored in the map
 * @param <V> the type of values that are associated with keys in the map
 */
public class SearchTableMap<K extends Comparable<K>, V> extends AbstractOrderedMap<K, V> {

	/** A private list to store key and value pairs. */
    private ArrayBasedList<Entry<K, V>> list;

    /**
     * Constructs a new SearchTableMap where keys of entries are compared based on
     * their natural ordering based on {@link Comparable#compareTo}
     */
    public SearchTableMap() {
        this(null);
    }
    
    /**
     * Constructs a new SearchTableMap where keys of entries are compared based on a
     * provided {@link Comparator}
     * 
     * @param compare a Comparator that defines comparisons rules for keys in the
     *                map
     */ 
    public SearchTableMap(Comparator<K> compare) {
        super(compare);
        list = new ArrayBasedList<Entry<K, V>>();
    }

    /**
     * Performs a lookup for a key in the map.
     *
     * @param key the key to look up
     * @return the index of the key if found, or a negative value 
     * 	indicating the insertion point if not found
     */
    private int lookUp(K key) {
    	return binarySearchHelper(0, list.size() - 1, key);
    }

    /**
     * Recursive helper method for binary search.
     *
     * @param min the lower bound of the search range
     * @param max the upper bound of the search range
     * @param key the key to search for
     * @return the index of the key if found, or a negative value 
     * 	indicating the insertion point if not found
     */
    private int binarySearchHelper(int min, int max, K key) {
    	if(min > max) {
    		return -1 * (min + 1);
    	}
    	int mid = (max + min) / 2;
    	if(key.equals(list.get(mid).getKey())) {
    		return mid;
    	} else if(compare(list.get(mid).getKey(), key) > 0) {
    		return binarySearchHelper(min, mid - 1, key);
    	} else {
    		return binarySearchHelper(mid + 1, max, key);
    	}
    }

    /**
     * Returns the size of the map
     * 
     * @return the size of the map
     */
    @Override
    public int size() {
        return list.size();
    }

    /**
     * Returns the value to which the specified key is mapped,
     * or null if this map contains no mapping for the key.
     *
     * @param key the key whose associated value is to be returned
     * @return the value to which the specified key is mapped, or 
     * 	null if this map contains no mapping for the key
     */
    @Override
    public V get(K key) {
        int index = lookUp(key);
        if (index >= 0) {
        	return list.get(index).getValue();
        }
       
        return null;
    }

    /**
     * Returns a set view of the mappings contained in this map.
     *
     * @return a set view of the mappings contained in this map
     */
    @Override
    public Iterable<Entry<K, V>> entrySet() {
        EntryCollection set = new EntryCollection();
        for (Entry<K, V> entry : list) {
            set.add(entry);
        }
        return set;
    }

    /**
     * Associates the specified value with the specified key in this map.
     * If the map previously contained a mapping for the key, the old
     * value is replaced.
     *
     * @param key key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     * @return the previous value associated with key, or null if there 
     * 	was no mapping for key
     */
    @Override
    public V put(K key, V value) {
        int index = lookUp(key);
        if(index >= 0) {
        	V oldValue = list.get(index).getValue();
        	list.set(index, new MapEntry<K, V>(key, value));
        	return oldValue;
        } else {
        	list.add((index + 1) * -1, new MapEntry<K, V>(key, value));
        	return null;
        }
        
    }

    /**
     * Removes the mapping for a key from this map if it is present.
     *
     * @param key key whose mapping is to be removed from the map
     * @return the previous value associated with key, or null if there 
     * 	was no mapping for key
     */
    @Override
    public V remove(K key) {
        int index = lookUp(key);
        if(index >= 0) {
        	Entry<K, V> removed = list.remove(index);
        	return removed.getValue();
        }
        
        return null;
        
    }
    
    /**
     * Returns a string representation of this SearchTableMap.
     *
     * @return a string representation of the map
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("SearchTableMap[");
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
