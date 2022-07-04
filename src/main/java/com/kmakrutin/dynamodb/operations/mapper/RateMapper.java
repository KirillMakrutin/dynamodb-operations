package com.kmakrutin.dynamodb.operations.mapper;

import com.kmakrutin.dynamodb.operations.dto.RateDto;
import com.kmakrutin.dynamodb.operations.model.Rate;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class RateMapper {
    public Rate fromDto(RateDto rateDto) {
        if (rateDto == null) {
            return null;
        }

        var rate = new Rate();
        rate.setId(String.format("%s-%s-%s",
                rateDto.getRateCode(),
                rateDto.getStartDate().format(DateTimeFormatter.ISO_LOCAL_DATE),
                rateDto.getEndDate().format(DateTimeFormatter.ISO_LOCAL_DATE)));
        rate.setRateCode(rateDto.getRateCode());
        rate.setStartDate(rateDto.getStartDate());
        rate.setEndDate(rateDto.getEndDate());
        rate.setAmount(rateDto.getAmount());

        return rate;

    }

    public RateDto toDto(Rate rate) {
        if (rate == null) {
            return null;
        }

        var rateDto = new RateDto();
        rateDto.setRateCode(rate.getRateCode());
        rateDto.setStartDate(rate.getStartDate());
        rateDto.setEndDate(rate.getEndDate());
        rateDto.setAmount(rate.getAmount());

        return rateDto;
    }

    public List<RateDto> toDto(Iterable<Rate> rates) {
        return StreamSupport.stream(rates.spliterator(), false)
                .filter(Objects::nonNull)
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
