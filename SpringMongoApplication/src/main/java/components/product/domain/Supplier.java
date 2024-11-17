package components.product.domain;

import components.customer.domain.Address;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Supplier {
    @Id
    private String supplierNumber;
    private String name;
    private String email;
    private String phone;

    private Address address;

    public Supplier(String supplierNumber, String name, String email, String phone) {
        this.supplierNumber = supplierNumber;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "supplierNumber=" + supplierNumber +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address=" + address +
                '}';
    }

    public String getSupplierNumber() {
        return supplierNumber;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress(){
        return this.address;
    }

}
