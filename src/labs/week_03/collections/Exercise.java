package labs.week_03.collections;
import labs.week_03.collections.entity.Dog;

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
            int indexToRemove = 2;
            arr.remove(indexToRemove);
        }
    }

    private static <T> int findElementInArray(List<T> arr, T value)
    {
        return arr.indexOf(value);
    }

    private static <T> void replaceElement(List<T> arr, T value) throws IndexOutOfBoundsException
    {
        int secondElemenIndex = 1;
        arr.set(secondElemenIndex, value);
    }

    private static <T, K> int getMapSize(Map<T, K> m)
    {
        //return m.size();

        int count = 0;
        for(Map.Entry<T, K> entry: m.entrySet())
        {
            count++;
        }
        return  count;
    }

    public static void main(String[] args)
    {
        List<Integer> l0 = new ArrayList<>();
        addElementAtFirstPosition(l0, 4);
        addElementAtFirstPosition(l0, 3);
        addElementAtFirstPosition(l0, 2);
        addElementAtFirstPosition(l0, 1);
        l0.forEach(l -> System.out.println(l));

        System.out.println("//////////////////////////////////////////////////");

        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(2);
        try
        {
            System.out.println(getElementAtIndex(l1, 1));
            System.out.println(getElementAtIndex(l1, 3));
        }
        catch (IndexOutOfBoundsException e)
        {
            System.out.println("Index " + 3 + " is out of range");
        }

        System.out.println("//////////////////////////////////////////////////");

        List<Integer> l2 = new ArrayList<>();
        l2.add(1);
        l2.add(2);
        l2.add(3);
        l2.forEach(l -> System.out.println(l));
        removeThirdElement(l2);
        l2.forEach(l -> System.out.println(l));

        System.out.println("//////////////////////////////////////////////////");

        List<Dog> l4 = new ArrayList<>();
        l4.add(new Dog("D2", 45));
        l4.add(new Dog("D1", 45));
        l4.add(new Dog("D2", 30));
        Collections.sort(l4);
        l4.forEach(l -> System.out.println(l));
    }
}
