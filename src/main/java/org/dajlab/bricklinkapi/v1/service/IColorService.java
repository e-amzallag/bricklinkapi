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
package org.dajlab.bricklinkapi.v1.service;

import org.dajlab.bricklinkapi.v1.vo.BricklinkException;
import org.dajlab.bricklinkapi.v1.vo.Color;
import org.dajlab.bricklinkapi.v1.vo.ColorsList;

/**
 * Service for Bricklink colors.
 * 
 * @see <a href=
 *      "http://apidev.bricklink.com/redmine/projects/bricklink-api/wiki/ColorMethod">Color</a>
 * @author Erik Amzallag
 *
 */
public interface IColorService {

	/**
	 * This method retrieves a list of the colors defined within BrickLink catalog.
	 * 
	 * @return a list of color resource
	 * @throws BricklinkException exception
	 */
	ColorsList getColorList() throws BricklinkException;

	/**
	 * This method retrieves information about a specific color.
	 * 
	 * @param colorId The ID of the color to get
	 * @return a color resource
	 * @throws BricklinkException exception
	 */
	Color getColor(Integer colorId) throws BricklinkException;
}
