package esi.atl.g53735.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 *
 * @author g53735
 */
public class BoardTest {

    /**
     * Test of winEnd method, of class Board.
     */
    @Test
    public void testWinEndOnlyWithZeroValuesNotWin() {
        Board instance = new Board(new int[][]{
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
        });
        boolean result = instance.winEnd();
        assertFalse(result);
    }

    /**
     * Test of winEnd method, of class Board.
     */
    @Test
    public void testWinEndWithDiffAndZeroValuesNotWin() {
        Board instance = new Board(new int[][]{
            {1024, 0, 0, 8},
            {0, 0, 2, 256},
            {512, 16, 0, 0},
            {0, 128, 0, 1024}
        });
        boolean result = instance.winEnd();
        assertFalse(result);
    }

    /**
     * Test of winEnd method, of class Board.
     */
    @Test
    public void testWinEndWithValuesAbove2048() {
        Board instance = new Board(new int[][]{
            {4096, 0, 0, 0},
            {0, 0, 2, 0},
            {2047, 0, 0, 0},
            {0, 512, 0, 2049}
        });
        boolean result = instance.winEnd();
        assertFalse(result);
    }

    /**
     * Test of winEnd method, of class Board.
     */
    @Test
    public void testWinEndBoardFullDiffValuesNot2048() {
        Board instance = new Board(new int[][]{
            {2, 2, 8, 8},
            {8, 32, 2, 4},
            {1024, 16, 128, 4},
            {32, 512, 8, 512}
        });
        boolean result = instance.winEnd();
        assertFalse(result);
    }

    /**
     * Test of winEnd method, of class Board.
     */
    @Test
    public void testWinEnd2048AtStartBoard() {
        Board instance = new Board(new int[][]{
            {2048, 2, 2, 0},
            {4, 4, 2, 0},
            {0, 16, 8, 16},
            {0, 128, 0, 128}
        });
        boolean result = instance.winEnd();
        assertTrue(result);
    }

    /**
     * Test of winEnd method, of class Board.
     */
    @Test
    public void testWinEnd2048AtEndBoard() {
        Board instance = new Board(new int[][]{
            {16, 8, 1024, 0},
            {4, 0, 2, 0},
            {0, 16, 1024, 16},
            {256, 0, 0, 2048}
        });
        boolean result = instance.winEnd();
        assertTrue(result);
    }

    /**
     * Test of loseEnd method, of class Board.
     */
    @Test
    public void testLoseEndOnlyZeroValuesFalse() {
        Board instance = new Board(new int[][]{
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
        });
        instance.addFreePlaces();
        boolean result = instance.loseEnd();
        assertFalse(result);
    }

    /**
     * Test of loseEnd method, of class Board.
     */
    @Test
    public void testLoseEndWithDiffAndZeroValuesFalse() {
        Board instance = new Board(new int[][]{
            {0, 8, 1024, 0},
            {128, 0, 2, 8},
            {0, 16, 1024, 8},
            {256, 0, 8, 32}
        });
        instance.addFreePlaces();
        boolean result = instance.loseEnd();
        assertFalse(result);
    }

    /**
     * Test of loseEnd method, of class Board.
     */
    @Test
    public void testLoseEndWithAllDiffValuesTrue() {
        Board instance = new Board(new int[][]{
            {4, 8, 2, 32},
            {2, 16, 128, 8},
            {128, 4, 32, 2},
            {16, 2, 16, 256}
        });
        instance.addFreePlaces();
        boolean result = instance.loseEnd();
        assertTrue(result);
    }

    /**
     * Test of randomValue method, of class Board.
     */
    @Test
    public void testRandomValueGoodValue() {
        Board instance = new Board();
        int result = instance.randomValue();
        assertTrue(result == 2 || result == 4);
    }

    /**
     * Test of randomValue method, of class Board.
     */
    @Test
    public void testRandomValueFalseValue() {
        Board instance = new Board();
        int result = instance.randomValue();
        assertFalse(result == 1 || result == 3);
    }

    /**
     * Test of setRandomValueBoard method, of class Board.
     */
    @Test
    public void testSetRandomValueBoardSetANumber() {
        Board instance = new Board(new int[][]{
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
        });
        instance.addFreePlaces();
        instance.setRandomValueBoard();
        boolean result = false;
        for (int lg = 0; lg < instance.getNbRow(); lg++) {
            for (int col = 0; col < instance.getNbColumn(); col++) {
                if (instance.getValue(lg, col) != 0) {
                    result = true;
                }
            }
        }
        assertTrue(result);
    }

    /**
     * Test of moveValues method, of class Board.
     */
    @Test
    public void testMoveValuesUp() {
        Direction direction = Direction.UP;
        Board instance = new Board(new int[][]{
            {2, 0, 0, 0},
            {0, 0, 0, 32},
            {4, 0, 8, 0},
            {0, 16, 0, 0}
        });
        instance.moveValues(direction);
        Board expResult = new Board(new int[][]{
            {2, 16, 8, 32},
            {4, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
        });
        assertArrayEquals(expResult.getSquares(), instance.getSquares());
    }

    /**
     * Test of moveValues method, of class Board.
     */
    @Test
    public void testMoveValuesSumAndUp() {
        Direction direction = Direction.UP;
        Board instance = new Board(new int[][]{
            {0, 4, 0, 2},
            {8, 4, 2, 0},
            {0, 0, 2, 2},
            {8, 16, 0, 32}
        });
        instance.moveValues(direction);
        Board expResult = new Board(new int[][]{
            {16, 8, 4, 4},
            {0, 16, 0, 32},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
        });
        assertArrayEquals(expResult.getSquares(), instance.getSquares());
    }

    /**
     * Test of moveValues method, of class Board.
     */
    @Test
    public void testMoveValuesFullBoardUp() {
        Direction direction = Direction.UP;
        Board instance = new Board(new int[][]{
            {16, 4, 256, 2},
            {8, 4, 32, 16},
            {4, 32, 1024, 2},
            {8, 16, 256, 32}
        });
        instance.moveValues(direction);
        Board expResult = new Board(new int[][]{
            {16, 8, 256, 2},
            {8, 32, 32, 16},
            {4, 16, 1024, 2},
            {8, 0, 256, 32}
        });
        assertArrayEquals(expResult.getSquares(), instance.getSquares());
    }

    /**
     * Test of moveValues method, of class Board.
     */
    @Test
    public void testMoveValuesFullBoardSumUp() {
        Direction direction = Direction.UP;
        Board instance = new Board(new int[][]{
            {16, 4, 256, 2},
            {16, 4, 256, 2},
            {8, 4, 64, 4},
            {8, 4, 64, 4}
        });
        instance.moveValues(direction);
        Board expResult = new Board(new int[][]{
            {32, 8, 512, 4},
            {16, 8, 128, 8},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
        });
        assertArrayEquals(expResult.getSquares(), instance.getSquares());
    }

    /**
     * Test of moveValues method, of class Board.
     */
    @Test
    public void testMoveValuesDownValueS() {
        Direction direction = Direction.DOWN;
        Board instance = new Board(new int[][]{
            {0, 2, 8, 32},
            {4, 0, 0, 0},
            {16, 0, 0, 128},
            {0, 0, 0, 0}
        });
        instance.moveValues(direction);
        Board expResult = new Board(new int[][]{
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {4, 0, 0, 32},
            {16, 2, 8, 128}
        });
        assertArrayEquals(expResult.getSquares(), instance.getSquares());
    }

    /**
     * Test of moveValues method, of class Board.
     */
    @Test
    public void testMoveValuesSumDown() {
        Direction direction = Direction.DOWN;
        Board instance = new Board(new int[][]{
            {16, 2, 8, 128},
            {16, 0, 0, 0},
            {0, 2, 8, 0},
            {0, 2, 0, 128}
        });
        instance.moveValues(direction);
        Board expResult = new Board(new int[][]{
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 2, 0, 0},
            {32, 4, 16, 256}
        });
        assertArrayEquals(expResult.getSquares(), instance.getSquares());
    }

    /**
     * Test of moveValues method, of class Board.
     */
    @Test
    public void testMoveValuesDownFailSum() {
        Direction direction = Direction.DOWN;
        Board instance = new Board(new int[][]{
            {16, 8, 8, 128},
            {64, 0, 128, 0},
            {16, 2, 8, 256},
            {64, 4, 128, 16}
        });
        instance.moveValues(direction);
        Board expResult = new Board(new int[][]{
            {16, 0, 8, 0},
            {64, 8, 128, 128},
            {16, 2, 8, 256},
            {64, 4, 128, 16}
        });
        assertArrayEquals(expResult.getSquares(), instance.getSquares());
    }

    /**
     * Test of moveValues method, of class Board.
     */
    @Test
    public void testMoveValuesDownFullBoard() {
        Direction direction = Direction.DOWN;
        Board instance = new Board(new int[][]{
            {2, 1024, 64, 256},
            {64, 32, 16, 8},
            {2, 256, 2, 128},
            {64, 512, 128, 256}
        });
        instance.moveValues(direction);
        Board expResult = new Board(new int[][]{
            {2, 1024, 64, 256},
            {64, 32, 16, 8},
            {2, 256, 2, 128},
            {64, 512, 128, 256}
        });
        assertArrayEquals(expResult.getSquares(), instance.getSquares());
    }

    /**
     * Test of moveValues method, of class Board.
     */
    @Test
    public void testMoveValuesDownFullBoardAndSum() {
        Direction direction = Direction.DOWN;
        Board instance = new Board(new int[][]{
            {16, 4, 256, 2},
            {16, 4, 256, 2},
            {8, 4, 64, 4},
            {8, 4, 64, 4}
        });
        instance.moveValues(direction);
        Board expResult = new Board(new int[][]{
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {32, 8, 512, 4},
            {16, 8, 128, 8}
        });
        assertArrayEquals(expResult.getSquares(), instance.getSquares());
    }

    /**
     * Test of moveValues method, of class Board.
     */
    @Test
    public void testMoveValuesLeftValueS() {
        Direction direction = Direction.LEFT;
        Board instance = new Board(new int[][]{
            {16, 0, 0, 2},
            {0, 0, 0, 256},
            {8, 4, 64, 0},
            {0, 4, 0, 0}
        });
        instance.moveValues(direction);
        Board expResult = new Board(new int[][]{
            {16, 2, 0, 0},
            {256, 0, 0, 0},
            {8, 4, 64, 0},
            {4, 0, 0, 0}
        });
        assertArrayEquals(expResult.getSquares(), instance.getSquares());
    }

    /**
     * Test of moveValues method, of class Board.
     */
    @Test
    public void testMoveValuesLeftValuesAndSum() {
        Direction direction = Direction.LEFT;
        Board instance = new Board(new int[][]{
            {16, 0, 0, 16},
            {256, 0, 256, 8},
            {4, 4, 64, 0},
            {2, 4, 0, 0}
        });
        instance.moveValues(direction);
        Board expResult = new Board(new int[][]{
            {32, 0, 0, 0},
            {512, 8, 0, 0},
            {8, 64, 0, 0},
            {2, 4, 0, 0}
        });
        assertArrayEquals(expResult.getSquares(), instance.getSquares());
    }

    /**
     * Test of moveValues method, of class Board.
     */
    @Test
    public void testMoveValuesLeftValuesFailSum() {
        Direction direction = Direction.LEFT;
        Board instance = new Board(new int[][]{
            {16, 8, 0, 16},
            {256, 2, 256, 0},
            {64, 4, 64, 0},
            {2, 16, 2, 8}
        });
        instance.moveValues(direction);
        Board expResult = new Board(new int[][]{
            {16, 8, 16, 0},
            {256, 2, 256, 0},
            {64, 4, 64, 0},
            {2, 16, 2, 8}
        });
        assertArrayEquals(expResult.getSquares(), instance.getSquares());

    }

    /**
     * Test of moveValues method, of class Board.
     */
    @Test
    public void testMoveValuesLeftValuesFullRow() {
        Direction direction = Direction.LEFT;
        Board instance = new Board(new int[][]{
            {16, 8, 32, 16},
            {256, 2, 256, 8},
            {64, 4, 64, 32},
            {2, 4, 128, 2}
        });
        instance.moveValues(direction);
        Board expResult = new Board(new int[][]{
            {16, 8, 32, 16},
            {256, 2, 256, 8},
            {64, 4, 64, 32},
            {2, 4, 128, 2}
        });
        assertArrayEquals(expResult.getSquares(), instance.getSquares());

    }

    /**
     * Test of moveValues method, of class Board.
     */
    @Test
    public void testMoveValuesRight() {
        Direction direction = Direction.RIGHT;
        Board instance = new Board(new int[][]{
            {32, 2, 0, 0},
            {4, 0, 0, 0},
            {128, 8, 0, 0},
            {0, 0, 0, 0}
        });
        instance.moveValues(direction);
        Board expResult = new Board(new int[][]{
            {0, 0, 32, 2},
            {0, 0, 0, 4},
            {0, 0, 128, 8},
            {0, 0, 0, 0}
        });
        assertArrayEquals(expResult.getSquares(), instance.getSquares());
    }

    /**
     * Test of moveValues method, of class Board.
     */
    @Test
    public void testMoveValuesRightSum() {
        Direction direction = Direction.RIGHT;
        Board instance = new Board(new int[][]{
            {0, 0, 2, 2},
            {0, 4, 4, 0},
            {8, 0, 0, 8},
            {2, 0, 2, 0}
        });
        instance.moveValues(direction);
        Board expResult = new Board(new int[][]{
            {0, 0, 0, 4},
            {0, 0, 0, 8},
            {0, 0, 0, 16},
            {0, 0, 0, 4}
        });
        assertArrayEquals(expResult.getSquares(), instance.getSquares());
    }

    /**
     * Test of moveValues method, of class Board.
     */
    @Test
    public void testMoveValuesRightFailSum() {
        Direction direction = Direction.RIGHT;
        Board instance = new Board(new int[][]{
            {4, 0, 2, 4},
            {16, 8, 16, 0},
            {4, 32, 0, 4},
            {16, 4, 2, 16}
        });
        instance.moveValues(direction);
        Board expResult = new Board(new int[][]{
            {0, 4, 2, 4},
            {0, 16, 8, 16},
            {0, 4, 32, 4},
            {16, 4, 2, 16}
        });
        assertArrayEquals(expResult.getSquares(), instance.getSquares());
    }

    /**
     * Test of moveValues method, of class Board.
     */
    @Test
    public void testMoveValuesRightFullBaordNotMove() {
        Direction direction = Direction.RIGHT;
        Board instance = new Board(new int[][]{
            {4, 2, 8, 16},
            {16, 2, 8, 32},
            {32, 1024, 512, 128},
            {64, 2, 256, 2}
        });
        instance.moveValues(direction);
        Board expResult = new Board(new int[][]{
            {4, 2, 8, 16},
            {16, 2, 8, 32},
            {32, 1024, 512, 128},
            {64, 2, 256, 2}
        });
        assertArrayEquals(expResult.getSquares(), instance.getSquares());
    }

    /**
     * Test of moveValues method, of class Board.
     */
    @Test
    public void testMoveValuesRightFullBaordAndSum() {
        Direction direction = Direction.RIGHT;
        Board instance = new Board(new int[][]{
            {2, 2, 4, 4},
            {16, 16, 8, 8},
            {32, 32, 128, 128},
            {64, 64, 256, 256}
        });
        instance.moveValues(direction);
        Board expResult = new Board(new int[][]{
            {0, 0, 4, 8},
            {0, 0, 32, 16},
            {0, 0, 64, 256},
            {0, 0, 128, 512}
        });
        assertArrayEquals(expResult.getSquares(), instance.getSquares());
    }
}
