import java.util.ArrayList;

interface SimpleHashFunction<K>{
    public int getHash(K key, int m);
}
public class ParamHT<K, V>{
    public ParamHT(int capacity) {}
    public ParamHT(int capacity, SimpleHashFunction<K> hashFunction) {}
    public static class Pair<K,V>{
        K key;
        V value;
    }
    public int size;
    public ArrayList<ArrayList<Pair>> data;
    public SimpleHashFunction<K> hashFunction;
    public int addressOf(K key) throws IndexOutOfBoundsException {return 0;}
    public void insert(K key, V value) {}
    public V get(K key) {
        Pair<K,V> pair = new Pair<>();
        return pair.value;
    }
    public boolean remove(K key) {return true;}
}