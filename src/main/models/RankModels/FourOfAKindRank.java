package main.models.RankModels;

import main.Constants.RankConstants;

/**
 The FourOfAKindRank class is an implementation of the Rank class and represents the rank of a Four of a kind hand in poker
 */
public class FourOfAKindRank extends Rank{
    @Override
    public int getRankValue() {
        return RankConstants.FOUR_OF_A_KIND;
    }

    @Override
    public String getDescription() {
        return RankConstants.FOUR_OF_A_KIND_DESC;
    }
}
