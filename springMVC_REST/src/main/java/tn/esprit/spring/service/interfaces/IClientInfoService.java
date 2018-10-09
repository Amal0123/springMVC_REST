/*
 * Copyright 2017 by Walid YAICH <walid.yaich@esprit.tn>
 * This is an Open Source Software
 * License: http://www.gnu.org/licenses/gpl.html GPL version 3
 */

package tn.esprit.spring.service.interfaces;

import java.util.List;
import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Project;

/**
 * Cette interface contient les méthodes qui permettent de gérer les clients et leur projets
 * @author Walid YAICH
 */
public interface IClientInfoService {
	public void addClient(Client client);
	public void addProjectAndAssignToClient(Project project, Long clientId);
	public Client getClientById(Long clientId);
	public void updateClientInfoById(Client client, Long clientId);
	public Project getProjectById(Long projectId);
	public List<Project> getAllProjects();
	public void deleteClient(Client client);
	public Long countClients();
	public void deleteAllProjects();
	public void updateProject(Long projectId, Project project);
}