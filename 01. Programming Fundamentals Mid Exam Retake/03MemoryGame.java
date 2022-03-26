import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MemoryGame {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        List<String> elements = Arrays.stream(console.nextLine().split(" ")).collect(Collectors.toList());
        String tryToFind = console.nextLine();
        int moves = 0;
        boolean elementIsEmpty = true;
        while (!"end".equals(tryToFind)){
            moves ++;
            int[] index = Arrays.stream(tryToFind.split(" ")).mapToInt(Integer::parseInt).toArray();
            int firstIndex = index[0];
            int secondIndex = index[1];
            if (firstIndex==secondIndex || firstIndex<0 || firstIndex>=elements.size() || secondIndex<0 || secondIndex>=elements.size()) {
                String elementToAdd ="-" + moves + "a";
                int position = elements.size()/2;
                elements.add(position, elementToAdd);
                elements.add(position+1, elementToAdd);
                System.out.println("Invalid input! Adding additional elements to the board");
            }
            else if (elements.get(firstIndex).equals(elements.get(secondIndex))){
                if (firstIndex>secondIndex){
                    int temp = secondIndex;
                    secondIndex = firstIndex;
                    firstIndex = temp;
                }
                String find = elements.get(firstIndex);
                elements.remove(secondIndex);
                elements.remove(firstIndex);
                System.out.printf("Congrats! You have found matching elements - %s!%n", find);
                if (elements.size()==0) {
                    elementIsEmpty = false;
                    System.out.printf("You have won in %d turns!", moves);
                    break;
                }
            }
            else System.out.println("Try again!");
            tryToFind = console.nextLine();
        }
        if (elementIsEmpty) {
            System.out.println("Sorry you lose :(");
            System.out.println(String.join(" ", elements));
        }
    }
}
