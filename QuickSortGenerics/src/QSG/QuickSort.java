package QSG;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {

    private List<Comparable> numbers;
    private int number;

    public void sort(List<Comparable> values) {
        // check for empty or null array
        if (values == null || values.size() == 0) {
            return;
        }
        this.numbers = values;
        number = values.size();
        quicksort(0, number - 1);
    }

    private void quicksort(int low, int high) {
        int i = low, j = high;
        // Get the pivot element from the middle of the list
        Comparable pivot = numbers.get(low + (high - low) / 2);

        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller then the pivot
            // element then get the next element from the left list

            while (numbers.get(i).compareTo(pivot) == -1) {
                i++;
            }


            // If the current value from the right list is larger then the pivot
            // element then get the next element from the right list

            while (numbers.get(j).compareTo(pivot) == 1) {
                j--;
            }

            // If we have found a values in the left list which is larger then
            // the pivot element and if we have found a value in the right list
            // which is smaller then the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }
        // Recursion
        if (low < j)
            quicksort(low, j);
        if (i < high)
            quicksort(i, high);

        return;
    }

    public List<Comparable> getResult() {
        return numbers;
    }

    private void exchange(int i, int j) {

        Comparable temp = numbers.get(i);
        numbers.set(i, numbers.get(j));
        numbers.set(j, temp);
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        List<Comparable> integers = new ArrayList<>();
        integers.add(new MyInteger(1));
        integers.add(new MyInteger(5));
        integers.add(new MyInteger(3));
        integers.add(new MyInteger(2));
        integers.add(new MyInteger(7));
        integers.add(new MyInteger(9));

        List<Comparable> doubles = new ArrayList<>();
        doubles.add(3.0);
        doubles.add(1.0);
        doubles.add(2.0);
        doubles.add(3.0);
        doubles.add(6.0);
        doubles.add(5.0);

        List<Comparable> cars = new ArrayList<>();
        cars.add(new Car("BMW", 20));
        cars.add(new Car("AUDI", 30));
        cars.add(new Car("MERCEDES", 50));
        cars.add(new Car("SKODA", 20));
        cars.add(new Car("FORD", 30));

        quickSort.sort(integers);
        System.out.println(quickSort.getResult());

        quickSort.sort(doubles);
        System.out.println(quickSort.getResult());

        quickSort.sort(cars);
        System.out.println(quickSort.getResult());
    }

}
