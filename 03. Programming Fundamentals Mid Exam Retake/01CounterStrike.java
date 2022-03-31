import java.util.Scanner;

public class CounterStrike {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int energy = Integer.parseInt(console.nextLine());
        int wonBattle = 0;
        boolean notEnoughEnergy = false;
        String command = console.nextLine();
        while(!"End of battle".equals(command)) {
            int distance = Integer.parseInt(command);
            if (energy >= distance) {
                energy -= distance;
                wonBattle ++;
                if(wonBattle%3==0) energy += wonBattle;
            }
            else {
                notEnoughEnergy = true;
                break;
            }
            command = console.nextLine();
        }

        if (notEnoughEnergy)  System.out.printf("Not enough energy! Game ends with %d won battles and %d energy", wonBattle, energy);
        else System.out.printf("Won battles: %d. Energy left: %d", wonBattle, energy);
    }
}
