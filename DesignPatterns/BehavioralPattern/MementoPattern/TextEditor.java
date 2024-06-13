package CodingAssignmentEducationalInitiatives.DesignPatterns.BehavioralPattern.MementoPattern;

import java.util.Stack;
//Originator class
class TextEditor {
    private StringBuilder text = new StringBuilder();
    private Stack<Editor> undoStack = new Stack<>();
    private Stack<Editor> redoStack = new Stack<>();

    public void write(String newText) {
        undoStack.push(new Editor(text.toString()));
        text.append(newText);
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            redoStack.push(new Editor(text.toString()));
            text = new StringBuilder(undoStack.pop().getText());
        } else {
            System.out.println("Nothing to undo.");
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            undoStack.push(new Editor(text.toString()));
            text = new StringBuilder(redoStack.pop().getText());
        } else {
            System.out.println("Nothing to redo.");
        }
    }

    public String getText() {
        return text.toString();
    }
}