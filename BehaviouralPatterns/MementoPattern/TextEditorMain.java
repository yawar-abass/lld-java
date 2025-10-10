package BehaviouralPatterns.MementoPattern;

public class TextEditorMain {

    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        Caretaker caretaker = new Caretaker();

        editor.write("Hello world");
        caretaker.saveSate(editor);

        editor.write("hello everyone");
        caretaker.saveSate(editor);

        caretaker.undo(editor);
        System.out.println(editor.getContent());
    }
}
