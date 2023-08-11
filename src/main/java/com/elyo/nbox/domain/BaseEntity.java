package com.elyo.nbox.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    public static final String DELETED_IS_FALSE = "deleted = false";

    @CreatedBy
    @Column(updatable = false)
    @Comment("생성자")
    private String createdBy;

    @CreatedDate
    @Column(updatable = false)
    @Comment("생성일")
    private LocalDateTime createdAt;

    @LastModifiedBy
    @Comment("수정자")
    private String modifiedBy;

    @LastModifiedDate
    @Comment("수정일")
    private LocalDateTime modifiedAt;

    @Comment("삭제일")
    private LocalDateTime deletedAt;

    @Comment("삭제 여부")
    private boolean deleted;

    public boolean isUndeleted() {
        return !isDeleted() ;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void delete() {
        this.deleted = true;
        this.deletedAt = LocalDateTime.now();
    }
}
