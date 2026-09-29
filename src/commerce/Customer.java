package commerce;

public class Customer {

    private String customerName;
    private String email;
    private int rating;


    // 생성자
    public Customer(String name, String email, int rating) {
        this.customerName = name;
        this.email = email;
        this.rating = rating;
    }


    // getter
    public String getCustomerName() {
        return customerName;
    }

    public String getEmail() {
        return email;
    }

    public int getRating() {
        return rating;
    }

}
