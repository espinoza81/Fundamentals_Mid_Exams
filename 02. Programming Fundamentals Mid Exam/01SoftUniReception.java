import java.util.Scanner;

public class SoftUniReception {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int employerOne = Integer.parseInt(console.nextLine());
        int employerTwo = Integer.parseInt(console.nextLine());
        int employerThree = Integer.parseInt(console.nextLine());
        int students = Integer.parseInt(console.nextLine());

        int studentsPerHour = employerOne + employerTwo + employerThree;
        double hourToWork = Math.ceil(students*1.0/studentsPerHour);
        double rest = Math.floor(hourToWork/3);
        if (hourToWork%3==0 && rest>0) rest--;

        System.out.printf("Time needed: %.0fh.", hourToWork+rest);
    }
}
