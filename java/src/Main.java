import sample.Q1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        Hobbies hobbies = new Hobbies();
//        hobbies.add("Steve", "Fashion", "Piano", "Reading");
//        hobbies.add("Patty", "Drama", "Magic", "Pets");
//        hobbies.add("Chad", "Puzzles", "Pets", "Yoga");
//
//        System.out.println(Arrays.toString(hobbies.findAllHobbyists("Yoga").toArray()));
        Q1 sol = new Q1();
        int[] nums = new int[] {1, 2, 3, 4, 5, 7, 10};
        int target = 6;
        ArrayList<ArrayList<Integer>> pairs = sol.targetSum(nums, target);
        for (ArrayList<Integer> pair: pairs) {
            System.out.print(pair.get(0));
            System.out.print(", ");
            System.out.println(pair.get(1));
        }
    }
}
