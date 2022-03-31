import java.util.Arrays;
import java.util.Scanner;

public class ShootForTheWin {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int[] targets = Arrays.stream(console.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int shootTarget = 0;
        String command;
        while(!"End".equals(command = console.nextLine())) {
            int targetIndex = Integer.parseInt(command);
            if (targetIndex>=targets.length || targets[targetIndex]==-1) {
                continue;
            }
            int reduceIncrease = targets[targetIndex];
            targets[targetIndex] = -1;
            shootTarget++;
            for (int i=0; i<targets.length; i++){
                if(targets[i]>reduceIncrease) targets[i] -= reduceIncrease;
                else if (targets[i] <= reduceIncrease && targets[i]>0) targets[i] += reduceIncrease;
            }
        }
        System.out.printf("Shot targets: %d -> ", shootTarget);
        for (int number : targets) {
            System.out.printf("%d ", number);
        }
    }
}
