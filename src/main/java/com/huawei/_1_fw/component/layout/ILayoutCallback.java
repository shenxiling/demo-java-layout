package com.huawei._1_fw.component.layout;

import java.util.Map;

import com.huawei._1_fw.vo.Node;

public interface ILayoutCallback {
	void layoutAfter(Map<String, Node> mapNode);
}