package com.kmakrutin.dynamodb.operations.repo;

import com.kmakrutin.dynamodb.operations.model.Rate;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

@EnableScan
public interface RateRepo extends CrudRepository<Rate, String> {
    Rate findByRateCode(String rateCode);

    List<Rate> findAllByStartDateLessThanEqualAndEndDateGreaterThan(LocalDate startDate, LocalDate endDate);
}
