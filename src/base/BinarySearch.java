package base;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.List;

public class BinarySearch<E> {

    private final List<? extends Comparable<E>> elements;

    public BinarySearch(List<? extends Comparable<E>> elements) {
        this.elements = elements;
    }

    public int indexOf(E element) {
        if (elements.isEmpty()) {
            return -1;
        }
        int lo = 0;
        int hi = elements.size() - 1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >>> 1);
            if (elements.get(mid).compareTo(element) < 0) {
                lo = mid + 1;
            } else if (elements.get(mid).compareTo(element) > 0) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public int indexOfReverse(E element) {
        return find(element, 0, elements.size() - 1);
    }

    public int find(E element, int lo, int hi) {
        if (lo > hi) {
            return -1;
        }
        int mid = lo + ((hi - lo) >>> 1);
        if (elements.get(mid).compareTo(element) < 0) {
            return find(element, mid + 1, hi);
        } else if (elements.get(mid).compareTo(element) > 0) {
            return find(element, lo, mid - 1);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        In in = new In("data/tinyT.txt");
        int[] writeList = in.readAllInts();
        Arrays.sort(writeList);
        List<Integer> list = Arrays.stream(writeList).boxed().toList();
        BinarySearch<Integer> bs = new BinarySearch<>(list);
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (bs.indexOf(key) == -1) {
                StdOut.println(key);
            } else {
                StdOut.println("find it");
            }
        }
    }

}
