package de.mkccl.communityprojectbackend.auth.user.model;

import de.mkccl.communityprojectbackend.project.model.ProjectModel;
import de.mkccl.communityprojectbackend.storage.model.BackgroundModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

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
    @Column(name = "auth_user_id")
    private String userId;

    @Column(name = "auth_user_firstname")
    private String firstName;

    @Column(name = "auth_user_lastname")
    private String lastName;

    @Column(name = "auth_user_email")
    private String email;

    @Column(name = "auth_user_password")
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_flag_userid")
    private UserFlagModel flag;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_dashboard_image_userId")
    private BackgroundModel dashboardImage;

    @ManyToMany
    @JoinTable(
            name = "user_project_member",
            joinColumns = { @JoinColumn(name = "auth_user_id") },
            inverseJoinColumns = { @JoinColumn(name = "project_id") }
    )
    private List<ProjectModel> project;

}
