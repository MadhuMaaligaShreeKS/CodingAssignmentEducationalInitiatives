package CodingAssignment__.DesignPatterns.BehavioralPattern.ChainOfResponsibility;
import java.util.logging.Level;
import java.util.logging.Logger;

class EmailSupportHandler extends SupportHandler {
    @Override
    protected boolean canHandle(SupportRequest request) {
        return "Email".equals(request.getRequestType());
    }

    @Override
    protected void processRequest(SupportRequest request) {
        Logger.getLogger(EmailSupportHandler.class.getName()).log(Level.INFO, 
            "EmailSupportHandler: Handling email request");
        // Handle the email request
    }
}
