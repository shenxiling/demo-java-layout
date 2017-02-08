package com.huawei._2_sys_layout_designer.provider.model.graphlayout;

import com.huawei._1_fw.component.layout.vo.rule.layout.EnumGraphvizLayoutTypeVo;

import lombok.Getter;
import lombok.Setter;

public class GraphLayoutRowValueModel {
	// #region Fields

	@Getter
	@Setter
	private EnumGraphvizLayoutTypeVo enumLayoutType;

	@Getter
	@Setter
	private int xOffsetOnGraph;

	@Getter
	@Setter
	private int yOffsetOnGraph;

	@Getter
	@Setter
	private double heightOnGraph;

	@Getter
	@Setter
	private double widthOnGraph;

	// #endregion
}
