/*
 * Copyright 2017 by Walid YAICH <walid.yaich@esprit.tn>
 * This is an Open Source Software
 * License: http://www.gnu.org/licenses/gpl.html GPL version 3
 */

package tn.esprit.spring.controller.impl;

import java.util.List;

import javax.persistence.NoResultException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Project;
import tn.esprit.spring.service.interfaces.IClientInfoService;


/**
 * 
 * Cette classe sert a implémenter les méthodes qui permettent de gérer un projet.
 * @author Walid YAICH
 *
 */
@RestController
@RequestMapping("/api")
public class ProjectController  {

	@Autowired
	private IClientInfoService clientInfoService;
	
	private Logger logger = LoggerFactory.getLogger(ProjectController.class);

	/**
	 * Ajouter un projet et l'affecter a un client
	 * @param projet
	 * @param clientId
	 */
	@RequestMapping(value = "/project", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addProject(@RequestBody Project projet, 
    									  @RequestParam("clientId") Long clientId){
    	logger.debug("Invocation de la resource : POST /project/");
    	clientInfoService.addProjectAndAssignToClient(projet, clientId);
    	return new ResponseEntity<>(HttpStatus.OK);
    }
	
	
	/**
	 * Mettre a jour les informations du projet
	 * @param projet
	 * @param clientId
	 */
	@RequestMapping(value = "/project/{projectId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateProject(@RequestBody Project project, 
    											@PathVariable("projectId") Long projectId){
    	logger.debug("Invocation de la resource : PUT /project/{projectId}");
    	try{
        	clientInfoService.updateProject(projectId, project);
    	}catch (NoResultException e) {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
    	return new ResponseEntity<>(HttpStatus.OK);
    }
	
	
	/**
	 * Retourner le projet s'il existe dans la base
	 * @param projectId
	 * @return Project project
	 */
    @RequestMapping(value = "/project/{projectId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Project> getProjet(@PathVariable("projectId") Long projectId) {
    	logger.debug("Invocation de la resource : GET /project/{projectId}");
    	
    	Project project = clientInfoService.getProjectById(projectId);
    	if(project == null){
    		logger.info("Impossible de trouver le projet");
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
        return new ResponseEntity<>(project, HttpStatus.CREATED);
    }
	
	
    /**
     * Récupérer tous les projets
     */
	@RequestMapping(value = "/project", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Project>> getAllProjects(){
    	logger.debug("Invocation de la resource : GET /project");
    	List<Project> projects = clientInfoService.getAllProjects();
    	if(projects.isEmpty()){
        	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    	}
    	return new ResponseEntity<>(projects, HttpStatus.OK);
    }
	
	
    /**
     * Supprimer tous les projets
     */
	@RequestMapping(value = "/project", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteAllProjects(){
    	logger.debug("Invocation de la resource : DELETE /project");
    	clientInfoService.deleteAllProjects();
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    	
}
