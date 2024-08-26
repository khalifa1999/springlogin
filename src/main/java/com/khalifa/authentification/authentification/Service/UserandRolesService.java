package com.khalifa.authentification.authentification.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.khalifa.authentification.authentification.Model.AppRole;
import com.khalifa.authentification.authentification.Model.MyAppUser;
import com.khalifa.authentification.authentification.Repository.AppRoleRepository;
import com.khalifa.authentification.authentification.Repository.MyAppUserRepository;

@Service
public class UserandRolesService{

  @Autowired 
  private MyAppUserRepository myAppUserRepository;

  @Autowired 
  private AppRoleRepository appRoleRepository;


  
}
