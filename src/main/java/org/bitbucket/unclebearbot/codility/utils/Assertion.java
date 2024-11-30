package org.bitbucket.unclebearbot.codility.utils;

import java.util.Arrays;
import java.util.Objects;

public class Assertion {
    public static void equalObjects(Object a, Object b) {
        if (!Objects.equals(a, b)) {
            throw new AssertionError(diffObjects(a, b));
        }
    }

    public static void equalArrays(int[] a, int[] b) {
        if (a == null && b == null) {
            return;
        }
        if (a == null || b == null) {
            throw new AssertionError(diffArrays(a, b));
        }
        if (a.length != b.length) {
            throw new AssertionError(diffArrays(a, b));
        }
        for (int i = 0; i < a.length; ++i) {
            if (a[i] != b[i]) {
                throw new AssertionError(diffArrays(a, b));
            }
        }
    }

    private static String diffObjects(Object a, Object b) {
        return String.format("%s <=> %s", a, b);
    }

    private static String diffArrays(int[] a, int[] b) {
        return diffObjects(Arrays.toString(a), Arrays.toString(b));
    }
}
