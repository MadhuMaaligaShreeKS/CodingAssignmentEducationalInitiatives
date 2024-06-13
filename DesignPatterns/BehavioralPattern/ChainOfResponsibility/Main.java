package CodingAssignment__.DesignPatterns.BehavioralPattern.ChainOfResponsibility;

public class Main {
    public static void main(String[] args) {
        // Create HandlerManager
        HandlerManager handlerManager = new HandlerManager();

        // Register handlers
        handlerManager.addHandler(new EmailSupportHandler());
        handlerManager.addHandler(new PhoneSupportHandler());

        // Create requests
        SupportRequest request1 = new SupportRequest("Email");
        SupportRequest request2 = new SupportRequest("Phone");
        SupportRequest request3 = new SupportRequest("WebForm"); // Added for demonstration

        // Process requests
        handlerManager.handleRequest(request1); // Handled by EmailSupportHandler
        handlerManager.handleRequest(request2); // Handled by PhoneSupportHandler
        handlerManager.handleRequest(request3); // No handler available
    }
}