package hh.palvelinohjelmointi.ProjectList.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Membership {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long membershipId;
	
	private String jobDescription;
	
	private Date date;
	
	@ManyToOne
	@JoinColumn(name = "memberId")
	private Member member;
	
	@ManyToOne
	@JoinColumn(name = "projectId")
	private Project project;
	
	public Membership() {}

	public Membership(String jobDescription, Member member, Project project) {
		super();
		this.jobDescription = jobDescription;
		this.date = new Date();
		this.member = member;
		this.project = project;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public long getMembershipId() {
		return membershipId;
	}
	public void setMembershipId(long membershipId) {
		this.membershipId = membershipId;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@Override
	public String toString() {
		return "Membership [membershipId=" + membershipId + ", jobDescription=" + jobDescription + ", date=" + date
				+ ", member=" + member + ", project=" + project + "]";
	}
}
