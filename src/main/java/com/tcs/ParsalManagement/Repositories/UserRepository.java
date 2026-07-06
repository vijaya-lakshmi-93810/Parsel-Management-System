package com.tcs.ParsalManagement.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tcs.ParsalManagement.Models.User;
@Repository
public interface UserRepository extends JpaRepository<User, String> 
{

}
