package problems;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * https://leetcode.com/problems/design-bounded-blocking-queue/
 *
 * Implement a thread-safe bounded blocking queue that has the following methods:
 *
 * BoundedBlockingQueue(int capacity) The constructor initializes the queue with a maximum capacity.
 * void enqueue(int element) Adds an element to the front of the queue. If the queue is full, the calling thread is blocked until the queue is no longer full.
 * int dequeue() Returns the element at the rear of the queue and removes it. If the queue is empty, the calling thread is blocked until the queue is no longer empty.
 * int size() Returns the number of elements currently in the queue.
 * Your implementation will be tested using multiple threads at the same time. Each thread will either be a producer thread that only makes calls to the enqueue method or a consumer thread that only makes calls to the dequeue method. The size method will be called after every test case.
 *
 * Please do not use built-in implementations of bounded blocking queue as this will not be accepted in an interview.
 */
public class BoundedBlockingQueue {
    int[] nums;
    int putPtr, takePtr, count, capacity;
    Lock lock;
    Condition notFull, notEmpty;

    public BoundedBlockingQueue(int capacity) {
        this.nums = new int[capacity];
        this.capacity = capacity;
        lock = new ReentrantLock();
        notFull = lock.newCondition();
        notEmpty = lock.newCondition();
    }

    public void enqueue(int element) throws InterruptedException {
        lock.lock();
        try {
            while (count == capacity) {
                notFull.await();
            }
            nums[putPtr] = element;
            ++count;
            if (++putPtr == capacity) {
                putPtr = 0;
            }
            notEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public int dequeue() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0) {
                notEmpty.await();
            }
            int ret = nums[takePtr];
            --count;
            if (++takePtr == capacity) {
                takePtr = 0;
            }
            notFull.signalAll();
            return ret;
        } finally {
            lock.unlock();
        }
    }

    public int size() {
        lock.lock();
        try {
            return count;
        } finally {
            lock.unlock();
        }
    }
}
