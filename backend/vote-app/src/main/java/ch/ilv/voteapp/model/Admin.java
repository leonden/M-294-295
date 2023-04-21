package ch.ilv.voteapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Admin {

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    @Size(max = 255)
    @NotEmpty
    private String name;

    public Admin() {
    }

}
