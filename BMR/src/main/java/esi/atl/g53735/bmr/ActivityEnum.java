package esi.atl.g53735.bmr;

/**
 *
 * @author g53735
 */
public enum ActivityEnum {
    SEDENTAIRE, PEUACTIF, ACTIF, FORTACTIF, EXTREMENTACTIF;

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
}
