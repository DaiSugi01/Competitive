//https://leetcode.com/problems/convert-the-temperature/
package LeetCode.Math;

public class ConvertTheTemperature_2469 {
    public static void main(String[] args) {
        convertTemperature(1.1);
    }

    public static double[] convertTemperature(double celsius) {
        double k = celsius + 273.15;
        double f = celsius * 1.80 + 32.00;
        return new double[]{k, f};
    }
}
