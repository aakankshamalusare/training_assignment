package project;

import java.util.HashSet;
import java.util.Set;

public class Project {
	
	private String projectName;
	private String projectInfo;
	private Set<String> teamMembers;
	
	
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public Set<String> getTeamMembers() {
		return teamMembers;
	}
	public void setTeamMembers(Set<String> teamMembers) {
		this.teamMembers = teamMembers;
	}
	
	@Override
	public String toString() {
		return "Project [projectName=" + projectName + ", teamMembers=" + teamMembers + "]";
	}
	
	public Project() {
		
	}
	public Project(String projectName,String projectInfo){
		super();
		this.projectName = projectName;
		this.projectInfo = projectInfo;
		this.teamMembers = new HashSet<>();
	}
	public String getProjectInfo() {
		return projectInfo;
	}
	public void setProjectInfo(String projectInfo) {
		this.projectInfo = projectInfo;
	}

    public void addTeamMember(String memberName) {
        teamMembers.add(memberName);
    }
	

}
