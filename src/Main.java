public class Main {

    public static void main(String[] args) {
        int c = 5;
        GenHT<String, String> map = new GenHT<String, String>(c);
        map.insert("10", "5");
        map.insert("10", "effe");
        map.insert("12", "lol");
        map.insert("wd", "lmao");
        for (int i = 0; i < c; i++) {
            map.show(i);
        }
    }
}
