INSERT INTO discussion(discussion_id,date_added,is_locked,section,text_content,title)
VALUES (0,now(),false,0,'Hello, and welcome to the Botaniac Forums.
		This is a place where you can discuss stuff about gardening","Welcome to the forums!','Botaniac Forums just opened!');
INSERT INTO discussion(discussion_id,date_added,is_locked,section,text_content,title)
VALUES (1,now(),false,0,'This section is dedicated to any news related to gardening or plants in general','Section guidelines');
SELECT * FROM discussion
