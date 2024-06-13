package CodingAssignmentEducationalInitiatives.DesignPatterns.CreationalPattern.FactoryPattern;

class CreditCard implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Paying $" + amount + " using Credit Card.");
    }
}