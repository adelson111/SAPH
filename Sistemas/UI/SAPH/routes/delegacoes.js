var express = require('express');
var router = express.Router();
var Client = require('node-rest-client').Client;
var client = new Client();

router.get('/nova-delegacao',(req, res, next)=>{
  async = true;
  res.render('nova-delegacao', {
    title: 'Delegacoes - SAPH',
    dele: true
  });
});

router.get('/listar-delegacoes',(req, res, next)=>{
  res.render('listar-delegacoes', {
    title: 'Solicitações - SAPH',
    dele: true
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
