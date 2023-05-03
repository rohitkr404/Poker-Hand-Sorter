package tests.models.RankModelsTest;

import main.Constants.RankConstants;
import main.models.RankModels.StraightFlushRank;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StraightFlushRankTest {

    @Test
    public void testGetRankValue() {
        StraightFlushRank rank = new StraightFlushRank();
        Assertions.assertEquals(RankConstants.STRAIGHT_FLUSH, rank.getRankValue());
    }

    @Test
    public void testGetDescription() {
        StraightFlushRank rank = new StraightFlushRank();
        Assertions.assertEquals(RankConstants.STRAIGHT_FLUSH_DESC, rank.getDescription());
    }

}

