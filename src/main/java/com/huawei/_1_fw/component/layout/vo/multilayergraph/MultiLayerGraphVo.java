package com.huawei._1_fw.component.layout.vo.multilayergraph;

import java.util.List;
import java.util.Map;

import com.huawei._1_fw.component.layout.vo.graph.GraphvizEdgeVo;
import com.huawei._1_fw.component.layout.vo.graph.GraphvizGraphVo;
import com.huawei._1_fw.component.layout.vo.graph.GraphvizNodeVo;

import lombok.Getter;
import lombok.Setter;

public class MultiLayerGraphVo {
	//#region Field
	
	//#region Field.Topo结构相关属性
	
	@Setter
	@Getter
	private String name;

	@Setter
	@Getter
	private Map<String,List<GraphvizNodeVo>> mapFirstLineNode;

	@Setter
	@Getter
	private List<GraphvizEdgeVo> lstEdge;

	@Setter
	@Getter
	private List<GraphvizGraphVo> lstGraph4MultiLayer;
	
	//#endreigon
	
	//#region Field.Topo展示相关属性
	
	@Setter
	@Getter
	private int yAngleTrans;
	
	@Setter
	@Getter
	private int zPlaneAngleTrans;
	
	//#endregion

	//#endregion
}
