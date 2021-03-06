package hh.palvelinohjelmointi.ProjectList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import hh.palvelinohjelmointi.ProjectList.web.UserDetailServiceImpl;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{
	
    @Autowired
    private UserDetailServiceImpl userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
		 .authorizeRequests()
		 .antMatchers("/", "/projectCatalog", "/register", "/saveMember").permitAll()
		 .anyRequest().authenticated()
		 .and()
		 .formLogin()
		  .loginPage("/login")
		 .permitAll();
	}
	
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
}
