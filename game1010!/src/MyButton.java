import javax.swing.*;

public class MyButton extends JButton {
    Figure.TYPE type;

    public MyButton() {
    }

    public MyButton(Figure.TYPE type) {
        this.type = type;
    }

    public Figure.TYPE getType() {
        return type;
    }

    public void setType(Figure.TYPE type) {
        this.type = type;
    }

}
