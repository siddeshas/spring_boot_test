package com.ifx.mosip.print.io.entity;

public final class IFXOperationalStatus {
    
    private String message;
    private int status;
    private Object data;

    public static int OK =0;
    public static int ERROR =1;
    public static int WARNING =-1;
    
    
    public IFXOperationalStatus(String message,int status,Object obj){
       this.message=message;
       this.status=status;
       this.data=obj;
    }
    
    public String getMessage(){
        return message;
    }

    public int getStatus(){
        return status;
    }

    public Object getData(){
        return data;
    }
  
}
