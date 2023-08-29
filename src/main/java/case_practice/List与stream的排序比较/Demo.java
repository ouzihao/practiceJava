package case_practice.List与stream的排序比较;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

class Demo0 {
    public static void main(String[] args) {

        List<Integer> userList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            userList.add(random.nextInt(1000));
        }
        List<Integer> userList2 = new ArrayList<>();
        userList2.addAll(userList);

        Long startTime1 = System.currentTimeMillis();
        userList2.stream().sorted(Comparator.comparing(Integer::intValue)).collect(Collectors.toList());
        System.out.println("stream.sort耗时："+(System.currentTimeMillis() - startTime1)+"ms");

        Long startTime = System.currentTimeMillis();
        userList.sort(Comparator.comparing(Integer::intValue));
        System.out.println("stream.sort耗时："+(System.currentTimeMillis() - startTime)+"ms");


    }
}

class Demo1 {
    public static void main(String[] args) {
        List<Integer> userList = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 10000 ; i++) {
            userList.add(rand.nextInt(1000));
        }
        List<Integer> userList2 = new ArrayList<>();
        userList2.addAll(userList);

        Long startTime = System.currentTimeMillis();
        userList.sort(Comparator.comparing(Integer::intValue));
        System.out.println("List.sort()耗时："+(System.currentTimeMillis()-startTime)+"ms");

        Long startTime1 = System.currentTimeMillis();
        userList2.stream().sorted(Comparator.comparing(Integer::intValue)).collect(Collectors.toList());
        System.out.println("stream.sort耗时："+(System.currentTimeMillis() - startTime1)+"ms");

    }
}


