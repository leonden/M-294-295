package ch.ilv.voteapp.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

enum VotedFor {
    A, B
}

@Data
@Entity
public class Vote {

    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "election_id")
    private Election election;
    @OneToOne(optional = false)
    @JoinColumn(name = "person_id")
    private Person person;
    @JsonProperty("voted_for")
    private VotedFor votedFor;

    public Vote() {
    }

}
