package de.mkccl.communityprojectbackend.project.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by
 * User: Michael Krause
 * Date: 17.06.21
 * Time: 10:59
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "project_flag")
public class ProjectFlagModel {

    @Id
    @GeneratedValue
    @Column(name = "project_flag_id")
    private int flagId;

    @Column(name = "project_flag_create_at")
    private Date createAt;

    @Column(name = "project_flag_edited_at")
    private Date editedAt;

    @Column(name = "project_flag_is_private")
    private boolean isPrivate;


}
