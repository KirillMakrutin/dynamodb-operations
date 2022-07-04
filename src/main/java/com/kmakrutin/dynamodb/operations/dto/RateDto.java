package com.kmakrutin.dynamodb.operations.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class RateDto {
    private String rateCode;

    private LocalDate startDate;

    private LocalDate endDate;

    private BigDecimal amount;
}
