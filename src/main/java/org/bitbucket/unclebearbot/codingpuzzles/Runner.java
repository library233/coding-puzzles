package org.bitbucket.unclebearbot.codingpuzzles;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        new Runner().runAll();
    }

    private void runAll() {
        String base = getClass().getPackage().getName();
        String[] categories = {"codility"};
        runCategories(base, categories);
    }

    private void runCategories(String base, String[] categories) {
        Arrays.stream(categories).forEach(category -> runLessons(base, category));
    }

    private void runLessons(String base, String category) {
        int lesson = 1;
        while (runTasks(base, category, lesson)) {
            ++lesson;
        }
    }

    private boolean runTasks(String base, String category, int lesson) {
        int task = 1;
        while (runSolution(base, category, lesson, task)) {
            ++task;
        }
        return task > 1;
    }

    private boolean runSolution(String base, String category, int lesson, int task) {
        try {
            Class.forName(String.format("%s.%s.lesson%03d.task%02d.Solution", base, category, lesson, task)).getDeclaredMethod("main", String[].class).invoke(null, (Object) new String[]{});
        } catch (ClassNotFoundException ignored) {
            return false;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
