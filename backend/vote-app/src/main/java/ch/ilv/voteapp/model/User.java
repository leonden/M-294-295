package ch.ilv.voteapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    @Size(max = 255)
    @NotEmpty
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    private boolean adult;
    @Size(min = 16)
    private int age;
    private String street;
    private String city;
    @Size(min = 1000)
    @JsonProperty("zip_code")
    private int zipCode;

    public User() {
    }

}
