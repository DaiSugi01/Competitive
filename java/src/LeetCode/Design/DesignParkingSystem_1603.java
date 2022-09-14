package LeetCode.Design;

public class DesignParkingSystem_1603 {
    class ParkingSystem {
        int[] slots;

        public ParkingSystem(int big, int medium, int small) {
            slots = new int[]{0, big, medium, small};
        }

        public boolean addCar(int carType) {
            if (slots[carType] > 0) {
                slots[carType]--;
                return true;
            } else {
                return false;
            }
        }
    }
}
