package azamat.config.security.model;

import org.springframework.security.core.GrantedAuthority;

public enum ERole implements GrantedAuthority {
    ROLE_ADMIN,
    ROLE_VENDOR,
    ROLE_CLIENT;

    @Override
    public String getAuthority() {
        return this.name();
    }
}
