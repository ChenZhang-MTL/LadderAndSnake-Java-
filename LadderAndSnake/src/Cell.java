

// ---------------------------------------
// Midterm Project
// LadderAndSnake
// Written by: Chen Zhang, 2211111
// ---------------------------------------

public class Cell {

    CellType cellType;

    int dest;

    private String upDownMsg;

    public Cell(CellType cellType) {
        this.cellType = cellType;
    }

    public Cell(CellType cellType, int dest) {
        this.cellType = cellType;
        this.dest = dest;
    }

    public CellType getType() {
        return cellType;
    }

    public int getDest() {
        return dest;
    }

    public void setDest(int dest) {
        this.dest = dest;
    }

    public CellType getCellType() {
        return cellType;
    }

    public void setCellType(CellType cellType) {
        this.cellType = cellType;
    }

    public String getUpDownMsg() {
        return upDownMsg;
    }

    public void setUpDownMsg(String upDownMsg) {
        this.upDownMsg = upDownMsg;
    }

    public Cell(CellType cellType, int dest, String upDownMsg) {
        this.cellType = cellType;
        this.dest = dest;
        this.upDownMsg = upDownMsg;
    }
}
