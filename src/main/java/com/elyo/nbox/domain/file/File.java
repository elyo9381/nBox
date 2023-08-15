package com.elyo.nbox.domain.file;

import com.elyo.nbox.domain.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class File extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long accountId;

    @Column
    private String name;

    @Column
    private String extension;

    @Column
    private Long size;

    @Column
    private String path;

    @Enumerated(EnumType.STRING)
    private String Type;

}