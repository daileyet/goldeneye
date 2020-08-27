/**
 * 
 */
package com.openthinks.goldeneye.utils;

import com.openthinks.libs.utilities.json.Valueable;

/**
 * @author dailey.yet@outlook.com
 *
 */
public final class Constants {
	private Constants() {
	}

	public static final String API_PREFIX = "/api";

	public static final String API_PATH_VERSION = "version";

	public static final String API_PATH_METAL = "metal";

	public static final String API_PATH_UNIT = "unit";

	public static final String API_EXECUTE_RST = "result";

	public static enum ErrorRst implements Valueable<Integer> {
		ERROR {
			@Override
			public Integer value() {
				return -1;
			}
		},
		SUCCESS {
			@Override
			public Integer value() {
				return 0;
			}
		};
	}

	public static enum ErrorCode implements Valueable<Integer> {
		NOT_SUPPORT_VERSION {
			@Override
			public Integer value() {
				return 10000;
			}
		},
		UNKONW {
			@Override
			public Integer value() {
				return 10100;
			}
		},
		NOT_SUPPORT_CATEGORY {
			@Override
			public Integer value() {
				return 10001;
			}
		},
		NOT_SUPPORT_UNIT {
			@Override
			public Integer value() {
				return 10002;
			}
		},
		NO_DATA_FETCH {
			@Override
			public Integer value() {
				return 10003;
			}
		};

	}

	public static enum Metas implements Valueable<String> {
		AG("Ag", "白银", "银", "Silver"), AU("Au", "黄金", "金", "Gold"), PT("Pt", "铂金", "铂", "Platinum"), PD("Pd", "钯",
				"Palladium"), RH("Rh", "铑", "Rhodium");

		private String code;
		private String[] displayNames;

		private Metas(String code, String... displayNames) {
			this.code = code;
			this.displayNames = displayNames;
		}

		@Override
		public String value() {
			return code;
		}

		public boolean hasDisplayName(String displayName) {
			if (code.equalsIgnoreCase(displayName))
				return true;
			for (String innerName : displayNames) {
				if (innerName.equalsIgnoreCase(displayName)) {
					return true;
				}
			}
			return false;
		}

		public static Metas toMetas(String displayName) {
			for (Metas meta : Metas.values()) {
				if (meta.hasDisplayName(displayName)) {
					return meta;
				}
			}
			return null;
		}

	}

	public static enum Units implements Valueable<String> {
		CNY_G("CNY.g", "人民币/克"), EUR_OZ("EUR.oz", "欧元/盎司"), GBP_OZ("GBP.oz", "英镑/盎司"), USD_OZ("USD.oz", "美元/盎司");

		private String code;
		private String[] displayNames;

		private Units(String code, String... displayNames) {
			this.code = code;
			this.displayNames = displayNames;
		}

		@Override
		public String value() {
			return code;
		}

		public boolean hasDisplayName(String displayName) {
			if (code.equalsIgnoreCase(displayName))
				return true;
			for (String innerName : displayNames) {
				if (innerName.equalsIgnoreCase(displayName)) {
					return true;
				}
			}
			return false;
		}

		public static Units toUnits(String displayName) {
			for (Units unit : Units.values()) {
				if (unit.hasDisplayName(displayName)) {
					return unit;
				}
			}
			return null;
		}

	}

}
