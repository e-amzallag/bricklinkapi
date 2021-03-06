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

/**
 * Region criteria.
 *
 */
public enum Region {

	ASIA("asia"), AFRICA("africa"), NORTH_AMERICA("north_america"), SOUTH_AMERICA("south_america"),
	MIDDLE_EAST("middle_east"), EUROPE("europe"), EU("eu"), OCEANIA("oceania");

	private String code;

	private Region(String code) {
		this.code = code;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

}
