package main.models.RankModels;

import main.Constants.RankConstants;

/**
 The PairRank class is an implementation of the Rank class and represents the rank of a Pair Rank hand in poker
 */

public class PairRank extends Rank{
    @Override
    public int getRankValue() {
        return RankConstants.PAIR;
    }

    @Override
    public String getDescription() {
        return RankConstants.PAIR_DESC;
    }
}
