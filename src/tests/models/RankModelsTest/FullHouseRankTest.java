package tests.models.RankModelsTest;

import main.Constants.RankConstants;
import main.models.RankModels.FullHouseRank;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FullHouseRankTest {

    @Test
    public void testGetRankValue() {
        FullHouseRank rank = new FullHouseRank();
        assertEquals(RankConstants.FULL_HOUSE, rank.getRankValue());
    }

    @Test
    public void testGetDescription() {
        FullHouseRank rank = new FullHouseRank();
        assertEquals(RankConstants.FULL_HOUSE_DESC, rank.getDescription());
    }
}

