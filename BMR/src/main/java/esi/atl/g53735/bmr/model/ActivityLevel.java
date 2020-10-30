package esi.atl.g53735.bmr.model;

/**
 * Represent the Activity Level.
 *
 * @author g53735
 */
public enum ActivityLevel {

    SEDENTAIRE(1.2), PEUACTIF(1.375), ACTIF(1.55), FORTACTIF(1.725),
    EXTREMENTACTIF(1.9);

    private final double level;

    /**
     * Constructor of the level of activity.
     *
     * @param level the level.
     */
    private ActivityLevel(double level) {
        this.level = level;
    }

    /**
     * String that represent the Activity.
     *
     * @return the String;
     */
    @Override
    public String toString() {
        switch (this) {
            case ACTIF:
                return "Actif";
            case SEDENTAIRE:
                return "Sédentaire";
            case PEUACTIF:
                return "Peu actif";
            case FORTACTIF:
                return "Fort actif";
            case EXTREMENTACTIF:
                return "Extrêmement actif";
        }
        return "";
    }

    /**
     * Get the level of the activity.
     *
     * @return the level.
     */
    public double getLevel() {
        return level;
    }
}
