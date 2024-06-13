package CodingAssignmentEducationalInitiatives.DesignPatterns.BehavioralPattern.ChainOfResponsibility;

import java.util.logging.Level;
import java.util.logging.Logger;
abstract class SupportHandler {
    private SupportHandler nextHandler;

    // Method to set the next handler in the chain
    public void setNextHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    // Method to handle the request
    public void handleRequest(SupportRequest request) {
        if (canHandle(request)) {
            processRequest(request);
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        } else {
            Logger.getLogger(SupportHandler.class.getName()).log(Level.WARNING, 
                "No handler available for this request: " + request.getRequestType());
        }
    }

    // Abstract methods to be implemented by concrete handlers
    protected abstract boolean canHandle(SupportRequest request);
    protected abstract void processRequest(SupportRequest request);
}