package kata6.model;

public class Person {

    private final Integer id;
    private final String name;
    private final Character gender;
    private final String birthday;
    private final float weight;
    private final String mail;

    public Person(Integer id, String name, Character gender, String birthday, float weight, String mail) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.weight = weight;
        this.mail = mail;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Character getGender() {
        return gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public float getWeight() {
        return weight;
    }

    public String getMail() {
        return mail;
    }
    
    
}
