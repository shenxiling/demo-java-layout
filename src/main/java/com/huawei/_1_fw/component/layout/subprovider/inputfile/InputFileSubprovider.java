package com.huawei._1_fw.component.layout.subprovider.inputfile;

import java.util.List;

import com.huawei._1_fw.component.layout.vo.config.GraphvizConfigVo;
import com.huawei._1_fw.component.layout.vo.graph.GraphvizGraphVo;
import com.huawei._1_fw.component.layout.vo.graph.GraphvizNodeVo;

public class InputFileSubprovider {
	// #region genInputFile

	/**
	 * ����graphvizGraphVo����dot�ļ� ��1.lstNode+lstGraph��deputyNode������������нڵ㣻
	 * 2.lstEdge��ֻ��¼��node��node�Լ�node��������deputyNode�����ߣ��������������ĸ��ڵ����Ӷ��ڱ������㷨��Ӱ�죬
	 * Graphviz������ֻ����lstNode���ڵ����·��ͨ��������ʽ��ѯ��
	 * 
	 * @param oSubgraph
	 * @return strCompletePath dot�ļ�������·���������ļ�����
	 */
	public static String genInputFile(GraphvizGraphVo oGraphvizGraphVo, GraphvizConfigVo oGraphvizConfigVo) {
		String strCompletePath = oGraphvizConfigVo.getDirPathRoot() + oGraphvizGraphVo.getName();
		List<GraphvizNodeVo> lstInputNode = oGraphvizGraphVo.getLstFirstLineNode();
		lstInputNode.addAll(oGraphvizGraphVo.getLstOtherNode());
		for (GraphvizGraphVo oSubgraph : oGraphvizGraphVo.getLstSubgraph()) {
			// lstInputNode.add(oSubgraph.getGraphvizRuleInstanceVo().getNodeOffset());
		}
		// 1.д��Graph���Ե��ļ�

		// 2.д��node�������Ե��ļ�

		// 3.д��Edge�������Ե��ļ�

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
