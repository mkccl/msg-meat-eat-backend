package de.mkccl.communityprojectbackend.storage.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by
 * User: Michael Krause
 * Date: 15.06.21
 * Time: 14:00
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "user_dashboard_image")
public class BackgroundModel {

    @Id
    @GeneratedValue
    @Column(name = "user_dashboard_image_dashboardid")
    private int dashboardId;

    @Column(name = "user_dashboard_image_path")
    private String path;

    @Column(name = "user_dashboard_image_type")
    private String type;




}
