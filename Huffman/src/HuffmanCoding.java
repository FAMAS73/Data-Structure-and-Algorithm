import java.util.PriorityQueue;
import java.util.HashMap;

class HuffmanNode implements Comparable<HuffmanNode> {
    char data;
    int frequency;
    HuffmanNode left, right;

    public HuffmanNode(char data, int frequency) {
        this.data = data;
        this.frequency = frequency;
        this.left = this.right = null;
    }

    @Override
    public int compareTo(HuffmanNode other) {
        return this.frequency - other.frequency;
    }
}

public class HuffmanCoding {
    public static void main(String[] args) {
        // Step 1: Build Frequency Map
        String input = "hello world";
        HashMap<Character, Integer> frequencyMap = buildFrequencyMap(input);

        // Step 2: Build Huffman Tree
        HuffmanNode root = buildHuffmanTree(frequencyMap);

        // Step 3: Generate Huffman Codes
        HashMap<Character, String> huffmanCodes = generateHuffmanCodes(root);

        // Step 4: Encode Message
        String encodedMessage = encodeMessage(input, huffmanCodes);

        // Display results
        System.out.println("Original message: " + input);
        System.out.println("Encoded message: " + encodedMessage);
    }

    private static HashMap<Character, Integer> buildFrequencyMap(String input) {
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : input.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        return frequencyMap;
    }

    private static HuffmanNode buildHuffmanTree(HashMap<Character, Integer> frequencyMap) {
        PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<>();
        for (char key : frequencyMap.keySet()) {
            priorityQueue.add(new HuffmanNode(key, frequencyMap.get(key)));
        }

        while (priorityQueue.size() > 1) {
            HuffmanNode left = priorityQueue.poll();
            HuffmanNode right = priorityQueue.poll();
            HuffmanNode mergedNode = new HuffmanNode('\0', left.frequency + right.frequency);
            mergedNode.left = left;
            mergedNode.right = right;
            priorityQueue.add(mergedNode);
        }

        return priorityQueue.poll();
    }

    private static HashMap<Character, String> generateHuffmanCodes(HuffmanNode root) {
        HashMap<Character, String> huffmanCodes = new HashMap<>();
        generateCodes(root, "", huffmanCodes);
        return huffmanCodes;
    }

    private static void generateCodes(HuffmanNode node, String code, HashMap<Character, String> huffmanCodes) {
        if (node == null) {
            return;
        }

        if (node.data != '\0') {
            huffmanCodes.put(node.data, code);
        }

        generateCodes(node.left, code + "0", huffmanCodes);
        generateCodes(node.right, code + "1", huffmanCodes);
    }

    private static String encodeMessage(String input, HashMap<Character, String> huffmanCodes) {
        StringBuilder encodedMessage = new StringBuilder();
        for (char c : input.toCharArray()) {
            encodedMessage.append(huffmanCodes.get(c));
        }
        return encodedMessage.toString();
    }
}
