package com.cognito.project.service;

import org.springframework.data.jpa.repository.JpaRepository;


import com.cognito.project.entity.CognitoAccount;

public interface CognitoRepository extends JpaRepository<CognitoAccount,Integer> {

}
