package SnakeLadderLLD;

public class Cell {
    public int val;
    public JumpObj jump;

    public Cell(int val) {
        this.val = val;
    }

    public void SetJump(JumpObj jump) {
        this.jump = jump;
    }
}
