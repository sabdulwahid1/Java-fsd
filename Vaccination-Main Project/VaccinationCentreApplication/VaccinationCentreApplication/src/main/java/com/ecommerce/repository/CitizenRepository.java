package com.ecommerce.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ecommerce.entity.Citizen;
import com.ecommerce.entity.VaccineCenter;
public interface CitizenRepository extends JpaRepository<Citizen, Long> {
	List<Citizen> findByVaccinationCenter(VaccineCenter vaccinationCenter);
}
