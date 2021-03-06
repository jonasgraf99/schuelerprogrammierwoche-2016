package com.sybit.education.taschengeldboerse.repository;


import com.sybit.education.taschengeldboerse.domain.Anbieter;
import com.sybit.education.taschengeldboerse.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by stl on 09.06.2015.
 */
public interface AnbieterRepository extends JpaRepository<Anbieter,Long> {

    List<User> findByEmail(String email);

}
