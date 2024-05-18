package entity;

public class Contact {
    private String contact_name;
    private String contact_company;
    private String contact_email;
    private String contact_phone;

    public Contact(String contact_name, String contact_company, String contact_email, String contact_phone) {
        this.contact_name = contact_name;
        this.contact_company = contact_company;
        this.contact_email = contact_email;
        this.contact_phone = contact_phone;
    }

    public String getContact_name() {
        return contact_name;
    }

    public void setContact_name(String contact_name) {
        this.contact_name = contact_name;
    }

    public String getContact_company() {
        return contact_company;
    }

    public void setContact_company(String contact_company) {
        this.contact_company = contact_company;
    }

    public String getContact_email() {
        return contact_email;
    }

    public void setContact_email(String contact_email) {
        this.contact_email = contact_email;
    }

    public String getContact_phone() {
        return contact_phone;
    }

    public void setContact_phone(String contact_phone) {
        this.contact_phone = contact_phone;
    }
}
