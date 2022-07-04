package com.kmakrutin.dynamodb.operations.model;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.kmakrutin.dynamodb.operations.converter.LocalDateConverter;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@DynamoDBTable(tableName = "rates")
public class Rate {
    @DynamoDBHashKey
    @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.S)
    private String id;

    @DynamoDBIndexHashKey(globalSecondaryIndexName = "idx_global_rateCode")
    @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.S)
    private String rateCode;

    @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.S)
    @DynamoDBTypeConverted(converter = LocalDateConverter.class)
    private LocalDate startDate;

    @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.S)
    @DynamoDBTypeConverted(converter = LocalDateConverter.class)
    private LocalDate endDate;

    @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.N)
    private BigDecimal amount;
}
