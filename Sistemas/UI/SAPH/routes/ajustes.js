var express = require('express');
var router = express.Router();
var Client = require('node-rest-client').Client;
var client = new Client();


router.get('/',(req, res, next)=>{
        res.render('dados', {
        title: 'Configurações - SAPH',
    });
});

router.get('/dados',(req, res, next)=>{
        res.render('dados', {
        title: 'Configurações - SAPH',
    });
});

router.get('/login-ajustes',(req, res, next)=>{
    res.render('login-ajustes', {
    title: 'Configurações - SAPH',
  });
  });

  router.get('/localizacao',(req, res, next)=>{
    res.render('localizacao', {
    title: 'Configurações - SAPH',
  });
  });
  
  router.get('/organizacionais',(req, res, next)=>{
    res.render('organizacionais', {
    title: 'Configurações - SAPH',
  });
  });
  
module.exports = router;
