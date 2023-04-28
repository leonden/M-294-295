package ch.ilv.voteapp.entity.person;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Person {

    @Id
    @GeneratedValue
    private Long id;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    private boolean adult;
    private Sex sex;
    private int age;
    private String street;
    private String city;
    @JsonProperty("zip_code")
    private String zipCode;

    public Person() {
    }

    public Person(String firstName, String lastName, boolean adult, Sex sex, int age, String street, String city, String zipCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.adult = adult;
        this.sex = sex;
        this.age = age;
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
    }
}
