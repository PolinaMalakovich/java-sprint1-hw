public class StepTracker {
    public static final int MONTHS = 12;
    public static final int DAYS = 30;

    private final int[][] stepTracker;
    private int goal;

    StepTracker() {
        stepTracker = new int[MONTHS][DAYS];
        goal = 10000;
    }

    public int getGoal() {
        return this.goal;
    }

    public void setGoal(int goal) {
        this.goal = goal;
    }

    Stats getStats(Months month) {
        return new Stats(stepTracker[month.getIndex()], getGoal());
    }

    public void saveSteps(Months month, int day, int steps) {
        stepTracker[month.getIndex()][day - 1] = steps;
    }
}
