package com.dtotaskwithspringboot.dtoproject.repository;

import com.dtotaskwithspringboot.dtoproject.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
