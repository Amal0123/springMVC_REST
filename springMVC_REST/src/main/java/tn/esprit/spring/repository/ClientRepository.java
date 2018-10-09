/*
 * Copyright 2017 by Walid YAICH <walid.yaich@esprit.tn>
 * This is an Open Source Software
 * License: http://www.gnu.org/licenses/gpl.html GPL version 3
 */

package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entity.Client;


//https://docs.spring.io/spring-data/jpa/docs/current/reference/html
public interface ClientRepository extends CrudRepository<Client, Long> {
    @Transactional
    @Modifying
    @Query("update Client c set c.firstName = ?1, c.lastName = ?2, c.email = ?3 where c.id = ?4")
    void updateClientInfoById(String firstname, String lastname, String email, Long userId);
	
    Client findById(Long id);
    
    Client findByFirstNameAndLastName(String firstName, String lastName);
    
    @Query("Select c.lastName from Client c where c.id=?1")
    String findLastNameById(Long id);
    
    @Query("Select count(c) from Client c where c.lastName=:lastName")
    long countClientsByName(@Param("lastName") String lastName);
}