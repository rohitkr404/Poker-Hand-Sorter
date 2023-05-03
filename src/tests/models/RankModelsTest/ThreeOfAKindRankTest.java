package tests.models.RankModelsTest;

import main.Constants.RankConstants;
import main.models.RankModels.HighCardRank;
import main.models.RankModels.StraightFlushRank;
import main.models.RankModels.ThreeOfAKindRank;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThreeOfAKindRankTest {
    ThreeOfAKindRank threeOfAKindRank = new ThreeOfAKindRank();

    @Test
    void testGetRankValue() {
        assertEquals(RankConstants.THREE_OF_A_KIND, threeOfAKindRank.getRankValue());
    }

    @Test
    void testGetDescription() {
        assertEquals(RankConstants.THREE_OF_A_KIND_DESC, threeOfAKindRank.getDescription());
    }

    @Test
    void testCompareTo() {
        ThreeOfAKindRank otherRank = new ThreeOfAKindRank();
        assertEquals(0, threeOfAKindRank.compareTo(otherRank));

        StraightFlushRank higherRank = new StraightFlushRank();
        assertTrue(threeOfAKindRank.compareTo(higherRank) < 0);

        HighCardRank lowerRank = new HighCardRank();
        assertTrue(threeOfAKindRank.compareTo(lowerRank) > 0);
    }
}

