package com.example.clickup.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;
import java.util.UUID;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public AuthenticationProvider authenticationProvider() {
        String password = UUID.randomUUID().toString();
        System.out.println("User Password : " + password);

        UserDetails user = User.builder()
                .username("user")
                .password("{noop}" + password)
                .roles("USER")
                .build();

        final DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(new InMemoryUserDetailsManager(user));
        return authenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorizationManagerRequestMatcherRegistry -> {
            authorizationManagerRequestMatcherRegistry
                    // Attachment
                    .requestMatchers(HttpMethod.GET, "/attachment", "/attachment/*").permitAll()
                    .requestMatchers(HttpMethod.POST, "/attachment").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/attachment/*").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/attachment/*").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    // Category
                    .requestMatchers(HttpMethod.GET, "/category", "/category/*").permitAll()
                    .requestMatchers(HttpMethod.POST, "/category").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/category/*").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/category/*").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    // CategoryUser
                    .requestMatchers(HttpMethod.GET, "/categoryUser", "/categoryUser/*").permitAll()
                    .requestMatchers(HttpMethod.POST, "/categoryUser").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/categoryUser/*").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/categoryUser/*").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    // Checklist
                    .requestMatchers(HttpMethod.GET, "/checklist", "/checklist/*").permitAll()
                    .requestMatchers(HttpMethod.POST, "/checklist").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/checklist/*").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/checklist/*").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    // ChecklistItem
                    .requestMatchers(HttpMethod.GET, "/checkListItem", "/checkListItem/*").permitAll()
                    .requestMatchers(HttpMethod.POST, "/checkListItem").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/checkListItem/*").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/checkListItem/*").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    // ClickApps
                    .requestMatchers(HttpMethod.GET, "/clickApps", "/clickApps/*").permitAll()
                    .requestMatchers(HttpMethod.POST, "/clickApps").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/clickApps/*").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/clickApps/*").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    // Comment
                    .requestMatchers(HttpMethod.OPTIONS, "/comment", "/comment/*").permitAll()
                    // Icon
                    .requestMatchers(HttpMethod.GET, "icon", "/icon/*").permitAll()
                    .requestMatchers(HttpMethod.POST, "icon").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.PUT, "icon/*").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "icon/*").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    // Priority
                    .requestMatchers(HttpMethod.GET, "/priority", "/priority/*").permitAll()
                    .requestMatchers(HttpMethod.POST, "/priority").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/priority/*").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/priority/*").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    // Project
                    .requestMatchers(HttpMethod.OPTIONS, "/project","/project/*").permitAll()
                    // ProjectUser
                    .requestMatchers(HttpMethod.GET, "/projectUser","/projectUser/*").permitAll()
                    .requestMatchers(HttpMethod.POST, "/projectUser").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/projectUser/*").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/projectUser/*").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    // SpaceClickApps
                    .requestMatchers(HttpMethod.GET, "/spaceClickApps", "/spaceClickApps/*").permitAll()
                    .requestMatchers(HttpMethod.POST, "/spaceClickApps").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/spaceClickApps/*").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/spaceClickApps/*").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    // Space
                    .requestMatchers(HttpMethod.GET, "/space", "/space/*").permitAll()
                    .requestMatchers(HttpMethod.POST, "/space").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/space/*").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/space/*").hasAnyRole("SUPER_ADMIN","ADMIN")
                    // SpaceUser
                    .requestMatchers(HttpMethod.GET, "/spaceUser","/spaceUser/*").permitAll()
                    .requestMatchers(HttpMethod.POST, "/spaceUser").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/spaceUser/*").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/spaceUser/*").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    // SpaceView
                    .requestMatchers(HttpMethod.GET, "/spaceView","/spaceView/*").permitAll()
                    .requestMatchers(HttpMethod.POST, "/spaceView").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/spaceView/*").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/spaceView/*").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    // Status
                    .requestMatchers(HttpMethod.GET, "/status","/status/*").permitAll()
                    .requestMatchers(HttpMethod.POST, "/status").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/status/*").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/status/*").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    // Tag
                    .requestMatchers(HttpMethod.OPTIONS, "/tag","/tag/*").permitAll()
                    // TaskAttachment
                    .requestMatchers(HttpMethod.GET, "/taskAttachment","/taskAttachment/*").permitAll()
                    .requestMatchers(HttpMethod.POST, "/taskAttachment").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/taskAttachment/*").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/taskAttachment/*").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    // Task
                    .requestMatchers(HttpMethod.OPTIONS, "/task","/task/*").permitAll()
                    // TaskDependency
                    .requestMatchers(HttpMethod.GET, "/taskDependency","/taskDependency/*").permitAll()
                    .requestMatchers(HttpMethod.POST, "/taskDependency").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/taskDependency/*").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/taskDependency/*").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    // TaskHistory
                    .requestMatchers(HttpMethod.GET, "/taHistory","/taHistory/*").permitAll()
                    .requestMatchers(HttpMethod.POST, "/taHistory").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/taHistory/*").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/taHistory/*").permitAll()
                    // User
                    .requestMatchers(HttpMethod.GET, "/user","/user/*").permitAll()
                    .requestMatchers(HttpMethod.POST, "/user").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/user/*").permitAll()
                    .requestMatchers(HttpMethod.DELETE, "/user/*").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    // View
                    .requestMatchers(HttpMethod.GET, "/view","/view/*").permitAll()
                    .requestMatchers(HttpMethod.POST, "/view").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/view/*").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/view/*").hasAnyRole("SUPER_ADMIN", "ADMIN")
                    // Workspace
                    .requestMatchers(HttpMethod.OPTIONS, "/workspace","/workspace/*").permitAll()
                    // WorkspacePermission
                    .requestMatchers(HttpMethod.OPTIONS, "/workspacePermission","/workspacePermission/*").permitAll()
                    // WorkspaceRole
                    .requestMatchers(HttpMethod.OPTIONS, "/workspaceRole","/workspaceRole/*").permitAll()
                    // WorkspaceUser
                    .requestMatchers(HttpMethod.OPTIONS, "/workspaceUser","/workspaceUser/*").permitAll()

                    .anyRequest()
                    .authenticated();
        }).formLogin(Customizer.withDefaults());

        http.httpBasic(Customizer.withDefaults());

        http.csrf(csrf -> csrf.ignoringRequestMatchers("/api/**"));
        http.cors(cors -> cors.configurationSource(request -> {
            var config = new org.springframework.web.cors.CorsConfiguration();
            config.setAllowedOrigins(List.of("https://your-frontend.com")); // frontend domain
            config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));
            config.setAllowedHeaders(List.of("*"));
            return config;
        }));
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence rawPassword) {
                return rawPassword.toString();
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                String md5 = MD5Util.getMD5(rawPassword.toString());
                return md5.equals(encodedPassword);
            }
        };

    }

}