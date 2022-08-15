package LeetCode.Design;

public class MainDesign {
    public static void main(String[] args) {
        designHashMap();
    }

    public static void designHashMap() {
        DesignHashMap2_706 hashMap = new DesignHashMap2_706();
        hashMap.add(9);
        hashMap.remove(19);
        hashMap.add(14);
        hashMap.remove(19);
        hashMap.remove(9);
        hashMap.add(0);
        hashMap.add(3);
        hashMap.add(4);
        hashMap.add(0);
        hashMap.remove(9);
    }
}
