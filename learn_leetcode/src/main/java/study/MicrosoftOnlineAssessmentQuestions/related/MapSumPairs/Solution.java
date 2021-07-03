package study.MicrosoftOnlineAssessmentQuestions.related.MapSumPairs;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.IntConsumer;

/**
 * 1 <= key.length, prefix.length <= 50
 * key and prefix consist of only lowercase English letters.
 */
class MapSum {

    private static class Node {
        Map<Character, Node> next = new HashMap<>();
        int value = 0;
    }

    private Node root;

    public MapSum() {
        root = new Node();
    }

    public void insert(String key, int val) {
        if (key == null) {
            return;
        }
        Node cur = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);

            if (!cur.next.containsKey(c)) {
                cur.next.put(c, createNode());
            }
            cur = cur.next.get(c);

            if (i == key.length() - 1) {
                cur.value = val;
            }
        }
    }

    public int sum(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            cur = cur.next.get(c);
            if (cur == null) {
                return 0;
            }
            if (i == prefix.length() - 1) {
                break;
            }
        }

        return dfs(cur);
    }

    private int dfs(Node start) {
        int count = start.value;
        for (Character character : start.next.keySet()) {
            Node node = start.next.get(character);
            count += dfs(node);
        }
        return count;
    }

    private Node createNode() {
        return new Node();
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */