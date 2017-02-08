package com.huawei._1_fw.component.layout.subprovider.rulefile;

import java.util.List;

import com.huawei._1_fw.component.layout.vo.graph.GraphvizGraphVo;
import com.huawei._1_fw.component.layout.vo.rule.coordinate.SubGraphCoordinateRuleKeyVo;
import com.huawei._1_fw.component.layout.vo.rule.layout.SubgraphLayoutRuleVo;
import com.huawei._1_fw.component.layout.vo.rule.split.GraphSplitRuleVo;

public class RuleFileProvider {
	// #region genGraphVo

	public static GraphvizGraphVo genGraphVo(String strRuleName,
			List<SubGraphCoordinateRuleKeyVo> lstSubGraphCordinateRuleKeyVo) {
		// 1.get oGraphSplitRuleVo

		// 2.get oSubGraphLayoutRuleVo

		// 3.get oSubGraphCoordinateRuleVo

		// 4.根据oGraphSplitRuleVo/oSubGraphLayoutRuleVo/oSubGraphCoordinateRuleVo,gen
		// oGraphvizRuleVo

		// 5.根据lstSubGraphCoordinateRuleKeyVo和oGraphvizRuleVo.subGraphCoordinateRuleVo,
		// 获得oSubGraphCoordinateRuleRowVo

		// 6.根据oGraphvizRuleVo,获得oGraphvizGraphVo
		// 6.1.根据oGraphvizGraphVo.graphSplitRuleVo,获得oGraphvizGraphVo
		// (缺少lstSubGraph之间的lstEdge4SubGraph)

		// 6.2.递归oGraphvizGraphVo,获得oGraphvizGraphVoThisIter
		// 6.2.0.遍历oGraphvizGraphVoThisIter.lstSubGraph，获得lstEdge4SubGraph,
		// 添加到oGraphvizGraphVoThisIter.lstEdge

		// 6.2.1.根据oGraphvizRuleVo.subGraphLayoutRuleVo,
		// 更新oGraphvizGraphVoThisIter.graphvizRuleInstanceVo.enumLayoutType

		// 6.2.2.根据oGraphvizRuleVo.subGraphCordinateRuleRowVo,
		// 更新oGraphvizGraphVoThisIter.graphvizRuleInstanceVo.xOffsetOnGraph
		// 更新oGraphvizGraphVoThisIter.graphvizRuleInstanceVo.yOffsetOnGraph
		// 更新oGraphvizGraphVoThisIter.graphvizRuleInstanceVo.heightOnGraph
		// 更新oGraphvizGraphVoThisIter.graphvizRuleInstanceVo.widthOnGraph

		return null;
	}

	// #endregion

	// #region readSplitFile

	public static GraphSplitRuleVo readSplitFile(String strFilePath) {
		GraphSplitRuleVo oGraphSplitRuleVo = new GraphSplitRuleVo();
		// TODO
		return oGraphSplitRuleVo;
	}

	// #endregion

	// #region readLayoutRuleFile

	public static SubgraphLayoutRuleVo readLayoutRuleFile(String strFilePath) {
		SubgraphLayoutRuleVo oSubgraphLayoutRuleVo = new SubgraphLayoutRuleVo();
		// TODO
		return oSubgraphLayoutRuleVo;
	}

	// #endregion

	// #region readCoordinateFile

	public static SubgraphLayoutRuleVo readCoordinateFile(String strFilePath) {
		SubgraphLayoutRuleVo oSubgraphLayoutRuleVo = new SubgraphLayoutRuleVo();
		// TODO
		return oSubgraphLayoutRuleVo;
	}

	// #endregion

	// #region readAttrFile

	// #endregion
}
