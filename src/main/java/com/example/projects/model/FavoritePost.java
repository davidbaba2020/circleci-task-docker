package com.example.projects.model;


import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_favorite_post")
public class FavoritePost {
    @Id
    @SequenceGenerator(
            name = "favorite_post_sequence",
            sequenceName = "favorite_post_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "favorite_post_sequence"
    )
    private Long favouritePostId;
    private String name;

    private String description;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Post> post;

    private Instant createdDate;
}
