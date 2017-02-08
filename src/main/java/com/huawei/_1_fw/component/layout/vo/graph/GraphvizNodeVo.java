package com.huawei._1_fw.component.layout.vo.graph;

import lombok.Getter;
import lombok.Setter;

public class GraphvizNodeVo {
	// #region Field

	@Getter
	@Setter
	private String name;

	@Getter
	@Setter
	private double x;

	@Getter
	@Setter
	private double y;

	@Getter
	@Setter
	private double height;

	@Getter
	@Setter
	private double width;

	@Getter
	@Setter
	private boolean needUpdate;

	// #endregion
}
