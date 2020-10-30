package esi.atl.g53735.bmr.model;

/**
 * Represent a person.
 *
 * @author g53735
 */
public class Person {

    private int size;
    private int weight;
    private int age;
    private ActivityLevel activityLevel;
    private Gender gender;

    /**
     * Get the height.
     *
     * @return the height.
     */
    public int getSize() {
        return size;
    }

    /**
     * Get the weight.
     *
     * @return the weight.
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Get the age.
     *
     * @return the age.
     */
    public int getAge() {
        return age;
    }

    /**
     * Get the level activity.
     *
     * @return level activity.
     */
    public ActivityLevel getActivityLevel() {
        return activityLevel;
    }

    /**
     * Get the gender.
     *
     * @return the gender.
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Set a height.
     *
     * @param size the height.
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Set a weight.
     *
     * @param weight the weight.
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * Set a age.
     *
     * @param age the age.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Set a level of activity.
     *
     * @param activityLevel the level of activity.
     */
    public void setActivityLevel(ActivityLevel activityLevel) {
        this.activityLevel = activityLevel;
    }

    /**
     * Set a gender.
     *
     * @param gender the gender.
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
