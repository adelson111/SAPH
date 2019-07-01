var express = require('express');
var router = express.Router();
var Client = require('node-rest-client').Client;
var client = new Client();
var server = "http://localhost:8080/SAPH/saph/solicitacao-delegacao/";

router.get('/nova',(req, res, next)=>{
  client.get(server+"funcionario/"+req.session.usuario.id+"/SOLICITACAO", function (data, response) {
    res.render('new', {
      title: 'Solicitacoes - SAPH',
      tipos: data,
      funcionario:req.session.usuario,
    });
  });

});

router.get('/recebidas',(req, res, next)=>{
  client.get(server+"recebidas/"+req.session.usuario.id+"/"+true, (data, response) => {
    console.log(data);
    res.render('list', {
      title: 'Solicitacoes - SAPH',
      solicitacoes:data,
      funcionario:req.session.usuario,
      tipo: 'Recebidas'
    });
  });
});

router.get('/enviadas',(req, res, next)=>{
  console.log(server);
  client.get(server+"parametros/SOLICITACAO/"+req.session.usuario.id, (data, response)=> {
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

router.get('/comentarios',(req,res)=>{
  console.log(req.query.solicitacao);
  client.get(server+'comentarios/\{id:'+req.query.solicitacao+'\}',(data, response)=>{
    res.send(data);
  });
});

router.post('/cadadastrar', function (req, res) {
  var args = {
      data: req.body.solicitacao,
      headers: { "Content-Type": "application/json" }
  };
  client.post(server,args,function (data, response) {
    res.send(data);
  });
});

router.post('/enviar',(req, res) => {
  var args = {
      data: req.body.solicitacao,
      headers: { "Content-Type": "application/json" }
  };
  client.post(server+"enviar",args,(data, response) => {
    res.send(data);
  });
});

router.post('/comentar',(req,res)=>{
  console.log(req.body);
  var args = {
      data: req.body.comentario,
      headers: { "Content-Type": "application/json" }
  };
  console.log(req.body.comentario);
  client.post(server+"comentar",args,function (data, response) {
    res.send(data);
  });
});

module.exports = router;
