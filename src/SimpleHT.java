import java.util.ArrayList;
import java.util.ListIterator;

public class SimpleHT {

    public int size;
    public ArrayList<ArrayList<Pair>> data;

    public SimpleHT(int capacity) {
        size = capacity;
        data = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            data.add(new ArrayList<>());
        }
    }

    public int addressOf(Integer key) {
        return Math.floorMod(key, size);
    }

    public void insert(Integer key, Integer value) {
        int address = addressOf(key);
        Pair pair = new Pair(key, value);
        Pair temp;
        ListIterator<Pair> iterator = data.get(address).listIterator();
        while (iterator.hasNext()) {
            temp = iterator.next();
            if (temp.key.equals(pair.key)) {
                temp.value = value;
                return;
            }
        }
        data.get(address).add(pair);
    }

    public Integer get(Integer key) {
        int address = addressOf(key);
        Pair temp;
        ListIterator<Pair> iterator = data.get(address).listIterator();
        while (iterator.hasNext()) {
            temp = iterator.next();
            if (temp.key.equals(key)) {
                return temp.value;
            }
        }
        return null;
    }

    public boolean remove(Integer key) {
        int address = addressOf(key);
        Pair temp;
        ListIterator<Pair> iterator = data.get(address).listIterator();
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
        ListIterator<Pair> iterator = data.get(i).listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toStrirng());
        }
    }

    public static class Pair {
        Integer key;
        Integer value;

        public Pair(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public String toStrirng() {
            return key.toString() + ", " + value.toString();
        }
    }
}
