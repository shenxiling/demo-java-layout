package com.huawei._1_fw.component.layout;

import java.util.ArrayList;
import java.util.List;

import com.huawei._1_fw.component.layout.subprovider.inputfile.InputFileSubprovider;
import com.huawei._1_fw.component.layout.subprovider.invokeexe.InvokeExeSubprovider;
import com.huawei._1_fw.component.layout.subprovider.multilayer.MultiLayerProvider;
import com.huawei._1_fw.component.layout.subprovider.outputfile.OutputFileSubprovider;
import com.huawei._1_fw.component.layout.vo.config.GraphvizConfigVo;
import com.huawei._1_fw.component.layout.vo.graph.GraphvizGraphVo;
import com.huawei._1_fw.component.layout.vo.graph.GraphvizNodeVo;
import com.huawei._1_fw.component.layout.vo.multilayergraph.MultiLayerGraphVo;

public class GraphvizUtils {
	// #region layout

	public static List<GraphvizNodeVo> layout(MultiLayerGraphVo oMultiLayerGraphVo, GraphvizConfigVo oGraphvizConfigVo) {
		//1.确定每一层的第一排的节点坐标（减少相互交叉）
		oMultiLayerGraphVo=MultiLayerProvider.layoutFirstLine(oMultiLayerGraphVo);
		//2.layout each layer
		List<GraphvizNodeVo> lstRes=new ArrayList<GraphvizNodeVo>();
		for(GraphvizGraphVo oGraphvizGraphVo : oMultiLayerGraphVo.getLstGraph4MultiLayer())
		{
			lstRes.addAll(layoutInner(oGraphvizGraphVo, oGraphvizConfigVo));
		}
		//3.多层graph展示相关坐标转换
		lstRes=MultiLayerProvider.coordinateTransByYAngle(oMultiLayerGraphVo.getYAngleTrans(), lstRes);
		lstRes=MultiLayerProvider.coordinateTransByZPlane(oMultiLayerGraphVo.getZPlaneAngleTrans(), lstRes);
		return lstRes;
	}

	// #endregion

	// #region _layout

	private static List<GraphvizNodeVo> layoutInner(GraphvizGraphVo oGraphvizGraphVo,
			GraphvizConfigVo oGraphvizConfigVo) {
		// 1.layout this graph
		List<GraphvizNodeVo> lstGraphNode = layoutThisLayer(oGraphvizGraphVo, oGraphvizConfigVo);
		// 2.layout lstSubgraph
		for (GraphvizGraphVo oSubGraphVo : oGraphvizGraphVo.getLstSubgraph()) {
			if (oSubGraphVo.getGraphvizRuleInstanceVo().getHeightOnGraph() == 0
					&& oSubGraphVo.getGraphvizRuleInstanceVo().getWidthOnGraph() == 0) {
				GraphvizNodeVo oGraphvizNodeVo = new GraphvizNodeVo();
				oGraphvizNodeVo.setX(oSubGraphVo.getGraphvizRuleInstanceVo().getXOffsetOnGraph());
				oGraphvizNodeVo.setY(oSubGraphVo.getGraphvizRuleInstanceVo().getYOffsetOnGraph());
				oGraphvizNodeVo.setName(oSubGraphVo.getName());
				lstGraphNode.add(oGraphvizNodeVo);
			} else {
				lstGraphNode.addAll(layoutInner(oSubGraphVo, oGraphvizConfigVo));
			}
		}
		return lstGraphNode;
	}

	// #endregion

	// #region _layoutThisLayer

	private static List<GraphvizNodeVo> layoutThisLayer(GraphvizGraphVo oGraphvizGraphVo,
			GraphvizConfigVo oGraphvizConfigVo) {
		// 1.genInputFile
		String strInputFilePath = InputFileSubprovider.genInputFile(oGraphvizGraphVo, oGraphvizConfigVo);
		// 2.invoke layout engine
		String strOutputFilePath = InvokeExeSubprovider.invokeLayoutEngine(strInputFilePath,
				oGraphvizGraphVo.getGraphvizRuleInstanceVo().getEnumLayoutType(), oGraphvizConfigVo);
		// 3.parse layout output file
		List<GraphvizNodeVo> lstNodeAfterLayout = OutputFileSubprovider.parseFile(strOutputFilePath);
		// 4.delInputFile/delOutputFile
		InputFileSubprovider.delInputFile(strInputFilePath);
		InvokeExeSubprovider.delOutputFile(strOutputFilePath);
		// 5.updateNodePos4Need
		oGraphvizGraphVo.updateNodePos4Need(lstNodeAfterLayout);
		// 6.posOffset（according to different deputyNode）
		oGraphvizGraphVo.posOffset();
		// 7.return
		return lstNodeAfterLayout;
	}

	// #endregion

}
