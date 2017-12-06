SELECT SUM(NumGoals) ,b.TeamID,b.TeamName 
FROM Players a JOIN Teams b
			ON a.TeamID = b.TeamID
	GROUP BY b.TeamID 
		HAVING SUM(NumGoals) >= 30
	ORDER BY SUM(NumGoals)DESC;