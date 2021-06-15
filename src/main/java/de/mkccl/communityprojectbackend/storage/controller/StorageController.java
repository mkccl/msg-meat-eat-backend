package de.mkccl.communityprojectbackend.storage.controller;

import de.mkccl.communityprojectbackend.auth.user.model.UserModel;
import de.mkccl.communityprojectbackend.auth.user.repository.UserRepository;
import de.mkccl.communityprojectbackend.storage.utils.BackgroundImageEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * Created by
 * User: Michael Krause
 * Date: 15.06.21
 * Time: 13:43
 */

@RestController
@RequestMapping("api/v1/storage/")
public class StorageController {

    @Autowired
    UserRepository userRepository;

    private final String path = "/assets/img/";

    @GetMapping("{userId}/dashboard/image")
    public ResponseEntity<byte[]> getBackground(@PathVariable("userId") String userId) throws IOException {


        UserModel userModel = userRepository.getById(userId);

        String picturePath = userModel.getDashboardImage().getPath();

        // KlassenPfad wird als Pfad eingelesen und als variable gespeichert
        var imgFile = new ClassPathResource(path + "background/" + picturePath);

        // Bild wird in ein Array aus Bytes aufgelöst
        byte[] bytes = StreamUtils.copyToByteArray(imgFile.getInputStream());

        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(bytes);

    }

    @GetMapping("logo")
    public ResponseEntity<byte[]> getLogo() throws IOException {

        // KlassenPfad wird als Pfad eingelesen und als variable gespeichert
        var imgFile = new ClassPathResource(path + "logo.png");

        // Bild wird in ein Array aus Bytes aufgelöst
        byte[] bytes = StreamUtils.copyToByteArray(imgFile.getInputStream());

        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(bytes);
    }

    @GetMapping("project/logo")
    public ResponseEntity<byte[]> getProjectLogo() throws IOException {

        // KlassenPfad wird als Pfad eingelesen und als variable gespeichert
        var imgFile = new ClassPathResource(path + "40.png");

        // Bild wird in ein Array aus Bytes aufgelöst
        byte[] bytes = StreamUtils.copyToByteArray(imgFile.getInputStream());

        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(bytes);
    }
}
