package hh.palvelinohjelmointi.ProjectList.model;

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
	private String joiningTime;
	
	@ManyToOne
	@JoinColumn(name = "memberId")
	private Member member;
	
	public Membership() {}
		
	public Membership(String jobDescription, String joiningTime, Member member) {
		super();
		this.jobDescription = jobDescription;
		this.joiningTime = joiningTime;
		this.member = member;
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
	public String getJoiningTime() {
		return joiningTime;
	}
	public void setJoiningTime(String joiningTime) {
		this.joiningTime = joiningTime;
	}
	
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@Override
	public String toString() {
		return "Membership [membershipId=" + membershipId + ", jobDescription=" + jobDescription + ", joiningTime="
				+ joiningTime + ", member=" + member + "]";
	}
}
