var express = require('express');
var router = express.Router();
var Client = require('node-rest-client').Client;
var client = new Client();
var server_solicitacao_delegacao = "http://localhost:8080/SAPH/saph/solicitacao-delegacao/";
var server_tipo_solicitacao_delegacao = "http://localhost:8080/SAPH/saph/tipo-solicitacao-delegacao/";

module.exports = (io)=>{
  router.get('/nova',(req, res, next)=>{
    client.get(server_tipo_solicitacao_delegacao+"funcionario/"+req.session.usuario.id+"/DELEGACAO", function (data, response) {

        console.log(data);
      res.render('nova-delegacao', {
        title: 'Delegacoes - SAPH',
        tipos: data,
        funcionario:req.session.usuario,
      });
    });
  });

  router.get('/recebidas',(req, res, next)=>{
    client.get(server_solicitacao_delegacao+"recebidas/"+req.session.usuario.id+"/"+false, function (data, response) {
      console.log(data);
      res.render('listar-delegacoes', {
        title: 'Delegacoes - SAPH',
        delegacoes:data,
        funcionario:req.session.usuario,
        tipo: 'Recebidas'
      });
    });
  });

  router.get('/enviadas',(req, res, next)=>{
    client.get(server_solicitacao_delegacao+"parametros/DELEGACAO/"+req.session.usuario.id, function (data, response) {
      res.render('listar-delegacoes-enviadas', {
        title: 'Delegacoes - SAPH',
        delegacoes:data,
        funcionario:req.session.usuario,
        tipo: 'Enviadas'
      });
    });
  });



  router.get('/listar-delegacoes',(req, res, next)=>{
    res.render('listar-delegacoes', {
      title: 'Solicitações - SAPH',
      dele: true,
      funcionario:req.session.usuario,
    });
  });

  router.get('/d-confirmadas',(req, res, next)=>{
    res.render('d-confirmadas', {
      title: 'Solicitações - SAPH',
      funcionario:req.session.usuario,
    });
  });

  router.get('/d-analise',(req, res, next)=>{
    res.render('d-analise', {
      title: 'Solicitações - SAPH',
      dele: true,
      funcionario:req.session.usuario,
    });
  });

  router.get('/d-salvas',(req, res, next)=>{
    res.render('d-salvas', {
      title: 'Solicitações - SAPH',
      dele: true,
      funcionario:req.session.usuario,
    });
  });

  return router;
};
