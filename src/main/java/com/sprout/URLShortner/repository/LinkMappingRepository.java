package com.sprout.URLShortner.repository;

import com.sprout.URLShortner.postgress.entities.LinkMappingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import static com.sprout.URLShortner.common.constant.QueryConstant.GET_URL_FROM_KEY;


@Repository
public interface LinkMappingRepository extends JpaRepository<LinkMappingEntity, Long> {

    @Query(GET_URL_FROM_KEY)
    String getUrlForKey(@Param("keyUrl") String keyUrl);

}
