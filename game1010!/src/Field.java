import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

public class Field extends JPanel {

    private int fieldWidth;
    private int fieldHeight;
    private Position[][] field;
    MouseAdapter positionMouseAdapter = new PositionMouseAdapter(this);
    MouseAdapter figureMouseAdapter = new FigureMouseAdapter();
    Figure.TYPE curType;
    public MyButton btn1;
    public MyButton btn2;
    public MyButton btn3;
    public MyButton curBtn;
    ArrayList<String> files;


    public Field(int fieldWidth, int fieldHeight, ArrayList<String> files) {
        this.files = files;
        this.fieldWidth = fieldWidth;
        this.fieldHeight = fieldHeight;
        this.field = new Position[fieldWidth][fieldHeight];
        setLayout(new GridLayout(fieldHeight, fieldWidth));
        init();
        setPositionMouseAdapter(positionMouseAdapter);
        refresh();
    }

    public void init() {
        for (int columnIndex = 0; columnIndex < fieldWidth; columnIndex++) {
            for (int rowIndex = 0; rowIndex < fieldHeight; rowIndex++) {
                Position newPosition = new Position(columnIndex, rowIndex);
                field[rowIndex][columnIndex] = newPosition;
                add(newPosition);
            }
        }
        refresh();
    }

    public void refresh() {
        revalidate();
        repaint();
    }

    public Position getPosition(int x, int y) {
        return field[x][y];
    }

    public int getFieldWidth() {
        return fieldWidth;
    }

    public int getFieldHeight() {
        return fieldHeight;
    }

    public void setPositionMouseAdapter(MouseAdapter positionMouseAdapter) {
        for (int columnIndex = 0; columnIndex < fieldWidth; columnIndex++) {
            for (int rowIndex = 0; rowIndex < fieldHeight; rowIndex++) {
                field[columnIndex][rowIndex].addMouseListener(positionMouseAdapter);
            }
        }
    }

    public void checkField() {
        boolean clearline;
        // линии по вертикали
        for (int columnIndex = 0; columnIndex < fieldWidth; columnIndex++) {
            clearline = true;
            for (int rowIndex = 0; rowIndex < fieldHeight; rowIndex++) {
                Position pos = getPosition(columnIndex, rowIndex);
                if (pos.getOwner() == null) {
                    clearline = false;
                    break;
                }
            }
            if (clearline) {clearColumn(columnIndex);}
        }
        // линии по горизонтали
        for (int rowIndex = 0; rowIndex < fieldHeight; rowIndex++) {
            clearline = true;
            for (int columnIndex = 0; columnIndex < fieldWidth; columnIndex++) {
                Position pos = getPosition(columnIndex, rowIndex);
                if (pos.getOwner() == null) {
                    clearline = false;
                    break;
                }
            }
            if (clearline) {clearRow(rowIndex);}
        }
    }

    public void clearColumn(int columnIndex) {
        for (int rowIndex = 0; rowIndex < fieldHeight; rowIndex++) {
            Position pos = getPosition(columnIndex, rowIndex);
            pos.setOwner(null);
        }
        refresh();
    }

    public void clearRow(int rowIndex) {
        for (int columnIndex = 0; columnIndex < fieldWidth; columnIndex++) {
            Position pos = getPosition(columnIndex, rowIndex);
            pos.setOwner(null);
        }
        refresh();
    }

    private class PositionMouseAdapter extends MouseAdapter {
        Field field;

        public PositionMouseAdapter(Field field) {
            this.field = field;
        }

        @Override
        public void mousePressed(MouseEvent event) {
            Position target = (Position) event.getSource();
            int row = target.getColumnIndex();
            int col = target.getRowIndex();
            try {
                Figure figure = new Figure(col, row, curType, field);
                checkField();
                curBtn.setType(null);
                curType = null;
                image(curBtn, "resources/null.PNG");
                if (btn1.getType() == null && btn2.getType() == null && btn3.getType() == null) {
                    randomFigures();
                }
                if (!checkEnd()) {
                    image(btn1, "resources/gameOver.PNG");
                    image(btn2, "resources/newGame.PNG");
                    btn2.addActionListener(new GameStartActionListener());
                    image(btn3, "resources/gameOver.PNG");
                }
            } catch (MyException e) {
                e.printStackTrace();
            }
            refresh();
        }
    }

    private class FigureMouseAdapter extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent event) {
            curBtn = (MyButton) event.getSource();
            curType = curBtn.getType();
            refresh();
        }
    }

    public void image(MyButton btn, String file) {
        try {
            Image img = ImageIO.read(getClass().getResource(file));
            btn.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void buttonInit(MyButton btn, ArrayList<String> files) {
        Random rnd = new Random();
        int x = rnd.nextInt(19);
        switch (x) {
            case 0:
                btn.setType(Figure.TYPE.SQUARE11);
                image(btn, files.get(0));
                break;
            case 1:
                btn.setType(Figure.TYPE.SQUARE22);
                image(btn, files.get(1));
                break;
            case 2:
                btn.setType(Figure.TYPE.SQUARE33);
                image(btn, files.get(2));
                break;
            case 3:
                btn.setType(Figure.TYPE.LINEH5);
                image(btn, files.get(3));
                break;
            case 4:
                btn.setType(Figure.TYPE.LINEV5);
                image(btn, files.get(4));
                break;
            case 5:
                btn.setType(Figure.TYPE.LINEH4);
                image(btn, files.get(5));
                break;
            case 6:
                btn.setType(Figure.TYPE.LINEV4);
                image(btn, files.get(6));
                break;
            case 7:
                btn.setType(Figure.TYPE.LINEH3);
                image(btn, files.get(7));
                break;
            case 8:
                btn.setType(Figure.TYPE.LINEV3);
                image(btn, files.get(8));
                break;
            case 9:
                btn.setType(Figure.TYPE.LINEH2);
                image(btn, files.get(9));
                break;
            case 10:
                btn.setType(Figure.TYPE.LINEV2);
                image(btn, files.get(10));
                break;
            case 11:
                btn.setType(Figure.TYPE.GSmallLU);
                image(btn, files.get(11));
                break;
            case 12:
                btn.setType(Figure.TYPE.GSmallLD);
                image(btn, files.get(12));
                break;
            case 13:
                btn.setType(Figure.TYPE.GSmallRU);
                image(btn, files.get(13));
                break;
            case 14:
                btn.setType(Figure.TYPE.GSmallRD);
                image(btn, files.get(14));
                break;
            case 15:
                btn.setType(Figure.TYPE.GBigLU);
                image(btn, files.get(15));
                break;
            case 16:
                btn.setType(Figure.TYPE.GBigLD);
                image(btn, files.get(16));
                break;
            case 17:
                btn.setType(Figure.TYPE.GBigRU);
                image(btn, files.get(17));
                break;
            case 18:
                btn.setType(Figure.TYPE.GBigRD);
                image(btn, files.get(18));
                break;
        }
        btn.repaint();
    }

    public void randomFigures() {
        buttonInit(btn1, files);
        buttonInit(btn2, files);
        buttonInit(btn3, files);
    }

    public boolean checkEnd() {
        Figure figure = new Figure(this);
        for (int columnIndex = 0; columnIndex < fieldWidth; columnIndex++) {
            for (int rowIndex = 0; rowIndex < fieldHeight; rowIndex++) {
                if (btn1.getType() != null) {
                    if (figure.canBePlaced(columnIndex, rowIndex, btn1.getType())) {
                        return true;
                    }
                }

                if (btn2.getType() != null) {
                    if (figure.canBePlaced(columnIndex, rowIndex, btn2.getType())) {
                        return true;
                    }
                }

                if (btn3.getType() != null) {
                    if (figure.canBePlaced(columnIndex, rowIndex, btn3.getType())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
