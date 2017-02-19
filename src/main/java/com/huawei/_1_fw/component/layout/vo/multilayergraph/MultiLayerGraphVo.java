package com.huawei._1_fw.component.layout.vo.multilayergraph;

import java.util.List;
import com.huawei._1_fw.component.layout.vo.graph.GraphvizEdgeVo;
import com.huawei._1_fw.component.layout.vo.graph.GraphvizGraphVo;
import lombok.Getter;
import lombok.Setter;

public class MultiLayerGraphVo {
	//#region Field
	
	//#region Field.Topo�ṹ�������
	
	@Setter
	@Getter
	private String name;

	@Setter
	@Getter
	private List<GraphvizEdgeVo> lstEdge;

	@Setter
	@Getter
	private List<GraphvizGraphVo> lstGraph4MultiLayer;
	
	//#endreigon
	
	//#region Field.Topoչʾ�������
	
	@Setter
	@Getter
	private int layerDistance;
	
	@Setter
	@Getter
	private int yAngleTrans;
	
	@Setter
	@Getter
	private int zPlaneAngleTrans;
	
	//#endregion

	//#endregion
}
