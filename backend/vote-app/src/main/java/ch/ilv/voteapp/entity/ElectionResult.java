package ch.ilv.voteapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

enum Result {
    A, B
}

@Data
@Entity
public class ElectionResult {

    @Id
    @GeneratedValue
    private Long id;
    @NotEmpty
    private Long electionId;
    private String title;
    private int votes;
    private int amountFemale;
    private int amountMale;
    private Result result;

    public ElectionResult() {
    }

}
