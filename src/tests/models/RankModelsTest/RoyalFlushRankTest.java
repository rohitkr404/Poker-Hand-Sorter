package tests.models.RankModelsTest;

import main.Constants.RankConstants;
import main.models.RankModels.RoyalFlushRank;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoyalFlushRankTest {

    @Test
    public void testGetRankValue() {
        RoyalFlushRank royalFlushRank = new RoyalFlushRank();
        assertEquals(RankConstants.ROYAL_FLUSH, royalFlushRank.getRankValue());
    }

    @Test
    public void testGetDescription() {
        RoyalFlushRank royalFlushRank = new RoyalFlushRank();
        assertEquals(RankConstants.ROYAL_FLUSH_DESC, royalFlushRank.getDescription());
    }

}

