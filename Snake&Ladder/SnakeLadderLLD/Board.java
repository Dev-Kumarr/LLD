package SnakeLadderLLD;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Board {
    public Cell[][] cells;
    public int size;
    public int snakeCount;
    public int ladderCount;

    public Board(int size, int snakeCount, int ladderCount) {
        this.size = size;
        this.snakeCount = snakeCount;
        this.ladderCount = ladderCount;
        CreateCells();
    }

    private void CreateCells() {
        cells = new Cell[size][size];
        int val = 0;
        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) {
                for (int j = size - 1; j >= 0; j--) {
                    cells[i][j] = new Cell(val++);
                }
            } else {
                for (int j = 0; j < size; j++) {
                    cells[i][j] = new Cell(val++);
                }
            }
        }
        SetJumps();
    }

    private void SetJumps() {
        int snakes = 0, ladder = 0;
        Random rand = new Random();
        while (snakes++ < snakeCount) {
            int start = rand.nextInt(1, size * size - 1);
            int end = rand.nextInt(0, start - 1);
            JumpObj jump = new JumpObj(start, end);
            SetCellJumpFromValue(start, jump);
        }
        while (ladder++ < ladderCount) {
            int start = rand.nextInt(0, size * size - 1);
            int end = rand.nextInt(start + 1, size * size);

            JumpObj jump = new JumpObj(start, end);
            SetCellJumpFromValue(start, jump);
        }
    }

    private int[] GetCellIndexFromValue(int value) {
        int[] cord = new int[2];
        int r, c;
        r = value / size;
        if (r % 2 == 0) {
            c = value % size;
        } else {
            c = size - value % size - 1;
        }
        cord[0] = r;
        cord[1] = c;
        return cord;
    }

    private void SetCellJumpFromValue(int value, JumpObj jump) {
        int r, c;
        int[] cord = GetCellIndexFromValue(value);
        r = cord[0];
        c = cord[1];
        cells[r][c].SetJump(jump);
    }

    public int GetJumpOnCell(int val) {
        if (val >= size * size) {
            return val;
        }
        int[] cord = GetCellIndexFromValue(val);
        JumpObj jump = cells[cord[0]][cord[1]].jump;
        if (jump != null) {
            if (jump.start > jump.end) {
                System.out.println("Hit by a snake");
            } else {
                System.out.println("Climb a ladder");
            }
            return jump.end;
        }
        return val;
    }
}
