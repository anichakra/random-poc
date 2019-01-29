package me.anichakra.poc.ruleservice.util;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
public class ResourceLoaderUtil implements ResourceLoaderAware {

	ResourceLoader resourceLoader;
	
	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		// TODO Auto-generated method stub
		this.resourceLoader=resourceLoader;
		
	}
	
	public Resource getResource(String location)
	{
		return resourceLoader.getResource(location);
	}

}
