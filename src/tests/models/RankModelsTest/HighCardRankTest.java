package tests.models.RankModelsTest;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import main.models.RankModels.HighCardRank;
import main.Constants.RankConstants;

public class HighCardRankTest {

    @Test
    public void testGetRankValue() {
        HighCardRank highCardRank = new HighCardRank();
        assertEquals(RankConstants.HIGH_CARD, highCardRank.getRankValue());
    }

    @Test
    public void testGetDescription() {
        HighCardRank highCardRank = new HighCardRank();
        assertEquals(RankConstants.HIGH_CARD_DESC, highCardRank.getDescription());
    }

    @Test
    public void testCompareTo() {
        HighCardRank highCardRank = new HighCardRank();
        HighCardRank otherHighCardRank = new HighCardRank();
        int expectedCompareTo = 0;
        int actualCompareTo = highCardRank.compareTo(otherHighCardRank);
        assertEquals(expectedCompareTo, actualCompareTo);
    }
}

