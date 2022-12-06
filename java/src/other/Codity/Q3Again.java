package other.Codity;

import java.util.ArrayDeque;
import java.util.Queue;

public class Q3Again {
    public static void main(String[] args) {
        Q3Again sol = new Q3Again();
//        System.out.println(sol.solution(new int[]{2, 8, 4, 3, 2}, 7, 11, 3));
        System.out.println(sol.solution(new int[]{5}, 4, 0, 3));
    }

    public int solution(int[] cars, int X, int Y, int Z) {
        GasStation gasStation = new GasStation(new Dispenser[]{
                new Dispenser(X),
                new Dispenser(Y),
                new Dispenser(Z),
        });

        Queue<Car> queue = new ArrayDeque<>();
        for (int car : cars)
            queue.add(new Car(car));

        while (queue.size() > 0 || gasStation.areCarsFuelingUp()) {
            Car currentCar = queue.peek();
            Dispenser freeDispenser = null;
            if (queue.size() > 0) {
                if (!gasStation.hasDispenserCapacity(currentCar.fuel))
                    return -1;

                freeDispenser = gasStation.getFreeDispenser(currentCar.fuel);
            }

            if (freeDispenser != null && queue.size() > 0) {
                freeDispenser.car = queue.poll();
            } else {

            }
        }
    }

    class Car {
        int fuel;
        int waitTime;

        public Car(int fuel) {
            this.fuel = fuel;
            this.waitTime = 0;
        }
    }


    class GasStation {
        Dispenser[] dispensers;

        public GasStation(Dispenser[] dispensers) {
            this.dispensers = dispensers;
        }

        public resolveFuelUp() {

        }

        public boolean hasDispenserCapacity(int fuelNeed) {
            for (Dispenser dispenser : dispensers) {
                if (dispenser.fuelCapacity >= fuelNeed)
                    return true;
            }

            return false;
        }

        public Dispenser getFreeDispenser(int fuelNeed) {
            for (Dispenser dispenser : dispensers) {
                if (dispenser.fuelCapacity >= fuelNeed && dispenser.car == null)
                    return dispenser;
            }

            return null;
        }

        public boolean areCarsFuelingUp() {
            for (Dispenser car : dispensers)
                if (car != null) return true;

            return false;
        }
    }

    class Dispenser {
        int fuelCapacity;
        Car car;

        public Dispenser(int fuelCapacity) {
            this.fuelCapacity = fuelCapacity;
            car = null;
        }
    }
}
