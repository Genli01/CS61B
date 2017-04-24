package Map61B;

import org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;
import org.junit.Test;


import static org.junit.Assert.*;

/**
 * An array based implementation of the Map61B class.
 */
public class ArrayMap<K, V> implements Map61B<K, V> {
    private K[] keys;
    private V[] values;
    int size;

    public ArrayMap() {
        keys = (K[]) new Object[16];
        values = (V[]) new Object[16];
    }

    /** Returns the index of the given key if it exists,
     *  -1 otherwise. */
    private int keyIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }

    /* checks if array map contains the key */

    public boolean containsKey(K key) {
        if (keyIndex(key) > -1) {
            return true;
        }
        else {
            return false;
        }
    }
    /* Associate a key with value*/
    public void put(K key, V value) {

        int index = keyIndex(key);
        if (index == -1) {
            keys[size] = key;
            values[size] = value;
            size ++;
        }
        else {
            values[index] = value;
        }
        
    }
    /* return value, assuming key exits. */
    public V get(K key) {
        int index = keyIndex(key);
        return values[index];
    }

    public int size() {
        return size;
    }

    public List<K> keys() {
        List<K> keylist = new ArrayList<K>();
        for (int i = 0; i < keys.length; i++) {
            keylist.add(keys[i]);
        }
        return keylist;
    }

    /*@Test
    public void test() {
        ArrayMap<Integer, Integer> am = new ArrayMap<Integer, Integer>();
        am.put(2, 5);
        int expected = 5;
        assertEquals(expected, am.get(2));
    }*/

    public static void main(String[] args) {
        ArrayMap<String, Integer> m = new ArrayMap<String, Integer>();
        m.put("horse", 3);
        m.put("fish", 9);
        m.put("house", 10);
    }
}
