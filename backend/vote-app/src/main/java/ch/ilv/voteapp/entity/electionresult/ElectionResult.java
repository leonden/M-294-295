package ch.ilv.voteapp.entity.electionresult;

import ch.ilv.voteapp.entity.Election;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

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

    public ElectionResult(Election election, String title, int votes, int amountFemale, int amountMale, Result result) {
        this.election = election;
        this.title = title;
        this.votes = votes;
        this.amountFemale = amountFemale;
        this.amountMale = amountMale;
        this.result = result;
    }
}
