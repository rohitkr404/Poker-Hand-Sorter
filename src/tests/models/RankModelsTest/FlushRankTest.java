package tests.models.RankModelsTest;

import main.Constants.RankConstants;
import main.models.RankModels.FlushRank;
import main.models.RankModels.Rank;
import main.models.RankModels.StraightRank;
import org.junit.Test;

import static org.junit.Assert.*;

public class FlushRankTest {

    @Test
    public void testGetRankValue() {
        FlushRank flushRank = new FlushRank();
        assertEquals(RankConstants.FLUSH, flushRank.getRankValue());
    }

    @Test
    public void testGetDescription() {
        FlushRank flushRank = new FlushRank();
        assertEquals(RankConstants.FLUSH_DESC, flushRank.getDescription());
    }

    @Test
    public void testCompareTo() {
        Rank flushRank1 = new FlushRank();
        Rank flushRank2 = new FlushRank();
        Rank straightRank = new StraightRank();

        assertTrue(flushRank1.compareTo(flushRank2) == 0);
        assertTrue(flushRank1.compareTo(straightRank) > 0);
        assertTrue(straightRank.compareTo(flushRank1) < 0);
    }

}
