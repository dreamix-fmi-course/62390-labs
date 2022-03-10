package labs.week_03.collections;
import java.util.*;

public class Exercise {

    private static <T> void addElementAtFirstPosition(List<T> arr, T value)
    {
        arr.add(0, value);
    }

    private static <T> T getElementAtIndex(List<T> arr, int index) throws IndexOutOfBoundsException
    {
        return arr.get(index);
    }

    private static <T> void removeThirdElement(List<T> arr)
    {
        if(arr.size() < 3)
        {
            return;
        }
        else
        {
            arr.remove(3);
        }
    }

    public static void main(String[] args)
    {

    }
}
