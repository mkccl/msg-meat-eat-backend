package de.mkccl.communityprojectbackend.auth.user.repository;

import de.mkccl.communityprojectbackend.auth.user.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<UserModel, String> {


    @Query("SELECT usr FROM UserModel usr WHERE usr.email LIKE :email")
    UserModel getUserByEmail(@Param("email") String email);

}
