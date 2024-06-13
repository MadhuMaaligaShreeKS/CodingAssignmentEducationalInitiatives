package CodingAssignment__.DesignPatterns.BehavioralPattern.MementoPattern;

public class Client {
    
        public static void main(String[] args) {
            TextEditor textEditor = new TextEditor();
    
            // Initial text
            System.out.println("Initial text: " + textEditor.getText());
    
            // Write some text
            textEditor.write("Hello, ");
            textEditor.write("world!");
    
            // Text after writing
            System.out.println("Text after writing: " + textEditor.getText());
    
            // Undo writing
            textEditor.undo();
            System.out.println("Text after undo: " + textEditor.getText());
    
            // Redo writing
            textEditor.redo();
            System.out.println("Text after redo: " + textEditor.getText());
        }
    }

