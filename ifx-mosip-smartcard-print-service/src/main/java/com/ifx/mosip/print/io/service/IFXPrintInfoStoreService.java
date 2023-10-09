package com.ifx.mosip.print.io.service;

import java.util.List;

import com.ifx.mosip.print.io.entity.IFXOperationalStatus;
import com.ifx.mosip.print.io.entity.IFXPrintInfo;

public interface IFXPrintInfoStoreService {
    
    public IFXOperationalStatus save(IFXPrintInfo printInfo);

    public IFXOperationalStatus modifyPrintInfo(IFXPrintInfo printInfo);

    public List<IFXPrintInfo> retrivePrintInfos();

    public IFXOperationalStatus retrivePrintInfoUsingUIN(Long uin);
}
