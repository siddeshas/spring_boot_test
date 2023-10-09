package com.ifx.mosip.print.io.service;

import com.ifx.mosip.print.io.entity.IFXOperationalStatus;
import com.ifx.mosip.print.io.entity.IFXPrintInfo;


public interface IFXSmartcardPrintService {

   public IFXOperationalStatus print(IFXPrintInfo printInfo);
   
}
