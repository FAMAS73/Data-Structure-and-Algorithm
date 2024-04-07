public class CustomHashTable {
    private static final int TABLE_SIZE = 10;
    private String[] keys;
    private int[] values;

    public CustomHashTable() {
        keys = new String[TABLE_SIZE];
        values = new int[TABLE_SIZE];
    }

    public void put(String key, int value) {
        int index = hash(key);
        while (keys[index] != null && !keys[index].equals(key)) {
            index = (index + 1) % TABLE_SIZE; // Linear probing for collision resolution
        }
        keys[index] = key;
        values[index] = value;
    }

    public int get(String key) {
        int index = hash(key);
        while (keys[index] != null && !keys[index].equals(key)) {
            index = (index + 1) % TABLE_SIZE; // Linear probing for collision resolution
        }
        if (keys[index] != null && keys[index].equals(key)) {
            return values[index];
        }
        return -1; // Key not found
    }

    private int hash(String key) {
        // Simple hash function using the length of the key
        return key.length() % TABLE_SIZE;
    }

    public static void main(String[] args) {
        CustomHashTable hashTable = new CustomHashTable();

        hashTable.put("John", 25);
        hashTable.put("Alice", 30);
        hashTable.put("Bob", 22);
        hashTable.put("Eva", 28);
        hashTable.put("David", 35);

        String searchKey = "Alice";
        int age = hashTable.get(searchKey);

        if (age != -1) {
            System.out.println(searchKey + "'s age is: " + age);
        } else {
            System.out.println(searchKey + " not found in the hash table.");
        }
    }
}
