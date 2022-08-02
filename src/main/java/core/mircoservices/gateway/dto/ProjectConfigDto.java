package core.mircoservices.gateway.dto;

import core.mircoservices.gateway.ProjectConfig;

public class ProjectConfigDto extends ProjectConfig {

	public ProjectConfigDto() { }
	
	public ProjectConfigDto(ProjectConfig projectConfig) {
		this.setTitle(projectConfig.getTitle());
		this.setLastUpdated(projectConfig.getLastUpdated());
		this.setContacts(projectConfig.getContacts());
		this.setPhones(projectConfig.getPhones());
	}
}
