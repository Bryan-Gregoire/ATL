package esi.atl.g53735.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 * @author Utilisateur
 */
public class BoardTest {

    /**
     * Test of sumScore method, of class Board.
     */
    @Test
    public void testSumScore() {
        int addToScore = 2048;
        Board instance = new Board();
        int result = 2048;
        instance.sumScore(addToScore);
        int expResult = instance.getScore();
        assertEquals(expResult, result);
    }

    /**
     * Test of winEnd method, of class Board.
     */
    @Test
    public void testWinEndOnlyWithZeroValuesNotWin() {
        Board instance = new Board();
        boolean result = instance.winEnd();
        assertFalse(result);
    }

    /**
     * Test of winEnd method, of class Board.
     */
    @Test
    public void testWinEndWithDiffValuesNotWin() {
        Board instance = new Board();
        instance.setValue(0, 0, 1024);
        instance.setValue(1, 2, 2);
        instance.setValue(3, 1, 128);
        instance.setValue(3, 3, 1024);
        boolean result = instance.winEnd();
        assertFalse(result);
    }

    /**
     * Test of winEnd method, of class Board.
     */
    @Test
    public void testWinEndWithValuesAbove2048() {
        Board instance = new Board();
        instance.setValue(0, 0, 4096);
        instance.setValue(1, 2, 2);
        instance.setValue(3, 1, 512);
        instance.setValue(3, 3, 4096);
        boolean result = instance.winEnd();
        assertFalse(result);
    }

    /**
     * Test of winEnd method, of class Board.
     */
    @Test
    public void testWinEnd2048AtStartBoard() {
        Board instance = new Board();
        instance.setValue(0, 0, 2048);
        instance.setValue(1, 2, 2);
        instance.setValue(3, 1, 128);
        instance.setValue(3, 3, 1024);
        boolean result = instance.winEnd();
        assertTrue(result);
    }

    /**
     * Test of winEnd method, of class Board.
     */
    @Test
    public void testWinEnd2048AtEndBoard() {
        Board instance = new Board();
        instance.setValue(0, 0, 1024);
        instance.setValue(1, 2, 64);
        instance.setValue(3, 1, 256);
        instance.setValue(3, 3, 2048);
        boolean result = instance.winEnd();
        assertTrue(result);
    }

    /**
     * Test of loseEnd method, of class Board.
     */
    @Test
    public void testLoseEndWithZeroValues() {
        Board instance = new Board();
        boolean result = instance.loseEnd();
        assertFalse(result);
    }

    /**
     * Test of loseEnd method, of class Board.
     */
    @Test
    public void testLoseEndWithDiffValuesButFalse() {
        Board instance = new Board();
        instance.setValue(0, 0, 2);
        instance.setValue(1, 0, 128);
        instance.setValue(1, 3, 8);
        instance.setValue(2, 3, 8);
        instance.setValue(3, 2, 8);
        instance.setValue(3, 3, 32);
        boolean result = instance.loseEnd();
        assertFalse(result);
    }

    /**
     * Test of loseEnd method, of class Board.
     */
    @Test
    public void testLoseEndWithAllDiffValues() {
        Board instance = new Board();
        int value = 0;
        for (int lg = 0; lg < instance.getNbRow(); lg++) {
            for (int col = 0; col < instance.getNbColumn(); col++) {
                value += value + 2;
                instance.setValue(lg, col, value);
            }
        }
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
        Board instance = new Board();
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
     * Test of doubleValues method, of class Board.
     */
    @Test
    public void testDoubleValues() {
        Board instance = new Board();
        instance.setValue(0, 0, 64);
        int expResult = 128;
        int result = instance.doubleValues(0, 0);
        assertEquals(expResult, result);
    }

    /**
     * Test of doubleValues method, of class Board.
     */
    @Test
    public void testDoubleValues2() {
        Board instance = new Board();
        instance.setValue(3, 3, 1024);
        int expResult = 2048;
        int result = instance.doubleValues(3, 3);
        assertEquals(expResult, result);
    }

    /**
     * Test of moveValues method, of class Board.
     */
    @Test
    public void testMoveValuesUp() {
        Direction direction = Direction.UP;
        Board instance = new Board();
        //Fair un parcours pour tout mettre a zero car j'ai un random.
        for (int lg = 0; lg < instance.getNbRow(); lg++) {
            for (int col = 0; col < instance.getNbColumn(); col++) {
                if (instance.getValue(lg, col) != 0) {
                    instance.setValue(lg, col, 0);
                    lg = 4;
                    col = 4;
                }
            }
        }
        instance.setValue(0, 0, 2);
        instance.setValue(1, 2, 8);
        instance.setValue(3, 1, 16);
        instance.setValue(2, 3, 32);
        instance.moveValues(direction);
        int result = instance.getValue(0, 0);
        int result2 = instance.getValue(0, 2);
        int result3 = instance.getValue(0, 1);
        int result4 = instance.getValue(0, 3);
        int expResult = 2;
        int expResult2 = 8;
        int expResult3 = 16;
        int expResult4 = 32;
        assertEquals(expResult, result);
        assertEquals(expResult2, result2);
        assertEquals(expResult3, result3);
        assertEquals(expResult4, result4);
    }

    /**
     * Test of moveValues method, of class Board.
     */
    @Test
    public void testMoveValuesSumAndUp() {
        Direction direction = Direction.UP;
        Board instance = new Board();
        //Fair un parcours pour tout mettre a zero car j'ai un random.
        for (int lg = 0; lg < instance.getNbRow(); lg++) {
            for (int col = 0; col < instance.getNbColumn(); col++) {
                if (instance.getValue(lg, col) != 0) {
                    instance.setValue(lg, col, 0);
                    lg = 4;
                    col = 4;
                }
            }
        }
        instance.setValue(2, 3, 2);
        instance.setValue(3, 3, 2);
        instance.setValue(1, 1, 4);
        instance.setValue(2, 1, 4);
        instance.moveValues(direction);
        int result = instance.getValue(0, 3);
        int result2 = instance.getValue(2, 3);
        int result3 = instance.getValue(3, 3);
        int result4 = instance.getValue(0, 1);
        int result5 = instance.getValue(1, 1);
        int result6 = instance.getValue(2, 1);
        int expResult = 4;
        int expResult2 = 0;
        int expResult3 = 0;
        int expResult4 = 8;
        int expResult5 = 0;
        int expResult6 = 0;
        assertEquals(expResult, result);
        assertEquals(expResult2, result2);
        assertEquals(expResult3, result3);
        assertEquals(expResult4, result4);
        assertEquals(expResult5, result5);
        assertEquals(expResult6, result6);
    }

    /**
     * Test of moveValues method, of class Board.
     */
    @Test
    public void testMoveValuesFullColUp() {
        Direction direction = Direction.UP;
        Board instance = new Board();
        //Fair un parcours pour tout mettre a zero car j'ai un random.
        for (int lg = 0; lg < instance.getNbRow(); lg++) {
            for (int col = 0; col < instance.getNbColumn(); col++) {
                if (instance.getValue(lg, col) != 0) {
                    instance.setValue(lg, col, 0);
                    lg = 4;
                    col = 4;
                }
            }
        }
        instance.setValue(0, 0, 256);
        instance.setValue(1, 0, 32);
        instance.setValue(2, 0, 1024);
        instance.setValue(3, 0, 256);
        instance.moveValues(direction);
        int result = instance.getValue(0, 0);
        int result2 = instance.getValue(1, 0);
        int result3 = instance.getValue(2, 0);
        int result4 = instance.getValue(3, 0);
        int expResult = 256;
        int expResult2 = 32;
        int expResult3 = 1024;
        int expResult4 = 256;
        assertEquals(expResult, result);
        assertEquals(expResult2, result2);
        assertEquals(expResult3, result3);
        assertEquals(expResult4, result4);
    }

    /**
     * Test of moveValues method, of class Board.
     */
    @Test
    public void testMoveValuesFullColSumUp() {
        Direction direction = Direction.UP;
        Board instance = new Board();
        //Fair un parcours pour tout mettre a zero car j'ai un random.
        for (int lg = 0; lg < instance.getNbRow(); lg++) {
            for (int col = 0; col < instance.getNbColumn(); col++) {
                if (instance.getValue(lg, col) != 0) {
                    instance.setValue(lg, col, 0);
                    lg = 4;
                    col = 4;
                }
            }
        }
        instance.setValue(0, 0, 256);
        instance.setValue(1, 0, 32);
        instance.setValue(2, 0, 32);
        instance.setValue(3, 0, 256);
        instance.moveValues(direction);
        int result = instance.getValue(0, 0);
        int result2 = instance.getValue(1, 0);
        int result3 = instance.getValue(2, 0);
        int result4 = instance.getValue(3, 0);
        int expResult = 256;
        int expResult2 = 64;
        int expResult3 = 256;
        int expResult4 = 0;
        assertEquals(expResult, result);
        assertEquals(expResult2, result2);
        assertEquals(expResult3, result3);
        assertEquals(expResult4, result4);
    }

    /**
     * Test of moveValues method, of class Board.
     */
    @Test
    public void testMoveValuesDownValueS() {
        Direction direction = Direction.DOWN;
        Board instance = new Board();
        //Fair un parcours pour tout mettre a zero car j'ai un random.
        for (int lg = 0; lg < instance.getNbRow(); lg++) {
            for (int col = 0; col < instance.getNbColumn(); col++) {
                if (instance.getValue(lg, col) != 0) {
                    instance.setValue(lg, col, 0);
                    lg = 4;
                    col = 4;
                }
            }
        }
        instance.setValue(0, 2, 8);
        instance.setValue(1, 3, 8);
        instance.setValue(0, 0, 8);
        instance.moveValues(direction);
        int result = instance.getValue(3, 2);
        int result2 = instance.getValue(0, 2);
        int result3 = instance.getValue(1, 3);
        int result4 = instance.getValue(0, 0);
        int result5 = instance.getValue(3, 3);
        int result6 = instance.getValue(3, 0);
        int expResult = 8;
        int expResult2 = 0;
        int expResult3 = 0;
        int expResult4 = 0;
        int expResult5 = 8;
        int expResult6 = 8;
        assertEquals(expResult, result);
        assertEquals(expResult2, result2);
        assertEquals(expResult3, result3);
        assertEquals(expResult4, result4);
        assertEquals(expResult5, result5);
        assertEquals(expResult6, result6);
    }

    /**
     * Test of moveValues method, of class Board.
     */
    @Test
    public void testMoveValuesSumDown() {
        Direction direction = Direction.DOWN;
        Board instance = new Board();
        //Fair un parcours pour tout mettre a zero car j'ai un random.
        for (int lg = 0; lg < instance.getNbRow(); lg++) {
            for (int col = 0; col < instance.getNbColumn(); col++) {
                if (instance.getValue(lg, col) != 0) {
                    instance.setValue(lg, col, 0);
                    lg = 4;
                    col = 4;
                }
            }
        }
        instance.setValue(1, 3, 8);
        instance.setValue(2, 3, 8);
        instance.setValue(0, 0, 4);
        instance.setValue(3, 0, 4);
        instance.moveValues(direction);
        int result = instance.getValue(3, 3);
        int result2 = instance.getValue(1, 3);
        int result3 = instance.getValue(2, 3);
        int result4 = instance.getValue(0, 0);
        int result5 = instance.getValue(3, 0);
        int expResult = 16;
        int expResult2 = 0;
        int expResult3 = 0;
        int expResult4 = 0;
        int expResult5 = 8;
        assertEquals(expResult, result);
        assertEquals(expResult2, result2);
        assertEquals(expResult3, result3);
        assertEquals(expResult4, result4);
        assertEquals(expResult5, result5);
    }

    /**
     * Test of moveValues method, of class Board.
     */
    @Test
    public void testMoveValuesDownFailSum() {
        Direction direction = Direction.DOWN;
        Board instance = new Board();
        //Fair un parcours pour tout mettre a zero car j'ai un random.
        for (int lg = 0; lg < instance.getNbRow(); lg++) {
            for (int col = 0; col < instance.getNbColumn(); col++) {
                if (instance.getValue(lg, col) != 0) {
                    instance.setValue(lg, col, 0);
                    lg = 4;
                    col = 4;
                }
            }
        }
        instance.setValue(1, 0, 8);
        instance.setValue(2, 0, 4);
        instance.setValue(3, 0, 8);
        instance.moveValues(direction);
        int result = instance.getValue(1, 0);
        int result2 = instance.getValue(2, 0);
        int result3 = instance.getValue(3, 0);
        int expResult = 8;
        int expResult2 = 4;
        int expResult3 = 8;
        assertEquals(expResult, result);
        assertEquals(expResult2, result2);
        assertEquals(expResult3, result3);
    }

    /**
     * Test of moveValues method, of class Board.
     */
    @Test
    public void testMoveValuesDownFullCol() {
        Direction direction = Direction.DOWN;
        Board instance = new Board();
        //Fair un parcours pour tout mettre a zero car j'ai un random.
        for (int lg = 0; lg < instance.getNbRow(); lg++) {
            for (int col = 0; col < instance.getNbColumn(); col++) {
                if (instance.getValue(lg, col) != 0) {
                    instance.setValue(lg, col, 0);
                    lg = 4;
                    col = 4;
                }
            }
        }
        instance.setValue(0, 2, 8);
        instance.setValue(1, 2, 1024);
        instance.setValue(2, 2, 256);
        instance.setValue(3, 2, 16);
        instance.moveValues(direction);
        int result = instance.getValue(0, 2);
        int result2 = instance.getValue(1, 2);
        int result3 = instance.getValue(2, 2);
        int result4 = instance.getValue(3, 2);
        int expResult = 8;
        int expResult2 = 1024;
        int expResult3 = 256;
        int expResult4 = 16;
        assertEquals(expResult, result);
        assertEquals(expResult2, result2);
        assertEquals(expResult3, result3);
        assertEquals(expResult4, result4);
    }

    /**
     * Test of moveValues method, of class Board.
     */
    @Test
    public void testMoveValuesLeftValueS() {
        Direction direction = Direction.LEFT;
        Board instance = new Board();
        //Fair un parcours pour tout mettre a zero car j'ai un random.
        for (int lg = 0; lg < instance.getNbRow(); lg++) {
            for (int col = 0; col < instance.getNbColumn(); col++) {
                if (instance.getValue(lg, col) != 0) {
                    instance.setValue(lg, col, 0);
                    lg = 4;
                    col = 4;
                }
            }
        }
        instance.setValue(0, 2, 8);
        instance.setValue(1, 2, 8);
        instance.moveValues(direction);
        int result = instance.getValue(0, 0);
        int result2 = instance.getValue(1, 0);
        int result3 = instance.getValue(0, 2);
        int result4 = instance.getValue(1, 2);
        int expResult = 8;
        int expResult2 = 8;
        int expResult3 = 0;
        int expResult4 = 0;
        assertEquals(expResult, result);
        assertEquals(expResult2, result2);
        assertEquals(expResult3, result3);
        assertEquals(expResult4, result4);
    }

    /**
     * Test of moveValues method, of class Board.
     */
    @Test
    public void testMoveValuesLeftValueSSum() {
        Direction direction = Direction.LEFT;
        Board instance = new Board();
        //Fair un parcours pour tout mettre a zero car j'ai un random.
        for (int lg = 0; lg < instance.getNbRow(); lg++) {
            for (int col = 0; col < instance.getNbColumn(); col++) {
                if (instance.getValue(lg, col) != 0) {
                    instance.setValue(lg, col, 0);
                    lg = 4;
                    col = 4;
                }
            }
        }
        instance.setValue(1, 1, 4);
        instance.setValue(1, 2, 4);
        instance.moveValues(direction);
        int result = instance.getValue(1, 0);
        int result2 = instance.getValue(1, 1);
        int result3 = instance.getValue(1, 2);
        int expResult = 8;
        int expResult2 = 0;
        int expResult3 = 0;
        assertEquals(expResult, result);
        assertEquals(expResult2, result2);
        assertEquals(expResult3, result3);
    }

    /**
     * Test of moveValues method, of class Board.
     */
    @Test
    public void testMoveValuesLeftValuesFailSum() {
        Direction direction = Direction.LEFT;
        Board instance = new Board();
        //Fair un parcours pour tout mettre a zero car j'ai un random.
        for (int lg = 0; lg < instance.getNbRow(); lg++) {
            for (int col = 0; col < instance.getNbColumn(); col++) {
                if (instance.getValue(lg, col) != 0) {
                    instance.setValue(lg, col, 0);
                    lg = 4;
                    col = 4;
                }
            }
        }
        instance.setValue(0, 1, 2);
        instance.setValue(0, 2, 4);
        instance.setValue(0, 3, 2);
        instance.moveValues(direction);
        int result = instance.getValue(0, 0);
        int result2 = instance.getValue(0, 1);
        int result3 = instance.getValue(0, 2);
        int expResult = 2;
        int expResult2 = 4;
        int expResult3 = 2;
        assertEquals(expResult, result);
        assertEquals(expResult2, result2);
        assertEquals(expResult3, result3);
    }

    /**
     * Test of moveValues method, of class Board.
     */
    @Test
    public void testMoveValuesLeftValuesFullRow() {
        Direction direction = Direction.LEFT;
        Board instance = new Board();
        //Fair un parcours pour tout mettre a zero car j'ai un random.
        for (int lg = 0; lg < instance.getNbRow(); lg++) {
            for (int col = 0; col < instance.getNbColumn(); col++) {
                if (instance.getValue(lg, col) != 0) {
                    instance.setValue(lg, col, 0);
                    lg = 4;
                    col = 4;
                }
            }
        }
        instance.setValue(0, 0, 2);
        instance.setValue(0, 1, 4);
        instance.setValue(0, 2, 8);
        instance.setValue(0, 3, 16);
        instance.moveValues(direction);
        int result = instance.getValue(0, 0);
        int result2 = instance.getValue(0, 1);
        int result3 = instance.getValue(0, 2);
        int result4 = instance.getValue(0, 3);
        int expResult = 2;
        int expResult2 = 4;
        int expResult3 = 8;
        int expResult4 = 16;
        assertEquals(expResult, result);
        assertEquals(expResult2, result2);
        assertEquals(expResult3, result3);
        assertEquals(expResult4, result4);
    }

    /**
     * Test of moveValues method, of class Board.
     */
    @Test
    public void testMoveValuesRight() {
        Direction direction = Direction.RIGHT;
        Board instance = new Board();
        //Fair un parcours pour tout mettre a zero car j'ai un random.
        for (int lg = 0; lg < instance.getNbRow(); lg++) {
            for (int col = 0; col < instance.getNbColumn(); col++) {
                if (instance.getValue(lg, col) != 0) {
                    instance.setValue(lg, col, 0);
                    lg = 4;
                    col = 4;
                }
            }
        }
        instance.setValue(0, 0, 2);
        instance.setValue(1, 1, 4);
        instance.moveValues(direction);
        int result = instance.getValue(0, 3);
        int result2 = instance.getValue(1, 3);
        int expResult = 2;
        int expResult2 = 4;
        assertEquals(expResult, result);
        assertEquals(expResult2, result2);
    }

    /**
     * Test of moveValues method, of class Board.
     */
    @Test
    public void testMoveValuesRightSum() {
        Direction direction = Direction.RIGHT;
        Board instance = new Board();
        //Fair un parcours pour tout mettre a zero car j'ai un random.
        for (int lg = 0; lg < instance.getNbRow(); lg++) {
            for (int col = 0; col < instance.getNbColumn(); col++) {
                if (instance.getValue(lg, col) != 0) {
                    instance.setValue(lg, col, 0);
                    lg = 4;
                    col = 4;
                }
            }
        }
        instance.setValue(0, 0, 16);
        instance.setValue(0, 1, 16);
        instance.setValue(3, 3, 8);
        instance.setValue(3, 0, 8);
        instance.moveValues(direction);
        int result = instance.getValue(0, 3);
        int result2 = instance.getValue(3, 3);
        int expResult = 32;
        int expResult2 = 16;
        assertEquals(expResult, result);
        assertEquals(expResult2, result2);
    }

    /**
     * Test of moveValues method, of class Board.
     */
    @Test
    public void testMoveValuesRightFailSum() {
        Direction direction = Direction.RIGHT;
        Board instance = new Board();
        //Fair un parcours pour tout mettre a zero car j'ai un random.
        for (int lg = 0; lg < instance.getNbRow(); lg++) {
            for (int col = 0; col < instance.getNbColumn(); col++) {
                if (instance.getValue(lg, col) != 0) {
                    instance.setValue(lg, col, 0);
                    lg = 4;
                    col = 4;
                }
            }
        }
        instance.setValue(0, 0, 16);
        instance.setValue(0, 1, 2);
        instance.setValue(0, 2, 8);
        instance.moveValues(direction);
        int result = instance.getValue(0, 1);
        int result2 = instance.getValue(0, 2);
        int result3 = instance.getValue(0, 3);
        int expResult = 16;
        int expResult2 = 2;
        int expResult3 = 8;
        assertEquals(expResult, result);
        assertEquals(expResult2, result2);
        assertEquals(expResult3, result3);
    }

    /**
     * Test of moveValues method, of class Board.
     */
    @Test
    public void testMoveValuesRightFullRow() {
        Direction direction = Direction.RIGHT;
        Board instance = new Board();
        //Fair un parcours pour tout mettre a zero car j'ai un random.
        for (int lg = 0; lg < instance.getNbRow(); lg++) {
            for (int col = 0; col < instance.getNbColumn(); col++) {
                if (instance.getValue(lg, col) != 0) {
                    instance.setValue(lg, col, 0);
                    lg = 4;
                    col = 4;
                }
            }
        }
        instance.setValue(0, 0, 16);
        instance.setValue(0, 1, 2);
        instance.setValue(0, 2, 8);
        instance.setValue(0, 3, 128);
        instance.moveValues(direction);
        int result = instance.getValue(0, 0);
        int result2 = instance.getValue(0, 1);
        int result3 = instance.getValue(0, 2);
        int result4 = instance.getValue(0, 3);
        int expResult = 16;
        int expResult2 = 2;
        int expResult3 = 8;
        int expResult4 = 128;
        assertEquals(expResult, result);
        assertEquals(expResult2, result2);
        assertEquals(expResult3, result3);
    }
}
