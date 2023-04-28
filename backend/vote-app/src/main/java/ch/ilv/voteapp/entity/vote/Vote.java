package ch.ilv.voteapp.entity.vote;

import ch.ilv.voteapp.entity.Election;
import ch.ilv.voteapp.entity.person.Person;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;


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

    public Vote(Election election, Person person, VotedFor votedFor) {
        this.election = election;
        this.person = person;
        this.votedFor = votedFor;
    }
}
