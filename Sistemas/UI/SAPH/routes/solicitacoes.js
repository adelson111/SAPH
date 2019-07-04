var express = require('express');
var router = express.Router();
var Client = require('node-rest-client').Client;
var client = new Client();
var server_solicitacao_delegacao = "http://192.168.137.240:8080/SAPH/saph/solicitacao-delegacao/";
var server_tipo_solicitacao_delegacao = "http://192.168.137.240:8080/SAPH/saph/tipo-solicitacao-delegacao/";

module.exports = (io)=>{
  router.get('/nova',(req, res, next)=>{
    client.get(server_tipo_solicitacao_delegacao+"funcionario/"+req.session.usuario.id+"/SOLICITACAO", function (data, response) {
      res.render('new', {
        title: 'Solicitacoes - SAPH',
        tipos: data,
        funcionario:req.session.usuario,
      });
    });

  });

  router.get('/recebidas',(req, res, next)=>{
    client.get(server_solicitacao_delegacao+"recebidas/"+req.session.usuario.id+"/"+true, (data, response) => {
      res.render('list', {
        title: 'Solicitacoes - SAPH',
        solicitacoes:data,
        funcionario:req.session.usuario,
        tipo: 'Recebidas'
      });
    });
  });

  router.get('/enviadas',(req, res, next)=>{
    client.get(server_solicitacao_delegacao+"parametros/SOLICITACAO/"+req.session.usuario.id, (data, response)=> {
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
    client.get(server_solicitacao_delegacao+'comentarios/\{id:'+req.query.solicitacao+'\}',(data, response)=>{
      res.send(data);
    });
  });

  router.post('/cadadastrar', function (req, res) {
    var args = {
        data: req.body.solicitacao,
        headers: { "Content-Type": "application/json" }
    };
    client.post(server_solicitacao_delegacao,args,function (data, response) {
      res.send(data);
      io.emit('notificar',req.body.solicitacao);
    });
  });

  router.post('/alterar-status',(req, res) => {
    var args = {
        data: req.body.solicitacao,
        headers: { "Content-Type": "application/json" }
    };
    client.post(server_solicitacao_delegacao+"alterar-status",args,(data, response) => {
      res.send(data);
      io.emit('notificar',req.body.solicitacao);
    });
  });
  router.post('/altualizar',(req, res) => {
    var args = {
        data: req.body.solicitacao,
        headers: { "Content-Type": "application/json" }
    };
    client.post(server_solicitacao_delegacao+"atualizar",args,(data, response) => {
      res.send(data);
    });
  });

  router.post('/enviar',(req, res) => {
    var args = {
        data: req.body.solicitacao,
        headers: { "Content-Type": "application/json" }
    };
    client.post(server_solicitacao_delegacao+"enviar",args,(data, response) => {
      res.send(data);
    });
  });

  router.post('/comentar',(req,res)=>{
    var args = {
        data: req.body.comentario,
        headers: { "Content-Type": "application/json" }
    };
    client.post(server_solicitacao_delegacao+"comentar",args,function (data, response) {
      io.emit('comentar',req.body.comentario);
    });
  });

  return router;
};
