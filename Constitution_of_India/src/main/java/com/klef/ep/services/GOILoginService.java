package com.klef.ep.services;

import javax.ejb.Remote;

import com.klef.ep.models.GOILogin;

@Remote
public interface GOILoginService 
{
  public GOILogin checkgoilogin(GOILogin GL);
}