public class Stats {
    private final int[] days;
    private final int goal;


    public Stats(int[] days, int goal) {
        this.days = days;
        this.goal = goal;
    }

    int[] getDays() {
        int[] copy = new int[days.length];
        System.arraycopy(days, 0, copy, 0, days.length);
        return copy;
    }

    int findTotal() {
        int sum = 0;
        for (int day : days) {
            sum += day;
        }

        return sum;
    }

    int findMax() {
        int max = 0;
        for (int day : days) {
            max = Math.max(max, day);
        }

        return max;
    }

    int findAverage() {
        return findTotal() / days.length;
    }

    double findDistance() {
        return Converter.convertToDistance(findTotal());
    }

    int findKcal() {
        return Converter.convertToKcal(findTotal());
    }

    int findBestStreak() {
        int best = 0;

        for (int i = 0, streak = 0; i < days.length; i++) {
            if (days[i] > goal) {
                streak += 1;
            } else {
                best = Math.max(best, streak);
                streak = 0;
            }
        }

        return best;
    }
}
