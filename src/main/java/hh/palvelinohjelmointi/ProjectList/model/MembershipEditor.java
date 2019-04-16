package hh.palvelinohjelmointi.ProjectList.model;

public class MembershipEditor {
	
	private Long membershipId;
	private String jobDescription;
	private String username;
	private Long projectId;
	
	public MembershipEditor() {
		super();
	}

	public MembershipEditor(Long membershipId, String jobDescription, String username, Long projectId) {
		super();
		this.membershipId = membershipId;
		this.jobDescription = jobDescription;
		this.username = username;
		this.projectId = projectId;
	}

	public Long getMembershipId() {
		return membershipId;
	}

	public void setMembershipId(Long membershipId) {
		this.membershipId = membershipId;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	@Override
	public String toString() {
		return "MembershipEditor [membershipId=" + membershipId + ", jobDescription=" + jobDescription + ", username="
				+ username + ", projectId=" + projectId + "]";
	}

}
