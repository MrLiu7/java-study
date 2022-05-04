package leetcode;

/**
 * @author Áø¼Ì¼Í
 * @date 3/5/2022
 * @apiNote
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        map.put(1, 1);
        int index = 3;
        Scanner scanner = new Scanner(System.in);
        int obj = scanner.nextInt();
        int counts = 1;
        int t;
        while (!map.containsKey(obj)) {
            list.add(1);
            ++index;
            for (int i = counts; i >0; --i) {
                list.set(i, list.get(i) + list.get(i - 1));
                ++index;
                if (!map.containsKey(list.get(i))) map.put(list.get(i), index);
                else break;
            }
            ++index;
            ++counts;
        }
        System.out.println(map.get(obj));
    }
}
