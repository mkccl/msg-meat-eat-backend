package de.mkccl.communityprojectbackend.auth.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by
 * User: Michael Krause
 * Date: 14.06.21
 * Time: 11:50
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


@Entity
@Table(name = "auth_user")
public class UserModel {

    @Id
    private String userId;

    @Column(name = "auth_user_firstname")
    private String firstName;

    @Column(name = "auth_user_lastname")
    private String lastName;

    @Column(name = "auth_user_email")
    private String email;

    @Column(name = "auth_user_password")
    private String password;

}
