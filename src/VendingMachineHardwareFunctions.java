public interface VendingMachineHardwareFunctions {
    default void showMessage(String message) {
        System.out.println(message);
    }
    default void dispenseProduct(Integer productPosition, String
            productName) {
        String nullSafeProductName = (productName != null) ? productName
                : "ProductNum" + productPosition;
        System.out.println("Dispensing " + nullSafeProductName + " from position " + productPosition);
    }
    default void dispenseChange(Integer changeInCents) {
        System.out.println("Dispensing " + changeInCents + " cents");
    }
}
