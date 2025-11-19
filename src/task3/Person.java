package task3;

public class Person {
    private String name;
    private int age;


    private void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name can't be null or empty");
        }

        if (!name.trim().matches("^[a-zA-Z]+$")) {
            throw new IllegalArgumentException("Name should contain only letters");
        }
    }

    private void validateAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Age should be greater than 0");
        }
    }

    public Person(String name, int age) {
        validateName(name);
        validateAge(age);

        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        validateName(name);
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        validateAge(age);
        this.age = age;
    }
}
