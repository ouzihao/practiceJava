package script;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectStreamDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("周杰伦");
        list.add("张学友");
        list.add("陶喆");
        list.add("陈奕迅");

        String[] strArray = list.stream().toArray(String[]::new);
        System.out.println(Arrays.toString(strArray));

        List<Integer> list1 = Arrays.stream(strArray).map(String::length).collect(Collectors.toList());
        System.out.println(list1);
        List<String> list2 = Arrays.stream(strArray).collect(Collectors.toCollection(ArrayList::new));
        System.out.println(list2);

        String str = Arrays.stream(strArray).collect(Collectors.joining(",")).toString();
        System.out.println(str);

    }



}
