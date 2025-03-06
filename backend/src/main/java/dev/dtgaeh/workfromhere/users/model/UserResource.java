package dev.dtgaeh.workfromhere.users.model;

import dev.dtgaeh.workfromhere.spaces.model.SpaceResource;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class UserResource {
    private Integer id;
    private String name;
    private String email;
    private String password;
    private List<SpaceResource> favouriteSpaces;
}
