package de.mkccl.communityprojectbackend.project.controller;

import de.mkccl.communityprojectbackend.auth.user.exception.UserNotFoundException;
import de.mkccl.communityprojectbackend.auth.user.model.UserModel;
import de.mkccl.communityprojectbackend.auth.user.repository.ProjectRepository;
import de.mkccl.communityprojectbackend.auth.user.repository.UserRepository;
import de.mkccl.communityprojectbackend.project.model.ProjectFlagModel;
import de.mkccl.communityprojectbackend.project.model.ProjectModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by
 * User: Michael Krause
 * Date: 17.06.21
 * Time: 11:10
 */

@RestController
@RequestMapping("api/v1/project")
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/get/{userId}")
    public List<ProjectModel> getProjectsFromUser(@PathVariable("userId") String userId) {

        return null;

    }

    @PostMapping("/post")
    public ProjectModel createProject(@RequestBody ProjectModel projectModel) throws UserNotFoundException {

        UserModel userModel = userRepository.findById(projectModel.getProjectLeaderUserId())
                .orElseThrow(
                        () -> new UserNotFoundException(projectModel.getProjectLeaderUserId())
                );

        /*
         * Flags
         */
        ProjectFlagModel flag = new ProjectFlagModel();
        flag.setCreateAt(new Date(System.currentTimeMillis()));
        flag.setEditedAt(new Date(System.currentTimeMillis()));
        flag.setPrivate(true);

        projectModel.setFlag(flag);

        /**
         * User wird zum Projekt hinzugefügt
         */
        List<UserModel> userModelList = new ArrayList<>();
        userModelList.add(userModel);

        projectModel.setMember(userModelList);

        // In die Datenbank schreiben
        projectRepository.save(projectModel);
        userRepository.save(userModel);

        return projectModel;
    }

}
