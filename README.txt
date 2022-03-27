I haven't done too much yet, like making html pages, but the api gateway works!!
How to start: 
1. Make sure you create the plants and the forums database in your PostgreSQL. The mysql one has the createDatabaseIfNotExists flag
2. have the account-service,forums-service and shop-service be open simultenously and run each individual one in your ide or from the cmd
3. After that, run the api-gateway and go to your browser. 
4. There, you may type one from the following:
localhost:8420/accounts - the gateway will redirect the request to the method mapped to /accounts from accounts-service
localhost:8420/forums - the gateway will redirect the request to /forums from forum
localhost:8420/plants - /plants from plants-service will be called

ports: 8420 the gateway
8421: accounts-service - with MySQL database
8422: forums-service - with PostgreSQL database(also from what I've understood, you can't make the database create itself if it doesn't exist with this one, so you'll have to make them manually)
8423: plants-service - PostgreSQL as well
To be added:
8424: shop-service - Will be with Firebird. Maybe even MongoDB for the shopping cart

!!Warning: I'm a bit unsure about having the same ports in the jpa connection configurations when the databases match