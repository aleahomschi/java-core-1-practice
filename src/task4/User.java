package task4;

public class User {

    private long id;
    private String firstName;
    private String lastName;

    private void validateString(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("String value can't be null or empty.");
        }

        if (!value.trim().matches("^[a-zA-Z]+$")) {
            throw new IllegalArgumentException("String value can only contain letters.");
        }
    }

    private void validateNumber(long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID should be greater than 0");
        }
    }

    public User(long id, String firstName, String lastName) {
        validateNumber(id);
        validateString(firstName);
        validateString(lastName);

        this.id = id;
        this.firstName = firstName.trim();
        this.lastName = lastName.trim();
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setId(long id) {
        validateNumber(id);
        this.id = id;
    }

    public void setFirstName(String firstName) {
        validateString(firstName);
        this.firstName = firstName.trim();
    }

    public void setLastName(String lastName) {
        validateString(lastName);
        this.lastName = lastName.trim();
    }

    public String userInfo() {
        return "ID: " + getId() + ". FirstName: " + getFirstName() + ". LastName: " + getLastName() + ".";
    }
}