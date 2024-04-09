import org.junit.Test;
import static org.junit.Assert.*;

public class ArraySortingTest {

    @Test
    public void testSortArray() {
        // Test-edge cases
        String[] emptyArray = {};
        assertArrayEquals(emptyArray, ArraySorting.sortArray(emptyArray));

        String[] singleElementArray = {"a"};
        assertArrayEquals(singleElementArray, ArraySorting.sortArray(singleElementArray));

        String[] alreadySortedArray = {"a", "b", "c", "d"};
        assertArrayEquals(alreadySortedArray, ArraySorting.sortArray(alreadySortedArray));

        String[] reverseSortedArray = {"d", "c", "b", "a"};
        String[] sortedReverseArray = {"a", "b", "c", "d"};
        assertArrayEquals(sortedReverseArray, ArraySorting.sortArray(reverseSortedArray));

        // Test random arrays
        String[] randomArray1 = {"d", "c", "b", "a"};
        String[] sortedArray1 = {"a", "b", "c", "d"};
        assertArrayEquals(sortedArray1, ArraySorting.sortArray(randomArray1));

        String[] randomArray2 = {"dog", "cat", "bird", "fish", "elephant", "ant"};
        String[] sortedArray2 = {"ant", "bird", "cat", "dog", "elephant", "fish"};
        assertArrayEquals(sortedArray2, ArraySorting.sortArray(randomArray2));

        String[] randomArray3 = {"Apple", "Banana", "orange", "apple", "banana", "Orange"};
        String[] sortedArray3 = {"Apple", "Banana", "Orange", "apple", "banana", "orange"};
        assertArrayEquals(sortedArray3, ArraySorting.sortArray(randomArray3));
    }
}