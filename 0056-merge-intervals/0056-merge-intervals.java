class Solution {
    public int[][] merge(int[][] intervals) {
        List<List<Integer>> mainList = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0])); 
        int i = 0;
        while (i < intervals.length) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            while (i < intervals.length - 1 && end >= intervals[i + 1][0]) {
                end = Math.max(end, intervals[i + 1][1]);
                i++;
            }
            List<Integer> mergedInterval = new ArrayList<>();
            mergedInterval.add(start);
            mergedInterval.add(end);
            mainList.add(mergedInterval);
            i++;
        }
        int[][] result = new int[mainList.size()][2];
        for (int j = 0; j < mainList.size(); j++) {
            result[j][0] = mainList.get(j).get(0);
            result[j][1] = mainList.get(j).get(1);
        }
        return result;
    }
}