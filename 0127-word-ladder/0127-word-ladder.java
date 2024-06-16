import java.util.*;

class Solution {
    class Pair<T1, T2> {
        T1 first;
        T2 second;

        public Pair(T1 first, T2 second) {
            this.first = first;
            this.second = second;
        }
    }

    HashMap<String, List<Integer>> words = new HashMap<>();

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        processWords(wordList);
        Queue<Pair<Integer, Integer>> Q = new LinkedList<>();
        HashMap<Integer, Boolean> visited = new HashMap<>();

        Q.offer(new Pair<>(-1, 1));
        while (!Q.isEmpty()) {
            Pair<Integer, Integer> node = Q.poll();
            Integer index = node.first;
            Integer level = node.second;
            if (!visited.containsKey(index)) {
                visited.put(index, true);
                String word = (index == -1) ? beginWord : wordList.get(index);
                if (Objects.equals(word, endWord)) return level;
                checkWords(word, level, Q);
            }
        }
        return 0;
    }

    public void checkWords(String word, int level, Queue<Pair<Integer, Integer>> Q) {
        for (int j = 0; j < word.length(); j++) {
            String variation = word.substring(0, j) + "-" + word.substring(j + 1);
            List<Integer> wordVariations = words.getOrDefault(variation, new ArrayList<>());
            for (Integer candidateIndex : wordVariations) {
                Q.offer(new Pair<>(candidateIndex, level + 1));
            }
        }
    }

    public void processWords(List<String> wordList) {
        for (int i = 0; i < wordList.size(); i++) {
            String word = wordList.get(i);
            for (int j = 0; j < word.length(); j++) {
                String variation = word.substring(0, j) + "-" + word.substring(j + 1);
                List<Integer> wordIndexes = words.getOrDefault(variation, new ArrayList<>());
                wordIndexes.add(i);
                words.put(variation, wordIndexes);
            }
        }
    }
}