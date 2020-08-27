/**
 * 
 */
package com.openthinks.goldeneye.web.api;

import com.openthinks.libs.utilities.json.JSONConverters;
import com.openthinks.libs.utilities.json.JSONObject;
import com.openthinks.libs.utilities.json.Valueable;

/**
 * @author dailey.yet@outlook.com
 *
 */
public final class APIResponse {
	private int rst = 0;
	private String msg = null;
	private Object data = null;

	public int getRst() {
		return rst;
	}

	public String getMsg() {
		return msg;
	}

	public Object getData() {
		return data;
	}

	public void setRst(int rst) {
		this.rst = rst;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public static final APIResponseBuilder builder() {
		return new APIResponseBuilder();
	}

	public static final class APIResponseBuilder {

		APIResponse apires = new APIResponse();

		public APIResponse finish() {
			return apires;
		}
		
		public JSONObject finishAsJSON() {
			JSONObject jsonObj = JSONConverters.perparedAndGet(apires);
			return jsonObj;
		}

		public APIResponseBuilder rst(int rst) {
			apires.rst = rst;
			return this;
		}

		public APIResponseBuilder rst(Valueable<Integer> rst) {
			apires.rst = rst == null ? 0 : rst.value();
			return this;
		}

		public APIResponseBuilder msg(String msg) {
			apires.msg = msg;
			return this;
		}

		public APIResponseBuilder msg(Object msg) {
			apires.msg = msg == null ? null : String.valueOf(msg);
			return this;
		}

		public APIResponseBuilder msg(Valueable<?> msg) {
			apires.msg = msg == null ? null : String.valueOf(msg.value());
			return this;
		}

		public APIResponseBuilder data(Object data) {
			apires.data = data;
			return this;
		}
	}

}
