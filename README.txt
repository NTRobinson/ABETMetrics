Description:
This program allows you to define the structure of ABET criteria satisfaction for all assignments
in a given course. Once defined, student grade data can be used to determine the average level of criteria
satisfaction.

Requirements:
Java - https://www.java.com/en/download/

Usage:
First, a list of graded assignments/materials must be compiled using the "Add Assignments" function. Create
an assignment, then populate it with problems having corresponding ABET criteria weight (represented by percentage
of each criteria for the particular problem). This data may be saved and loaded as text files for future use.

Second, you'll need a grade sheet formated like so and saved as a tab-delimited text file:
Name	PCB1	PCB2	Test 1	Test 2	Test 3
John	82	87	84	92	98

Note: This sheet can be created in Microsoft Excel or Google Sheets and saved as "Text (Tab Delimited) (*txt)"


Once grades are loaded, click "Calculate". Class criteria satisfaction percentage based on assignment grades
will be calculated and displayed.