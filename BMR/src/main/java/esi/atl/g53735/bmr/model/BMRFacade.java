package esi.atl.g53735.bmr.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Represent the facade of the model.
 *
 * @author g53735
 */
public class BMRFacade {

    public static final String CALCUL_BMR = "Calcul du BMR";
    public static final String CALCUL_CALORIE = "Calcul des calories";
    private final Person person;
    private PropertyChangeSupport pcs;

    /**
     * Constructor of BMRFacade.
     *
     */
    public BMRFacade() {
        this.person = new Person();
        this.pcs = new PropertyChangeSupport(this);
    }

    /**
     * Set the data's of a person.
     *
     * @param size the height of a person.
     * @param weight the weight of a person.
     * @param age the age of a person.
     * @param activity the activity of a person.
     * @param gender the gender of a person.
     */
    public void setData(int size, int weight, int age, ActivityLevel activity,
            Gender gender) {
        person.setSize(size);
        person.setWeight(weight);
        person.setAge(age);
        person.setActivityLevel(activity);
        person.setGender(gender);

    }

    /**
     * Get the weight of a person.
     *
     * @return the weight.
     */
    public int getWeightPerson() {
        return person.getWeight();
    }

    /**
     * Get the gender of a person.
     *
     * @return the gender.
     */
    public Gender getGenderPerson() {
        return person.getGender();
    }

    /**
     * Get the height of a person.
     *
     * @return the height.
     */
    public int getHeightPerson() {
        return person.getSize();
    }

    /**
     * Calculate the BMR of the gender female.
     *
     * @return the BMR.
     */
    public double femaleBMR() {
        double bmr = (9.6 * person.getWeight()) + (1.8 * person.getSize())
                - (4.7 * person.getAge()) + 655;
        if (bmr < 0) {
            throw new IllegalStateException();
        }
        pcs.firePropertyChange(CALCUL_BMR, 0, bmr);
        return bmr;
    }

    /**
     * Calculate the BMR of the male.
     *
     * @return the BMR.
     */
    public double maleBMR() {
        double bmr = (13.7 * person.getWeight()) + (5 * person.getSize())
                - (6.8 * person.getAge()) + 66;
        if (bmr < 0) {
            throw new IllegalStateException();
        }
        pcs.firePropertyChange(CALCUL_BMR, 0, bmr);
        return bmr;
    }

    /**
     * Calculate calorie expenditure.
     *
     * @param bmr the BMR.
     * @return the number of calories.
     */
    public double caloriesResult(double bmr) {
        double calories = bmr * person.getActivityLevel().getLevel();
        pcs.firePropertyChange(CALCUL_CALORIE, 0, calories);
        return calories;
    }

    /**
     * Calculate the BMR.
     *
     * @return the calculated BMR.
     */
    public double calculBMR() {
        return person.getGender().equals(Gender.FEMME) ? femaleBMR()
                : maleBMR();
    }

    /**
     * Add listener
     *
     * @param listener the listener.
     */
    public void addPropertChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    /**
     * Remove listener.
     *
     * @param listener the listener.
     */
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(listener);
    }
}
