# DiscworldNovelCheckList #

### Original creation date ###
29/07/2012

### Lead Programmer ###
Jamie 'GaProgMan' Taylor

## Purpose of the project ##
  After spending way too many hours in books stores pondering the eternal though of, "Do I have this book already?" I decided to create an Android app that will allow me to keep track of the Discworld Novels that I have already purchased.
  This repo is the fruit of my labour so far. Currently, the app loads a selection of "elements" from a string-array (found in /res/values/elementTitles.xml) at boot-time and uses these to create an array of "element" objects. These objects are used to represent the novels in the series.
  elementTitles.xml is in no way complete - it contains only a few titles, to aid in testing.
  As of 18/01/2013, the element objects do nothing once they have been created. Future revisions, however, will include an array of check boxes (displayed in a list), each representing an individual "element" object.

## Licence ##

		GNU Copyright information
		Copyright 2013 Jamie Taylor <jamie@taylorj.org.uk>

		This program is free software; you can redistribute it and/or modify
		it under the terms of the GNU General Public License as published by
		the Free Software Foundation; either version 2 of the License, or
		(at your option) any later version.

		This program is distributed in the hope that it will be useful,
		but WITHOUT ANY WARRANTY; without even the implied warranty of
		MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
		GNU General Public License for more details.

		You should have received a copy of the GNU General Public License
		along with this program; if not, write to the Free Software
		Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
		MA 02110-1301, USA.

## Changelog ##

2013-05-27 - Jamie Taylor
- Updated Readme to use Markdown

2013-01-18 - Jamie Taylor
- Re-design and re-implementation of classes
- Added element and elementLoader classes
- /res/values/elementTitles.xml
- Removed depricated code

2012-05-02 - Jamie Taylor
- Initial creation of solution
- Added all source code to solution
- Re-written README to make solution
- Added content to chapterOne and chapterTwoDiscworldNovelCheckList
