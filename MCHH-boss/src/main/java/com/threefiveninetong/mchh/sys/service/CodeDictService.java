package com.threefiveninetong.mchh.sys.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.threefiveninetong.mchh.core.base.BaseService;
import com.threefiveninetong.mchh.sys.dao.CodeCategoryDao;
import com.threefiveninetong.mchh.sys.dao.CodeDao;
import com.threefiveninetong.mchh.sys.po.CodeCategoryPO;
import com.threefiveninetong.mchh.sys.po.CodePO;
import com.threefiveninetong.mchh.sys.vo.CodeCategoryVO;
import com.threefiveninetong.mchh.sys.vo.CodeVO;
import com.threefiveninetong.mchh.util.IdUtil;
import com.threefiveninetong.mchh.util.Page;



@Service
public class CodeDictService extends
BaseService<CodeCategoryPO, CodeCategoryVO> {

	private static final Logger log = LoggerFactory.getLogger(CodeDictService.class);

	@Resource
	private CodeCategoryDao codeCategoryDao;
	@Resource
	private CodeDao codeDao;

	public void listCategoryForPage(Map<String, Object> conds,
			Page<CodeCategoryPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<CodeCategoryPO> list = codeCategoryDao
				.listCodeCategoryForPage(conds);
		page.setList(list);
	}

	public CodeCategoryVO addOrUpdateCategory(CodeCategoryVO codeCategoryVO) {
		CodeCategoryPO codeCategoryPO = vo2po(codeCategoryVO);
		if (codeCategoryVO != null
				&& !StringUtils.isEmpty(codeCategoryVO.getId())) {
			codeCategoryDao.update(codeCategoryPO);
		} else {
			codeCategoryPO.setId(IdUtil.uuid());
			codeCategoryDao.add(codeCategoryPO);
		}
		return codeCategoryVO;
	}

	public void deleteCategory(String[] codeCategoryIds) {
		codeCategoryDao.deleteCode(codeCategoryIds);
		codeCategoryDao.delete(codeCategoryIds);
	}

	public CodeCategoryVO getCategory(Map<String, Object> conds) {
		CodeCategoryPO opePO = codeCategoryDao.getCodeCategory(conds);
		if (opePO != null) {
			return po2vo(opePO);
		}
		return null;
	}

	public void updateCategory(CodeCategoryVO codeCategoryVO) {
		codeCategoryDao.update(vo2po(codeCategoryVO));
	}

	public void listCodeForPage(Map<String, Object> conds, Page<CodePO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<CodePO> list = codeDao.listCodeForPage(conds);
		page.setList(list);
	}

	public CodeVO addOrUpdateCode(CodeVO codeVO) {
		CodePO codePO = new CodePO();
		BeanUtils.copyProperties(codeVO, codePO);
		if (codeVO != null && !StringUtils.isEmpty(codeVO.getId())) {
			codeDao.update(codePO);
		} else {
			codePO.setId(IdUtil.uuid());
			codeDao.add(codePO);
		}
		return codeVO;
	}

	public void deleteCode(String[] codeIds) {
		codeDao.delete(codeIds);
	}

	public CodeVO getCode(Map<String, Object> conds) {
		CodePO codePO = codeDao.getCode(conds);
		if (codePO != null) {
			CodeVO codeVO = new CodeVO();
			BeanUtils.copyProperties(codePO, codeVO);
			return codeVO;
		}
		return null;
	}

	public void updateCode(CodeVO codeVO) {
		CodePO codePO = new CodePO();
		BeanUtils.copyProperties(codeVO, codePO);
		codeDao.update(codePO);
	}

	public List<Map<String, Object>> queryForList(Map<String, Object> cond) {
		return codeDao.queryForList(cond);
	}

	public List<Map<String, Object>> queryCategoryForList(
			Map<String, Object> conds) {
		return codeCategoryDao.queryCategoryForList(conds);
	}

}