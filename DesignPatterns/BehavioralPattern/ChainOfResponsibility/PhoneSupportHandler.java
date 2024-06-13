package CodingAssignment__.DesignPatterns.BehavioralPattern.ChainOfResponsibility;
import java.util.logging.Level;
import java.util.logging.Logger;
class PhoneSupportHandler extends SupportHandler {
    @Override
    protected boolean canHandle(SupportRequest request) {
        return "Phone".equals(request.getRequestType());
    }

    @Override
    protected void processRequest(SupportRequest request) {
        Logger.getLogger(PhoneSupportHandler.class.getName()).log(Level.INFO, 
            "PhoneSupportHandler: Handling phone request");
        // Handle the phone request
    }
}
