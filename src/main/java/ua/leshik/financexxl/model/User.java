package ua.leshik.financexxl.model;

import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Table(name = "users",
                uniqueConstraints = {
                    @UniqueConstraint(columnNames = "username"),
                })
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

}
