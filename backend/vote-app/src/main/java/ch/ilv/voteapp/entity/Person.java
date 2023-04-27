package ch.ilv.voteapp.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

enum Sex {
    MALE, FEMALE
}

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

}
