package Mizut452.learn_law.Service;

import java.lang.reflect.Array;
import java.util.*;

public class Test {
    public static void main(String[] args) {
            int[] copied = {10, 20, 30};
            int[] doing = Arrays.copyOf(copied, 2);
            System.out.println(Arrays.toString(doing));
        }
    }
