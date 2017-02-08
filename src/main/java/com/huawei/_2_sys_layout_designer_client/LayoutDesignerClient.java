package com.huawei._2_sys_layout_designer_client;

import java.util.List;

import com.huawei._1_fw.component.layout.vo.graph.GraphvizNodeVo;
import com.huawei._1_ms.service_component.layout.vo.GraphvizBuGraphVo;

public class LayoutDesignerClient {
	// #region split

	public static String split(GraphvizBuGraphVo oGraphvizBuGraphVo) {
		// 向LayoutDesigner的split接口发送post请求,传递子网节点的从属关系信息

		return null;
	}

	// #endregion

	// #region layout

	public static List<GraphvizNodeVo> layout(GraphvizBuGraphVo oGraphvizBuGraphVo) {
		// 向LayoutDesigner的layout接口发送post请求,传递新的子网节点信息,获得lstGraphvizNode

		return null;
	}

	// #endregion
}
