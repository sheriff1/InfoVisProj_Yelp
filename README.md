vtvisyelp
=========
-Parse objects to get the following information - http://wiki.fasterxml.com/JacksonInFiveMinutes

    S---> All of the user profile objects match up with a review object                             [X]           
    S---> Extract all Virginia Tech objects to separate JSON files                                  [X]
		    -expecting 770 review objects, <=770 user profile objects, and 91 business profile objects
		OUTPUT FROM ID_Match.java: Number of VT objects:
						Business profiles: 143
						User profiles: 320
						User reviews: 992

	S---> How many restaurants are near Virginia Tech (can be verified by "stufte" website)         [X]
		-see above			

	S---> How many categories of restaurants are there near Virginia Tech                           [X]
		this was done in Extract_Categories.java, the problem now is to identify 
		which categories we need to consider for our visualization.
		see list_categories_VT_Food_only.txt to see the list. 

 	D---> How many restaurants are within each these categories					[X]
		see list_categories_VT_Food_only.txt for the list of categories we care to display

	S---> The earliest and latest dates of reviews of restaurants                                   [ ]
			-near Virginia Tech
			-for each category
			-for each restaurant
			-think of date boundary - for whole area? for a category only? for a restaurant only?
	*** gauge the amount of time it took to parse each of these things

[above done by 11-16-12???]

    S ---> Incorporate submit button into menu interface (figure 1) - S                                  [X]

    S ---> the algorithm for incorporating voting metrics into rating. VERIFY. write the report about it.[*]
  	see list_of_scores.txt. 
	still to-do: recent scores, user review quantity weighted scores.

    S ---> remove non-restaurants from business profiles JSON file					 [X]
	in VT_jsons folder, business_profiles_food_only

    S ---> -layout the visualization and menu interface                                                         [X
   	created in Java. 

Suggestions for layout enhancement after Project 2 presentation (11/13/2012):
- Mesh the UI with the visualization.
- Incorporate Olympic-style podium into rows ---> Color the rows gold, silver, bronze as opposed to having podium
- Do not "emphasize" top 5 restaurants with separate click-buttons, but emphasize them in the drop down menu.
- In Figure 2, incorporate drop-down menu into the "Category X" part, so then we don't need it in the initial UI/part of meshing process
- ***Show all types of ratings in visualization, like bar graphs for all of the "What's important to you" metrics
	and then allow user to create "What's Important to you" rating based on those (still use checkbox, seems easiest for now)


TODO (12/6/12 - End)
1.) Olympic coloring in visualization
2.) placing box around selected rating type in visualization
3.) placing instructions in visualization


