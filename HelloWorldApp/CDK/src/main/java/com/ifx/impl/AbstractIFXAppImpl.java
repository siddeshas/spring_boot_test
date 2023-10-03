package com.ifx.impl;
import com.ifx.model.*;
import software.amazon.awscdk.Environment;

public abstract class AbstractIFXAppImpl implements IIFXApp{


 public static Environment makeEnv(String account, String region) {
    return Environment.builder()
      .account(account)
      .region(region)
      .build();
  }
}