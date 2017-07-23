package com.threefiveninetong.mchh.core.export;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.mail.internet.MimeUtility;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.ognl.Ognl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.threefiveninetong.mchh.sys.controller.EnvController;
import com.threefiveninetong.mchh.util.DateUtil;
import com.threefiveninetong.mchh.util.Page;
import com.ximpleware.AutoPilot;
import com.ximpleware.NavException;
import com.ximpleware.VTDGen;
import com.ximpleware.VTDNav;
import com.ximpleware.XPathEvalException;
import com.ximpleware.XPathParseException;

@SuppressWarnings("restriction")
public class ExportExcel extends  AbstractExcelView {
    private static final Logger log = LoggerFactory.getLogger(ExportExcel.class);

    public static final String EXCEL_ID = "__excel_id_";

    public static final String EXCEL_VIEW = "exportExcel";

    public static final String EXCEL_DATA = "__excel_data_";

    private static Map<String, ExcelView> views = new HashMap<String, ExcelView>();

    protected void buildExcelDocument(Map<String, Object> conds, HSSFWorkbook Workbook, HttpServletRequest req,
            HttpServletResponse resp) throws Exception {
		String excelId = conds.get(EXCEL_ID).toString();
		ExcelView excelView = views.get(excelId);
		//选择引入excel模板
		if(StringUtils.isNotEmpty(excelView.getFilePath())){
			String xlsPath = URLDecoder.decode(ExportExcel.class.getResource("templates").getPath(), "utf-8")+"/"+excelView.getFilePath();
			System.out.println(xlsPath);
			FileInputStream inputStream = new FileInputStream(xlsPath);
			Workbook=new HSSFWorkbook(inputStream);
			HSSFSheet sheet = Workbook.getSheet(excelView.getName());
			sheet.setDefaultColumnWidth(20);
			//冻结列
			//sheet.createFreezePane(0, 1);
			loadData(sheet, conds, Workbook, req);
		}else{
			createExcel(conds, Workbook, req,excelView);// 创建excel
		}
        
        
        genFile(conds, Workbook, req, resp);// 生成文件下载
    }

    static {
        getExcelDef();
    }

    /* 获得表格定义 */
    private static void getExcelDef() {
        try {
            VTDGen vg = new VTDGen(); 
            String filePath = ExportExcel.class.getResource("ExcelXml.xml").getPath();
            try {
				filePath = URLDecoder.decode(filePath, "utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            vg.parseFile(filePath, false);
            VTDNav vn = vg.getNav();
            AutoPilot ap = new AutoPilot(vn);
            ap.selectXPath("/excels/excel");
            int i = 0;
            List<Integer> indexs = new ArrayList<Integer>();
            while ((i = ap.evalXPath()) != -1) {
                indexs.add(i);
            }
            for (Integer index : indexs) {
                vn.recoverNode(index);
                String excel = vn.toString(vn.getAttrVal("id"));
                String name = vn.toString(vn.getAttrVal("name"));
                String templatesFilePath = vn.getAttrVal("filePath") == -1 ? null : vn.toString(vn.getAttrVal("filePath"));
                
                ExcelView excelView = new ExcelView();
                excelView.setName(name);// 设置excel名称
                excelView.setFilePath(templatesFilePath);
                ap.selectXPath("./columns/cell");
                List<ExcelCell> cells = new ArrayList<ExcelCell>();
                while (ap.evalXPath() != -1) {
                    String title = vn.toString(vn.getAttrVal("title"));
                    String field = vn.toString(vn.getAttrVal("field"));
                    String render = vn.getAttrVal("render") == -1 ? null : vn.toString(vn.getAttrVal("render"));
                    String format = vn.getAttrVal("format") == -1 ? null : vn.toString(vn.getAttrVal("format"));
                    ExcelCell cell = new ExcelCell();
                    cell.setTitle(title);
                    cell.setField(field);
                    cell.setFormat(format);
                    cell.setRender(render);
                    cells.add(cell);
                }
                excelView.setColumns(cells);
                ap.selectXPath("./datasource");
                ap.evalXPath();
                String dao = vn.toString(vn.getAttrVal("dao"));
                String method = vn.toString(vn.getAttrVal("method"));
                vn.recoverNode(index);
                excelView.setDao(dao);// 设置excel使用的dao
                excelView.setMethod(method);// 设置excel使用的method
                views.put(excel, excelView);
            }
        } catch (XPathParseException e) {
            e.printStackTrace();
        } catch (XPathEvalException e) {
            e.printStackTrace();
        } catch (NavException e) {
            e.printStackTrace();
        }
    }

    /* 创建excel */
    private void createExcel(Map<String, Object> conds, HSSFWorkbook Workbook, HttpServletRequest req,ExcelView excelView) {
      
        HSSFSheet sheet = Workbook.createSheet(excelView.getName());
        sheet.setDefaultColumnWidth(20);
        List<ExcelCell> columns = excelView.getColumns();
        int tmpIndex = -1;
        for (ExcelCell cell : columns) {
            setText(getCell(sheet, 0, tmpIndex += 1), cell.getTitle());
        }
        sheet.createFreezePane(0, 1);
        loadData(sheet, conds, Workbook, req);
    }
    /* 加载数据 */
    private void loadData(HSSFSheet sheet, Map<String, Object> conds, HSSFWorkbook Workbook, HttpServletRequest reqs) {
        String excelId = conds.get(EXCEL_ID).toString();
        ExcelView excelView = views.get(excelId);
        List<ExcelCell> columns = excelView.getColumns();
        List<?> list = null;
        if ((list = (List<?>) conds.get(EXCEL_DATA)) == null) {// 如果直接将数据统计好了，不在重复统计
            String dao = excelView.getDao();
            String method = excelView.getMethod();
            ServletContext servletContext = reqs.getSession().getServletContext();
            WebApplicationContext context1 = WebApplicationContextUtils
                    .getRequiredWebApplicationContext(servletContext);
            Object bean = context1.getBean(dao);
            try {
                Method method2 = bean.getClass().getMethod(method, Map.class);
                Page page = new Page();
                page.setPage(1);
                page.setRows(Integer.MAX_VALUE);
                conds.put("page", page);
                list = (List<?>) method2.invoke(bean, conds);
            } catch (SecurityException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        if (list == null || list.isEmpty()) {
            return;
        }
        Object object = list.get(0);
        boolean flag = false;
        if (object instanceof Map) {
            flag = true;
        }
        int titleRowsCount = sheet.getLastRowNum()+1;
        for (int i = 0; i < list.size(); i++) {
            int col = 0;
            Map<String, Object> hashMap = null;
            if (flag) {
                hashMap = (Map<String, Object>) list.get(i);
            } 
//            else {
//                hashMap = obj2Map(list.get(i));
//            }
            for (ExcelCell c : columns) {
                String field = c.getField();
                String render = c.getRender();
                String format = c.getFormat();
                
                Object obj = null;
                if(flag)
                	obj = hashMap.get(field);
                else{
                	 try {
                     	obj = Ognl.getValue(field,list.get(i));
     				} catch (Exception e) {
     					e.printStackTrace();
     				}
                }
                int currRowNum = i + titleRowsCount;
                if (obj instanceof java.util.Date) {// 日期格式化
                    setDate(getCell(sheet, currRowNum, col++), (Date) obj, format);
                } else if (!StringUtils.isEmpty(render)) {// 用数据字典转值转义
                    setTextEscape(getCell(sheet, currRowNum, col++), String.valueOf(obj), render);
                } else if (obj instanceof java.math.BigDecimal) {// BigDecimal数值格式化
                    setBigDecimal(getCell(sheet, currRowNum, col++), (BigDecimal) obj, format);
                } else if (obj instanceof java.lang.Number) {// 数值格式化
                    setNumber(getCell(sheet, currRowNum, col++), (Number) obj, format);
                } else {
                    String value = String.valueOf(obj);
                    setText(getCell(sheet, currRowNum, col++), trimToEmpty(value));
                }
            }
        }
    }

    /* 生成下载文件 */
    private void genFile(Map<String, Object> conds, HSSFWorkbook Workbook, HttpServletRequest reqs,
            HttpServletResponse resp) {
        try {
            String excelId = conds.get(EXCEL_ID).toString();
            ExcelView excelView = views.get(excelId);
            String filename = excelView.getName() + ".xls";
            filename = encodeFilename(filename, reqs);// 处理中文文件名
            resp.setContentType("application/vnd.ms-excel");
            resp.setHeader("Content-disposition", "attachment;filename=" + filename);
            OutputStream ouputStream = resp.getOutputStream();
            Workbook.write(ouputStream);
            ouputStream.flush();
            ouputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 设置下载文件中文件的名称
     * 
     * @param filename
     * @param request
     * @return
     */
    private String encodeFilename(String filename, HttpServletRequest request) {
        /**
         * 获取客户端浏览器和操作系统信息 在IE浏览器中得到的是：User-Agent=Mozilla/4.0 (compatible; MSIE
         * 6.0; Windows NT 5.1; SV1; Maxthon; Alexa Toolbar)
         * 在Firefox中得到的是：User-Agent=Mozilla/5.0 (Windows; U; Windows NT 5.1;
         * zh-CN; rv:1.7.10) Gecko/20050717 Firefox/1.0.6
         */
        String agent = request.getHeader("USER-AGENT");
        try {
            if ((agent != null) && (-1 != agent.indexOf("MSIE"))) {
                String newFileName = URLEncoder.encode(filename, "UTF-8");
                newFileName = newFileName.replace("+", "%20");
                if (newFileName.length() > 150) {
                    newFileName = new String(filename.getBytes("GB2312"), "ISO8859-1");
                    newFileName = newFileName.replace("+", "%20");
                }
                return newFileName;
            }
            if ((agent != null) && (-1 != agent.indexOf("Mozilla")))
                return MimeUtility.encodeText(filename, "UTF-8", "B");
            return filename;
        } catch (Exception ex) {
            return filename;
        }
    }

    /* 对象转为map */
    private Map<String, Object> obj2Map(Object object) {
        Map<String, Object> data = new HashMap<String, Object>();
        String jsonStr = JSONObject.toJSONString(object);
        JSONObject jsonObject = (JSONObject) JSONObject.parse(jsonStr);
        Set<String> keys = jsonObject.keySet();
        for (String key : keys) {
            Object value = jsonObject.get(key);
            data.put(key, value);
        }
        return data;
    }

    protected void setDate(HSSFCell cell, Date date, String format) {
        String value = DateUtil.dateToString(date, format);
        setText(cell, trimToEmpty(value));
    }

    protected void setNumber(HSSFCell cell, Number num, String format) {
        if (StringUtils.isEmpty(format)) {
            cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            cell.setCellValue(num.toString());
        } else {
            DecimalFormat df = new DecimalFormat(format);
            String v = df.format(num);
            setText(cell, trimToEmpty(v));
        }
    }

    protected void setBigDecimal(HSSFCell cell, BigDecimal big, String format) {
        if (StringUtils.isEmpty(format)) {
            cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            cell.setCellValue((Double) big.doubleValue());
        } else {
            DecimalFormat df = new DecimalFormat(format);
            String v = df.format(big);
            setText(cell, trimToEmpty(v));
        }
    }

    protected void setTextEscape(HSSFCell cell, String text, String render) {
        Map<String, Map<String, String>> codes = EnvController.getCodes();
        try {
            text = codes.get(render).get(text);
        } catch (Exception e) {
            log.error("render error:[render:" + render + ",key:" + text + "],");
        }
        setText(cell, trimToEmpty(text));
    }

    private static String trimToEmpty(String text) {
        text = StringUtils.trimToEmpty(text);
        return "null".equals(text) ? "" : text;
    }
}
