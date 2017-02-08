package com.huawei._2_sys_layout_designer.provider.model.layoutresult;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class LayoutResultRowModel {
	// #region Field

	@Getter
	@Setter
	private String graphName;

	@Getter
	@Setter
	private String parentGraphName;

	@Getter
	@Setter
	private List<LayoutResultNodeModel> lstResultNodeModel;

	// #endregion
}
