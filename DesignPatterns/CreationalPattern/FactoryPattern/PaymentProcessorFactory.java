package CodingAssignmentEducationalInitiatives.DesignPatterns.CreationalPattern.FactoryPattern;
import java.util.*;
class PaymentProcessorFactory {
    private static final Map<String, Class<? extends PaymentMethod>> registeredMethods = new HashMap<>();

    // Register payment methods
    static {
        registeredMethods.put("CREDITCARD", CreditCard.class);
        registeredMethods.put("PAYPAL", PayPal.class);
        registeredMethods.put("GOOGLEPAY", GooglePay.class);
    }

    // Factory method to create payment methods based on method type
    public PaymentMethod createPaymentMethod(String methodType) {
        Class<? extends PaymentMethod> paymentClass = registeredMethods.get(methodType.toUpperCase());
        if (paymentClass != null) {
            try {
                return paymentClass.getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                throw new IllegalArgumentException("Error creating payment method", e);
            }
        } else {
            return null;
        }
    }

    // Method to register new payment methods
    public static void registerPaymentMethod(String methodType, Class<? extends PaymentMethod> paymentClass) {
        registeredMethods.put(methodType.toUpperCase(), paymentClass);
    }
}
