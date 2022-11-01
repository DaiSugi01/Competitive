package other.Codity;

import java.util.Map;
import java.util.TreeMap;

public class Q3 {
    int res = 0;

    public static void main(String[] args) {
        Q3 sol = new Q3();
//        System.out.println(sol.solution(new int[]{2, 8, 4, 3, 2}, 7, 11, 3));
        System.out.println(sol.solution(new int[]{5}, 4, 0, 3));
    }

    public int solution(int[] A, int X, int Y, int Z) {
        int[] lot = new int[]{-1, -1, -1};
        Map<Integer, Integer> dispensers = new TreeMap<>();
        dispensers.put(0, X);
        dispensers.put(1, Y);
        dispensers.put(2, Z);

        for (int i = 0; i < A.length; i++) {
            if (occupyLot(i, lot, dispensers, A)) continue;

            if (!swapCar(i, lot, dispensers, A)) return -1;
        }

        return res;
    }

    private boolean occupyLot(int currentCar, int[] lot, Map<Integer, Integer> dispensers, int[] cars) {
        for (int i = 0; i < dispensers.size(); i++) {
            if (lot[i] == -1 && dispensers.get(i) - cars[currentCar] >= 0) {
                lot[i] = currentCar;
                return true;
            }
        }

        return false;
    }

    private boolean swapCar(int currentCar, int[] lot, Map<Integer, Integer> dispensers, int[] cars) {
        for (int i = 0; i < dispensers.size(); i++) {
            int occupiedCar = lot[i];
            int restFuel = dispensers.get(i);

            if (occupiedCar == -1) continue;

            if (restFuel - cars[occupiedCar] >= cars[currentCar]) {
                for (int j = 0; j < dispensers.size(); j++) {
                    if (lot[j] != -1) {
                        dispensers.put(j, Math.min(0, dispensers.get(j) - cars[occupiedCar]));
                    }
                }
                for (int j = 0; j < lot.length; j++) {
                    if (lot[j] != -1 && occupiedCar != lot[j]) {
                        cars[lot[j]] = Math.min(cars[lot[j]] - cars[occupiedCar], 0);
                    }
                }

                lot[i] = currentCar;
                res += cars[occupiedCar];
                return true;
            }
        }

        return false;
    }
}
