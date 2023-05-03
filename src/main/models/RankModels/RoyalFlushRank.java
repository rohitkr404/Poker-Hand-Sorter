package main.models.RankModels;

import main.Constants.RankConstants;

/**
 The RoyalFlushRank class is an implementation of the Rank class and represents the rank of a Royal Flush Rank hand in poker
 */
public class RoyalFlushRank extends Rank {
    @Override
    public int getRankValue() {
        return RankConstants.ROYAL_FLUSH;
    }

    @Override
    public String getDescription() {
        return RankConstants.ROYAL_FLUSH_DESC;
    }
}