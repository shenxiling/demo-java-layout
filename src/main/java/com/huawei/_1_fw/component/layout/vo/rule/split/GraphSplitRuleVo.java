package com.huawei._1_fw.component.layout.vo.rule.split;

import lombok.Getter;
import lombok.Setter;

public class GraphSplitRuleVo {
	// #region Field

	/**
	 * 潜规则：GraphVizBuUtils自行从线程上下文获得pluginGraphSplitImpl依赖的上下文<br>
	 * 例如：db的操作对象/工程Id/场景Id
	 */
	@Setter
	@Getter
	private String pluginGraphSplitImpl;

	// #endregion
}
