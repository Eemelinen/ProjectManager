package hh.palvelinohjelmointi.ProjectList.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import hh.palvelinohjelmointi.ProjectList.model.Member;
import hh.palvelinohjelmointi.ProjectList.model.MemberRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
	
	private final MemberRepository repository;
	
	@Autowired
	public UserDetailServiceImpl(MemberRepository memberRepository) {	
		this.repository = memberRepository;
	}
	
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {   
    	Member member = repository.findByUsername(username);
        UserDetails user = new org.springframework.security.core.userdetails.User(username, member.getPasswordHash(), 
        		AuthorityUtils.createAuthorityList(member.getRole()));
        return user;
    }   
}
