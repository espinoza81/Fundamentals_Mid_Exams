import java.util.Arrays;
import java.util.Scanner;

public class TheLift {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int peopleWaiting = Integer.parseInt(console.nextLine());
        int[] currentBusyLift = Arrays.stream(console.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int maxPerWagon = 4;
        int countWagon = 0;
        for (int n:currentBusyLift) {
            if (n<4) countWagon++;
        }

        for (int i=0; i<currentBusyLift.length; i ++) {

            int freeSeatOnWagon = maxPerWagon - currentBusyLift[i];

            if (peopleWaiting>=freeSeatOnWagon) {
                peopleWaiting -= freeSeatOnWagon;
                currentBusyLift[i] = maxPerWagon;
                countWagon --;
            }
            else {
                //(peopleWaiting > 0 && peopleWaiting < maxPerWagon) {
                currentBusyLift[i] += peopleWaiting;
                peopleWaiting = 0;
            }

            if (peopleWaiting==0) break;
        }

        if (peopleWaiting>0) System.out.printf("There isn't enough space! %d people in a queue!%n", peopleWaiting);
        else if (countWagon>0) System.out.println("The lift has empty spots!");

        for (int n : currentBusyLift) {
            System.out.printf("%d ", n);
        }

    }
}
