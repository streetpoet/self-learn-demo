package com.spstudio.zheng.common.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embeddable;
import java.time.Instant;

@Embeddable
@Data
public class AuditMetaData {

    @CreatedBy
    @Column(name = "created_by", length = 36, updatable = false)
    private String createdBy;

    @CreatedDate
    @Convert(disableConversion = true)
    @Column(name = "created_date", updatable = false)
    private Instant createdDate;

    @LastModifiedBy
    @Column(name = "modified_by", length = 36)
    private String modifiedBy;

    @LastModifiedDate
    @Convert(disableConversion = true)
    @Column(name = "modified_date")
    private Instant modifiedDate;
}
