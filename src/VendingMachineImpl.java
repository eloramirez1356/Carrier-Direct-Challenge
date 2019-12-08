import java.util.*;

public class VendingMachineImpl implements VendingMachine, VendingMachineHardwareFunctions{

    private static final int MAX_NUMBER_PRODUCTS = 8;
    private List<Product> products;
    private int moneyAdded;

    public VendingMachineImpl(List<Product> products) throws Exception {
        if(products.size() > MAX_NUMBER_PRODUCTS){
            throw new Exception("Products exceeds max number: " + MAX_NUMBER_PRODUCTS);
        }
        this.products = products;
        this.moneyAdded = 0;
    }

    @Override
    public void buttonPress(Integer productPosition) {
        Product itemSelectedDetails = products.get(productPosition);
        String productName = itemSelectedDetails.getName();
        Integer productPrice = itemSelectedDetails.getPrice();
        if(moneyAdded>=productPrice){
            dispenseProduct(productPosition, productName);
            if(moneyAdded>productPrice){
                dispenseChange(moneyAdded-productPrice);
            }
            moneyAdded = 0;
        } else {
            showMessage("The price of " + productName + " is: " + productPrice);
        }
    }

    @Override
    public void addUserMoney(Integer cents) {
        moneyAdded = moneyAdded + cents;
    }

    @Override
    public void addProduct(Product product) {
        products.add(product);
        System.out.println("New product added: " + products.get(products.size()-1).getName() + " with price: " + products.get(products.size()-1).getPrice());
    }
}
