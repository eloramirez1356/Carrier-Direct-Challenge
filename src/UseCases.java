import java.util.ArrayList;
import java.util.List;

public class UseCases {
    public static void main(String[]args) throws Exception {
        /**
         * Initialization of the vending machine with the products
         */
        List<Product> products = new ArrayList<>();
        products.add(new Product("Cookies", 95));
        products.add(new Product("Chips", 45));
        products.add(new Product("Mineral Water", 50));
        products.add(new Product("Coffee", 90));
        products.add(new Product("Candy", 75));

        VendingMachineImpl vendingMachine = new VendingMachineImpl(products);

        /**
         * Use case 1: User press button 3 of the vending machine
         * and this shows the price
         */
        System.out.println("Use case 1:");
        vendingMachine.buttonPress(3);

        /**
         * Use case 2: User adds two quarters to the vending machine and press button 1,
         * dispensing the product 1 and the change of 5 cents
         */
        System.out.println("Use case 2:");
        vendingMachine.addUserMoney(25);
        vendingMachine.addUserMoney(25);
        vendingMachine.buttonPress(1);

        /**
         * Use case 3: Admin adds one new product to the vending machine
         */
        System.out.println("Use case 3:");
        vendingMachine.addProduct(new Product("Orange Juice", 99));
    }
}
