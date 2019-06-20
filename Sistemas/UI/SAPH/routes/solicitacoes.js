var express = require('express');
var router = express.Router();
var Client = require('node-rest-client').Client;
var client = new Client();

router.get('/new',(req, res, next)=>{
  client.get("http://localhost:8080/SAPH/saph/tipo-solicitacao-delegacao/tipo/SOLICITACAO", function (data, response) {
    res.render('new', {
      title: 'Solicitacoes - SAPH',
      tipos: data,
    });
  });

});

router.get('/list',(req, res, next)=>{
  client.get("http://localhost:8080/SAPH/saph/solicitacao-delegacao/parametros/SOLICITACAO/7", function (data, response) {
    res.render('list', {
      title: 'Solicitacoes - SAPH',
      solicitacoes:data,
    });
  });
});

router.get('/confirmadas',(req, res, next)=>{
  res.render('confirmadas', {
    title: 'Solicitações - SAPH',
  });
});

router.get('/analise',(req, res, next)=>{
  res.render('analise', {
    title: 'Solicitações - SAPH',
  });
});

router.get('/recusadas',(req, res, next)=>{
  res.render('recusadas', {
    title: 'Solicitações - SAPH',
  });
});

router.get('/salvas',(req, res, next)=>{
  res.render('salvas', {
    title: 'Solicitações - SAPH',
  });
});

router.post('/cada', function (req, res) {
  // console.log(res.body.solicitacao);
  var args = {
      data: req.body.solicitacao,
      headers: { "Content-Type": "application/json" }
  };
  client.post("http://localhost:8080/SAPH/saph/solicitacao-delegacao",args,function (data, response) {
    res.send(data);
  });
});
module.exports = router;
