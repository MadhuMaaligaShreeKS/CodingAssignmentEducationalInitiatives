package CodingAssignment__.DesignPatterns.BehavioralPattern.ChainOfResponsibility;

class SupportRequest {
    private final String requestType;

    public SupportRequest(String requestType) {
        this.requestType = requestType;
    }

    public String getRequestType() {
        return requestType;
    }
}

