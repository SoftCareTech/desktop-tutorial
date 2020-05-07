package ng.edu.baze.apptesterdb2020q1;

public class User {
   private String Name;
   private String phone;
   private String email;

    public User(String name, String phone, String email) {
        Name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
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
}
