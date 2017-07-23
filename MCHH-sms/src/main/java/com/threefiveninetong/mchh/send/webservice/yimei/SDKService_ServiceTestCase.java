/**
 * SDKService_ServiceTestCase.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.threefiveninetong.mchh.send.webservice.yimei;
import java.util.List;

public class SDKService_ServiceTestCase extends junit.framework.TestCase {
    public SDKService_ServiceTestCase(java.lang.String name) {
        super(name);
    }

    public void testSDKServiceWSDL() throws Exception {
        javax.xml.rpc.ServiceFactory serviceFactory = javax.xml.rpc.ServiceFactory.newInstance();
        java.net.URL url = new java.net.URL(new SDKService_ServiceLocator().getSDKServiceAddress() + "?WSDL");
        javax.xml.rpc.Service service = serviceFactory.createService(url, new SDKService_ServiceLocator().getServiceName());
        assertTrue(service != null);
    }

    public void test1SDKServiceGetVersion() throws Exception {
        SDKServiceBindingStub binding;
        try {
            binding = (SDKServiceBindingStub)
                          new SDKService_ServiceLocator().getSDKService();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.getVersion();
        // TBD - validate results
    }

    public void test2SDKServiceGetReport() throws Exception {
        SDKServiceBindingStub binding;
        try {
            binding = (SDKServiceBindingStub)
                          new SDKService_ServiceLocator().getSDKService();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        StatusReport[] value = null;
        value = binding.getReport(new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test3SDKServiceCancelMOForward() throws Exception {
        SDKServiceBindingStub binding;
        try {
            binding = (SDKServiceBindingStub)
                          new SDKService_ServiceLocator().getSDKService();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        int value = -3;
        value = binding.cancelMOForward(new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test4SDKServiceChargeUp() throws Exception {
        SDKServiceBindingStub binding;
        try {
            binding = (SDKServiceBindingStub)
                          new SDKService_ServiceLocator().getSDKService();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        int value = -3;
        value = binding.chargeUp(new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test5SDKServiceGetBalance() throws Exception {
        SDKServiceBindingStub binding;
        try {
            binding = (SDKServiceBindingStub)
                          new SDKService_ServiceLocator().getSDKService();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        double value = -3;
        value = binding.getBalance(new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test6SDKServiceGetEachFee() throws Exception {
        SDKServiceBindingStub binding;
        try {
            binding = (SDKServiceBindingStub)
                          new SDKService_ServiceLocator().getSDKService();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        double value = -3;
        value = binding.getEachFee(new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test7SDKServiceGetMO() throws Exception {
        SDKServiceBindingStub binding;
        try {
            binding = (SDKServiceBindingStub)
                          new SDKService_ServiceLocator().getSDKService();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        Mo[] value = null;
        value = binding.getMO(new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test8SDKServiceLogout() throws Exception {
        SDKServiceBindingStub binding;
        try {
            binding = (SDKServiceBindingStub)
                          new SDKService_ServiceLocator().getSDKService();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        int value = -3;
        value = binding.logout(new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test9SDKServiceRegistDetailInfo() throws Exception {
        SDKServiceBindingStub binding;
        try {
            binding = (SDKServiceBindingStub)
                          new SDKService_ServiceLocator().getSDKService();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        int value = -3;
        value = binding.registDetailInfo(new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test10SDKServiceRegistEx() throws Exception {
        SDKServiceBindingStub binding;
        try {
            binding = (SDKServiceBindingStub)
                          new SDKService_ServiceLocator().getSDKService();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        int value = -3;
        value = binding.registEx(new java.lang.String(), new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test11SDKServiceSendSMS() throws Exception {
        SDKServiceBindingStub binding;
        try {
            binding = (SDKServiceBindingStub)
                          new SDKService_ServiceLocator().getSDKService();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        int value = -3;
        value = binding.sendSMS(new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String[0], new java.lang.String(), new java.lang.String(), new java.lang.String(), 0, 0);
        // TBD - validate results
    }

    public void test12SDKServiceSerialPwdUpd() throws Exception {
        SDKServiceBindingStub binding;
        try {
            binding = (SDKServiceBindingStub)
                          new SDKService_ServiceLocator().getSDKService();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        int value = -3;
        value = binding.serialPwdUpd(new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test13SDKServiceSetMOForward() throws Exception {
        SDKServiceBindingStub binding;
        try {
            binding = (SDKServiceBindingStub)
                          new SDKService_ServiceLocator().getSDKService();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        int value = -3;
        value = binding.setMOForward(new java.lang.String(), new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test14SDKServiceSetMOForwardEx() throws Exception {
        SDKServiceBindingStub binding;
        try {
            binding = (SDKServiceBindingStub)
                          new SDKService_ServiceLocator().getSDKService();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        int value = -3;
        value = binding.setMOForwardEx(new java.lang.String(), new java.lang.String(), new java.lang.String[0]);
        // TBD - validate results
    }
    public static void main(String[] args) throws Exception{
      	 SDKServiceBindingStub binding;
           try {
               binding = (SDKServiceBindingStub)
                             new SDKService_ServiceLocator().getSDKService();
           }
           catch (javax.xml.rpc.ServiceException jre) {
               if(jre.getLinkedCause()!=null)
                   jre.getLinkedCause().printStackTrace();
               throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
           }
           assertNotNull("binding is null", binding);

           	int value = -3;
           	//ע�����к�
              // value = binding.registEx("6SDK-EMY-6688-JBRMW", "375703", "375703");
           	//value = binding.registEx("2SDK-EMY-6688-JBTPP", "002428", "446877");
            //   System.out.println(value);
           	
               //��ȡ���
               double d=binding.getBalance("2SDK-EMY-6688-JBTPP", "002428");
   	        System.out.println("����֮ǰ���=="+d);
   	        
   	        //���Ͷ���
   	        /*int p=binding.sendSMS("2SDK-EMY-6688-JBTPP", "002428", null
   	        		, new String[]{"13911793432"
   	        		,"13501294832"
   	        		,"18601133653"
   	        		,"13311020599"
   	        		}, "��¡����Ƽ���������Ϣ:���� ֤������:110111198211158235 2010-12-04 CA1824 �˲�/16:50��� ����(��T3 �ӻ�)/18:50���� Ʊ��:9991712720434,����4006858999����ʱΪ�����"
   	        		, null, "gbk",5, 888890);*/
   	        
   	        	String strContent="��¡����Ƽ���������Ϣ:���� ֤������:110111198211158235 2010-12-04 CA1824 " +
   	        			"�˲�/16:50��� ����(��T3 �ӻ�)/18:50���� Ʊ��:9991712720434," +
   	        			"����4006858999����ʱΪ����� ��¡����Ƽ���������Ϣ:���� ֤������:110111198211158235 2010-12-04 CA1824" +
   	        			"��¡����Ƽ���������Ϣ:���� ֤������:110111198211158235 2010-12-04 CA1824";
   	        	
   	        	System.out.println("���ų���=="+strContent.length());
   	        	int p=binding.sendSMS("2SDK-EMY-6688-JBTPP", "002428", null
	        		, new String[]{
	        		"13911793432","13520026020","13501294832","13311020599"
	        		,"18601133653","18901106650"
	        		},strContent
	        		, null, "gbk",5, 888902);
   	        
   	        System.out.println("״̬��==="+p);
   	        
   	      d=binding.getBalance("2SDK-EMY-6688-JBTPP", "002428");
	        System.out.println("����֮�����=="+d);
   	        //��ȡ״̬����
		//��xFire��ʽ���ý���ȡList
   	        StatusReport[] statusReport=(StatusReport[])binding.getReport("2SDK-EMY-6688-JBTPP",  "002428");
   			  if(statusReport!=null){
   				System.out.println("״̬��������="+statusReport.length);
   			}
   			for(int i=0;statusReport!=null && i<statusReport.length;i++){
   				StatusReport report=(StatusReport)statusReport[i];
   				String id=report.getSeqID()+"";
   				System.out.println("Status="+report.getReportStatus()+"\tPhone="+report.getMobile()+"\tSEQid="+report.getSeqID()+"\tMemo="+report.getMemo()+"\tServiceCodeAdd="+report.getServiceCodeAdd()+"\tSubmitDate="+report.getSubmitDate()+"\tReceiveDate="+report.getReceiveDate()+"\tErrorCode="+report.getErrorCode());
   			}
   			/*new Thread(){
   				public void run(){
	   			while(true){
	   	        	Mo[] list=binding.getMO("2SDK-EMY-6688-JBTPP", "002428");
	   	        	if(list!=null){
		   	        	for(int i=0;i<list.length;i++){
		   	        		System.out.println(list[i].getSmsContent());
		   	        	}
	   	        	}
	   	        	Thread.sleep(500);
	   	        }
   				}
   			}.start();*/
   	}
   }
