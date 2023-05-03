package main.models.RankModels;

import main.Constants.RankConstants;

/**
 The StraightFlushRank class is an implementation of the Rank class and represents the rank of a Straight Flush Rank hand in poker
 */

public class StraightFlushRank extends Rank{
    @Override
    public int getRankValue() {
        return RankConstants.STRAIGHT_FLUSH;
    }

    @Override
    public String getDescription() {
        return RankConstants.STRAIGHT_FLUSH_DESC;
    }
}
