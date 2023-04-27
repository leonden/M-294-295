package ch.ilv.voteapp.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
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
    @OneToOne(optional = false)
    @JoinColumn(name = "election_id")
    private Election election;
    private String title;
    private int votes;
    @JsonProperty("amount_female")
    private int amountFemale;
    @JsonProperty("amount_male")
    private int amountMale;
    private Result result;

    public ElectionResult() {
    }

}
