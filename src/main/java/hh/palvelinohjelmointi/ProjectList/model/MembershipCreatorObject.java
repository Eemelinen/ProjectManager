package hh.palvelinohjelmointi.ProjectList.model;

public class MembershipCreatorObject {
	
	private String id;
	private String username;
	private String jobDescription;

	public MembershipCreatorObject() {
		super();
	}

	public MembershipCreatorObject(String id, String username, String jobDescription) {
		super();
		this.id = id;
		this.username = username;
		this.jobDescription = jobDescription;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	@Override
	public String toString() {
		return "MembershipCreatorObject [id=" + id + ", username=" + username + ", jobDescription=" + jobDescription
				+ "]";
	}
	
}
