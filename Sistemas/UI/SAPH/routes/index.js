var express = require('express');
var router = express.Router();
var Client = require('node-rest-client').Client;
var client = new Client();
var usuarios = require('./../apoio/usuario');
global.server_backend = 'http://10.193.1.48:8080/SAPH/saph/';
global.server_ui = 'http://10.193.1.48:3000/';
global.erro = null;
/* GET home page. */

router.get('/', function(req, res, next) {
  res.render('index', {
     title: 'SAPH',
     home : true
    },
);
});

router.get('/contato',(req, res, next)=>{
  res.render('contato', {
    title: 'Contato - SAPH',
    home : true
  });
});

router.get('/logout',(req, res, next) =>{
  delete req.session.usuario;
  res.redirect('/login');
});



router.post('/login',(req, res, next)=>{
  if(!req.body.email){
    usuarios.render(req, res, "preencha o email");
  }else if(!req.body.senha){
    usuarios.render(req,res, "digite a senha");
  }else{

    usuarios.login(req.body.email, req.body.senha).then( data =>{
      usuario = data.funcionario;
      usuario.nivel = data.nivel;
      req.session.usuario = usuario;
      res.redirect('/inicio');

    }).catch(err =>{
      erro = 'Email  ou senha incorreto';
      res.redirect('/login');
    })
  }

});


router.get('/sobre',(req, res, next)=>{
  res.render('sobre', {
    title: 'Sobre - SAPH',
    home : true
  });
});

router.get('/login',(req, res, next)=>{
  res.render('login', {
    title: 'Login - SAPH',
    home:true
  });
});

router.get('/inicio',(req, res, next)=>{
  res.render('inicio', {
    title: 'Home - SAPH',
    funcionario:req.session.usuario,
    //req.body
  });
});

router.get('/visualizar',(req, res, next)=>{
  res.render('visualizar', {
    title: 'Visualizar - SAPH',
    funcionario:req.session.usuario,
  });
});

router.get('/exportar',(req, res, next)=>{
  res.render('exportar', {
    title: 'Exportar - SAPH',
    funcionario:req.session.usuario,
  });

});

module.exports = router;
