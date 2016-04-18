import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class YahtzeeTest {
    
    @Test
    public void test_chance() {
        assertEquals(16, new Yahtzee(1,3,4,6,2).chance());
        assertEquals(17, new Yahtzee(1,4,4,6,2).chance());
    }
    
    @Test
    public void test_ones() {
        assertEquals(3, new Yahtzee(1,3,1,6,1).ones());
        assertEquals(4, new Yahtzee(1,1,1,1,2).ones());
        assertEquals(0, new Yahtzee(3,2,4,6,2).ones());
    }
    
    @Test
    public void test_twos() {
        assertEquals(4, new Yahtzee(1,2,2,6,1).twos());
        assertEquals(2, new Yahtzee(1,1,1,1,2).twos());
        assertEquals(0, new Yahtzee(1,3,4,6,5).twos());
    }
    
    @Test
    public void test_threes() {
        assertEquals(6, new Yahtzee(1,3,3,6,1).threes());
        assertEquals(3, new Yahtzee(1,4,6,3,2).threes());
        assertEquals(0, new Yahtzee(1,2,4,6,5).threes());
    }
    
    @Test
    public void test_fours() {
        assertEquals(4, new Yahtzee(1,2,4,6,1).fours());
        assertEquals(8, new Yahtzee(1,4,1,4,2).fours());
        assertEquals(0, new Yahtzee(1,3,2,6,5).fours());
    }
    
    @Test
    public void test_fives() {
        assertEquals(5, new Yahtzee(1,2,5,6,1).fives());
        assertEquals(10, new Yahtzee(1,5,1,5,2).fives());
        assertEquals(0, new Yahtzee(1,3,2,6,4).fives());
    }
    
    @Test
    public void test_sixes() {
        assertEquals(6, new Yahtzee(1,2,4,6,1).sixes());
        assertEquals(12, new Yahtzee(1,6,1,6,2).sixes());
        assertEquals(0, new Yahtzee(1,3,2,4,1).sixes());
    }
    
    @Test
    public void test_pair() {
        assertEquals(6, new Yahtzee(3,2,4,6,3).pair());
        assertEquals(12, new Yahtzee(2,2,6,6,2).pair());
        assertEquals(0, new Yahtzee(1,3,2,4,6).pair());
    }
    
    @Test
    public void test_twoPairs() {
        assertEquals(10, new Yahtzee(1,1,2,4,4).twoPairs());
        assertEquals(16, new Yahtzee(2,2,6,6,2).twoPairs());
        assertEquals(0, new Yahtzee(1,3,2,4,6).twoPairs());
    }
    
    @Test
    public void test_threeOfaKind() {
        assertEquals(12, new Yahtzee(1,2,4,4,4).threeOfaKind());
        assertEquals(6, new Yahtzee(2,2,6,6,2).threeOfaKind());
        assertEquals(0, new Yahtzee(1,1,2,2,3).threeOfaKind());
    }
    
    @Test
    public void test_fourOfaKind() {
        assertEquals(16, new Yahtzee(1,4,4,4,4).fourOfaKind());
        assertEquals(8, new Yahtzee(2,2,2,6,2).fourOfaKind());
        assertEquals(0, new Yahtzee(1,1,2,2,2).fourOfaKind());
    }
    
    @Test
    public void test_smallStraight() {
        assertEquals(15, new Yahtzee(1,2,3,4,5).smallStraight());
        assertEquals(15, new Yahtzee(2,3,5,1,4).smallStraight());
        assertEquals(0, new Yahtzee(2,3,4,5,6).smallStraight());
    }
    
    @Test
    public void test_largeStraight() {
        assertEquals(20, new Yahtzee(2,3,4,5,6).largeStraight());
        assertEquals(20, new Yahtzee(6,2,4,3,5).largeStraight());
        assertEquals(0, new Yahtzee(1,2,3,4,5).largeStraight());
    }
    
    @Test
    public void test_fullHouse() {
        assertEquals(14, new Yahtzee(2,2,4,4,2).fullHouse());
        assertEquals(7, new Yahtzee(1,2,1,2,1).fullHouse());
        assertEquals(0, new Yahtzee(1,2,2,2,2).fullHouse());
    }
    
    @Test
    public void test_Yahtzee() {
        assertEquals(50, new Yahtzee(1,1,1,1,1).yahtzee());
        assertEquals(50, new Yahtzee(5,5,5,5,5).yahtzee());
        assertEquals(0, new Yahtzee(2,2,2,2,5).yahtzee());
    }

}
