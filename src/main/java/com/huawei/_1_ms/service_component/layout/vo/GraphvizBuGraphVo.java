package com.huawei._1_ms.service_component.layout.vo;

import java.util.List;

import com.huawei._1_fw.component.layout.vo.graph.GraphvizEdgeVo;
import com.huawei._1_fw.component.layout.vo.graph.GraphvizNodeVo;

import lombok.Getter;
import lombok.Setter;

public class GraphvizBuGraphVo {
	// #region Field

	@Setter
	@Getter
	private String name;

	@Setter
	@Getter
	private List<GraphvizNodeVo> lstNode;

	@Setter
	@Getter
	private List<GraphvizEdgeVo> lstEdge;

	@Setter
	@Getter
	private List<GraphvizBuGraphVo> lstSubgraph;

	// #endregion
}
