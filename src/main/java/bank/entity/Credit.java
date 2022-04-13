package bank.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CREDITS")
@NoArgsConstructor
@Getter
@Setter
public class Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "CREDITS_LIMIT")
    private int creditsLimit;
    @Column(name = "PERCENTAGES")
    private double percentages;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;


    public Credit(int creditsLimit, double percentages) {
        this.creditsLimit = creditsLimit;
        this.percentages = percentages;
    }
}
