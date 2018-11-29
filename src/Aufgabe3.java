import java.util.Arrays;

class HashMap {
    private int[] table = new int[11];

    private int getHash(int value) {
        return value;
    }

    private int getSecondHash(int value) {
        return 1 + (value % (table.length - 1));
    }

    void insertLinear(int value) {
        final int startHash = getHash(value);
        int hash;
        int i = 0;

        do {
            hash = startHash + i;
            i++;
        } while (table[hash % table.length] != 0);
        table[hash % table.length] = value;
    }

    void insertQuadratic(int value) {
        final int c1 = 1;
        final int c2 = 3;

        final int startHash = getHash(value);
        int hash;
        int i = 0;

        do {
            hash = startHash + c1 * i + c2 * i * i;
            i++;
        } while (table[hash % table.length] != 0);
        table[hash % table.length] = value;
    }

    void insertRehash(int value) {
        final int startHash = getHash(value);
        final int rehash = getSecondHash(value);
        int hash;
        int i = 0;

        do {
            hash = startHash + i * rehash;
            i++;
        } while (table[hash % table.length] != 0);
        table[hash % table.length] = value;
    }

    @Override
    public String toString() {
        return Arrays.toString(table);
    }
}

class Aufgabe3 {
    public static void main(String[] args) {
        int[] numbers = { 10, 22, 31, 4, 15, 28, 17, 88, 59};

        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();

        for (int number : numbers) {
            map.insertLinear(number);
            map2.insertQuadratic(number);
            map3.insertRehash(number);
        }
        System.out.println(map);
        System.out.println(map2);
        System.out.println(map3);
    }
}