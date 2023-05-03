package main.models.RankModels;

/**
 This class is an abstract class that represents the rank of a hand in a poker game.
 */

public abstract class Rank implements Comparable<Rank> {
    protected final int rankValue = getRankValue();
    protected final String rankDescription = getDescription();

    public int compareTo(Rank other) {
        return Integer.compare(this.getRankValue(), other.getRankValue());
    }

    public abstract int getRankValue();
    public abstract String getDescription();
}