package com.shams.sorting.algorithms;

import com.shams.commons.UtilityHelper;

/**
 * Reference : https://www.geeksforgeeks.org/min-heap-in-java/
 */
public class MinHeap {

  int[] heap;
  int size;
  int maxHeapSize;

  MinHeap(int maxHeapSize) {
    this.maxHeapSize = maxHeapSize;
    this.size = 0;
    heap = new int[this.maxHeapSize + 1];
    heap[0] = Integer.MIN_VALUE;
  }

  public static void main(String[] args) {
    int[] a = {1, 2, 4, 4};
    int[] a1 = {5, 3, 4, 2, 7, 6, 8, 1, 9, 5, 3, 4, 1};
    MinHeap minHeap = new MinHeap(15);
    minHeap.insert(5);
    minHeap.insert(3);
    minHeap.insert(17);
    minHeap.insert(10);
    minHeap.insert(84);
    minHeap.insert(19);
    minHeap.insert(6);
    minHeap.insert(22);
    minHeap.insert(9);
    minHeap.minHeap();
    minHeap.print();
  }

  private int getParentIndex(int currentElementIndex) {
    return currentElementIndex / 2;
  }

  private int getLeftChildIndex(int i) {
    return (2 * i);
  }

  private int getRightChildIndex(int i) {
    return (2 * i) + 1;
  }

  private void minHeap() {
    for (int i = (this.size - 1) / 2; i >= 0; --i) {
      minHeapify(i);
    }
  }

  // Function that returns true if the passed
  // node is a leaf node
  private boolean isLeadNode(int pos) {
    return (pos >= (size / 2)) && pos <= size;
  }

  private void minHeapify(int currentNodeIndex) {
    if (!isLeadNode(heap[currentNodeIndex])) {
      if (heap[getParentIndex(currentNodeIndex)] > heap[getLeftChildIndex(currentNodeIndex)]
          || heap[getParentIndex(currentNodeIndex)] > heap[getRightChildIndex(currentNodeIndex)]) {
        if (heap[getLeftChildIndex(currentNodeIndex)] < heap[getRightChildIndex(currentNodeIndex)]) {
          minHeapify(getLeftChildIndex(currentNodeIndex));
        } else {
          minHeapify(getRightChildIndex(currentNodeIndex));
        }
      }
    }
  }
/**
 *  for(int i = (size-1)/2; i>=0; --i) {
 *    meinHeapify(i);
 *  }
 *  mineHeapify(int currPos) {
 *    if(!isLeaf(currPos)) {
 *      if(parent > leftChild || parent > rightChild) {
 *        if(leftChild < rightChild) {
 *          minHeapify(leftChildIndex)
 *        } esle {
 *          minHeapify(rightChildIndex)
 *        }
 *      }
 *    }
 *  }
 *
 *  isLeaf(currPos) {
 *    return cusrPos >= (size/2) && curPos <= size;
 *  }
 *
 *
 * */
  private void insert(int element) {

    if (this.size >= this.maxHeapSize) {
      return;
    }
    heap[++size] = element;
    int current = size;
    //  If new key is larger than its parent, then we don’t need to do anything.
    //  Otherwise, we need to traverse up to fix the violated heap property.
    while (heap[current] < heap[this.getParentIndex(current)]) {
      UtilityHelper.swap(heap, current, this.getParentIndex(current));
      current = this.getParentIndex(current);
    }
  }

  public void print()
  {
//    Arrays.stream(heap).forEach(System.out::println);
    for (int i = 1; i <= size / 2; i++) {
      System.out.print(" PARENT : " + heap[i]
          + " LEFT CHILD : " + heap[2 * i ]
          + " RIGHT CHILD :" + heap[2 * i + 1]);
      System.out.println();
    }
  }
}
