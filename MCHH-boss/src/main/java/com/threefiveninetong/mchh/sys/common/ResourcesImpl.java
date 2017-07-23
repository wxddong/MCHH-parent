/**
 * 
 */
package com.threefiveninetong.mchh.sys.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import com.threefiveninetong.mchh.sys.dao.ResourcesDao;
import com.threefiveninetong.mchh.sys.po.ResourcesPO;




/**
 * 权限拦截器辅助实现类
 * @author xuyh
 * @date 2013-7-22上午09:40:00
 * @description
 */
public class ResourcesImpl implements Resources {

	@Resource
	private ResourcesDao resourcesDao;
	private long lastmodify = -1L;
	private Object lock = new Object();
	
	// 缓存住功能URI数据{全站的菜单+功能uri数据 受权限控制的,数据格式为:uri=[uri1,uri2]}
	private Map<String, Set<String>> uriMap = new HashMap<String, Set<String>>();
	//正常状态,受权限控制的资源{只有菜单的,没有模块和功能的}
	private Set<String> enableMenusIds = new HashSet<String>();
	
	public boolean isProtectedUri(String uri){
		if(this.lastmodify < 0) reload();
		synchronized (lock) {
			if(uri.indexOf("/")==0)uri=uri.substring(1);
			return uriMap.containsKey(uri);
		}
	}
	
	public String[] getEnableMenuIdsByUri(String uri) {
		if(this.lastmodify < 0) reload();
		synchronized (lock) {
			if(this.uriMap.containsKey(uri)){
				Set<String> resIds = this.uriMap.get(uri);
				List<String> list = new ArrayList<String>();
				for(String resId : resIds){
					if(this.enableMenusIds.contains(resId)){
						list.add(resId);
					}
				}
				return list.toArray(new String[0]);
			}
		}
		return new String[0];
	}
	
	

	public long lastModify() {
		return this.lastmodify;
	}

	public void reload() {
		Map<String, Object> conds = new HashMap<String, Object>();
		conds.put("grantFlag", 1);
		conds.put("typeRange", new String[]{"2","3"});//TODO 应该是2和3
		List<ResourcesPO> list = resourcesDao.listResources(conds);
		Map<String, Set<String>> urimap0 = new HashMap<String, Set<String>>();
		Set<String> enableResourcesIds0 = new HashSet<String>();
		for(ResourcesPO res : list){
			int type = res.getType();
			String resuri = res.getUri();//uri表示的是功能
			if(resuri!=null && resuri.trim().length()>0){
				String id = res.getId();
				String parentId = res.getParentId();
				String[] uris = resuri.split(",");
				for(String uri : uris){
					Set<String> resourcesIds;
					if(urimap0.containsKey(uri)){
						resourcesIds = urimap0.get(uri);
					}else{
						resourcesIds = new HashSet<String>();
						urimap0.put(uri, resourcesIds);
					}
					if(2==type){//菜单
						resourcesIds.add(id);
						if(1 == res.getFlag()){
							enableResourcesIds0.add(id);
						}
					}else{//子功能并入功能
						resourcesIds.add(parentId);
					}
				}
			}
			}
		synchronized (lock) {
			this.uriMap = urimap0;
			this.lastmodify = System.currentTimeMillis();
			this.enableMenusIds = enableResourcesIds0;
		}
	}


	/**
	 * 根据uri获取对应的功能模块对象
	 * @param uri
	 * @return
	 */
	public ResourcesPO getResourcesByUri(String uri, String method){
		int methodType = 0; //GET
		if("POST".equalsIgnoreCase(method)){
			methodType=1;
		}
		Map<String, Object> conds = new HashMap<String, Object>();
		conds.put("logFlag", 1);
		conds.put("logUri", uri);
		conds.put("logMethod", methodType);
		List<ResourcesPO> resourcesList = resourcesDao.listResources(conds);
		if(resourcesList==null || resourcesList.size()<1){
			return new ResourcesPO();
		}else{
			return resourcesList.get(0);
		}
	}

}
