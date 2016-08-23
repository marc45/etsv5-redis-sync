package com.etrans.etsv5.app.redis.sync;

/**
 * 版权所有 (C) 2016 ® E-trans Company  <br />
 * 单元名称: RC_Pipeline.java  <br />
 * 说       明: <br />
 * 作       者: yunnet <br />
 * 创建时间: 2016年8月23日 下午4:20:36 <br />
 * 最后修改: 2016年8月23日 下午4:20:36 <br />
 * 修改历史: <br />
 */
public interface RC_Pipeline<IN, OUT> extends RC_Pipe<IN, OUT>{
	
	/**
	 *  往该Pipeline实例中添加一个Pipe实例。
	 * @param _pipe Pipe实例
	 */
	void addPipe(RC_Pipe<?, ?> _pipe);

}
