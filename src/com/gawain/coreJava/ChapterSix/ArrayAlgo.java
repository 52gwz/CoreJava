package com.gawain.coreJava.ChapterSix;


//给定一组数组 返回包含最大值最小值的Pair
public class ArrayAlgo {
    public static class Pair {
        private double first;
        private double second;

        public Pair(double first, double second) {
            this.first = first;
            this.second = second;
        }

        public double getFirst() {
            return first;
        }

        public double getSecond() {
            return second;
        }
    }

    public static Pair minmax(double[] d) {
        double min = Double.POSITIVE_INFINITY;  //正无穷大
        double max = Double.NEGATIVE_INFINITY;  //负无穷大
        for (double v : d) {
            if (v > max) {
                max = v;
            }
            if (v < min) {
                min = v;
            }
        }
        return new Pair(min, max);
    }
}
