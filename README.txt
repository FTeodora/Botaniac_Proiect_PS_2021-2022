Patch Notes:

V 0.2
Moved the javascript that fetches the forum sections in its separate folder

V 0.1
Now you have a homepage from which you can select the microservice you want to access
How to start: 
1. Make sure you create the plants and the forums database in your PostgreSQL. The mysql one has the createDatabaseIfNotExists flag
2. have the homepage-service,account-service,forums-service, shop-service and the gateway be open simultenously and run each individual one in your ide or from the cmd (or if you just want to see the forum features, just start homepage-service, forums-service and the api-gateway)
3. Type localhost:8420/Homepage in your browser
4. This should redirect you to a page with a text and three buttons, each corresponding to a microservice accordingly. Click on the desired button
5. In addition, the forum page will redirect you to another page containing the available forums sections (from the enum)
6. If you click on any of the forums sections, you will be redirected to a page with the name of the section. The discussions corresponging to the sections will be added in the future

ports: 8420 the gateway
8421: accounts-service - with MySQL database
8422: forums-service - with PostgreSQL database(also from what I've understood, you can't make the database create itself if it doesn't exist with this one, so you'll have to make them manually)
8423: plants-service - PostgreSQL as well
To be added:
8424: shop-service - Will be with MySql. Maybe even MongoDB for the shopping cart

TO DO: Make section discussions from the database appear. Maybe even make it show the messages
Change the homepage-service to a vue.js project
Note: Ignore the discussions-browser from the css folder in the forums microservice. It was just me getting used with vue.js projects