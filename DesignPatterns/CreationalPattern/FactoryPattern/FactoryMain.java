package CodingAssignmentEducationalInitiatives.DesignPatterns.CreationalPattern.FactoryPattern;

import java.util.*;

public class FactoryMain {
    public static void main(String[] args) {
        PaymentProcessorFactory factory = new PaymentProcessorFactory();
        try (Scanner scanner = new Scanner(System.in)) {
            // Get user input for payment method and amount
            System.out.println("Enter payment method (CreditCard, PayPal, GooglePay):");
            String methodType = scanner.nextLine();

            System.out.println("Enter amount to pay:");
            double amount = scanner.nextDouble();

            // Process the payment
            processPayment(factory, methodType, amount);
        }
    }

    private static void processPayment(PaymentProcessorFactory factory, String methodType, double amount) {
        PaymentMethod paymentMethod = factory.createPaymentMethod(methodType);
        if (paymentMethod != null) {
            paymentMethod.pay(amount);
        } else {
            System.out.println("Invalid payment method specified: " + methodType);
        }
        
    }
    
}
