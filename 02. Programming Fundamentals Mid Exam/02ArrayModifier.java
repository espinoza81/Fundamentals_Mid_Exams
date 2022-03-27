import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int[] arrayStart = Arrays.stream(console.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String command = console.nextLine();
        while(!"end".equals(command)) {
            String[] index = command.split(" ");
            int indexFirst = 0;
            int indexSecond = 0;
            if (!"decrease".equals(index[0])) {
                indexFirst = Integer.parseInt(index[1]);
                indexSecond = Integer.parseInt(index[2]);
            }
            switch (index[0]){
                case "swap":
                    int temp = arrayStart[indexSecond];
                    arrayStart[indexSecond] = arrayStart[indexFirst];
                    arrayStart[indexFirst] = temp;
                    break;
                case "multiply":
                    arrayStart[indexFirst] *= arrayStart[indexSecond];
                    break;
                case "decrease":
                    for (int i = 0; i <arrayStart.length; i++){
                        arrayStart[i] --;
                    }
                    break;
            }
            command = console.nextLine();
        }
        String result = Arrays.stream(arrayStart).mapToObj(String::valueOf).collect(Collectors.joining(", "));
        System.out.println(result);
    }
}
