var express = require('express');
var router = express.Router();
var Client = require('node-rest-client').Client;
var client = new Client();


var server_funcionario = "http://192.168.137.240:8080/SAPH/saph/funcionario/";

router.get('/',(req, res, next)=>{
        res.render('dados', {
        title: 'Configurações - SAPH',
        funcionario:req.session.usuario,
    });
});

router.get('/dados',(req, res, next)=>{
        res.render('dados', {
        title: 'Configurações - SAPH',
        funcionario:req.session.usuario,
    });
});

router.post('/atualizar-funcionario',(req , res)=>{
  funcionario = req.session.usuario;
  funcionario.nome = req.body.nome;
  funcionario.telefon = req.body.telefone;
  var args = {
      data: funcionario,
      headers: { "Content-Type": "application/json" }
  };
  client.put(server_funcionario,args,function (data, response) {
    res.redirect('/ajustes/dados');
  });
});

router.get('/login-ajustes',(req, res, next)=>{
    res.render('login-ajustes', {
    title: 'Configurações - SAPH',
    funcionario:req.session.usuario,
  });
  });

  router.get('/localizacao',(req, res, next)=>{
    res.render('localizacao', {
    title: 'Configurações - SAPH',
    funcionario:req.session.usuario,
  });
  });

  router.get('/organizacionais',(req, res, next)=>{
    res.render('organizacionais', {
    title: 'Configurações - SAPH',
    funcionario:req.session.usuario,
  });
  });

module.exports = router;
