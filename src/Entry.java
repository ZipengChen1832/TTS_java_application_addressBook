public class Entry {
    private String firstName;
    private String lastName;
    private String phone;
    private String email;

    public Entry() {
    }

    public Entry(String firstName, String lastName, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "************\n" +
                "First Name: " + firstName + "\n" +
                "Last Name: " + lastName + "\n" +
                "Phone Number: " + phone + "\n" +
                "Email: " + email  + "\n" +
                "************\n";
    }
}
