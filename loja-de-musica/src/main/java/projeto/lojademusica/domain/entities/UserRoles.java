package projeto.lojademusica.domain.entities;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum UserRoles{

    ADMIN("admin"),
    USER("user");

    private String role;

    UserRoles(String role){
        this.role = role;
    }

    public String getRole() {
        return role;
    }


}
