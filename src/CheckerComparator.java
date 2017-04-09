import java.util.Comparator;

class CheckerComparator implements Comparator<CheckerComparator.Player> {

    public int compare(Player a, Player b) {
        return a.score == b.score ? a.name.toLowerCase().compareTo(b.name.toLowerCase()) : b.score - a.score;
    }

    class Player {
        int score;
        String name;

        public Player(int score, String name) {
            this.score = score;
            this.name = name;
        }
    }
}


