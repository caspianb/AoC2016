package aoc2016;

import util.ResourceReader;
import util.misc.DateWindow;
import util.misc.DateWindowSpan;

import java.util.List;

import com.google.common.collect.Lists;

public class Day20 {

    private static final long MAX_VALUE = 4294967295l;

    public static void main(String[] args) throws Exception {
        List<String> input = ResourceReader.readLines("aoc2016/input20.txt");

        problem1(input);
        problem2(input);
    }

    private static void problem1(List<String> input) {

        List<DateWindow> windows = Lists.newArrayList();
        for (String line : input) {
            String[] vals = line.split("-");

            long low = Long.valueOf(vals[0]);
            long high = Long.valueOf(vals[1]);
            DateWindow window = new DateWindow(low, high);
            windows.add(window);
        }

        DateWindowSpan span = new DateWindowSpan(windows);

        for (long i = 0; i <= MAX_VALUE; i++) {
            if (!span.contains(i)) {
                System.out.println(i);
                break;
            }
        }
    }

    private static void problem2(List<String> input) {
        List<DateWindow> windows = Lists.newArrayList();
        for (String line : input) {
            String[] vals = line.split("-");

            long low = Long.valueOf(vals[0]);
            long high = Long.valueOf(vals[1]);
            DateWindow window = new DateWindow(low, high);
            windows.add(window);
        }

        DateWindowSpan span = new DateWindowSpan(windows);

        long prevEnd = -1;
        long allowed = 0;
        for (DateWindow window : span.getWindows()) {
            long start = window.getStartTime();

            allowed += start - (prevEnd + 1);
            prevEnd = window.getEndTime();
        }
        allowed += MAX_VALUE - prevEnd;

        System.out.println(allowed);
    }
}
