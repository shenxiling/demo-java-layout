package com.huawei._1_fw.component.layout.vo.graph;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class GraphvizGraphVo {
	// #region Field

	// #region Fields.Topo形态相关的属性

	@Setter
	@Getter
	private String name;

	@Setter
	@Getter
	private List<GraphvizNodeVo> lstFirstLineNode;
	
	@Setter
	@Getter
	private List<GraphvizNodeVo> lstOtherNode;

	@Setter
	@Getter
	private List<GraphvizEdgeVo> lstEdge;

	@Setter
	@Getter
	private List<GraphvizGraphVo> lstSubgraph;

	// #endregion

	// #region Fields.当前GraphInstance与布局形态相关的属性(ruleInstance)

	@Setter
	@Getter
	private GraphvizRuleInstanceVo graphvizRuleInstanceVo;

	// #endregion

	// #endregion

	// #region updateNodePos

	/**
	 * updateNodePos<br>
	 * 1.将lstNodeAfterLayout的坐标更新到lstNode中（根据isNew标志位判断是否更新）
	 * 2.将lstNodeAfterLayout的坐标更新到lstGraph中的每一个deputyNode中
	 * 
	 * @param lstNodeAfterLayout
	 *            根据布局算法算出坐标的节点链表
	 */
	public void updateNodePos4Need(List<GraphvizNodeVo> lstNodeAfterLayout) {
		// TODO
	}

	// #endregion

	// #region posOffset

	/**
	 * 0.判断是否设置Rule ； 1.如果存在deputyNode4Rule则使用此坐标更新pos；
	 * 2.如果不存在，则使用deputyNode坐标更新pos
	 * 
	 */
	public void posOffset() {
		// TODO
	}

	// #endregion
}
