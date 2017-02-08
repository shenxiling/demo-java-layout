package com.huawei._2_sys_layout_designer.provider.subprovider;

import java.util.List;

import com.huawei._1_fw.component.layout.vo.graph.GraphvizGraphVo;
import com.huawei._1_fw.component.layout.vo.graph.GraphvizNodeVo;
import com.huawei._1_ms.service_component.layout.GraphvizBuUtils;
import com.huawei._1_ms.service_component.layout.vo.GraphvizBuGraphVo;

public class SubProvider {
	// #region split

	public static String split(GraphvizBuGraphVo oGraphvizBuGraphVo) {

		return GraphvizBuUtils.split(oGraphvizBuGraphVo);
	}

	// #endregion

	// #region save

	public static String save(GraphvizGraphVo oGraphvizGraphVo) {
		return GraphvizBuUtils.save(oGraphvizGraphVo);
	}

	// #endregion

	// #region layout

	public static List<GraphvizNodeVo> layout(GraphvizBuGraphVo oGraphvizBuGraphVo) {
		return GraphvizBuUtils.layout(oGraphvizBuGraphVo);
	}

	// #endregion
}
