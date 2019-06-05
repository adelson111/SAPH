var express = require('express');
var router = express.Router();
var Client = require('node-rest-client').Client;
var client = new Client();

router.get('/new',(req, res, next)=>{
  client.get("http://localhost:8080/SAPH/saph/solicitacao/listar", function (data, response) {
    res.render('new', {
      title: 'Solicitacoes - SAPH',
      tipos: data,
    });
  });

});
router.post('/cada', function (req, res) {
  console.log('a1');
  client.post("http://localhost:8080/SAPH/saph/solicitacao/cadastrar",'{"solicitacao":"é"}',function (data, response) {
    console.log('a2');
    res.send('data');
    res.send("response");
  });
});
module.exports = router;
