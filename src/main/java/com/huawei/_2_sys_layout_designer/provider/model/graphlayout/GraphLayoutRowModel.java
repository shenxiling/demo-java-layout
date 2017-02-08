package com.huawei._2_sys_layout_designer.provider.model.graphlayout;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class GraphLayoutRowModel {
	// #region Field

	@Getter
	@Setter
	private String subgraphName;

	@Getter
	@Setter
	private List<GraphLayoutRowValueModel> lstSubgraphLayoutRowValueModel;

	// #endregion
}
