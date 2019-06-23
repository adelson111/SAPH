var express = require('express');
var router = express.Router();
var Client = require('node-rest-client').Client;
var client = new Client();
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

router.get('/sobre',(req, res, next)=>{
  res.render('sobre', {
    title: 'Sobre - SAPH',
    home : true
  });
});

router.get('/login',(req, res, next)=>{
  res.render('login', {
    title: 'Login - SAPH',
  });
});

router.get('/inicio',(req, res, next)=>{
  email = req.query.email;
  senha = req.query.senha;
  client.post("http://localhost:8080/SAPH/saph/usuario/autenticar/"+email+"/"+senha,function (data, response) {
    console.log(data);
    if(data!=null){
      res.render('inicio', {
        title: 'Home - SAPH',
        funcionario:data
      });
    }else{
      res.send("erro");
    }
  });
});

//rota para testes

// router.get('/inicio',(req, res, next)=>{
//   res.render('inicio', {
//     title: 'Visualizar - SAPH',
//   });
// });

router.get('/visualizar',(req, res, next)=>{
  res.render('visualizar', {
    title: 'Visualizar - SAPH',
  });
});

router.get('/exportar',(req, res, next)=>{
  res.render('exportar', {
    title: 'Exportar - SAPH',
  });

});

module.exports = router;
