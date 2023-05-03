package tests.models.RankModelsTest;

import main.Constants.RankConstants;
import main.models.RankModels.FourOfAKindRank;
import main.models.RankModels.Rank;
import main.models.RankModels.StraightFlushRank;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FourOfAKindRankTest {

    @Test
    public void testGetRankValue() {
        FourOfAKindRank rank = new FourOfAKindRank();
        assertEquals(RankConstants.FOUR_OF_A_KIND, rank.getRankValue());
    }

    @Test
    public void testGetDescription() {
        FourOfAKindRank rank = new FourOfAKindRank();
        assertEquals(RankConstants.FOUR_OF_A_KIND_DESC, rank.getDescription());
    }

    @Test
    public void testCompareTo() {
        FourOfAKindRank rank1 = new FourOfAKindRank();
        FourOfAKindRank rank2 = new FourOfAKindRank();
        assertTrue(rank1.compareTo(rank2) == 0);
        assertTrue(rank2.compareTo(rank1) == 0);
    }

    @Test
    public void testCompareToHigherRank() {
        FourOfAKindRank rank1 = new FourOfAKindRank();
        StraightFlushRank rank2 = new StraightFlushRank();
        assertTrue(rank1.compareTo(rank2) < 0);
        assertTrue(rank2.compareTo(rank1) > 0);
    }

}

