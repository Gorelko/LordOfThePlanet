package com.gorelko.ntiteam.repository;

import com.gorelko.ntiteam.model.Lord;
import com.gorelko.ntiteam.model.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PlanetRepository extends JpaRepository<Planet, Long> {

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM PLANET WHERE NAME = ?1", nativeQuery = true)
    void delPlanet(String namePlanet);


}