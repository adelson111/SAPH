var express = require('express');
var router = express.Router();
var Client = require('node-rest-client').Client;
var client = new Client();

router.get('/nova-delegacao',(req, res, next)=>{
  client.get("http://localhost:8080/SAPH/saph/tipo-solicitacao-delegacao/tipo/DELEGACAO", function (data, response) {
    res.render('nova-delegacao', {
      title: 'Delegacoes - SAPH',
      tipos: data,
    });
  });
});

router.get('/listar-delegacoes',(req, res, next)=>{
  client.get("http://localhost:8080/SAPH/saph/solicitacao-delegacao/parametros/DELEGACAO/7", function (data, response) {
    console.log(data);
    res.render('listar-delegacoes', {
      title: 'Delegacoes - SAPH',
      delegacoes:data,
    });
  });
});


router.get('/listar-delegacoes',(req, res, next)=>{
  res.render('listar-delegacoes', {
    title: 'Solicitações - SAPH',
    dele: true
  });
});

router.get('/d-confirmadas',(req, res, next)=>{
  res.render('d-confirmadas', {
    title: 'Solicitações - SAPH',
  });
});

router.get('/d-analise',(req, res, next)=>{
  res.render('d-analise', {
    title: 'Solicitações - SAPH',
    dele: true
  });
});

router.get('/d-salvas',(req, res, next)=>{
  res.render('d-salvas', {
    title: 'Solicitações - SAPH',
    dele: true
  });
});

module.exports = router;
