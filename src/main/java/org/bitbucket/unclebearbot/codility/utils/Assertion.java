package org.bitbucket.unclebearbot.codility.utils;

import java.util.Objects;

public class Assertion {
    public static void equal(Object a, Object b) {
        if (!Objects.equals(a, b)) {
            throw new IllegalStateException();
        }
    }
}
