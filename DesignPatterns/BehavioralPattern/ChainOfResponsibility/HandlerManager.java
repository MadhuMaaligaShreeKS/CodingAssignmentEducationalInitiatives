package CodingAssignmentEducationalInitiatives.DesignPatterns.BehavioralPattern.ChainOfResponsibility;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;

class HandlerManager {
    private final List<SupportHandler> handlers = new ArrayList<>();

    // Method to add a handler to the manager
    public void addHandler(SupportHandler handler) {
        if (!handlers.isEmpty()) {
            handlers.get(handlers.size() - 1).setNextHandler(handler);
        }
        handlers.add(handler);
    }

    // Method to handle a request
    public void handleRequest(SupportRequest request) {
        if (!handlers.isEmpty()) {
            handlers.get(0).handleRequest(request);
        } else {
            Logger.getLogger(HandlerManager.class.getName()).log(Level.WARNING, 
                "No handlers registered to handle the request.");
        }
    }
}
