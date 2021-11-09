package com.gorelko.ntiteam.repository;

import com.gorelko.ntiteam.model.Lord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface LordRepository extends JpaRepository<Lord, Long> {


    @Query(value = "SELECT t.ID FROM LORD t WHERE t.AGE = ?1 AND t.NAME = ?2", nativeQuery = true)
    Long idLord(int ageLord, String nameLord);

    @Modifying
    @Transactional
    @Query(value = "UPDATE PLANET SET LORD_ID = ?1 WHERE name = ?2", nativeQuery = true)
    void setPlanetforLord(long id, String planet);

    @Query(value = "SELECT * FROM LORD WHERE ID NOT IN (SELECT LORD_ID FROM PLANET WHERE LORD_ID >= 0)", nativeQuery = true)
    List<Lord> findLazyLords();

    @Query(value = "SELECT * FROM LORD ORDER BY AGE LIMIT 0,10", nativeQuery = true)
    List<Lord> findYoungLords();

}
