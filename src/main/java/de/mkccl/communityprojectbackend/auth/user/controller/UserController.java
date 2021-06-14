package de.mkccl.communityprojectbackend.auth.user.controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
import de.mkccl.communityprojectbackend.auth.user.model.UserModel;
import de.mkccl.communityprojectbackend.auth.user.repository.UserRepository;
import org.hibernate.NonUniqueResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.UUID;

/**
 * Created by
 * User: Michael Krause
 * Date: 14.06.21
 * Time: 11:50
 */


@RestController
@RequestMapping("api/v1/auth/")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
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
            System.out.println(npe);

            String bcryptHashString = BCrypt.withDefaults().hashToString(12, userModel.getPassword().toCharArray());
            userModel.setPassword(bcryptHashString);

            userModel.setUserId(UUID.randomUUID().toString());

            return ResponseEntity.ok(userRepository.save(userModel));
        }

        return ResponseEntity.status(500).body(null);

    }

}
