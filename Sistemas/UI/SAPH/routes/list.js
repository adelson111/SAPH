var express = require('express');
var router = express.Router();
var Client = require('node-rest-client').Client;
var client = new Client();

router.get('/list',(req, res, next)=>{
  res.render('list', {
    title: 'Solicitações - SAPH',
  });
});

router.get('/list/todas',(req, res, next)=>{
  res.render('todas', {
    title: 'Solicitações - SAPH',
  });
});

router.get('/list/analise',(req, res, next)=>{
  res.render('confirmadas', {
    title: 'Solicitações - SAPH',
  });
});

router.get('/list/analise',(req, res, next)=>{
  res.render('todas', {
    title: 'Solicitações - SAPH',
  });
});

router.get('/list/recusadas',(req, res, next)=>{
  res.render('recusadas', {
    title: 'Solicitações - SAPH',
  });
});

router.get('/list/salvas',(req, res, next)=>{
  res.render('salvas', {
    title: 'Solicitações - SAPH',
  });
});
module.exports = router;
