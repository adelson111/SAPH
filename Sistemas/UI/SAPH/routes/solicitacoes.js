var express = require('express');
var router = express.Router();
var Client = require('node-rest-client').Client;
var client = new Client();

router.get('/nova',(req, res, next)=>{
  client.get("http://localhost:8080/SAPH/saph/tipo-solicitacao-delegacao/funcionario/"+req.session.usuario.id+"/SOLICITACAO", function (data, response) {
    res.render('new', {
      title: 'Solicitacoes - SAPH',
      tipos: data,
      funcionario:req.session.usuario,
    });
  });

});

router.get('/recebidas',(req, res, next)=>{
  client.get("http://localhost:8080/SAPH/saph/solicitacao-delegacao/recebidas/"+req.session.usuario.id+"/"+true, function (data, response) {
    res.render('list', {
      title: 'Solicitacoes - SAPH',
      solicitacoes:data,
      funcionario:req.session.usuario,
      tipo: 'Recebidas'
    });
  });
});

router.get('/enviadas',(req, res, next)=>{
  client.get("http://localhost:8080/SAPH/saph/solicitacao-delegacao/parametros/SOLICITACAO/"+req.session.usuario.id, function (data, response) {
    res.render('listar-enviadas', {
      title: 'Solicitacoes - SAPH',
      solicitacoes:data,
      funcionario:req.session.usuario,
      tipo: 'Enviadas'
    });
  });
});

router.get('/confirmadas',(req, res, next)=>{
  res.render('confirmadas', {
    title: 'Solicitações - SAPH',
    funcionario:req.session.usuario,
  });
});

router.get('/analise',(req, res, next)=>{
  res.render('analise', {
    title: 'Solicitações - SAPH',
    funcionario:req.session.usuario,
  });
});

router.get('/recusadas',(req, res, next)=>{
  res.render('recusadas', {
    title: 'Solicitações - SAPH',
    funcionario:req.session.usuario,
  });
});

router.get('/salvas',(req, res, next)=>{
  res.render('salvas', {
    title: 'Solicitações - SAPH',
    funcionario:req.session.usuario,
  });
});

router.post('/cadadastrar', function (req, res) {
  var args = {
      data: req.body.solicitacao,
      headers: { "Content-Type": "application/json" }
  };
  client.post("http://localhost:8080/SAPH/saph/solicitacao-delegacao",args,function (data, response) {
    res.send(data);
  });
});

router.post('/enviar', function (req, res) {
  var args = {
      data: req.body.solicitacao,
      headers: { "Content-Type": "application/json" }
  };
  client.post("http://localhost:8080/SAPH/saph/solicitacao-delegacao/enviar",args,function (data, response) {
    res.send(data);
  });
});

module.exports = router;
