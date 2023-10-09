package com.ifx.mosip.print.io.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ifx.mosip.print.io.entity.IFXOperationalStatus;
import com.ifx.mosip.print.io.entity.IFXPrintInfo;
import com.ifx.mosip.print.io.service.IFXPrintInfoStoreService;
import com.ifx.mosip.print.io.service.IFXSmartcardPrintService;


@Controller
@RequestMapping("/ifx")
public class IFXPrintInfoController {

	private Logger logger = LoggerFactory.getLogger(IFXPrintInfoController.class);

	IFXPrintInfoStoreService printStoreService;
	IFXSmartcardPrintService smartCardPrintService;

	public IFXPrintInfoController(IFXPrintInfoStoreService service,IFXSmartcardPrintService smartCardPrintService){
		this.printStoreService=service;
		this.smartCardPrintService=smartCardPrintService;
	}

	
	@PostMapping("/notifySave")
	public ResponseEntity<IFXOperationalStatus> print(@RequestBody  IFXPrintInfo printInfo) {
		logger.info(String.format("Received Store event %s ",printInfo.toString()));
		IFXOperationalStatus status = printStoreService.save(printInfo);
		return new ResponseEntity<IFXOperationalStatus>(status, HttpStatus.OK);
	}

	@PostMapping("/notifyPrint")
	public ResponseEntity<IFXOperationalStatus> printCard(@ModelAttribute("IFXPrintInfo") IFXPrintInfo payload) {
		logger.info(String.format("Received Print event %s ",payload.toString()));

		IFXOperationalStatus dbPrintInfo = printStoreService.retrivePrintInfoUsingUIN(payload.getUin());
		if(dbPrintInfo.getData()!=null){
			IFXOperationalStatus printStatus = smartCardPrintService.print((IFXPrintInfo) dbPrintInfo.getData());
			if (printStatus.getStatus() == IFXOperationalStatus.OK) {
				IFXOperationalStatus status = printStoreService.modifyPrintInfo((IFXPrintInfo) dbPrintInfo.getData());
				return new ResponseEntity<IFXOperationalStatus>(status, HttpStatus.OK);
			}
		}
		IFXOperationalStatus printStatus = new IFXOperationalStatus(String.format("Data not found for the UIN %d ",payload.getUin()), IFXOperationalStatus.ERROR, payload);
		return new ResponseEntity<IFXOperationalStatus>(printStatus, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping("/listPrintInfos")
	public List<IFXPrintInfo> getPrintInfos(){
		logger.info(String.format("Received Get PrintInfos event..."));
		return printStoreService.retrivePrintInfos();
	}
}
