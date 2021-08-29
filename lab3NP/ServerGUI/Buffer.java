/*
 * 
 */
package ServerGUI;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/**
 * The Class Buffer.
 */
public class Buffer {

	
    /** The buffer. */
    private Map<Integer, Object> buff = Collections.synchronizedMap(new HashMap<Integer, Object>());
    private int lastKey;
    private Object lastObject;
        
    /**
     * Instantiates a new simple cache manager.
     */
    public Buffer() {
 
    }
   

    /**
     * Put. Stores the data and the key.
     *
     * @param Key the key
     * @param value the value
     */
    public void put(Integer Key, Object value) {
        buff.put(Key, value);  
        lastKey = Key;
        lastObject = value;
        
    }
    
    /**
     * 
     * @param Key
     * @return value the XyColor Object.
     */
    public Object getLastObject() {
    	return lastObject;
    	
    	//return null;
    }
    

    /**
     * Returns the stored data.
     *
     * @param Key the key
     * @return object the stored data.
     */
    public Object get(Integer Key) {
        return buff.get(Key);
    }
    
    /**
     * Gets the keyset.
     *
     * @return the keyset
     */
    public Set<Integer> getKeyset() {
    	return buff.keySet();
    }
    
    /**
     * Check key. Returns true if this map
     * contains a mapping for the specified key.
     *
     * @param key the key
     * @return true, if successful
     */
    public boolean checkKey(Integer key) {
    	return buff.containsKey(key);

    	//return buff.containsKey(key);
    }

    /**
     * Clear. Removes the data attached to a certain key/town.
     *
     * @param cacheKey the cache key
     */
    public void clear(Integer cacheKey) {
        buff.put(cacheKey, null);
    }

    /**
     * Clear. Removes all the data.
     */
    public void clear() {
        buff.clear();
    }
    
    /**
     * Remove. Removes the mapping.
     */
    public void remove(int cachekey) {
    	buff.remove(cachekey);
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
