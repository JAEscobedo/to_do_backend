package com.alex.to_do.model.dto;

import java.time.LocalDate;

import com.alex.to_do.model.Priority;

public record TaskDTO(
    String title,
    Priority priority,
    String description,
    LocalDate deadline
) {}