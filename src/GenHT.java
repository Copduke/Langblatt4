import java.util.ArrayList;
import java.util.ListIterator;

public class GenHT<K, V>{

    public int size;
    public ArrayList<ArrayList<Pair<K,V>>> data;

    public GenHT(int capacity) {
        size = capacity;
        data = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            data.add(new ArrayList<>());
        }
    }

    public int addressOf(K key) {
        return Math.floorMod(key.hashCode(), size);
    }

    public void insert(K key, V value) {
        int address = addressOf(key);
        Pair<K,V> pair = new Pair<>(key, value);
        Pair<K,V> temp;
        ListIterator<Pair<K,V>> iterator = data.get(address).listIterator();
        while (iterator.hasNext()) {
            temp = iterator.next();
            if (temp.key.equals(pair.key)) {
                temp.value = value;
                return;
            }
        }
        data.get(address).add(pair);
    }

    public V get(K key) {
        int address = addressOf(key);
        Pair<K,V> temp;
        ListIterator<Pair<K,V>> iterator = data.get(address).listIterator();
        while (iterator.hasNext()) {
            temp = iterator.next();
            if (temp.key.equals(key)) {
                return temp.value;
            }
        }
        return null;
    }

    public boolean remove(K key) {
        int address = addressOf(key);
        Pair<K,V> temp;
        ListIterator<Pair<K,V>> iterator = data.get(address).listIterator();
        while (iterator.hasNext()) {
            temp = iterator.next();
            if (temp.key.equals(key)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public void show(int i) {
        ListIterator<Pair<K,V>> iterator = data.get(i).listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toStrirng());
        }
    }

    public static class Pair<K,V>{
        K key;
        V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public String toStrirng() {
            return key.toString() + ", " + value.toString();
        }
    }
}