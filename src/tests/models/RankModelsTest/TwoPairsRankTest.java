package tests.models.RankModelsTest;

import main.Constants.RankConstants;
import main.models.RankModels.StraightFlushRank;
import main.models.RankModels.TwoPairsRank;
import org.junit.Test;
import static org.junit.Assert.*;

public class TwoPairsRankTest {

    @Test
    public void testGetRankValue() {
        TwoPairsRank rank = new TwoPairsRank();
        assertEquals(RankConstants.TWO_PAIRS, rank.getRankValue());
    }

    @Test
    public void testGetDescription() {
        TwoPairsRank rank = new TwoPairsRank();
        assertEquals(RankConstants.TWO_PAIRS_DESC, rank.getDescription());
    }

    @Test
    public void testCompareTo() {
        TwoPairsRank rank1 = new TwoPairsRank();
        TwoPairsRank rank2 = new TwoPairsRank();
        assertEquals(0, rank1.compareTo(rank2));

        StraightFlushRank straightFlushRank = new StraightFlushRank();
        assertTrue(rank1.compareTo(straightFlushRank) < 0);
        assertTrue(straightFlushRank.compareTo(rank1) > 0);
    }
}
