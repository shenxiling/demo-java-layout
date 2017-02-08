package com.huawei._1_ms.service_component.layout.subprovider.cache;

import com.huawei._1_fw.component.layout.vo.graph.GraphvizGraphVo;

import lombok.Getter;
import lombok.Setter;

public class GraphvizGraphVoCache {
	// TODO GraphvizGraphVo需要考虑线程安全
	// #region Field

	@Getter
	@Setter
	private GraphvizGraphVo graphvizGraphVo;

	private static GraphvizGraphVoCache m_oInstance;

	// #endregion

	// #region constructor

	private GraphvizGraphVoCache() {

	}

	public static synchronized GraphvizGraphVoCache getInstance() {
		if (null == m_oInstance) {
			m_oInstance = new GraphvizGraphVoCache();
		}
		return m_oInstance;
	}

	// #endregion
}
