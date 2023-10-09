package  com.ifx.mosip.print.io.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ifx.mosip.print.io.entity.IFXPrintInfo;


public interface IFXPrintInfoRepository  extends JpaRepository<IFXPrintInfo,Long>{
}