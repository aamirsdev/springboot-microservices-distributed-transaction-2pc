package io.learning.product.repository;

import io.learning.product.domain.DummyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DummyRepository extends JpaRepository<DummyEntity, Long> {
}