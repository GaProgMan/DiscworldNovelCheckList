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

## Wiki Entry ##
A more up to date description of this project can be found at GaProgMan's Wiki: http://wiki.gaprogman.com/index.php?title=dwChecker

## Changelog ##

2016-06-05 Jamie Taylor
 - Removed License section of Readme
 - Added link to Wiki entry for project into Readme

2016-05-25 - Jamie Taylor
 - Began re-implementing entire code base from the ground up.
 - Added SQLite code to perform CRU (of CRUD) operations
 - Added a service class (will be expanded on in a later commit) for adding
   default books when no database is present.
 - Happy Glorious 25th of May!

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
