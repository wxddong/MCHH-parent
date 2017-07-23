package com.threefiveninetong.mchh.sys.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.threefiveninetong.mchh.core.page.Model;
import com.threefiveninetong.mchh.core.vo.Tree;
import com.threefiveninetong.mchh.sys.service.ResourcesService;
import com.threefiveninetong.mchh.sys.vo.ResourcesVO;

/**
 * 资源控制类
 * <ul>
 * <li>/tree： 资源树</li>
 * <li>/treegrant ：角色的资源授权树</li>
 * <li>/add ：资源添加</li>
 * <li>/update ：资源更新</li>
 * <li>/del：资源删除</li>
 * </ul>
 * 
 * @author zhouzhao
 * @date 2013-7-16
 */
@Controller
@RequestMapping("/sys/resources")
public class ResourcesController {
    private static final Logger log = LoggerFactory.getLogger(ResourcesController.class);

    @Resource
    private ResourcesService resourcesService;

    /**
     * 资源树视图
     * 
     * @return
     */
    @RequestMapping(value = "/tree", method = RequestMethod.GET)
    public String listResourcesView() {
        log.debug("request page: /sys/resources/tree");
        return "sys/resources/resources_tree";
    }

    /**
     * 资源树数据
     * 
     * @param reqs
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/tree", method = RequestMethod.POST)
    public Model listResourcesActoin(@RequestParam Map<String, Object> reqs) {
        log.debug("request data: listResources");
        Model model = new Model();
        Tree<ResourcesVO> tree = new Tree<ResourcesVO>();
        List<ResourcesVO> list = resourcesService.listResourcesTree(reqs);
        List<Tree<ResourcesVO>> tl = new ArrayList<Tree<ResourcesVO>>();
        tl = rl2tl(list, tl, null, null, 1);
        tree.setId("0");
        tree.setText("后台系统");
        tree.setChildren(tl);
        model.setTree(tree);
        return model;
    }

    /**
     * 角色的资源授权树
     * 
     * @param reqs
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/treegrant", method = RequestMethod.POST)
    public Model listResourcesGrantActoin(@RequestParam Map<String, Object> reqs) {
        log.debug("request data: listResources");
        Model model = new Model();
        Tree<ResourcesVO> tree = new Tree<ResourcesVO>();
        List<ResourcesVO> list = resourcesService.listResourcesGrantTree(reqs);
        List<Tree<ResourcesVO>> tl = new ArrayList<Tree<ResourcesVO>>();
        tl = rl2tl(list, tl, null, null, 1);
        tree.setId("0");
        tree.setText("后台系统");
        tree.setChildren(tl);
        model.setTree(tree);
        return model;
    }

    /**
     * 资源添加
     * 
     * @param resourcesVO
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Model addResourcesActoin(ResourcesVO resourcesVO) {
        Model model = new Model();
        model.set("msg", true);
        try {
        	log.info(resourcesVO.toString());
            model.setRow(resourcesService.addOrUpdateResourcesActoin(resourcesVO));
        } catch (Exception e) {
            e.printStackTrace();
            model.set("msg", false);
        }
        return model;
    }

    /**
     * 资源修改
     * 
     * @param resourcesVO
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Model updateResourcesActoin(ResourcesVO resourcesVO) {
        Model model = new Model();
        model.set("msg", true);
        try {
            log.info(resourcesVO.toString());
            model.setRow(resourcesService.addOrUpdateResourcesActoin(resourcesVO));
        } catch (Exception e) {
            e.printStackTrace();
            model.set("msg", false);
        }
        return model;
    }

    /**
     * 资源删除
     * 
     * @param resourcesId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/del", method = RequestMethod.POST, produces = "application/json")
    public Model delResourcesAction(@RequestParam("resourcesId") String resourcesId) {
        Model model = new Model();
        model.set("msg", true);
        try {
            resourcesService.deleteResources(resourcesId);
        } catch (Exception e) {
            e.printStackTrace();
            model.set("msg", false);
        }
        return model;
    }

    /**
     * 将资源转为树形结构
     * 
     * @param rl
     *            所有资源数据
     * @param tl
     *            树结构数据
     * @param parentId
     *            父结构
     * @param evel
     *            层级 共1 2 3级，1为模块，2为菜单，3为链接或按钮
     * @return
     */
    private List<Tree<ResourcesVO>> rl2tl(List<ResourcesVO> rl, List<Tree<ResourcesVO>> tl, Tree<ResourcesVO> parent,
            String parentId, int evel) {
        if (evel > 3) {
            return tl;
        }
        if (StringUtils.isEmpty(parentId)) {
            for (ResourcesVO r : rl) {
                if (StringUtils.isEmpty(r.getParentId())) {
                    Tree<ResourcesVO> t = new Tree<ResourcesVO>();
                    t.setId(r.getId());
                    t.setText(r.getName());
                    t.setAttributes(r);
                    t.setChecked(r.getChecked() == 1);
                    t.setParent(parent);
                    tl.add(t);
                    rl2tl(rl, tl, t, r.getId(), evel + 1);
                }
            }
        } else {
            Tree<ResourcesVO> p = parent;
            for (ResourcesVO r : rl) {
                if (parentId.equals(r.getParentId())) {
                    Tree<ResourcesVO> t = new Tree<ResourcesVO>();
                    t.setId(r.getId());
                    t.setText(r.getName());
                    t.setAttributes(r);
                    t.setChecked(r.getChecked() == 1);
                    t.setParent(parent);
                    updateParentChecked(t);
                    p.getChildren().add(t);
                    rl2tl(rl, tl, t, r.getId(), evel + 1);
                }
            }
        }
        return tl;
    }

    private void updateParentChecked(Tree<ResourcesVO> tree) {
        if (tree.getParent() != null) {
            tree.getParent().setChecked(false);
            updateParentChecked(tree.getParent());
        }
    }
}
