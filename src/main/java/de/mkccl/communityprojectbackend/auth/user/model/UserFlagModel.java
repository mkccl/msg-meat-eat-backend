package de.mkccl.communityprojectbackend.auth.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by
 * User: Michael Krause
 * Date: 15.06.21
 * Time: 14:04
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


@Entity
@Table(name = "user_flag")
public class UserFlagModel {

    @Id
    @GeneratedValue
    @Column(name = "user_flag_flagid")
    private int flagId;

    @Column(name = "user_flag_background_image")
    private boolean hasBackgroundImage;

    @Column(name = "user_flag_isnewuser")
    private boolean isNewUser;

}
