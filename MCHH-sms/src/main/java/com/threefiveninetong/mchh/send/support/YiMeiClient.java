package com.threefiveninetong.mchh.send.support;

import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.threefiveninetong.mchh.send.webservice.yimei.Mo;
import com.threefiveninetong.mchh.send.webservice.yimei.SDKServiceBindingStub;
import com.threefiveninetong.mchh.send.webservice.yimei.SDKServiceLocator;
import com.threefiveninetong.mchh.send.webservice.yimei.StatusReport;

public class YiMeiClient {
	
	Logger log=LoggerFactory.getLogger(YiMeiClient.class);
	private String softwareSerialNo;
	private String key;
	public YiMeiClient(String sn,String key){
		this.softwareSerialNo=sn;
		this.key=key;
		init();
	}
	
	SDKServiceBindingStub binding;
	
	
	public void init(){
		 try {
            binding = (SDKServiceBindingStub)
                          new SDKServiceLocator().getSDKService();
		 }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
	}
	
	public int chargeUp(  String cardNo,String cardPass)
			throws RemoteException {
		int value=-1;
		value=binding.chargeUp(softwareSerialNo, key, cardNo, cardPass);
		return value;
	}

	public double getBalance() throws RemoteException {
		double value=0.0;
		value=binding.getBalance(softwareSerialNo, key);
		return value;
	}

	public double getEachFee( ) throws RemoteException {
		double value=0.0;
		value=binding.getEachFee(softwareSerialNo, key);
		return value;
	}
	public List<Mo> getMO( ) throws RemoteException {
		Mo[] mo=binding.getMO(softwareSerialNo, key);
		
		if(null == mo){
			return null;
		}else{
			List<Mo> molist=Arrays.asList(mo);
		    return molist;
		}
	}
	

	public List<StatusReport> getReport( )
			throws RemoteException {
		StatusReport[] sr=binding.getReport(softwareSerialNo, key);
		if(null!=sr&&sr.length>0){
			log.info("易美下行返回信息********************************");
			for (int i = 0; i < sr.length; i++) {
				log.info("手机号码:"+sr[i].getMobile()+"\t状态:"+sr[i].getReportStatus()+"\t信息ID："+sr[i].getSeqID()+"\t提交时间："+sr[i].getSubmitDate()+"\t接受时间："+sr[i].getReceiveDate()+"\t错误码:"+sr[i].getErrorCode());
			}
			return Arrays.asList(sr);
		}else{
			return null;
		}
	}


	public int logout( ) throws RemoteException {
		int value=-1;
		value=binding.logout(softwareSerialNo, key);
		return value;
	}

	public int registDetailInfo(
			String eName, String linkMan, String phoneNum, String mobile,
			String email, String fax, String address, String postcode
) throws RemoteException {
		int value=-1;
		value=binding.registDetailInfo(softwareSerialNo, key, eName, linkMan, phoneNum, mobile, email, fax, address, postcode);
		return value;
	}

	public int registEx(String password)
			throws RemoteException {
		int value=-1;
		value=binding.registEx(softwareSerialNo, key, password);
		return value;
	}


	public int sendSMS( String[] mobiles, String smsContent,String addSerial,long unitId)
			throws RemoteException {
		int value=-1;
		value=binding.sendSMS(
				softwareSerialNo, key, null,
				mobiles,
				smsContent, addSerial, "gbk", 5,unitId);
		return value;
	}
	
	
	public int serialPwdUpd( String serialPwd, String serialPwdNew)
			throws RemoteException {
		int value=-1;
		value=binding.serialPwdUpd(softwareSerialNo, key, serialPwd, serialPwdNew);
		return value;
	}
}
