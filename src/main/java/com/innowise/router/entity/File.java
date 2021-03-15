package com.innowise.router.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "file_id_seq")
    @SequenceGenerator(name = "file_id_seq", sequenceName = "FILE_ID_SEQUENCE")
    private Long id;

    private String fileName;

    private String fileExtension;

    @Lob
    private byte[] content;
}
