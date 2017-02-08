package com.huawei._2_sys_layout_designer.provider.model.subgraphsplit;

import java.util.List;

import com.huawei._1_fw.component.layout.vo.graph.GraphvizEdgeVo;
import com.huawei._1_fw.component.layout.vo.graph.GraphvizNodeVo;

import lombok.Getter;
import lombok.Setter;

public class SubgraphSplitRowModel {
	// #region Field

	@Getter
	@Setter
	private String graphName;

	@Getter
	@Setter
	private String parentGraphName;

	@Getter
	@Setter
	private List<GraphvizNodeVo> lstNode;

	@Getter
	@Setter
	private List<GraphvizEdgeVo> lstEdge;

	// #endregion
}
