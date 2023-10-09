package com.ifx.mosip.print.io.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifx.mosip.print.io.dao.IFXPrintInfoRepository;
import com.ifx.mosip.print.io.entity.IFXOperationalStatus;
import com.ifx.mosip.print.io.entity.IFXPrintInfo;

@Service
public class IFXPrintInfoStoreServiceImpl implements IFXPrintInfoStoreService {
   
    public IFXPrintInfoRepository repository;
    
    @Autowired
    public IFXPrintInfoStoreServiceImpl(IFXPrintInfoRepository repository) {
    	this.repository=repository;
    }

    @Override
    public IFXOperationalStatus save(IFXPrintInfo printInfo) {
        Exception currException;
        try {
            repository.save(printInfo);
            return new IFXOperationalStatus(
                    String.format("Information for UIN  {%d} is stored successfully", printInfo.getUin()),
                    IFXOperationalStatus.ERROR, printInfo);
        } catch (Exception ex) {
            currException = ex;
        }
        return new IFXOperationalStatus(
                String.format("Information for UIN  {%d} failed to store, because of the below reason \n {%s}",
                        printInfo.getUin(), currException.getMessage()),
                IFXOperationalStatus.ERROR, printInfo);
    }

    @Override
    public IFXOperationalStatus modifyPrintInfo(IFXPrintInfo printInfo) {
        try {
            Optional<IFXPrintInfo> fromDB = repository.findById(printInfo.getUin());

            if (fromDB == null || fromDB.get() == null) {
                return new IFXOperationalStatus(
                        String.format("Information for UIN  {%d} not found ", printInfo.getUin()),
                        IFXOperationalStatus.ERROR, printInfo);
            }
            repository.delete(fromDB.get());
            
            IFXPrintInfo latest=new IFXPrintInfo(printInfo.getUin(),printInfo.getName(), printInfo.getDob(), printInfo.getGender(), printInfo.getAddress(),printInfo.getPhoto(), printInfo.getQrcode(), 1);
            
            return save(latest);
        } catch (Exception ex) {
            return new IFXOperationalStatus(
                    String.format("Information for UIN  {%d} failed to store, because of the following reason \n {%s}",
                            printInfo.getUin(), ex.getMessage()),
                    IFXOperationalStatus.ERROR, printInfo);
        }
    }

    @Override
    public List<IFXPrintInfo> retrivePrintInfos() {
        List<IFXPrintInfo> printInfos = repository.findAll();
        return printInfos;
    }

    @Override
    public IFXOperationalStatus retrivePrintInfoUsingUIN(Long uin) {
        try {
            Optional<IFXPrintInfo> fromDB = repository.findById(uin);
            IFXPrintInfo ifxPrintInfo = fromDB.get();
            if (ifxPrintInfo != null) {
                return new IFXOperationalStatus(
                        String.format("Information for UIN  {%d} retrived successfully", uin),
                        IFXOperationalStatus.ERROR,
                        ifxPrintInfo);

            }
        } catch (Exception ex) {
            return new IFXOperationalStatus(
                    String.format("Information for UIN  {%d} failed to store, because of the following reason \n {%s}",
                            uin, ex.getMessage()),
                    IFXOperationalStatus.ERROR,
                    null);
        }
        return new IFXOperationalStatus(
                String.format("Information for UIN  {%d} not found", uin), IFXOperationalStatus.ERROR, null);
    }

}
