package com.ifx.impl;

import software.amazon.awscdk.App;
import software.amazon.awscdk.Environment;
import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;
import static com.ifx.impl.Validations.*;

public class BootstrapApp extends AbstractIFXAppImpl{
    

    public static void main(String[] args) {

        App app=new App();
        String region=(String)app.getNode().tryGetContext("region");
        requireNonEmpty(region, "Region cannot be empty");

        String accountID=(String)app.getNode().tryGetContext("accountId");
        requireNonEmpty(accountID, "Account ID cannot be empty");

        Environment env = makeEnv(accountID,region);

        Stack bootstrapStack=new Stack(app, "Bootstrap",StackProps.builder().env(env).build());
        app.synth();
    }
}
