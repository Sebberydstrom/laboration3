package lab3NP.ServerGUI;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.awt.Point;

public class Buffer {

	
    /** The buffer. */
    private Map<PairHash, Object> buff = Collections.synchronizedMap(new HashMap<PairHash, Object>());

        
    /**
     * Instantiates a new simple cache manager.
     */
    public Buffer() {
    
    }
   

    /**
     * Put. Stores the data and the key.
     *
     * @param cacheKey the cache key
     * @param value the value
     */
    public void put(PairHash Key, Object value) {
        buff.put(Key, value);      
        
    }

    /**
     * Returns the stored data.
     *
     * @param cacheKey 
     * @return object the stored xml data.
     */
    public Object get(PairHash Key) {
        return buff.get(Key);
    }
    
    /**
     * Gets the keyset.
     *
     * @return the keyset
     */
    public Set<PairHash> getKeyset() {
    	return buff.keySet();
    }
    
    /**
     * Check key. Returns true if this map
     * contains a mapping for the specified key.
     *
     * @param key
     * @return true, if successful
     */
    public boolean checkKey(PairHash key) {
    	return buff.containsKey(key);
    }

    /**
     * Clear. Removes the data attached to a certain key/town.
     *
     * @param cacheKey the cache key
     */
    public void clear(PairHash cacheKey) {
        buff.put(cacheKey, null);
    }

    /**
     * Clear. Removes all the data.
     */
    public void clear() {
        buff.clear();
    }
    
    /**
     * Size, returns the size of the cache.
     *
     * @return the int
     */
    public int size() {
    	return buff.size();
    }
}
