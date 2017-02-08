package com.huawei._1_fw.component.layout.subprovider.invokeexe;

import com.huawei._1_fw.component.layout.vo.config.GraphvizConfigVo;
import com.huawei._1_fw.component.layout.vo.rule.layout.EnumGraphvizLayoutTypeVo;

public class InvokeExeSubprovider {
	// #region invokeLayoutEngine

	/**
	 * 
	 * @param strInutFilePath
	 *            输入文件的完整路径（包含文件名）
	 * @param enumlayoutType
	 *            使用哪种布局算法
	 * @return strOutputFilePath 输出文件的完整路径（包含文件名）
	 */
	public static String invokeLayoutEngine(String strInutFilePath, EnumGraphvizLayoutTypeVo enumGraphvizLayoutTypeVo,
			GraphvizConfigVo oGraphvizConfigVo) {
		String strOutputFilePath = null;
		// TODO
		return strOutputFilePath;
	}

	// #endregion

	// #region delOutputFile

	public static void delOutputFile(String strOutputFilePath) {

	}

	// #endregion
}
