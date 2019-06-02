var express = require('express');
var router = express.Router();

router.get('/new',(req, res, next)=>{
  var Client = require('node-rest-client').Client;
  var client = new Client();
  client.get("http://localhost:8080/SAPH/SAPH/solicitacao/listar", function (data, response) {
    res.render('new', {
      title: 'Solicitacoes - SAPH',
      tipos: data,
    });
  });

});
module.exports = router;
