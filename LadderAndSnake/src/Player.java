
// ---------------------------------------
// Midterm Project
// LadderAndSnake
// Written by: Chen Zhang, 2211111
// ---------------------------------------


public class Player {

    int sort;
    private int dice;

    private String name;

    private boolean same;

    private int position;

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public int getDice() {
        return dice;
    }



    public void setDice(int dice) {
        this.dice = dice;
    }

    public boolean isSame() {
        return same;
    }

    public void setSame(boolean same) {
        this.same = same;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(int i) {
        this.position = i;
    }

    public int getPosition() {
        return this.position;
    }
}

