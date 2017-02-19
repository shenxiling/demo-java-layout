package com.huawei._1_fw.component.layout.vo.graph;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class GraphvizGraphVo {
	// #region Field

	// #region Fields.Topo��̬��ص�����

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

	// #region Fields.��ǰGraphInstance�벼����̬��ص�����(ruleInstance)

	@Setter
	@Getter
	private GraphvizRuleInstanceVo graphvizRuleInstanceVo;

	// #endregion

	// #endregion

	// #region updateNodePos

	/**
	 * updateNodePos<br>
	 * 1.��lstNodeAfterLayout��������µ�lstNode�У�����isNew��־λ�ж��Ƿ���£�
	 * 2.��lstNodeAfterLayout��������µ�lstGraph�е�ÿһ��deputyNode��
	 * 
	 * @param lstNodeAfterLayout
	 *            ���ݲ����㷨�������Ľڵ�����
	 */
	public void updateNodePos4Need(List<GraphvizNodeVo> lstNodeAfterLayout) {
		// TODO
	}

	// #endregion

	// #region posOffset

	/**
	 * 0.�ж��Ƿ�����Rule �� 1.�������deputyNode4Rule��ʹ�ô��������pos��
	 * 2.��������ڣ���ʹ��deputyNode�������pos
	 * 
	 */
	public void posOffset() {
		// TODO
	}

	// #endregion
}
