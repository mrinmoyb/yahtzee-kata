

public class Yahtzee {
    
    private int[] dices;
    
    private static final int ONES = 1;
    
    private static final int TWOS = 2;
    
    private static final int THREES = 3;
    
    private static final int FOURS = 4;
    
    private static final int FIVES = 5;
    
    private static final int SIXES = 6;
    
    public Yahtzee(int... dices) {
        this.dices = dices;
    }
    
    public int ones() {
        return getMatchingScores(ONES, dices);
    }
    
    public int twos() {
        return getMatchingScores(TWOS, dices);
    }
    
    public int threes() {
        return getMatchingScores(THREES, dices);
    }
    
    public int fours() {
        return getMatchingScores(FOURS, dices);
    }
    
    public int fives() {
        return getMatchingScores(FIVES, dices);
    }
    
    public int sixes() {
        return getMatchingScores(SIXES, dices);
    }
    
    public int pair() {
        int[] counts = new int[6];
        
        for (int i : dices) {
            counts[i-1]++;
        }
        
        for (int j = 0; j < 6; j++) {
            if (counts[6-j-1] >= 2) {
                return (6-j) * 2;
            }
        }
        return 0;
    }
    
    public int twoPairs() {
        int[] counts = new int[6];
        
        for (int i : dices) {
            counts[i-1]++;
        }
        
        int score = 0;
        int pairCount = 0;
        
        for (int j = 0; j < 6; j++) {
            if (counts[6-j-1] >= 2) {
                score += (6-j);
                pairCount++;
            }
        }
        
        return pairCount == 2 ? score * 2 : 0;
    }
    
    public int threeOfaKind() {
        int[] counts = new int[6];
        
        for (int i : dices) {
            counts[i-1]++;
        }
        
        for (int j = 0; j < 6; j++) {
            if (counts[j] >= 3) {
                return (j+1) * 3;
            }
        }
        return 0;
    }
    
    public int fourOfaKind() {
        int[] counts = new int[6];
        
        for (int i : dices) {
            counts[i-1]++;
        }
        
        for (int j = 0; j < 6; j++) {
            if (counts[j] >= 4) {
                return (j+1) * 4;
            }
        }
        return 0;
    }
    
    public int smallStraight() {
        int[] counts = new int[6];
        
        for (int i : dices) {
            counts[i-1]++;
        }
        
        if (counts[0] == 1 &&
            counts[1] == 1 &&
            counts[2] == 1 &&
            counts[3] == 1 &&
            counts[4] == 1) {
            return 15;
        }
        return 0;
    }
    
    public int largeStraight() {
        int[] counts = new int[6];
        
        for (int i : dices) {
            counts[i-1]++;
        }
        
        if (counts[1] == 1 &&
            counts[2] == 1 &&
            counts[3] == 1 &&
            counts[4] == 1 &&
            counts[5] == 1) {
            return 20;
        }
        return 0;
    }
    
    public int fullHouse() {
        int[] counts = new int[6];
        boolean pair = false;
        boolean threeOfaKind = false;
        
        int pairValue = 0;
        int threeOfaKindValue = 0;
        
        for (int i : dices) {
            counts[i-1]++;
        }
        
        for (int j = 0; j < 6; j++) {
            if (counts[j] == 2) {
                pair = true;
                pairValue = j + 1;
            }
        }
        
        for (int k = 0; k < 6; k++) {
            if (counts[k] == 3) {
                threeOfaKind = true;
                threeOfaKindValue = k + 1;
            }
        }
        return pair && threeOfaKind ? pairValue * 2 + threeOfaKindValue * 3 : 0;
    }
    
    public int yahtzee() {
        int[] counts = new int[6];
        
        for (int i : dices) {
            counts[i-1]++;
        }
        
        for (int j = 0; j < 6; j++) {
            if (counts[j] == 5) {
                return 50;
            }
        }
        return 0;
    }
    
    public int chance() {
        int sum = 0;
        for (int i : dices) {
            sum += i;
        }
        return sum;
    }

    private int getMatchingScores(int category, int[] dices) {
        int i = dices.length, score = 0;
        while (--i >= 0) {
            if (dices[i] == category) {
                score++;
            }
        }
        return score * category;
    }

}
