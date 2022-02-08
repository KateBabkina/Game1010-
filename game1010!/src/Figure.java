import java.util.ArrayList;

public class Figure {

    static enum TYPE {
        SQUARE11,
        SQUARE22,
        SQUARE33,
        LINEH5,
        LINEV5,
        LINEH4,
        LINEV4,
        LINEH3,
        LINEV3,
        LINEH2,
        LINEV2,
        GSmallLU,
        GSmallLD,
        GSmallRU,
        GSmallRD,
        GBigLU,
        GBigLD,
        GBigRU,
        GBigRD,
    }

    ArrayList<Position> positions = new ArrayList<>();
    ArrayList<Coord> coords = new ArrayList<>();
    Field field;
    TYPE type;

    public Figure(Field field) {
        this.field = field;
    }

    public Figure(int left, int top, TYPE type, Field field) throws MyException {
        this.field = field;
        this.type = type;
        if (type != null)
            switch (type) {
                case SQUARE11:
                    if (!addSQUARE11(left, top))
                        throw new MyException();
                    break;
                case SQUARE22:
                    if (!addSQUARE22(left, top))
                        throw new MyException();
                    break;
                case SQUARE33:
                    if (!addSQUARE33(left, top))
                        throw new MyException();
                    break;
                case LINEH5:
                    if (!addLINEH5(left, top))
                        throw new MyException();
                    break;
                case LINEV5:
                    if (!addLINEV5(left, top))
                        throw new MyException();
                    break;
                case LINEH4:
                    if (!addLINEH4(left, top))
                        throw new MyException();
                    break;
                case LINEV4:
                    if (!addLINEV4(left, top))
                        throw new MyException();
                    break;
                case LINEH3:
                    if (!addLINEH3(left, top))
                        throw new MyException();
                    break;
                case LINEV3:
                    if (!addLINEV3(left, top))
                        throw new MyException();
                    break;
                case LINEH2:
                    if (!addLINEH2(left, top))
                        throw new MyException();
                    break;
                case LINEV2:
                    if (!addLINEV2(left, top))
                        throw new MyException();
                    break;
                case GSmallLU:
                    if (!addGSmallLU(left, top))
                        throw new MyException();
                    break;
                case GSmallLD:
                    if (!addGSmallLD(left, top))
                        throw new MyException();
                    break;
                case GSmallRU:
                    if (!addGSmallRU(left, top))
                        throw new MyException();
                    break;
                case GSmallRD:
                    if (!addGSmallRD(left, top))
                        throw new MyException();
                    break;
                case GBigLU:
                    if (!addGBigLU(left, top))
                        throw new MyException();
                    break;
                case GBigLD:
                    if (!addGBigLD(left, top))
                        throw new MyException();
                    break;
                case GBigRU:
                    if (!addGBigRU(left, top))
                        throw new MyException();
                    break;
                case GBigRD:
                    if (!addGBigRD(left, top))
                        throw new MyException();
                    break;
            }

    }

    public boolean canBePlaced(int left, int top, TYPE type) {
        switch (type) {
            case SQUARE11:
                return checkSQUARE11(left, top);

            case SQUARE22:
                return checkSQUARE22(left, top);

            case SQUARE33:
                return checkSQUARE33(left, top);

            case LINEH5:
                return checkLINEH5(left, top);

            case LINEV5:
                return checkLINEV5(left, top);

            case LINEH4:
                return checkLINEH4(left, top);

            case LINEV4:
                return checkLINEV4(left, top);

            case LINEH3:
                return checkLINEH3(left, top);

            case LINEV3:
                return checkLINEV3(left, top);

            case LINEH2:
                return checkLINEH2(left, top);

            case LINEV2:
                return checkLINEV2(left, top);

            case GSmallLU:
                return checkGSmallLU(left, top);

            case GSmallLD:
                return checkGSmallLD(left, top);

            case GSmallRU:
                return checkGSmallRU(left, top);

            case GSmallRD:
                return checkGSmallRD(left, top);

            case GBigLU:
                return checkGBigLU(left, top);

            case GBigLD:
                return checkGBigLD(left, top);

            case GBigRU:
                return checkGBigRU(left, top);

            case GBigRD:
                return checkGBigRD(left, top);

        }
        return false;
    }

    public boolean checkPositions(ArrayList<Coord> coords) {
        for (Coord coord : coords) {
            if (coord.getX() >= field.getFieldHeight()) {
                return false;
            }
            if (coord.getY() >= field.getFieldWidth()) {
                return false;
            }

            Position pos = field.getPosition(coord.getX(), coord.getY());
            if (pos.getOwner() != null) {
                return false;
            }
        }
        return true;
    }

    public void addPosition(int left, int top) {
        Position pos = field.getPosition(left, top);
        positions.add(pos);
        pos.setOwner(this);
    }

    public TYPE getType() {
        return type;
    }

    public boolean addSQUARE11(int left, int top) {
        coords.clear();
        coords.add(new Coord(left, top));
        if (checkPositions(coords)) {
            addPosition(left, top);
            return true;
        }
        return false;
    }

    public boolean addSQUARE22(int left, int top) {
        coords.clear();
        coords.add(new Coord(left, top));
        coords.add(new Coord(left + 1, top));
        coords.add(new Coord(left, top + 1));
        coords.add(new Coord(left + 1, top + 1));
        if (checkPositions(coords)) {
            addPosition(left, top);
            addPosition(left + 1, top);
            addPosition(left, top + 1);
            addPosition(left + 1, top + 1);
            return true;
        }
        return false;
    }

    public boolean addSQUARE33(int left, int top) {
        coords.clear();
        coords.add(new Coord(left, top));
        coords.add(new Coord(left + 1, top));
        coords.add(new Coord(left, top + 1));
        coords.add(new Coord(left + 1, top + 1));
        coords.add(new Coord(left + 2, top));
        coords.add(new Coord(left + 2, top + 1));
        coords.add(new Coord(left + 2, top + 2));
        coords.add(new Coord(left, top + 2));
        coords.add(new Coord(left + 1, top + 2));
        if (checkPositions(coords)) {
            addPosition(left, top);
            addPosition(left + 1, top);
            addPosition(left, top + 1);
            addPosition(left + 1, top + 1);
            addPosition(left + 2, top);
            addPosition(left + 2, top + 1);
            addPosition(left + 2, top + 2);
            addPosition(left, top + 2);
            addPosition(left + 1, top + 2);
            return true;
        }
        return false;
    }

    public boolean addLINEH5(int left, int top) {
        coords.clear();
        coords.add(new Coord(left, top));
        coords.add(new Coord(left + 1, top));
        coords.add(new Coord(left + 2, top));
        coords.add(new Coord(left + 3, top));
        coords.add(new Coord(left + 4, top));
        if (checkPositions(coords)) {
            addPosition(left, top);
            addPosition(left + 1, top);
            addPosition(left + 2, top);
            addPosition(left + 3, top);
            addPosition(left + 4, top);
            return true;
        }
        return false;
    }

    public boolean addLINEV5(int left, int top) {
        coords.clear();
        coords.add(new Coord(left, top));
        coords.add(new Coord(left, top + 1));
        coords.add(new Coord(left, top + 2));
        coords.add(new Coord(left, top + 3));
        coords.add(new Coord(left, top + 4));
        if (checkPositions(coords)) {
            addPosition(left, top);
            addPosition(left, top + 1);
            addPosition(left, top + 2);
            addPosition(left, top + 3);
            addPosition(left, top + 4);
            return true;
        }
        return false;
    }

    public boolean addLINEH4(int left, int top) {
        coords.clear();
        coords.add(new Coord(left, top));
        coords.add(new Coord(left + 1, top));
        coords.add(new Coord(left + 2, top));
        coords.add(new Coord(left + 3, top));
        if (checkPositions(coords)) {
            addPosition(left, top);
            addPosition(left + 1, top);
            addPosition(left + 2, top);
            addPosition(left + 3, top);
            return true;
        }
        return false;
    }

    public boolean addLINEV4(int left, int top) {
        coords.clear();
        coords.add(new Coord(left, top));
        coords.add(new Coord(left, top + 1));
        coords.add(new Coord(left, top + 2));
        coords.add(new Coord(left, top + 3));
        if (checkPositions(coords)) {
            addPosition(left, top);
            addPosition(left, top + 1);
            addPosition(left, top + 2);
            addPosition(left, top + 3);
            return true;
        }
        return false;
    }

    public boolean addLINEH3(int left, int top) {
        coords.clear();
        coords.add(new Coord(left, top));
        coords.add(new Coord(left + 1, top));
        coords.add(new Coord(left + 2, top));
        if (checkPositions(coords)) {
            addPosition(left, top);
            addPosition(left + 1, top);
            addPosition(left + 2, top);
            return true;
        }
        return false;
    }

    public boolean addLINEV3(int left, int top) {
        coords.clear();
        coords.add(new Coord(left, top));
        coords.add(new Coord(left, top + 1));
        coords.add(new Coord(left, top + 2));
        if (checkPositions(coords)) {
            addPosition(left, top);
            addPosition(left, top + 1);
            addPosition(left, top + 2);
            return true;
        }
        return false;
    }

    public boolean addLINEH2(int left, int top) {
        coords.clear();
        coords.add(new Coord(left, top));
        coords.add(new Coord(left + 1, top));
        if (checkPositions(coords)) {
            addPosition(left, top);
            addPosition(left + 1, top);
            return true;
        }
        return false;
    }

    public boolean addLINEV2(int left, int top) {
        coords.clear();
        coords.add(new Coord(left, top));
        coords.add(new Coord(left, top + 1));
        if (checkPositions(coords)) {
            addPosition(left, top);
            addPosition(left, top + 1);
            return true;
        }
        return false;
    }

    public boolean addGSmallLU(int left, int top) {
        coords.clear();
        coords.add(new Coord(left, top));
        coords.add(new Coord(left, top + 1));
        coords.add(new Coord(left + 1, top));
        if (checkPositions(coords)) {
            addPosition(left, top);
            addPosition(left, top + 1);
            addPosition(left + 1, top);
            return true;
        }
        return false;
    }

    public boolean addGSmallLD(int left, int top) {
        coords.clear();
        coords.add(new Coord(left, top));
        coords.add(new Coord(left, top + 1));
        coords.add(new Coord(left + 1, top + 1));
        if (checkPositions(coords)) {
            addPosition(left, top);
            addPosition(left, top + 1);
            addPosition(left + 1, top + 1);
            return true;
        }
        return false;
    }

    public boolean addGSmallRU(int left, int top) {
        coords.clear();
        coords.add(new Coord(left, top));
        coords.add(new Coord(left + 1, top + 1));
        coords.add(new Coord(left + 1, top));
        if (checkPositions(coords)) {
            addPosition(left, top);
            addPosition(left + 1, top + 1);
            addPosition(left + 1, top);
            return true;
        }
        return false;
    }

    public boolean addGSmallRD(int left, int top) {
        coords.clear();
        coords.add(new Coord(left + 1, top));
        coords.add(new Coord(left, top + 1));
        coords.add(new Coord(left + 1, top + 1));
        if (checkPositions(coords)) {
            addPosition(left + 1, top);
            addPosition(left, top + 1);
            addPosition(left + 1, top + 1);
            return true;
        }
        return false;
    }

    public boolean addGBigLU(int left, int top) {
        coords.clear();
        coords.add(new Coord(left, top));
        coords.add(new Coord(left, top + 1));
        coords.add(new Coord(left, top + 2));
        coords.add(new Coord(left + 1, top));
        coords.add(new Coord(left + 2, top));
        if (checkPositions(coords)) {
            addPosition(left, top);
            addPosition(left, top + 1);
            addPosition(left, top + 2);
            addPosition(left + 1, top);
            addPosition(left + 2, top);
            return true;
        }
        return false;
    }

    public boolean addGBigLD(int left, int top) {
        coords.clear();
        coords.add(new Coord(left, top));
        coords.add(new Coord(left, top + 1));
        coords.add(new Coord(left, top + 2));
        coords.add(new Coord(left + 1, top + 2));
        coords.add(new Coord(left + 2, top + 2));
        if (checkPositions(coords)) {
            addPosition(left, top);
            addPosition(left, top + 1);
            addPosition(left, top + 2);
            addPosition(left + 1, top + 2);
            addPosition(left + 2, top + 2);
            return true;
        }
        return false;
    }

    public boolean addGBigRU(int left, int top) {
        coords.clear();
        coords.add(new Coord(left, top));
        coords.add(new Coord(left + 1, top));
        coords.add(new Coord(left + 2, top));
        coords.add(new Coord(left + 2, top + 1));
        coords.add(new Coord(left + 2, top + 2));
        if (checkPositions(coords)) {
            addPosition(left, top);
            addPosition(left + 1, top);
            addPosition(left + 2, top);
            addPosition(left + 2, top + 1);
            addPosition(left + 2, top + 2);
            return true;
        }
        return false;
    }

    public boolean addGBigRD(int left, int top) {
        coords.clear();
        coords.add(new Coord(left + 2, top));
        coords.add(new Coord(left + 2, top + 1));
        coords.add(new Coord(left + 2, top + 2));
        coords.add(new Coord(left + 1, top + 2));
        coords.add(new Coord(left, top + 2));
        if (checkPositions(coords)) {
            addPosition(left + 2, top);
            addPosition(left + 2, top + 1);
            addPosition(left + 2, top + 2);
            addPosition(left + 1, top + 2);
            addPosition(left, top + 2);
            return true;
        }
        return false;
    }

    public boolean checkSQUARE11(int left, int top) {
        coords.clear();
        coords.add(new Coord(left, top));
        boolean result = checkPositions(coords);
        return result;
    }

    public boolean checkSQUARE22(int left, int top) {
        coords.clear();
        coords.add(new Coord(left, top));
        coords.add(new Coord(left + 1, top));
        coords.add(new Coord(left, top + 1));
        coords.add(new Coord(left + 1, top + 1));
        boolean result = checkPositions(coords);
        return result;
    }

    public boolean checkSQUARE33(int left, int top) {
        coords.clear();
        coords.add(new Coord(left, top));
        coords.add(new Coord(left + 1, top));
        coords.add(new Coord(left, top + 1));
        coords.add(new Coord(left + 1, top + 1));
        coords.add(new Coord(left + 2, top));
        coords.add(new Coord(left + 2, top + 1));
        coords.add(new Coord(left + 2, top + 2));
        coords.add(new Coord(left, top + 2));
        coords.add(new Coord(left + 1, top + 2));
        boolean result = checkPositions(coords);
        return result;
    }

    public boolean checkLINEH5(int left, int top) {
        coords.clear();
        coords.add(new Coord(left, top));
        coords.add(new Coord(left + 1, top));
        coords.add(new Coord(left + 2, top));
        coords.add(new Coord(left + 3, top));
        coords.add(new Coord(left + 4, top));
        boolean result = checkPositions(coords);
        return result;
    }

    public boolean checkLINEV5(int left, int top) {
        coords.clear();
        coords.add(new Coord(left, top));
        coords.add(new Coord(left, top + 1));
        coords.add(new Coord(left, top + 2));
        coords.add(new Coord(left, top + 3));
        coords.add(new Coord(left, top + 4));
        boolean result = checkPositions(coords);
        return result;
    }

    public boolean checkLINEH4(int left, int top) {
        coords.clear();
        coords.add(new Coord(left, top));
        coords.add(new Coord(left + 1, top));
        coords.add(new Coord(left + 2, top));
        coords.add(new Coord(left + 3, top));
        boolean result = checkPositions(coords);
        return result;
    }

    public boolean checkLINEV4(int left, int top) {
        coords.clear();
        coords.add(new Coord(left, top));
        coords.add(new Coord(left, top + 1));
        coords.add(new Coord(left, top + 2));
        coords.add(new Coord(left, top + 3));
        boolean result = checkPositions(coords);
        return result;
    }

    public boolean checkLINEH3(int left, int top) {
        coords.clear();
        coords.add(new Coord(left, top));
        coords.add(new Coord(left + 1, top));
        coords.add(new Coord(left + 2, top));
        boolean result = checkPositions(coords);
        return result;
    }

    public boolean checkLINEV3(int left, int top) {
        coords.clear();
        coords.add(new Coord(left, top));
        coords.add(new Coord(left, top + 1));
        coords.add(new Coord(left, top + 2));
        boolean result = checkPositions(coords);
        return result;
    }

    public boolean checkLINEH2(int left, int top) {
        coords.clear();
        coords.add(new Coord(left, top));
        coords.add(new Coord(left + 1, top));
        boolean result = checkPositions(coords);
        return result;
    }

    public boolean checkLINEV2(int left, int top) {
        coords.clear();
        coords.add(new Coord(left, top));
        coords.add(new Coord(left, top + 1));
        boolean result = checkPositions(coords);
        return result;
    }

    public boolean checkGSmallLU(int left, int top) {
        coords.clear();
        coords.add(new Coord(left, top));
        coords.add(new Coord(left, top + 1));
        coords.add(new Coord(left + 1, top));
        boolean result = checkPositions(coords);
        return result;
    }

    public boolean checkGSmallLD(int left, int top) {
        coords.clear();
        coords.add(new Coord(left, top));
        coords.add(new Coord(left, top + 1));
        coords.add(new Coord(left + 1, top + 1));
        boolean result = checkPositions(coords);
        return result;
    }

    public boolean checkGSmallRU(int left, int top) {
        coords.clear();
        coords.add(new Coord(left, top));
        coords.add(new Coord(left + 1, top + 1));
        coords.add(new Coord(left + 1, top));
        boolean result = checkPositions(coords);
        return result;
    }

    public boolean checkGSmallRD(int left, int top) {
        coords.clear();
        coords.add(new Coord(left + 1, top));
        coords.add(new Coord(left, top + 1));
        coords.add(new Coord(left + 1, top + 1));
        boolean result = checkPositions(coords);
        return result;
    }

    public boolean checkGBigLU(int left, int top) {
        coords.clear();
        coords.add(new Coord(left, top));
        coords.add(new Coord(left, top + 1));
        coords.add(new Coord(left, top + 2));
        coords.add(new Coord(left + 1, top));
        coords.add(new Coord(left + 2, top));
        boolean result = checkPositions(coords);
        return result;
    }

    public boolean checkGBigLD(int left, int top) {
        coords.clear();
        coords.add(new Coord(left, top));
        coords.add(new Coord(left, top + 1));
        coords.add(new Coord(left, top + 2));
        coords.add(new Coord(left + 1, top + 2));
        coords.add(new Coord(left + 2, top + 2));
        boolean result = checkPositions(coords);
        return result;
    }

    public boolean checkGBigRU(int left, int top) {
        coords.clear();
        coords.add(new Coord(left, top));
        coords.add(new Coord(left + 1, top));
        coords.add(new Coord(left + 2, top));
        coords.add(new Coord(left + 2, top + 1));
        coords.add(new Coord(left + 2, top + 2));
        boolean result = checkPositions(coords);
        return result;
    }

    public boolean checkGBigRD(int left, int top) {
        coords.clear();
        coords.add(new Coord(left + 2, top));
        coords.add(new Coord(left + 2, top + 1));
        coords.add(new Coord(left + 2, top + 2));
        coords.add(new Coord(left + 1, top + 2));
        coords.add(new Coord(left, top + 2));
        boolean result = checkPositions(coords);
        return result;
    }


}
