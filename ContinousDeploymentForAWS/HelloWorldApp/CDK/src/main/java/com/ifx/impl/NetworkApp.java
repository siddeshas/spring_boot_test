package com.ifx.impl;

import software.amazon.awscdk.App;
import software.amazon.awscdk.Environment;
import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;

import static com.ifx.impl.Validations.*;

import dev.stratospheric.cdk.Network;


public class NetworkApp extends AbstractIFXAppImpl {
    public static void main(String[] args) {
      App app = new App();

      String environmentName = (String) app.getNode().tryGetContext("environmentName");
      requireNonEmpty(environmentName, "context variable 'environmentName' must not be null");
  
      String accountId = (String) app.getNode().tryGetContext("accountId");
      requireNonEmpty(accountId, "context variable 'accountId' must not be null");
  
      String region = (String) app.getNode().tryGetContext("region");
      requireNonEmpty(region, "context variable 'region' must not be null");
  
      String sslCertificateArn = (String) app.getNode().tryGetContext("sslCertificateArn");
    
  
      Environment awsEnvironment = makeEnv(accountId, region);
  
      Stack networkStack = new Stack(app, "NetworkStack", StackProps.builder()
        .stackName(environmentName + "-Network")
        .env(awsEnvironment)
        .build());
  
      Network network = new Network(
        networkStack,
        "Network",
        awsEnvironment,
        environmentName,
        new Network.NetworkInputParameters(sslCertificateArn));
        app.synth();
    }
}
