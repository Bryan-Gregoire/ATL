package esi.atl.g53735.bmr.model;

/**
 * Represent the gender.
 *
 * @author g53735
 */
public enum Gender {
    HOMME, FEMME;

    /**
     * String that represent the gender.
     *
     * @return a String.
     */
    @Override
    public String toString() {
        switch (this) {
            case FEMME:
                return "Femme";
            case HOMME:
                return "Homme";
        }
        return null;
    }
}
