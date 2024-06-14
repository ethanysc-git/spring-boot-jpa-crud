package com.ethan.crud.backend.dtos;

import java.time.LocalDateTime;

import org.antlr.v4.runtime.misc.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("deprecation")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Getter
@Setter
public class GymRecordDto {

    private Long id;

    @SuppressWarnings("deprecation")
    @NotNull
    private String exercise;

    @SuppressWarnings("deprecation")
    @NotNull
    private Integer weight;

    private LocalDateTime date;

}