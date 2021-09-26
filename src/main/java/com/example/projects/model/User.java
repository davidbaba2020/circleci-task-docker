package com.example.projects.model;
import lombok.*;
import javax.persistence.*;
import java.time.Instant;
import java.util.*;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(
        name = "tbl_user",
        uniqueConstraints = @UniqueConstraint(
                name = "email_unique",
                columnNames = "email"
        )
)
public class User {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long userId;

    private String firstName;


    private String lastName;

    @Column(name = "email")
    private String email;
    private String password;
    private Instant dateRegistered;
    @OneToMany
    private List<Comments> comments = new LinkedList<>();

    @OneToMany
    private List<Post> myListOfPosts = new ArrayList<>();

    @ElementCollection
    private Map<Long,String> favouritePost = new LinkedHashMap<>();

    @ElementCollection
    private Map<Long,String> friendList = new LinkedHashMap<>();

    private boolean activated;
}

