public class CollisionExample {
    private static final int TABLE_SIZE = 5;
    private String[] keys;
    private int[] values;

    public CollisionExample() {
        keys = new String[TABLE_SIZE];
        values = new int[TABLE_SIZE];
    }

    public void put(String key, int value) {
        int index = hash(key);
        int originalIndex = index;

        do {
            if (keys[index] == null || keys[index].equals(key)) {
                keys[index] = key;
                values[index] = value;
                return;
            }
            index = (index + 1) % TABLE_SIZE;
        } while (index != originalIndex);

        // If the loop completes without finding an empty slot, the table is full.
        System.out.println("Unable to insert " + key + ". The hash table is full.");
    }


    public int get(String key) {
        int index = hash(key);
        int originalIndex = index;

        do {
            if (keys[index] != null && keys[index].equals(key)) {
                return values[index];
            }
            index = (index + 1) % TABLE_SIZE;
        } while (index != originalIndex);

        return -1; // Key not found
    }


    private int hash(String key) {
        // Simple hash function using the length of the key
        return key.length() % TABLE_SIZE;
    }

    public static void main(String[] args) {
        CollisionExample hashTable = new CollisionExample();

        hashTable.put("John", 25);
        hashTable.put("Alice", 30);
        hashTable.put("Bob", 22);
        hashTable.put("Eva", 28);
        hashTable.put("David", 35);

        // Introducing a collision by attempting to add a key with the same hash
        hashTable.put("Alex", 40); // Collision with "Eva"

        // Retrieving values
        System.out.println("Alice's age: " + hashTable.get("Alice"));
        System.out.println("Alex's age: " + hashTable.get("Alex")); // Should print -1 due to the collision
    }
}
