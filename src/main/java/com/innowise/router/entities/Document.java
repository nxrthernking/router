package com.innowise.router.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sender;

    private LocalDateTime date;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<File> files;


}
