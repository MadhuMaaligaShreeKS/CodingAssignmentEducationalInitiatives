package CodingAssignmentEducationalInitiatives.DesignPatterns.CreationalPattern.FactoryPattern;

class GooglePay implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Paying $" + amount + " using Google Pay.");
    }
}
