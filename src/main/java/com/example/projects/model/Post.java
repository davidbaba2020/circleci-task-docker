package com.example.projects.model;

import com.sun.istack.Nullable;
import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.LinkedList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="tbl_post")
public class Post {
    @Id
    @SequenceGenerator(
            name = "post_sequence",
            sequenceName = "post_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "post_sequence"
    )
    private Long postId;
    private String postName;
    @Lob
    @Nullable
    private String description;
    private Integer postLikeCount;
    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "userId",
            referencedColumnName = "userId"
    )
    private User user;

    private Instant createdDate;

    @ManyToOne(
            fetch = FetchType.LAZY,cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "favouritePostId",
            referencedColumnName = "favouritePostId"
    )
    private FavoritePost favoritePosts;
    @OneToMany
    private List<Comments> comments = new LinkedList<>();
}
