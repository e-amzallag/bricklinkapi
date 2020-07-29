/*
 * Copyright 2020 Erik Amzallag
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.dajlab.bricklinkapi.v1.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Condition of item criteria.
 *
 */
public enum NewOrUsed {
	NEW("N"), USED("U");

	private String code;

	private NewOrUsed(String code) {
		this.code = code;
	}

	/**
	 * @return the code
	 */
	@JsonValue
	public String getCode() {
		return code;
	}

	/**
	 * 
	 * @param code
	 *            code
	 * @return the enum, or null if not found
	 */
	@JsonCreator
	public static NewOrUsed fromCode(String code) {
		for (NewOrUsed e : NewOrUsed.values()) {
			if (e.getCode().equals(code)) {
				return e;
			}
		}
		return null;
	}

}
