package com.threefiveninetong.mchh.sys.controller;

import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.threefiveninetong.mchh.core.export.ExportExcel;

/**
 * @author xuyh
 * @date 2013-12-31下午01:55:49
 * @description
 */
@Controller("commonExcelController")
public class ExcelController {
    /**
     * 导出excel视图
     * 
     * @return
     */
    @RequestMapping(value = "/export")
    public ModelAndView exportExcelView(@RequestParam Map<String, Object> conds, HttpServletRequest reqs) {
        Set<String> keys = conds.keySet();
        for (String key : keys) {
            Object v = conds.get(key);
            if (v != null && v instanceof String) {
                try {
                    v = new String(reqs.getParameter(key).getBytes("UTF-8"), "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                conds.put(key, v);
            }
        }
        return new ModelAndView(ExportExcel.EXCEL_VIEW, conds);
    }
}