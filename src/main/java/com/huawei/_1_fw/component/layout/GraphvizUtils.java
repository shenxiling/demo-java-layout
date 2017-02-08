package com.huawei._1_fw.component.layout;

import java.util.List;

import com.huawei._1_fw.component.layout.subprovider.inputfile.InputFileSubprovider;
import com.huawei._1_fw.component.layout.subprovider.invokeexe.InvokeExeSubprovider;
import com.huawei._1_fw.component.layout.subprovider.outputfile.OutputFileSubprovider;
import com.huawei._1_fw.component.layout.vo.config.GraphvizConfigVo;
import com.huawei._1_fw.component.layout.vo.graph.GraphvizGraphVo;
import com.huawei._1_fw.component.layout.vo.graph.GraphvizNodeVo;

public class GraphvizUtils {
	// #region layout

	public static List<GraphvizNodeVo> layout(GraphvizGraphVo oGraphvizGraphVo, GraphvizConfigVo oGraphvizConfigVo) {
		List<GraphvizNodeVo> lstRes = layoutInner(oGraphvizGraphVo, oGraphvizConfigVo);
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
				lstGraphNode.addAll(layout(oSubGraphVo, oGraphvizConfigVo));
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
		// 6.posOffset£¨according to different deputyNode£©
		oGraphvizGraphVo.posOffset();
		// 7.return
		return lstNodeAfterLayout;
	}

	// #endregion

}
