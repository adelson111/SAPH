var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', { title: 'SAPH' });
});

router.get('/contato',(req, res, next)=>{
  res.render('contato', {
    title: 'Contato - SAPH',
  });
});

router.get('/sobre',(req, res, next)=>{
  res.render('sobre', {
    title: 'Sobre - SAPH',
  });
});

router.get('/login',(req, res, next)=>{
  res.render('login', {
    title: 'Login - SAPH',
  });
});

router.get('/inicio',(req, res, next)=>{
  res.render('inicio', {
    title: 'Home - SAPH',
  });
});
router.get('/solicitacoes',(req, res, next)=>{
  res.render('solicitacoes', {
    title: 'Solicitacoes - SAPH',
  });
});
router.get('/delegacao',(req, res, next)=>{
  res.render('delegacao', {
    title: 'Delegações - SAPH',
  });
});
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
