package com.sagar.problems;

import java.util.Arrays;
import java.util.stream.Stream;

public class Permutations {

    public static void main(String[] args) {

        String text = "abcd";

        permute(text.split(""), 0);

    }

    public static void permute(String[] txt, int fixIndex) {

        if (fixIndex == txt.length) {
            Stream.of(txt).forEach(s -> System.out.print(s));
            System.out.println();
        } else {
//            System.out.println(Arrays.toString(txt)+" : Fixing : " + fixIndex);
            for (int i = fixIndex; i < txt.length; i++) {
                swap(txt, i, fixIndex);
                permute(txt, fixIndex + 1);
                swap(txt, i, fixIndex);
            }
        }
    }

    private static void swap(String[] txt, int i, int fixIndex) {
        String temp = txt[i];
        txt[i] = txt[fixIndex];
        txt[fixIndex] = temp;

    }

}
