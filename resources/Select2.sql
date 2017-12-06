SELECT a.TeamID,
a.TeamName, 
b.FirstName, 
b.LastName,
b.NumGoals
	FROM Players b JOIN Teams a 
		ON b.TeamID = a.TeamID
  GROUP BY PlayerID
  ORDER BY NumGoals DESC;