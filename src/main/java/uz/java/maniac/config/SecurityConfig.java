package uz.java.maniac.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true,
        prePostEnabled = true
)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Qualifier("customUserDetailsService")
    @Autowired
    UserDetailsService userDetailsService;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

//        auth
//                .inMemoryAuthentication()
//                .withUser("admin").password(passwordEncoder().encode("admin")).roles("ADMIN")
//                .and()
//                .withUser("user").password(passwordEncoder().encode("user")).roles("USER");

        auth
                .userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//                .and()
//                .inMemoryAuthentication()
//                .withUser("admin").password(passwordEncoder().encode("admin")).roles("ADMIN");

    }

    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .headers()
                .frameOptions()
                .disable()
                .and()
                .authorizeRequests()
//                .antMatchers("/").permitAll()
                .antMatchers("/login").permitAll()
//                .antMatchers("api/login").permitAll()
//                .antMatchers("/*").permitAll()
//                .antMatchers("/dist/*").permitAll()
//                .antMatchers("/all").permitAll()
//                .antMatchers("/all/*").permitAll()
//                .antMatchers("/api/register").permitAll()
//                .antMatchers("/register").permitAll()
//                .antMatchers("/js/*").permitAll()
//                .antMatchers("/admin").hasRole("ADMIN")
//                .antMatchers("/admin/*").hasRole("ADMIN")
//                .antMatchers("/admin/*").hasAuthority("ADMIN")
////                .antMatchers("/admin/api/*").hasRole("ADMIN")
////                .antMatchers("/admin/simple-test").hasRole("ADMIN")
////                .antMatchers("/admin/simple-home").hasRole("ADMIN")
//                .antMatchers("/user/").hasRole("USER")
//                .antMatchers("/user/*").hasRole("USER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
//                .disable()
//                .httpBasic();
//                .formLogin()
                .successForwardUrl("/")
                .defaultSuccessUrl("/");
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new PasswordEncoderTest();
    }
    static class PasswordEncoderTest implements PasswordEncoder {
        @Override
        public String encode(CharSequence charSequence) {
            return charSequence.toString();
        }

        @Override
        public boolean matches(CharSequence charSequence, String s) {
            return charSequence.toString().equals(s);
        }
    }
}
