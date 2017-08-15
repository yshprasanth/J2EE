package sort;

import java.util.Arrays;
import java.util.Comparator;

public class FastMergeSort {

        public static  void main(String[] args) {
            Integer[] arr = {1,4,3,25,4,6,22};
            doSort(arr);
        }

        @SuppressWarnings( { "unchecked" })
        private static void mergeSort(Object src[], Object dest[], int low, int high, int off,
                                      Comparator c) {
            System.out.println("start merge sort: " + low + ", " +  high + ", " + (off) + "; " + Arrays.toString(src) + "; " + Arrays.toString(dest));
            int length = high - low;

            // use insertion sort on smallest arrays
            if (length < 7) {
                for (int i = low; i < high; i++) {
                    for (int j = i; j > low && c.compare(dest[j - 1], dest[j]) > 0; j--) {
                        Object temp = dest[j];
                        dest[j] = dest[j - 1];
                        dest[j - 1] = temp;
                    }
                }
                return;
            }

            // recursively sort halves of dest into src
            int destLow = low;
            int destHigh = high;
            low += off;
            high += off;
            int mid = (low + high) >> 1;
            System.out.println("Calling first half merge sort: " + low + ", " +  mid + ", " + (-off) + ", " + Arrays.toString(dest) + "; " + Arrays.toString(src));
            mergeSort(dest, src, low, mid, -off, c);
            System.out.println("Calling second half merge sort: " + low + ", " +  mid + ", " + (-off) + ", " + Arrays.toString(dest) + "; " + Arrays.toString(src));
            mergeSort(dest, src, mid, high, -off, c);
            System.out.println("after Calling second half merge sort: " + low + ", " +  mid + ", " + (-off) + ", " + Arrays.toString(dest) + "; " + Arrays.toString(src));
            // is list already sorted?
            if (c.compare(src[mid - 1], src[mid]) <= 0) {
                System.arraycopy(src, low, dest, destLow, length);
                System.out.println("after arraycopy: " + low + ", " +  mid + ", " + dest + ", " + destLow + ", " + length + Arrays.toString(dest) + "; " + Arrays.toString(src));
                return;
            }

            // merge sorted halves from src into dest
            for (int i = destLow, p = low, q = mid; i < destHigh; i++) {
                if (q >= high || p < mid && c.compare(src[p], src[q]) <= 0) {
                    dest[i] = src[p++];
                } else {
                    dest[i] = src[q++];
                }
            }

            System.out.println("after merge sorted : " + low + ", " +  mid + ", " + dest + ", " + destLow + ", " + length + Arrays.toString(dest) + "; " + Arrays.toString(src));
        }

        public void sort(Object[] a, Comparator c) {
            Object aux[] = a.clone();
            mergeSort(aux, a, 0, a.length, 0, c);
        }

        public void sort(Comparable[] a) {
            Object aux[] = a.clone();
            mergeSort(aux, a, 0, a.length, 0, ComparableComparator.INSTANCE);
        }

        // ---------------------------------------------------------------- static

        public static void doSort(Object[] a, Comparator c) {
            Object aux[] = a.clone();
            mergeSort(aux, a, 0, a.length, 0, c);
        }

        public static void doSort(Comparable[] a) {
            Object aux[] = a.clone();
            mergeSort(aux, a, 0, a.length, 0, ComparableComparator.INSTANCE);
        }

    }

    class ComparableComparator<T extends Comparable<T>> implements Comparator<T> {

        /**
         * Cached instance.
         */
        public static final ComparableComparator INSTANCE = new ComparableComparator();

        public int compare(T o1, T o2) {
            return o1.compareTo(o2);
        }

    }
