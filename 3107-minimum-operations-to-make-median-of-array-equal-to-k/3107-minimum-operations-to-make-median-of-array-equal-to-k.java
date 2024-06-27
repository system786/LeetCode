import java.util.PriorityQueue;

class MedianFinder {
    private PriorityQueue<Integer> small; // Max heap for values less than median
    private PriorityQueue<Integer> large; // Min heap for values greater than median
    
    public MedianFinder() {
        // Initialize the max heap and min heap
        // The custom comparator reverses the order for max heap behavior
        small = new PriorityQueue<>((a, b) -> b - a);
        large = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        // Add the number to the max heap
        small.offer(num);
        
        // Balance the heaps to ensure the max heap contains smaller elements than the min heap
        if (!small.isEmpty() && !large.isEmpty() && small.peek() > large.peek()) {
            int val = small.poll();
            large.offer(val);
        }
        
        // If max heap size exceeds min heap size by more than 1, move the root to the min heap
        if (small.size() > large.size() + 1) {
            int val = small.poll();
            large.offer(val);
        }
        
        // If min heap size exceeds max heap size by more than 1, move the root to the max heap
        if (large.size() > small.size() + 1) {
            int val = large.poll();
            small.offer(val);
        }
    }
    
    public double findMedian() {
        if (small.size() > large.size()) {
            // If max heap has more elements, the median is the root of the max heap
            return small.peek();
        }
        
        if (large.size() > small.size()) {
            // If min heap has more elements, the median is the root of the min heap
            return large.peek();
        }
        
        // If heaps have equal size, median is the average of the roots of both heaps
        return (small.peek() + large.peek()) / 2.0;
    }
}