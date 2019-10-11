package com.santander.circuitbreaker;

public interface IClientLogic {
  public ClientDTO searchClientById(String id) throws Exception;
}
