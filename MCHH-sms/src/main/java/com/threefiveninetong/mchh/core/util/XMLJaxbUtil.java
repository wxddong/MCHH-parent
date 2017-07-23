package com.threefiveninetong.mchh.core.util;

import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Jaxb2工具类
 */
public class XMLJaxbUtil {
	private static final Logger log=LoggerFactory.getLogger(XMLJaxbUtil.class);
	/**
	 * JavaBean转换成xml
	 * 默认编码UTF-8
	 * @param obj
	 * @param writer
	 * @return 
	 */
	public static String convertToXml(Object obj) {
		return convertToXml(obj, "UTF-8");
	}

	/**
	 * JavaBean转换成xml
	 * @param obj
	 * @param encoding 
	 * @return 
	 */
	public static String convertToXml(Object obj, String encoding) {
		String result = null;
		try {
			JAXBContext context = JAXBContext.newInstance(obj.getClass());
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);
			marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
//			marshaller.setProperty("showAllElement", true);
            StringWriter writer = new StringWriter();
            writer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            writer.append("\n");
            marshaller.marshal(obj, writer);
            result=writer.toString();
            log.info(result);
            return result;
		} catch (Exception e) {
			log.error("", e);
			e.printStackTrace();
		}

		return result;
	}
	
	
	public static String convertToXml1(Object obj,String encoding){
	        try {
	        	
	        	JAXBContext  	jaxbContext = JAXBContext.newInstance(obj.getClass());
	        	XMLOutputFactory  xmlOutputFactory = XMLOutputFactory.newInstance();
	            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	            jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);
	            jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);

	            ByteArrayOutputStream baos = new ByteArrayOutputStream();
	            XMLStreamWriter xmlStreamWriter = xmlOutputFactory.createXMLStreamWriter(baos, (String) jaxbMarshaller.getProperty(Marshaller.JAXB_ENCODING));
	            xmlStreamWriter.writeStartDocument((String)jaxbMarshaller.getProperty(Marshaller.JAXB_ENCODING), "1.0");
	            jaxbMarshaller.marshal(obj, xmlStreamWriter);
	            xmlStreamWriter.writeEndDocument();
	            xmlStreamWriter.close();
	            return new String(baos.toByteArray());
	        } catch (Exception e) {
	        }
	        return null;
	}

	/**
	 * xml转换成JavaBean
	 * @param xml
	 * @param c
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T converyToJavaBean(String xml, Class<T> c)throws Exception {
		T t = null;
		try {
			JAXBContext context = JAXBContext.newInstance(c);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			t = (T) unmarshaller.unmarshal(new StringReader(xml));
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

		return t;
	}
}
