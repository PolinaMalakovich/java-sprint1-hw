public class Converter {
    private static final int STEP_TO_CM = 75;
    private static final int KM_TO_CM = 100000;
    private static final int STEP_TO_CAL = 50;
    private static final int KCAL_TO_CAL = 1000;

    static int convertToKcal(int steps) {
        int calories = steps * STEP_TO_CAL;
        return calories / KCAL_TO_CAL;
    }

    static double convertToDistance(int steps) {
        double distance = steps * STEP_TO_CM;
        return distance / KM_TO_CM;
    }
}
