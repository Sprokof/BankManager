package bank.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "CLIENTS")
@NoArgsConstructor
@Getter
@Setter
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "SECOND_NAME")
    private String secondName;
    @Column(name = "PATRONYMIC")
    private String patronymic;
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PASSPORT_NUMBER")
    private String passportNumber;

    @OneToMany(mappedBy = "CLIENTS")
    private List<Credit> credits = new ArrayList<>();

    public Client(String firstName, String secondName,
                  String patronymic, String phoneNumber, String email, String passportNumber){
        this.firstName = firstName;
        this.secondName = secondName;
        this.patronymic = patronymic;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.passportNumber = passportNumber;
    }

}
