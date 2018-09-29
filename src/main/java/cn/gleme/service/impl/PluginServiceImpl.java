/*
 * Copyright 2005-2015 gleme.cn. All rights reserved.
 * Support: http://www.gleme.cn

 */
package cn.gleme.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import cn.gleme.plugin.StoragePlugin;
import cn.gleme.service.PluginService;
import cn.gleme.plugin.StoragePlugin;
import cn.gleme.service.PluginService;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.springframework.stereotype.Service;

/**
 * Service - 插件
 * 
 * @author XJANY Team
 * @version 4.0
 */
@Service("pluginServiceImpl")
public class PluginServiceImpl implements PluginService {

//	@Resource
//	private List<PaymentPlugin> paymentPlugins = new ArrayList<PaymentPlugin>();
	@Resource
	private List<StoragePlugin> storagePlugins = new ArrayList<StoragePlugin>();
//	@Resource
//	private List<LoginPlugin> loginPlugins = new ArrayList<LoginPlugin>();
//	@Resource
//	private Map<String, PaymentPlugin> paymentPluginMap = new HashMap<String, PaymentPlugin>();
	@Resource
	private Map<String, StoragePlugin> storagePluginMap = new HashMap<String, StoragePlugin>();
//	@Resource
//	private Map<String, LoginPlugin> loginPluginMap = new HashMap<String, LoginPlugin>();
//
//	public List<PaymentPlugin> getPaymentPlugins() {
//		Collections.sort(paymentPlugins);
//		return paymentPlugins;
//	}
//
	public List<StoragePlugin> getStoragePlugins() {
		Collections.sort(storagePlugins);
		return storagePlugins;
	}
//
//	public List<LoginPlugin> getLoginPlugins() {
//		Collections.sort(loginPlugins);
//		return loginPlugins;
//	}
//
//	public List<PaymentPlugin> getPaymentPlugins(final boolean isEnabled,final PaymentPlugin.PaySource paySource ) {
//		List<PaymentPlugin> result = new ArrayList<PaymentPlugin>();
//		CollectionUtils.select(paymentPlugins, new Predicate() {
//			public boolean evaluate(Object object) {
//				PaymentPlugin paymentPlugin = (PaymentPlugin) object;
//				boolean isCanPay = false;
//				switch (paySource){
//					case wechat:
//						isCanPay = paymentPlugin.getIsWechat();
//						break;
//					case app:
//						isCanPay = paymentPlugin.getIsApp();
//						break;
//					case miniApp:
//						isCanPay = paymentPlugin.getIsMiniapp();
//						break;
//					case pc:
//						isCanPay = paymentPlugin.getIsPc();
//						break;
//					case mobile:
//						isCanPay = paymentPlugin.getIsMobile();
//						break;
//					default:
//						isCanPay = false;
//						break;
//				}
//				return paymentPlugin.getIsEnabled() == isEnabled && isCanPay;
//			}
//		}, result);
//		Collections.sort(result);
//		return result;
//	}

	public List<StoragePlugin> getStoragePlugins(final boolean isEnabled) {
		List<StoragePlugin> result = new ArrayList<StoragePlugin>();
		CollectionUtils.select(storagePlugins, new Predicate() {
			public boolean evaluate(Object object) {
				StoragePlugin storagePlugin = (StoragePlugin) object;
				return storagePlugin.getIsEnabled() == isEnabled;
			}
		}, result);
		Collections.sort(result);
		return result;
	}

//	public List<LoginPlugin> getLoginPlugins(final boolean isEnabled) {
//		List<LoginPlugin> result = new ArrayList<LoginPlugin>();
//		CollectionUtils.select(loginPlugins, new Predicate() {
//			public boolean evaluate(Object object) {
//				LoginPlugin loginPlugin = (LoginPlugin) object;
//				return loginPlugin.getIsEnabled() == isEnabled;
//			}
//		}, result);
//		Collections.sort(result);
//		return result;
//	}
//
//	public PaymentPlugin getPaymentPlugin(String id) {
//		return paymentPluginMap.get(id);
//	}
//
	public StoragePlugin getStoragePlugin(String id) {
		return storagePluginMap.get(id);
	}
//
//	public LoginPlugin getLoginPlugin(String id) {
//		return loginPluginMap.get(id);
//	}

}