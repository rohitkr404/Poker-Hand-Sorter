package main.models.RankModels;

import main.Constants.RankConstants;

/**
 The StraightRank class is an implementation of the Rank class and represents the rank of a Straight Rank hand in poker
 */

public class StraightRank extends Rank{
    @Override
    public int getRankValue() {
        return RankConstants.STRAIGHT;
    }

    @Override
    public String getDescription() {
        return RankConstants.STRAIGHT_DESC;
    }
}
