import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> files = new ArrayList<>();
        files.add("resources/SQUARE11.PNG");
        files.add("resources/SQUARE22.PNG");
        files.add("resources/SQUARE33.PNG");
        files.add("resources/LINEH5.PNG");
        files.add("resources/LINEV5.PNG");
        files.add("resources/LINEH4.PNG");
        files.add("resources/LINEV4.PNG");
        files.add("resources/LINEH3.PNG");
        files.add("resources/LINEV3.PNG");
        files.add("resources/LINEH2.PNG");
        files.add("resources/LINEV2.PNG");
        files.add("resources/GSmallLU.PNG");
        files.add("resources/GSmallLD.PNG");
        files.add("resources/GSmallRU.PNG");
        files.add("resources/GSmallRD.PNG");
        files.add("resources/GBigLU.PNG");
        files.add("resources/GBigLD.PNG");
        files.add("resources/GBigRU.PNG");
        files.add("resources/GBigRD.PNG");
        JFrame frame = new JFrame("1010!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(950, 1050);
        frame.setLocationRelativeTo(null);
        Field field = new Field(10, 10, files);
        Container cp = frame.getContentPane();
        frame.setLayout(new BorderLayout());
        cp.add(field, BorderLayout.CENTER);
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout());
        field.btn1 = new MyButton();
        field.buttonInit(field.btn1, files);
        field.btn1.setPreferredSize(new Dimension(300, 300));
        field.btn1.addMouseListener(field.figureMouseAdapter);
        jPanel.add(field.btn1, BorderLayout.EAST);
        field.btn2 = new MyButton();
        field.buttonInit(field.btn2, files);
        field.btn2.addMouseListener(field.figureMouseAdapter);
        field.btn2.setPreferredSize(new Dimension(300, 300));
        jPanel.add(field.btn2, BorderLayout.CENTER);
        field.btn3 = new MyButton();
        field.buttonInit(field.btn3, files);
        field.btn3.setPreferredSize(new Dimension(300, 300));
        field.btn3.addMouseListener(field.figureMouseAdapter);
        jPanel.add(field.btn3, BorderLayout.WEST);
        cp.add(jPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}
