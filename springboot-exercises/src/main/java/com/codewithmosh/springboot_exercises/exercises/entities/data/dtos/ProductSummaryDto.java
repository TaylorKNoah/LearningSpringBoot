package com.codewithmosh.springboot_exercises.exercises.entities.data.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductSummaryDto {
    private Long id;
    private String name;
}
