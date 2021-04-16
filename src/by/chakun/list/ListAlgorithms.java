package by.chakun.list;

import by.chakun.list.linked.CustomLinkedList;

public class ListAlgorithms {


    public static void testList() {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println(list.toString());

        list.remove(2);

        System.out.println(list.toString());
    }

    public static void removeDuplicates() {

    }

    private static void doRemoveDuplicates(CustomLinkedList list) {

    }

}
