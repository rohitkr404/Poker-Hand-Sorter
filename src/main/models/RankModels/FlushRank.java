package main.models.RankModels;

import main.Constants.RankConstants;

/**
 The FlushRank class is an implementation of the Rank class and represents the rank of a Flush hand in poker
 */

public class FlushRank extends Rank{
    @Override
    public int getRankValue() {
        return RankConstants.FLUSH;
    }

    @Override
    public String getDescription() {
        return RankConstants.FLUSH_DESC;
    }
}
