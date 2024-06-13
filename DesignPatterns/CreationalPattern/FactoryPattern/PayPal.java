package CodingAssignmentEducationalInitiatives.DesignPatterns.CreationalPattern.FactoryPattern;

class PayPal implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Paying $" + amount + " using PayPal.");
    }
}
