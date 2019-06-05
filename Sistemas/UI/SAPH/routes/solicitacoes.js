var express = require('express');
var router = express.Router();
var Client = require('node-rest-client').Client;
var client = new Client();

router.get('/list',(req, res, next)=>{
  res.render('list', {
    title: 'Solicitações - SAPH',
  });
});

  router.get('/list',(req, res, next)=>{
    client.get("http://localhost:8080/SAPH/saph/solicitacao/listar", function (data, response) {
      res.render('new', {
        title: 'Solicitacoes - SAPH',
        tipos: data,
      });
    });

});
router.post('/cada', function (req, res) {
  var args = {
      data: "hello" ,
      headers: { "Content-Type": "application/json" }
  };
  client.post("http://localhost:8080/SAPH/saph/solicitacao/cadastrar",args,function (data, response) {
    res.send(data);
  });
});
module.exports = router;
