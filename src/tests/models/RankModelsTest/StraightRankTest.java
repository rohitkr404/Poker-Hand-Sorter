package tests.models.RankModelsTest;

import main.Constants.RankConstants;
import main.models.RankModels.HighCardRank;
import main.models.RankModels.Rank;
import main.models.RankModels.StraightRank;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StraightRankTest {

    @Test
    void testStraightRankValue() {
        Rank straightRank = new StraightRank();
        assertEquals(RankConstants.STRAIGHT, straightRank.getRankValue());
    }

    @Test
    void testStraightRankDescription() {
        Rank straightRank = new StraightRank();
        assertEquals(RankConstants.STRAIGHT_DESC, straightRank.getDescription());
    }

    @Test
    void testRankComparison() {
        Rank straightRank = new StraightRank();
        Rank highCardRank = new HighCardRank();
        assertTrue(straightRank.compareTo(highCardRank) > 0);
    }
}

