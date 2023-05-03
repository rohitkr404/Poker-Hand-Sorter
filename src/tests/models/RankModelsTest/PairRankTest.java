package tests.models.RankModelsTest;

import main.Constants.RankConstants;
import main.models.RankModels.HighCardRank;
import main.models.RankModels.PairRank;
import main.models.RankModels.Rank;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PairRankTest {

    @Test
    void testGetRankValue() {
        Rank pairRank = new PairRank();
        Assertions.assertEquals(RankConstants.PAIR, pairRank.getRankValue());
    }

    @Test
    void testGetDescription() {
        Rank pairRank = new PairRank();
        Assertions.assertEquals(RankConstants.PAIR_DESC, pairRank.getDescription());
    }

    @Test
    void testCompareTo() {
        Rank pairRank = new PairRank();
        Rank highCardRank = new HighCardRank();
        Assertions.assertTrue(pairRank.compareTo(highCardRank) > 0);
    }
}

