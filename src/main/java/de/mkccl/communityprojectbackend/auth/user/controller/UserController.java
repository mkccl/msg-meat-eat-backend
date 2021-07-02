package de.mkccl.communityprojectbackend.auth.user.controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
import de.mkccl.communityprojectbackend.auth.user.model.UserFlagModel;
import de.mkccl.communityprojectbackend.auth.user.model.UserModel;
import de.mkccl.communityprojectbackend.auth.user.repository.UserRepository;
import de.mkccl.communityprojectbackend.storage.model.BackgroundModel;
import de.mkccl.communityprojectbackend.storage.utils.BackgroundImageEnum;
import org.hibernate.NonUniqueResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Created by
 * User: Michael Krause
 * Date: 14.06.21
 * Time: 11:50
 */


@RestController
@RequestMapping("api/v1/auth/")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("user/authenticate")
    public ResponseEntity<UserModel> getUser(@RequestBody UserModel userModel) {

        UserModel user;

        try {
            user = userRepository.getUserByEmail(userModel.getEmail());

            BCrypt.Result result = BCrypt.verifyer().verify(userModel.getPassword().toCharArray(), user.getPassword());

            if (result.verified) {
                System.out.println("true");
                return ResponseEntity.status(200).body(user);
            }
            else {
                System.out.println("false");
                return ResponseEntity.status(403).body(null);

            }

        } catch (NullPointerException e) {
            return ResponseEntity.status(400).body(null);
        }

    }

    @PostMapping("user/register")
    public ResponseEntity<UserModel> addUser(@RequestBody UserModel userModel) {


        try {

            UserModel user = userRepository.getUserByEmail(userModel.getEmail());

            if (!user.getEmail().isEmpty()) {
                return ResponseEntity.status(409).body(null);
            }
            if (user.getEmail() == null) {
                return ResponseEntity.status(409).body(null);
            }

        } catch (NullPointerException | NonUniqueResultException npe) {

            UserFlagModel flag = new UserFlagModel();
            BackgroundModel backgroundModel = new BackgroundModel();

            backgroundModel.setPath(userModel.getUserId());

            flag.setNewUser(true);
            flag.setHasBackgroundImage(true);

            backgroundModel.setPath(BackgroundImageEnum.BACKGROUND4.getValue());
            backgroundModel.setType("jpeg");

            userModel.setDashboardImage(backgroundModel);
            userModel.setFlag(flag);


            String bcryptHashString = BCrypt.withDefaults().hashToString(12, userModel.getPassword().toCharArray());
            userModel.setPassword(bcryptHashString);

            userModel.setUserId(UUID.randomUUID().toString());

            return ResponseEntity.ok(userRepository.save(userModel));
        }

        return ResponseEntity.status(500).body(null);

    }

}
