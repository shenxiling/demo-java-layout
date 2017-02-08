package com.huawei._1_fw.component.layout.vo.rule;

import com.huawei._1_fw.component.layout.vo.rule.coordinate.SubGraphCoordinateRuleVo;
import com.huawei._1_fw.component.layout.vo.rule.layout.SubgraphLayoutRuleVo;
import com.huawei._1_fw.component.layout.vo.rule.split.GraphSplitRuleVo;

import lombok.Getter;
import lombok.Setter;

public class GraphvizRuleVo {
	// #region Field

	@Setter
	@Getter
	private GraphSplitRuleVo graphSplitRuleVo;

	@Setter
	@Getter
	private SubgraphLayoutRuleVo subGraphLayoutRuleVo;

	@Setter
	@Getter
	private SubGraphCoordinateRuleVo subGraphCordinateRuleVo;

	// #endregion
}
