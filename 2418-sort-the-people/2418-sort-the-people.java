class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        return IntStream.range(0, names.length)
            .mapToObj(i -> new Pair<String, Integer>(names[i], heights[i]))
            .sorted((p1, p2) -> Integer.compare(p2.getValue(), p1.getValue()))
            .map(Pair::getKey)
            .toArray(String[]::new);
    }
}