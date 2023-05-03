package main.models.RankModels;

import main.Constants.RankConstants;

/**
 The ThreeOfAKindRank class is an implementation of the Rank class and represents the rank of a Three Of A Kind Rank hand in poker
 */

public class ThreeOfAKindRank extends Rank{
    @Override
    public int getRankValue() {
        return RankConstants.THREE_OF_A_KIND;
    }

    @Override
    public String getDescription() {
        return RankConstants.THREE_OF_A_KIND_DESC;
    }
}
