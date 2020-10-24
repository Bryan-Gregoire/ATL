package esi.atl.g53735.bmr.model;

/**
 *
 * @author Utilisateur
 */
public class Person {
    private int size;
    private int weight;
    private int age;
    private ActivityLevel activityLevel;
    private Gender gender;

    
    public int getSize() {
        return size;
    }

    public int getWeight() {
        return weight;
    }

    public int getAge() {
        return age;
    }

    public ActivityLevel getActivityLevel() {
        return activityLevel;
    }

    public Gender getGender() {
        return gender;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setActivityLevel(ActivityLevel activityLevel) {
        this.activityLevel = activityLevel;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
