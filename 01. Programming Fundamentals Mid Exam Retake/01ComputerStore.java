import java.util.Scanner;

public class ComputerStore {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String price = console.nextLine();
        double allMoney = 0.0;
        while (!("special".equals(price) || "regular".equals(price) )){
            double pricePerPart = Double.parseDouble(price);
            if (pricePerPart <=0 ) {
                System.out.println("Invalid price!");
            }
            else allMoney += pricePerPart;
            price = console.nextLine();
        }
        double taxes = allMoney*0.2;
        double finalPrice = allMoney+taxes;
        if ("special".equals(price)) finalPrice *= 0.9;
        if (finalPrice>0) {
            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$%n", allMoney);
            System.out.printf("Taxes: %.2f$%n", taxes);
            System.out.println("-----------");
            System.out.printf("Total price: %.2f$", finalPrice);
        }
        else System.out.println("Invalid order!");
    }
}
