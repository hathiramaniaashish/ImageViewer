package util;

import java.util.HashMap;

public class AccessCounter {
    private final HashMap<String, Integer> accesses = new HashMap<>();
    static final private AccessCounter INSTANCE = new AccessCounter();

    private AccessCounter() {
        
    }
    
    public static AccessCounter getInstance() {
        return INSTANCE;
    }
    
    public Integer increment(String key) {
        final Integer count;
        if (accesses.containsKey(key)) {
            count = accesses.get(key) + 1;
        } else {
            count = 1;
        }
        accesses.put(key, count);
        return count;
    }
    
}
