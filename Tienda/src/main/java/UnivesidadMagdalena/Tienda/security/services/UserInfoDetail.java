package UnivesidadMagdalena.Tienda.security.services;

import UnivesidadMagdalena.Tienda.entities.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

import UnivesidadMagdalena.Tienda.entities.User;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public class UserInfoDetail implements UserDetails {

    private static final long serialVersionUID = 1L;
    private long id;
    private String username;
    private String email;

    @JsonIgnore
    private String password;

    private List<GrantedAuthority> authorities;

    public UserInfoDetail(Long id, String username, String email, String password,
                          List<GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    public UserInfoDetail(User user){
        email = user.getEmail();
        password = user.getPassword();
        authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getRol().name()))
                        .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
