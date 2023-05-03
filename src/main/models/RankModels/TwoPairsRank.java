package main.models.RankModels;

import main.Constants.RankConstants;

/**
 The TwoPairsRank class is an implementation of the Rank class and represents the rank of a Two Pairs Rank hand in poker
 */

public class TwoPairsRank extends Rank{
    @Override
    public int getRankValue() {
        return RankConstants.TWO_PAIRS;
    }

    @Override
    public String getDescription() {
        return RankConstants.TWO_PAIRS_DESC;
    }
}
