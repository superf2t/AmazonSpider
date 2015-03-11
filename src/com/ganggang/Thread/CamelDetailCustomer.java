package com.ganggang.Thread;

import java.util.List;

import com.ganggang.Proxy.CamelProxy;

public class CamelDetailCustomer implements Runnable {

	private CamelUrlContainer container;

	public CamelUrlContainer getContainer() {
		return container;
	}

	public void setContainer(CamelUrlContainer container) {
		this.container = container;
	}
	@Override
	public void run() {
		while(true){
			List<CamelUrl> camelUrls=container.Get();
			if(camelUrls.size()<=0){
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					System.out.println(e);
				}
			}
			for(CamelUrl camelUrl : camelUrls){
				CamelProxy.GetDetail(camelUrl);
			}
		}
		
	}

}
