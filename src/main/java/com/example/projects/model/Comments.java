package com.example.projects.model;


import lombok.*;
import javax.persistence.*;
import java.time.Instant;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="tbl_comments")
public class Comments {
    @Id
    @SequenceGenerator(
            name = "comment_sequence",
            sequenceName = "comment_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "comment_sequence"
    )
    private Long commentId;

    private String text;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(
            name = "postId",
            referencedColumnName = "postId"
    )
    private Post post;

    private Instant commentedDate;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(
            name = "userId",
            referencedColumnName = "userId"
    )
    private User user;
}
