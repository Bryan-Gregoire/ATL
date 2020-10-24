package esi.atl.g53735.bmr.model;

/**
 *
 * @author Utilisateur
 */
public class BMRFacade {

    private final Person person;

    public BMRFacade() {
        this.person = new Person();
    }

    public void setData(int size, int weight, int age, ActivityLevel activity,
            Gender gender) {
        person.setSize(size);
        person.setWeight(weight);
        person.setAge(age);
        person.setActivityLevel(activity);
        person.setGender(gender);
    }

    /**
     * Calculate the BMR of the female.
     *
     * @return the BMR.
     */
    public double femaleBMR() {
        return (9.6 * person.getWeight()) + (1.8 * person.getSize()) 
                - (4.7 * person.getAge()) + 655;
    }

    /**
     * Calculate the BMR of the male.
     *
     * @return the BMR.
     */
    public double maleBMR() {
        return (13.7 * person.getWeight()) + (5 * person.getSize()) 
                - (6.8 * person.getAge()) + 66;
    }

    /**
     * Check if the result of BMR is negative.
     *
     * @param bmr the BMR.
     * @return true if it is under zero else false.
     */
    public boolean BMRUnderZero(double bmr) {
        return bmr < 0;
    }

    /**
     * Calculate calorie expenditure.
     *
     * @param bmr the BMR.
     * @return the number of calories.
     */
    public double caloriesResult(double bmr) {
        return bmr * person.getActivityLevel().getLevel();
    }
}
