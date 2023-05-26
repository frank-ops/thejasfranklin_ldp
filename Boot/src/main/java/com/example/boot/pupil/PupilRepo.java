package com.example.boot.pupil;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface PupilRepo extends JpaRepository<Pupil,Long> {

    @Query("select p from Pupil p where p.email= ?1")
    Optional<Pupil> findByEmail(String mail);


}
