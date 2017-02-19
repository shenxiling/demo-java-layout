package com.huawei._1_fw.component.layout.subprovider.inputfile;

import java.util.List;

import com.huawei._1_fw.component.layout.vo.config.GraphvizConfigVo;
import com.huawei._1_fw.component.layout.vo.graph.GraphvizGraphVo;
import com.huawei._1_fw.component.layout.vo.graph.GraphvizNodeVo;

public class InputFileSubprovider {
	// #region genInputFile

	/**
	 * 根据graphvizGraphVo生成dot文件 （1.lstNode+lstGraph的deputyNode构成输入的所有节点；
	 * 2.lstEdge中只记录了node与node以及node与子网中deputyNode的连线，具体与子网中哪个节点连接对于本布局算法无影响，
	 * Graphviz工具类只返回lstNode，节点间链路可通过其它方式查询）
	 * 
	 * @param oSubgraph
	 * @return strCompletePath dot文件的完整路径（包含文件名）
	 */
	public static String genInputFile(GraphvizGraphVo oGraphvizGraphVo, GraphvizConfigVo oGraphvizConfigVo) {
		String strCompletePath = oGraphvizConfigVo.getDirPathRoot() + oGraphvizGraphVo.getName();
		List<GraphvizNodeVo> lstInputNode = oGraphvizGraphVo.getLstFirstLineNode();
		lstInputNode.addAll(oGraphvizGraphVo.getLstOtherNode());
		for (GraphvizGraphVo oSubgraph : oGraphvizGraphVo.getLstSubgraph()) {
			// lstInputNode.add(oSubgraph.getGraphvizRuleInstanceVo().getNodeOffset());
		}
		// 1.写入Graph属性到文件

		// 2.写入node及其属性到文件

		// 3.写入Edge及其属性到文件

		return strCompletePath;
	}

	// #endregion

	// #region delInputFile

	/**
	 * 
	 * @param strInputFilePath
	 * @return
	 */
	public static boolean delInputFile(String strInputFilePath) {
		// TODO
		return true;
	}

	// #endregion
}
