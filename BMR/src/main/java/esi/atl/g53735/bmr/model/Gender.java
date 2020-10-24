package esi.atl.g53735.bmr.model;

/**
 *
 * @author Utilisateur
 */
public enum Gender {
    HOMME, FEMME;

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
