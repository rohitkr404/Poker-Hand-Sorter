package main.models.RankModels;

import main.Constants.RankConstants;

/**
 The FullHouseRank class is an implementation of the Rank class and represents the rank of a Full House hand in poker
 */

public class FullHouseRank extends Rank{
    @Override
    public int getRankValue() {
        return RankConstants.FULL_HOUSE;
    }

    @Override
    public String getDescription() {
        return RankConstants.FULL_HOUSE_DESC;
    }
}
