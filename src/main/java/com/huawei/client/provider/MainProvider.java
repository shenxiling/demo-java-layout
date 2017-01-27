package com.huawei.client.provider;

import com.huawei.client.provider.subprovider.Subprovider;

public class MainProvider {
	// #region hello

	public static String hello() {
		return Subprovider.hello();
	}

	// #endregion

}
