Feature: data Table

Scenario: single row with no headers
Given enter username and password
   |AmolDombale|Amol@5793|  
   
Scenario: multiple row with no headers
Given enter multiple username and password
   |AmolDombale|Amol@5793| 
   |AmolDombale1|Amol@57931| 
   |AmolDombale2|Amol@57931| 
   |AmolDombale3|Amol@57931| 
   |AmolDombale4|Amol@57931| 
 When enter multiple with list username and password
   |AmolDombale|Amol@5793| 
   |AmolDombale1|Amol@57931| 
   |AmolDombale2|Amol@57931| 
   |AmolDombale3|Amol@57931| 
   |AmolDombale4|Amol@57931|  
   
   