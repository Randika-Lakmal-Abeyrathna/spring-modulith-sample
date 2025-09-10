package com.randikalakmal.spring_modulith_sample.billing;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingRecordRepository extends JpaRepository<BillingRecord,Long> {
}
