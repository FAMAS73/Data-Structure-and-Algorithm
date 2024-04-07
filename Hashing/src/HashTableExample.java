public class HashTableExample {
    private static final int INITIAL_TABLE_SIZE = 5;
    private static final double LOAD_FACTOR_THRESHOLD = 0.7; // Resize if load factor exceeds this value

    private String[] keys;
    private int[] values;
    private int size; // Number of elements currently in the table

    public HashTableExample() {
        keys = new String[INITIAL_TABLE_SIZE];
        values = new int[INITIAL_TABLE_SIZE];
        size = 0;
    }

    private int hash(String key) {
        return key.length() % keys.length;
    }

    private void resizeTable() {
        int newTableSize = keys.length * 2;
        String[] newKeys = new String[newTableSize];
        int[] newValues = new int[newTableSize];

        // Rehash existing key-value pairs into the new table
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] != null) {
                rehashInsert(newKeys, newValues, keys[i], values[i]);
            }
        }

        // Update the table and arrays
        keys = newKeys;
        values = newValues;
    }

    private void rehashInsert(String[] tableKeys, int[] tableValues, String key, int value) {
        int index = hash(key);

        // Linear probing to find the next available slot
        while (tableKeys[index] != null) {
            index = (index + 1) % tableKeys.length;
        }

        tableKeys[index] = key;
        tableValues[index] = value;
    }

    public void put(String key, int value) {
        if ((double) size / keys.length > LOAD_FACTOR_THRESHOLD) {
            resizeTable();
        }

        int index = hash(key);

        // Linear probing to handle collisions
        while (keys[index] != null && !keys[index].equals(key)) {
            index = (index + 1) % keys.length;
        }

        keys[index] = key;
        values[index] = value;
        size++;
    }

    public int get(String key) {
        int index = hash(key);
        int originalIndex = index;

        // Linear probing to find the correct key
        do {
            if (keys[index] != null && keys[index].equals(key)) {
                return values[index];
            }
            index = (index + 1) % keys.length;
        } while (index != originalIndex);

        return -1; // Key not found
    }

    public void delete(String key) {
        int index = hash(key);
        int originalIndex = index;

        // Linear probing to find the correct key
        do {
            if (keys[index] != null && keys[index].equals(key)) {
                keys[index] = null;
                values[index] = 0; // Reset the value (optional)
                size--;
                return;
            }
            index = (index + 1) % keys.length;
        } while (index != originalIndex);
    }

    public static void main(String[] args) {
        HashTableExample hashTable = new HashTableExample();

        hashTable.put("John", 25);
        hashTable.put("Alice", 30);
        hashTable.put("Bob", 22);
        hashTable.put("Eva", 28);
        hashTable.put("David", 35);

        // Introduce a collision
        hashTable.put("Alex", 40); // Collision with "Alice"

        // Retrieving values
        System.out.println("Alice's age: " + hashTable.get("Alice"));
        System.out.println("Eva's age: " + hashTable.get("Eva")); // Should print -1 due to the collision
        System.out.println("Alex's age: " + hashTable.get("Alex")); // Should print 40

        // Deleting a key
        hashTable.delete("Bob");


        // Retrieving values after deletion
        System.out.println("Bob's age: " + hashTable.get("Bob")); // Should print -1 after deletion

        // Adding more elements to trigger resizing
        hashTable.put("Sophia", 18);
        hashTable.put("Michael", 45);

        // Retrieving values after resizing
        System.out.println("Sophia's age: " + hashTable.get("Sophia"));
        System.out.println("Michael's age: " + hashTable.get("Michael"));
    }
}
