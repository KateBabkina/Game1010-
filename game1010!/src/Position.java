import javax.swing.*;
import java.awt.*;

public class Position extends JButton {
    private int columnIndex;
    private int rowIndex;
    private Figure owner = null;

    Position(int columnIndex, int rowIndex) {
        this.columnIndex = columnIndex;
        this.rowIndex = rowIndex;
        setEnabled(true);
        setBackground(Color.LIGHT_GRAY);
    }

    public int getColumnIndex() {
        return columnIndex;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public Figure getOwner() {
        return owner;
    }

    public void setOwner(Figure owner) {
        this.owner = owner;
        if (owner != null) {
            switch (owner.getType()) {
                case SQUARE11:
                    setBackground(Color.PINK);
                    break;
                case SQUARE22:
                    setBackground(Color.CYAN);
                    break;
                case SQUARE33:
                    setBackground(Color.GREEN);
                    break;
                case LINEH5:
                    setBackground(Color.MAGENTA);
                    break;
                case LINEV5:
                    setBackground(Color.MAGENTA);
                    break;
                case LINEH4:
                    setBackground(Color.BLUE);
                    break;
                case LINEV4:
                    setBackground(Color.BLUE);
                    break;
                case LINEH3:
                    setBackground(Color.BLACK);
                    break;
                case LINEV3:
                    setBackground(Color.BLACK);
                    break;
                case LINEH2:
                    setBackground(Color.ORANGE);
                    break;
                case LINEV2:
                    setBackground(Color.ORANGE);
                    break;
                case GSmallLU:
                    setBackground(Color.YELLOW);
                    break;
                case GSmallLD:
                    setBackground(Color.YELLOW);
                    break;
                case GSmallRU:
                    setBackground(Color.YELLOW);
                    break;
                case GSmallRD:
                    setBackground(Color.YELLOW);
                    break;
                case GBigLU:
                    setBackground(Color.RED);
                    break;
                case GBigLD:
                    setBackground(Color.RED);
                    break;
                case GBigRU:
                    setBackground(Color.RED);
                    break;
                case GBigRD:
                    setBackground(Color.RED);
                    break;
            }
        } else setBackground(Color.LIGHT_GRAY);
    }
}
