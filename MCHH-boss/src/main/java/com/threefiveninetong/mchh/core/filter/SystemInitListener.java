package com.threefiveninetong.mchh.core.filter;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;
@Service
public class SystemInitListener implements ApplicationListener<ContextRefreshedEvent>{


	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		System.out.println("----------");
	}

}
