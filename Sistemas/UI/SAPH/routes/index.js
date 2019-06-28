var express = require('express');
var router = express.Router();
var Client = require('node-rest-client').Client;
var client = new Client();
var usuarios = require('./../apoio/usuario');
/* GET home page. */

router.use(function(req,res,next){
  if(['/login'].indexOf(req.url) === -1 && !req.session.usuario){
    req.redirect("/login");
  }else{
    next();
  }
});
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

router.get('/login',(req, res, next)=>{

  usuarios.render(req, res, null);
  // res.render('login', {
  //   title: 'Login - SAPH',
  //   home : true
  // });
});

router.post('/login',(req, res, next)=>{
  console.log(req.body.email);
  console.log(req.body.senha);
  if(!req.body.email){
    usuarios.render(req, res, "preencha o email");
  }else if(!req.body.senha){
    usuarios.render(req,res, "digite a senha");
  }else{

    usuarios.login(req.body.email, req.body.senha).then( usuario =>{
      req.session.usuario = usuario;
      res.redirect('/inicio');

    }).catch(err =>{
        console.log('erro543');
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
  });
});

router.get('/inicio',(req, res, next)=>{
  console.log("ala:" +req.session.usuario);
  res.render('inicio', {
    title: 'Home - SAPH',
    funcionario:req.session.usuario,
    //req.body
  });
});

//rota para testes

// router.get('/inicio',(req, res, next)=>{
//   res.render('inicio', {
//     title: 'Início - SAPH',
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
