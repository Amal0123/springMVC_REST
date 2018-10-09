/*
 * Copyright 2017 by Walid YAICH <walid.yaich@esprit.tn>
 * This is an Open Source Software
 * License: http://www.gnu.org/licenses/gpl.html GPL version 3
 */

package tn.esprit.spring.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Project;


//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods
public interface ProjectRepository extends CrudRepository<Project, Long> {
	List<Project> findByClient(Client client);
}