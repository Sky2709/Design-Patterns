package snakeAndLadder;

import java.util.concurrent.ThreadLocalRandom;

public class Board {
    Cell[][] cells;

    Board(int boardSize, int noOfSnakes, int noOfLadders) {
        initializeCells(boardSize);
        addSnakesAndLadders(cells, noOfSnakes, noOfLadders);
    }

    private void initializeCells(int boardSize) {
        cells = new Cell[boardSize][boardSize];

        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                Cell cell = new Cell();
                cells[i][j] = cell;
            }
        }
    }

    private void addSnakesAndLadders(Cell[][] cells, int noOfSnakes, int noOfLadders) {
        while (noOfSnakes > 0) {
            int snakeHead = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length - 1);
            int snakeTail = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length - 1);
            if (snakeTail >= snakeHead) {
                continue;
            }

            Jump snakeObj = new Jump();
            snakeObj.from = snakeHead;
            snakeObj.to = snakeTail;

            Cell cell = getCell(snakeHead);
            cell.jump = snakeObj;
            noOfSnakes--;
        }

        while (noOfLadders > 0) {
            int ladderHead = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length - 1);
            int ladderTail = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length - 1);
            if (ladderTail >= ladderHead) {
                continue;
            }

            Jump ladderObj = new Jump();
            ladderObj.from = ladderHead;
            ladderObj.to = ladderTail;

            Cell cell = getCell(ladderHead);
            cell.jump = ladderObj;
            noOfSnakes--;
        }
    }

    Cell getCell(int position) {
        int boardRow = position / cells.length;
        int boardCol = position % cells.length;
        return cells[boardRow][boardCol];
    }
}
