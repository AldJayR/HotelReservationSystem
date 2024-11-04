
public class Guest {
    String name;
    String contactInfo;
    String email;
    
    public Guest(String name, String contactInfo, String email) {
        this.name = name;
        this.contactInfo = contactInfo;
        this.email = email;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getContactInfo() {
        return this.contactInfo;
    }
    
    public String getEmail() {
        return this.email;
    }
}
