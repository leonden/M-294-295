package ch.ilv.voteapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Election {

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    @NotEmpty
    private String title;
    private String description;
    @Size(min = 0, max = 100)
    private int progress;

    public Election() {
    }

}
