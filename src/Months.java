public enum Months {
    JANUARY("Январь", 0),
    FEBRUARY("Февраль", 1),
    MARCH("Март", 2),
    APRIL("Апрель", 3),
    MAY("Май", 4),
    JUNE("Июнь", 5),
    JULY("Июль", 6),
    AUGUST("Август", 7),
    SEPTEMBER("Сентябрь", 8),
    OCTOBER("Октябрь", 9),
    NOVEMBER("Ноябрь", 10),
    DECEMBER("Декабрь", 11);

    private final String label;
    private final int index;

    Months(String label, int index) {
        this.label = label;
        this.index = index;
    }

    public String getLabel() {
        return label;
    }

    public int getIndex() {
        return index;
    }

    public static Months fromString(String month) {
        Months result = null;
        for (Months value : values()) {
            if (month.equalsIgnoreCase(value.getLabel())) {
                result = value;
                break;
            }
        }
        return result;
    }
}
