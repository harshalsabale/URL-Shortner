package com.sprout.URLShortner.repository;

import com.sprout.URLShortner.postgress.entities.LinkMappingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LinkMappingRepository extends JpaRepository<LinkMappingEntity, Long> {

}
