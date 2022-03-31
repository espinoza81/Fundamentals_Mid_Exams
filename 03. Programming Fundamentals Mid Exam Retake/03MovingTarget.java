import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MovingTarget {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        List<Integer> targets = Arrays.stream(console.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String command;
        while(!"End".equals(command = console.nextLine())) {
            String[] input = command.split(" ");
                int targetIndex = Integer.parseInt(input[1]);
                int powerValueRadius = Integer.parseInt(input[2]);
            switch (input[0]){
                case "Shoot":
                    if(targetIndex < targets.size() && targetIndex>=0) {
                        targets.set(targetIndex,targets.get(targetIndex)-powerValueRadius);
                        if (targets.get(targetIndex)<=0) targets.remove(targetIndex);
                    }
                    break;
                case "Add":
                    if(targetIndex < targets.size() && targetIndex>=0) targets.add(targetIndex, powerValueRadius);
                    else System.out.println("Invalid placement!");
                    break;
                case "Strike":
                    if (targetIndex-powerValueRadius < 0 || targetIndex+powerValueRadius >=targets.size()) System.out.println("Strike missed!");
                    else targets.subList(targetIndex - powerValueRadius, targetIndex + powerValueRadius+1).clear();
                    break;
            }
        }
        String result ="";
        if(targets.size()>0) result = targets.stream().map(Object::toString).collect(Collectors.joining("|"));
        System.out.println(result);
    }
}
