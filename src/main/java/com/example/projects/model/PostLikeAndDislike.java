package com.example.projects.model;


import com.example.projects.Enum.VoteType;
import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="tbl_post_like_and_dislike")
public class PostLikeAndDislike {
    @Id
    @SequenceGenerator(
            name = "postLikeAndDislike_sequence",
            sequenceName = "postLikeAndDislike_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "postLikeAndDislike_sequence"
    )
    private Long id;
    private VoteType likeAndDislike;
}
