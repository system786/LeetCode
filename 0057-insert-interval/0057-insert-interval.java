class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            int[][] result = new int[1][2];
            result[0][0] = newInterval[0];
            result[0][1] = newInterval[1];
            return result;
        }
        int startRow = -1;
        int endRow = -1;
        int firstStartCheck = 0;
        int intervalsLength = intervals.length;
        for (int i = 0; i < intervalsLength; i++) {
            if (newInterval[0] <= intervals[i][1] && firstStartCheck == 0) {
                startRow = i;
                firstStartCheck = 1;
            }
            if (newInterval[1] >= intervals[i][0]) {
                endRow = i;
            }
        }
        if (startRow == -1) {
            int[][] newIntervals = new int[intervalsLength + 1][2];
            for (int i = 0; i < intervalsLength + 1; i++) {
                if (i < intervalsLength) {
                    newIntervals[i][0] = intervals[i][0];
                    newIntervals[i][1] = intervals[i][1];
                } else {
                    newIntervals[i][0] = newInterval[0];
                    newIntervals[i][1] = newInterval[1];
                }
            }
            return newIntervals;
        }
        if (endRow == -1) {
            int[][] newIntervals = new int[intervalsLength + 1][2];
            for (int i = 0; i < intervalsLength + 1; i++) {
                if (i == 0) {
                    newIntervals[i][0] = newInterval[0];
                    newIntervals[i][1] = newInterval[1];
                } else {
                    newIntervals[i][0] = intervals[i-1][0];
                    newIntervals[i][1] = intervals[i-1][1];
                }
            }
            return newIntervals;
        }
        int newStart = Math.min(newInterval[0], intervals[startRow][0]);
        int newEnd = Math.max(newInterval[1], intervals[endRow][1]);
        int mergedCount = endRow - startRow;
        int newIntervalLength = intervalsLength - mergedCount;
        int[][] newIntervals = new int[newIntervalLength][2];
        int firstSetCheck = 0;
        for (int i = 0; i < newIntervalLength; i++) {
            if (i < startRow) {
                newIntervals[i][0] = intervals[i][0];
                newIntervals[i][1] = intervals[i][1];
            } else if (firstSetCheck == 0) {
                newIntervals[i][0] = newStart;
                newIntervals[i][1] = newEnd;
                firstSetCheck = 1;
            } else {
                newIntervals[i][0] = intervals[i + mergedCount][0];
                newIntervals[i][1] = intervals[i + mergedCount][1];
            }
        }
        return newIntervals;
    }
}