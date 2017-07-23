package com.threefiveninetong.mchh.send.vo.devsource;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.mapper.MapperWrapper;

public class XstreamObjResultByXML {

     /**
      * 发送短信
      * @param sendXML
      * @return
      */
	public static SendReturnsms getSendReturnsmsByXML(String sendXML){
		XStream xStream=CreateXStream();
		 xStream.alias("returnsms", SendReturnsms.class);
//		 xStream.alias("Output", Output.class);
//		 xStream.alias("HeaderOut", HeaderOutType.class);=
//		 xStream.alias("Result", Result.class);
//		 xStream.alias("FlightShopResult", FlightShopResult.class);
//		 xStream.alias("Error", WarningType.class);
//		 xStream.addImplicitCollection(FlightShopResult.class, "avJourneys", "AvJourneys", AvJourneys.class);	 
//		 xStream.addImplicitCollection(AvJourneys.class, "avJourney", "AvJourney", AvailableJourneyType.class);
//		 xStream.addImplicitCollection(AvailableJourneyType.class, "avOpt", "AvOpt", AvOpt.class);
//		 xStream.addImplicitCollection(AvOpt.class, "flt", "Flt", FsFlightType.class);
//		 xStream.alias("codeshare", Codeshare.class);
//		 xStream.alias("term", Term.class);	 
//		 xStream.addImplicitCollection(FsFlightType.class, "clazz", "class", ClassType.class); 
//		 xStream.addImplicitCollection(ClassType.class, "subClass", "subClass", String.class);
//		 xStream.alias("PS", PricingSolutionType.class);
//		 xStream.alias("RMK", RMK.class);
//		 xStream.alias("Tax", TaxType.class);
//		 xStream.addImplicitCollection(TaxType.class, "taxComponent", "taxComponent", Integer.class);
//		 xStream.addImplicitCollection(PricingSolutionType.class, "routs", "Routs", Routs.class);
//		 xStream.addImplicitCollection(Routs.class, "rout", "Rout", RoutType.class);
//		 xStream.alias("FC", FareComponentType.class);
//		 xStream.addImplicitCollection(FareComponentType.class, "secInfo", "SecInfo", FcSectorInfoType.class);
//		 xStream.alias("FareBind", FareBind.class);
//		 xStream.addImplicitCollection(FareComponentType.class, "refundRuleDetailRPH", "RefundRuleDetailRPH", String.class);
//		 xStream.addImplicitCollection(FareComponentType.class, "reissueRuleDetailRPH", "ReissueRuleDetailRPH", String.class);
//		 xStream.alias("YFares", YFares.class);
//		 xStream.addImplicitCollection(YFares.class, "yFareAmount", "yFareAmount", String.class);
//		 xStream.alias("offices", Offices.class);
//		 xStream.addImplicitCollection(Offices.class, "office", "office", String.class);
//		 xStream.alias("CabinFares", CabinFares.class);
//		 xStream.addImplicitCollection(CabinFares.class, "cabinFare", "CabinFare", CabinFareType.class);
//		 xStream.alias("PsAvBind", PsAvBindingType.class);
//		 xStream.addImplicitCollection(PsAvBindingType.class, "avRPH", "avRPH", String.class);
//		 xStream.addImplicitCollection(PsAvBindingType.class, "bkClass", "bkClass", Object.class);
//		 xStream.alias("PsDateBind", PsDateBind.class);
//		 xStream.addImplicitCollection(PsDateBind.class, "dateBinding", "DateBinding", DateBinding.class);
//		 xStream.alias("NFare", NetFareType.class);
//		 xStream.alias("PFare", PubFareType.class);
//		 xStream.alias("FbrDtl", FbrDtlType.class);
//		 xStream.alias("Rule", RuleType.class);
//		 xStream.alias("CombineRule", CombineRule.class);
//		 xStream.addImplicitCollection(CombineRule.class, "combineRuleDtl", "CombineRuleDtl", CombineRuleDtl.class);
//		 xStream.alias("RefundRule", RefundRule.class);
//		 xStream.addImplicitCollection(RefundRule.class, "refundDetail", "RefundDetail", RefundDetail.class);
//		 xStream.alias("ReissueRule", ReissueRule.class);
//		 xStream.addImplicitCollection(ReissueRule.class, "reissueRuleDetail", "ReissueRuleDetail", ReissueRuleDetail.class);
//		 xStream.alias("ReissueRuleRestriction", ReissueRuleRestriction.class);
//		 xStream.addImplicitCollection(FlightShopResult.class, "journeyPrice", "JourneyPrice", JourneyPrice.class);
//		 
		
		 SendReturnsms sendReturnsms=(SendReturnsms) xStream.fromXML(sendXML);
		
		 return sendReturnsms;
	}
	
	/**
	 * 查询余额
	 * @param overageXML
	 * @return
	 */
	public static OverageReturnsms getOverageReturnsmsByXML(String overageXML){
		XStream xStream=CreateXStream();
		 xStream.alias("returnsms", OverageReturnsms.class);

		 OverageReturnsms overageReturnsms=(OverageReturnsms) xStream.fromXML(overageXML);
		
		 return overageReturnsms;
	}
	 
	private static XStream CreateXStream(){
		 XStream xStream = new XStream(new DomDriver()) {
		        @Override
		         protected MapperWrapper wrapMapper(MapperWrapper next) {
		             return new MapperWrapper(next) {
		                 @Override
		                 public boolean shouldSerializeMember(Class definedIn, String fieldName) {
		                	 if (definedIn == Object.class) {
		                		 try {
		                			 return this.realClass(fieldName) != null;
		                		 } catch(Exception e) {
		                			 return false;
		                		 }
		                	 } else {
		                         return super.shouldSerializeMember(definedIn, fieldName);
		                     }
		                 }
		             };
		         }
		     };
		     
		     return xStream;
	}

}
