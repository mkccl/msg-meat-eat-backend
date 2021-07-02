package de.mkccl.communityprojectbackend.project.model;

import de.mkccl.communityprojectbackend.auth.user.model.UserModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Created by
 * User: Michael Krause
 * Date: 17.06.21
 * Time: 10:57
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


@Entity
@Table(name = "project")
public class ProjectModel {

    @Id
    @GeneratedValue
    @Column(name = "project_id")
    private int projectId;

    @Column(name = "project_owner_user_id")
    private String projectLeaderUserId;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "project_description")
    private String projectDescription;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "project_flag_id")
    private ProjectFlagModel flag;

    @ManyToMany
    @JoinTable(
            name = "project_project_member",
            joinColumns = { @JoinColumn(name = "project_id") },
            inverseJoinColumns = { @JoinColumn(name = "auth_user_id") }
    )
    private List<UserModel> member;


}
