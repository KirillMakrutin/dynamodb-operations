package com.kmakrutin.dynamodb.operations.controller;

import com.kmakrutin.dynamodb.operations.dto.RateDto;
import com.kmakrutin.dynamodb.operations.mapper.RateMapper;
import com.kmakrutin.dynamodb.operations.repo.RateRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/rates")
public class RateController {
    private final RateRepo rateRepo;
    private final RateMapper rateMapper;

    @GetMapping
    public List<RateDto> findAll() {
        return rateMapper.toDto(rateRepo.findAll());
    }

    @GetMapping("/{rateCode}")
    public RateDto findByRateCode(@PathVariable String rateCode) {
        return rateMapper.toDto(rateRepo.findByRateCode(rateCode));
    }

    @GetMapping("/filter")
    public List<RateDto> findAllForDate(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate filterDate) {
        return rateMapper.toDto(rateRepo.findAllByStartDateLessThanEqualAndEndDateGreaterThan(filterDate, filterDate));
    }

    @PostMapping
    public RateDto save(@RequestBody RateDto rate) {
        return rateMapper.toDto(rateRepo.save(rateMapper.fromDto(rate)));
    }

    @DeleteMapping
    public void deleteAll() {
        rateRepo.deleteAll();
    }
}
