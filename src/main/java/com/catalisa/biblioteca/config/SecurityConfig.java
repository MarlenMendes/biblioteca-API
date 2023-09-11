package com.catalisa.biblioteca.config;

@Configuration
@EnableWebSecurity
public class SecurtyConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails user = User.withUsername("marlen")
            .password(passwordEncoder.encode("1234"))
            .roles("USER")
            .build();

        UserDetails admin = User.withUsername("jose")
            .password(passwordEncoder.encode("5678"))
            .roles("USER", "ADMIN")
            .build();

        return new InMemoryUserDetailsManager(user, admin);
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return encoder;
    }

    @Bean
    public SecurityFilterChain apiFilterChain(HttpSecurity http) throws Exception {
        http
            .securityMatcher("/livros/**")                                   
            .authorizeHttpRequests(authorize -> authorize
                .anyRequest().hasRole("user")
            )
            .httpBasic(withDefaults());
        return http.build();
    }
}