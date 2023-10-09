package com.ifx.mosip.print.io.service;

import org.springframework.stereotype.Service;

import com.ifx.mosip.print.io.entity.IFXOperationalStatus;
import com.ifx.mosip.print.io.entity.IFXPrintInfo;

@Service
public class IFXSmartcardPrintServiceImpl implements IFXSmartcardPrintService{

    @Override
    public IFXOperationalStatus print(IFXPrintInfo printInfo) {
        return new IFXOperationalStatus(String.format("Smart card printing successful for UIN  {%d} ",printInfo.getUin()), IFXOperationalStatus.OK,printInfo);
    }
    
}
