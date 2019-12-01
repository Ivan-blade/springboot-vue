const JsonServer = require('json-server');
const data =require('./db.js');

const server = JsonServer.create();
const router = JsonServer.router(data);
const middleware = JsonServer.defaults();

server.use(middleware);
server.use(router);
server.use(JsonServer.bodyParser);

server.listen({
    host:'127.0.0.1',
    port:'8858'
},function(){
    console.log('Json-server is running ~');
}); 