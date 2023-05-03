package main.models.RankModels;

import main.Constants.RankConstants;

/**
 The HighCardRank class is an implementation of the Rank class and represents the rank of a High card hand in poker
 */

public class HighCardRank extends Rank{
    @Override
    public int getRankValue() {
        return RankConstants.HIGH_CARD;
    }

    @Override
    public String getDescription() {
        return RankConstants.HIGH_CARD_DESC;
    }
}
