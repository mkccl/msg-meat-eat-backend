package de.mkccl.communityprojectbackend.auth.user.repository;

import de.mkccl.communityprojectbackend.project.model.ProjectModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectRepository extends JpaRepository<ProjectModel, Integer> {



}
