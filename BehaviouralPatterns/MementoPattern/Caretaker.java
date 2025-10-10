package BehaviouralPatterns.MementoPattern;

import java.util.Stack;

public class Caretaker {
    private  final Stack<EditorMemento> history = new Stack<>();

    public  void saveSate(TextEditor editor){
        history.push(editor.save());
    }

    public  void undo(TextEditor editor){
        if(!history.empty()){
            history.pop();
            editor.restore(history.peek());
        }
    }

}
