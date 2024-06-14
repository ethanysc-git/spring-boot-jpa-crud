package com.ethan.crud.backend.entities;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "gym_record")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class GymRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String exercise;

    @Column
    private Integer weight;

    @CreatedDate
    private LocalDateTime created;

    @LastModifiedDate
    private LocalDateTime modified;
}