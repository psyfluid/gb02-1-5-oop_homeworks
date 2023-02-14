package homework04;

import java.lang.reflect.Array;
import java.util.*;

public class MyArray<T extends Comparable<T>> implements Iterable<T>, Iterator<T> {
    T[] elements;
    private int size;
    private int index;

    public MyArray(int size) {
        this.size = size;
        this.elements = (T[]) new Object[size];
    }

    public MyArray() {
        this(0);
    }

    public MyArray(T[] elements) {
        this.elements = Arrays.copyOf(elements, elements.length);
        this.size = elements.length;
    }

    public int size() {
        return size;
    }

    public T[] elements() {
        return elements;
    }

    public MyArray<T> clone() {
        return new MyArray<T>(Arrays.copyOf(elements, size));
    }

    public void add(T element) {
        this.elements = Arrays.copyOf(elements, ++size);
        this.elements[size - 1] = element;
    }

    public T get(int index) {
        Objects.checkIndex(index, this.size);
        return this.elements[index];
    }

    public void set(int index, T element) {
        Objects.checkIndex(index, this.size);
        this.elements[index] = element;
    }

    public void remove(int index) {
        Objects.checkIndex(index, this.size);
        T[] temp = (T[]) Array.newInstance(this.get(0).getClass(), --size);
        System.arraycopy(elements, 0, temp, 0, index);
        System.arraycopy(elements, index + 1, temp, index, size - index);
        this.elements = Arrays.copyOf(temp, size);
    }

    public void removeValue(T value) {
        Set<Integer> indices = new HashSet<>();
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(value)) {
                indices.add(i);
            }
        }

        if (indices.isEmpty()) return;

        T[] temp = (T[]) Array.newInstance(this.get(0).getClass(), size - indices.size());
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (indices.contains(i)) continue;
            temp[j++] = elements[i];
        }
        this.size -= indices.size();
        this.elements = Arrays.copyOf(temp, size);
    }

    public T min() {
        T temp = get(0);
        for (int i = 0; i < size; i++) {
            if (get(i).compareTo(temp) < 0) temp = get(i);
        }
        return temp;
    }

    public T max() {
        T temp = get(0);
        for (int i = 0; i < size; i++) {
            if (get(i).compareTo(temp) > 0) temp = get(i);
        }
        return temp;
    }

    public Number sumOfElements() {
        T temp = get(0);
        var sum = 0;
        if (temp instanceof Integer) {
            for (int i = 0; i < size; i++) {
                sum += (Integer) get(i);
            }
        } else if (temp instanceof Double) {
            for (int i = 0; i < size; i++) {
                sum += (Double) get(i);
            }
        } else return null;
        return sum;
    }

    public Number productOfElements() {
        T temp = get(0);
        var product = 1;
        if (temp instanceof Integer) {
            for (int i = 0; i < size; i++) {
                product *= (Integer) get(i);
            }
        } else if (temp instanceof Double) {
            for (int i = 0; i < size; i++) {
                product *= (Double) get(i);
            }
        } else return null;
        return product;
    }

    private void swap(int i1, int i2) {
        T temp = get(i1);
        set(i1, get(i2));
        set(i2, temp);
    }

    public void sort() {
        sort(SortingType.BubbleSort);
    }

    public void sort(SortingType sortingType) {
        if (sortingType == SortingType.BubbleSort) {
            bubbleSort();
        } else if (sortingType == SortingType.InsertionSort) {
            insertionSort();
        } else if (sortingType == SortingType.SelectionSort) {
            selectionSort();
        }
    }

    private void bubbleSort() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (get(j).compareTo(get(j + 1)) > 0) {
                    swap(j, j + 1);
                }
            }
        }

    }

    private void insertionSort() {
        for (int i = 1; i < size; i++) {
            T current = get(i);
            int j = i - 1;

            while (j >= 0 && get(j).compareTo(current) > 0) {
                set(j + 1, get(j));
                j--;
            }
            set(j + 1, current);
        }
    }

    private void selectionSort() {
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++)
                if (get(j).compareTo(get(minIndex)) < 0) minIndex = j;
            swap(i, minIndex);
        }

    }

    public int indexOf(T value) {
        if (value == null) {
            for (int i = 0; i < size; i++) {
                if (get(i) == null) return i;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (value.equals(get(i))) return i;
            }
        }
        return -1;
    }

    public boolean contains(T value) {
        return indexOf(value) > -1;
    }

    public void printArray() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return (elements == null ? "null" : Arrays.asList(elements).toString());
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> iterator = new Iterator<>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size();
            }

            @Override
            public T next() {
                return get(index++);
            }
        };

        return iterator;
    }

    @Override
    public boolean hasNext() {
        return index < size();
    }

    @Override
    public T next() {
        return get(index++);
    }

    enum SortingType {
        BubbleSort, InsertionSort, SelectionSort
    }

}
